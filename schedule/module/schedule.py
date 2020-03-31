import boto3
from datetime import datetime, timedelta
from module.group_schedule import GroupSchedule
from module.schedule_util import ScheduleUtil

class Schedule:
    schedule_name = None
    schedule_data = {}

    db = boto3.resource('dynamodb')
    ec2 = boto3.client('ec2')
    rds = boto3.client('rds')

    def __init__(self, schedule_name):
        self.schedule_name = schedule_name

    def load_schedule_item_from_db(self):
        table = self.db.Table('Schedule2')
        response = table.get_item(
            Key={
                'ScheduleName': self.schedule_name
            }
        )

        return response['Item'] if 'Item' in response else {}

    def get_schedule_property(self, property_name, default_value=None):
        if property_name in self.get_schedule():
            return self.get_schedule()[property_name]
        else:
            return default_value

    def get_schedule(self):
        if not self.schedule_data:
            self.schedule_data = self.load_schedule_item_from_db()

        return self.schedule_data

    def get_start_date_time(self) -> datetime:
        start_time = self.get_schedule_property('StartTime')

        if start_time == 'None':
            return None

        start_date_time = ScheduleUtil.hm_to_date_time(start_time)

        return start_date_time

    def get_stop_date_time(self) -> datetime:
        stop_time = self.get_schedule_property('StopTime')

        if stop_time == 'None':
            return None

        stop_date_time = ScheduleUtil.hm_to_date_time(stop_time)

        return stop_date_time

    def set_schedule_force_start(self, flag):
        return self.db.Table('Schedule2').update_item(
            Key={
                'ScheduleName': self.schedule_name,
            },
            UpdateExpression='set ForceStart=:c',
            ExpressionAttributeValues={
                ':c': flag
            },
            ReturnValues='UPDATED_NEW'
        )

    def is_enable(self) -> bool:
        return self.get_schedule_property('Enabled')

    def is_active_day(self) -> bool:
        days_active = self.get_schedule_property('DaysActive')
        current_week_day = datetime.now().strftime('%a').lower()

        # 매일 작동
        if days_active == 'all':
            return True
        # 월~금만 작동
        elif days_active == 'weekdays':
            weekdays = ['mon', 'tue', 'wed', 'thu', 'fri']
            if current_week_day in weekdays:
                return True
        # 지정요일만 작동 (ex : mon,tue)
        else:
            days = days_active.split(',')
            for d in days:
                if d.lower().strip() == current_week_day:
                    return True

        return False

    def is_start_time(self) -> bool:
        if not self.is_active_day():
            return False

        start = self.get_start_date_time()

        if start is None:
            return False

        now = datetime.now()
        now_max = now - timedelta(minutes=59)

        return now_max <= start <= now

    def is_stop_time(self) -> bool:
        if not self.is_active_day():
            return False

        stop = self.get_stop_date_time()

        if stop is None:
            return False

        now = datetime.now()
        now_max = now - timedelta(minutes=59)

        return now_max <= stop <= now

    def is_force_start(self) -> bool:
        return self.get_schedule_property('ForceStart', False)

    def has_running_instance(self):
        ec2_instance_list = self.get_ec2_instance_list()
        rds_instance_list = self.get_rds_instance_list()

        running_ec2_instance_list = ScheduleUtil.get_ec2_instance_list_by_status(ec2_instance_list, 'running')
        running_rds_instance_list = ScheduleUtil.get_rds_instance_list_by_status(rds_instance_list, 'available')

        return False if len(running_ec2_instance_list) == 0 and len(running_rds_instance_list) == 0 else True

    def get_ec2_instance_list(self) -> list:

        schedule_tag_name = self.get_schedule_property('TagValue')

        ec2_schedule_filter = [{
            'Name': 'tag:ScheduleName',
            'Values': [schedule_tag_name]
        }]

        instances = self.ec2.describe_instances(Filters=ec2_schedule_filter)

        reservation_list = instances['Reservations']

        instance_list = []

        for reservation in reservation_list:
            instance_list = instance_list + reservation['Instances']

        return instance_list

    def get_rds_instance_list(self) -> list:

        schedule_tag_value = self.get_schedule_property('TagValue')
        instances = self.rds.describe_db_instances()

        schedule_instances_list = []

        for instance in instances['DBInstances']:
            arn = instance['DBInstanceArn']
            tags = self.rds.list_tags_for_resource(ResourceName=arn)

            if ScheduleUtil.equals_rds_schedule_name(tags, schedule_tag_value):
                schedule_instances_list.append(instance)

        return schedule_instances_list

    def start_ec2_instances(self, ec2_instance_list):
        ec2_instance_ids = ScheduleUtil.get_ec2_instance_ids(ec2_instance_list)
        return self.ec2.start_instances(InstanceIds=ec2_instance_ids)

    def stop_ec2_instances(self, ec2_instance_list):
        ec2_instance_ids = ScheduleUtil.get_ec2_instance_ids(ec2_instance_list)
        return self.ec2.stop_instances(InstanceIds=ec2_instance_ids, Force=True)

    def start_rds_instances(self, rds_instance_list):
        response_list = []
        rds_instance_ids = ScheduleUtil.get_rds_instance_ids(rds_instance_list)

        for rdb_instance_id in rds_instance_ids:
            res = self.rds.start_db_instance(DBInstanceIdentifier=rdb_instance_id)
            print('Start RDS :' + str(rdb_instance_id))
            response_list.append(res)

        return response_list

    def stop_rds_instances(self, rds_instance_list):
        response_list = []
        rds_instance_ids = ScheduleUtil.get_rds_instance_ids(rds_instance_list)

        for rdb_instance_id in rds_instance_ids:
            res = self.rds.stop_db_instance(DBInstanceIdentifier=rdb_instance_id)
            print('Stop RDS : ' + str(rdb_instance_id))
            response_list.append(res)

        return response_list