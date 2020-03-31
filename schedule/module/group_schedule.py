import boto3
from boto3.dynamodb.conditions import Attr
from module.schedule import Schedule

class GroupSchedule(Schedule):
    schedule_server_group_list = []

    def __init__(self, schedule_name):
        super().__init__(schedule_name)

    def load_schedule_server_group_list_from_db(self) -> list:
        table = self.db.Table('ScheduleServerGroup')

        response = table.scan(
            Select='ALL_ATTRIBUTES',
            FilterExpression=Attr('ScheduleName').eq(self.schedule_name)
        )

        return response['Items']

    def get_schedule_server_group_list(self) -> list:
        if not self.schedule_server_group_list:
            self.schedule_server_group_list = self.load_schedule_server_group_list_from_db()

        return self.schedule_server_group_list

    def get_schedule_server_group(self, group_name):
        server_group_list = self.get_schedule_server_group_list()

        for server_group in server_group_list:
            if server_group['GroupName'] == group_name:
                return server_group

        return None

    def get_server_group_ec2_instance_list(self, server_group) -> list:
        schedule_tag_name = self.get_schedule_property('TagValue')

        ec2_schedule_filter = [{
            'Name': 'tag:ScheduleName',
            'Values': [schedule_tag_name]
        }, {
            'Name': 'tag:ScheduleGroupName',
            'Values': [server_group['GroupName']]
        }]
        instances = self.ec2.describe_instances(Filters=ec2_schedule_filter)

        reservation_list = instances['Reservations']

        instance_list = []

        for reservation in reservation_list:
            instance_list = instance_list + reservation['Instances']

        return instance_list