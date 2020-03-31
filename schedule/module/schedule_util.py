from datetime import datetime, timedelta

class ScheduleUtil:
    @staticmethod
    def get_ec2_instance_list_by_status(ec2_instance_list, status) -> list:
        filtered_ec2_instance_list = []

        for ec2_instance in ec2_instance_list:
            if ScheduleUtil.get_ec2_instance_status(ec2_instance) == status:
                filtered_ec2_instance_list.append(ec2_instance)

        return filtered_ec2_instance_list

    @staticmethod
    def get_ec2_instance_ids(ec2_instance_list) -> list:
        ec2_instance_ids = []

        for ec2_instance in ec2_instance_list:
            ec2_instance_ids.append(ec2_instance['InstanceId'])

        return ec2_instance_ids

    @staticmethod
    def get_ec2_instance_status(ec2_instance) -> str:
        return ec2_instance['State']['Name']

    @staticmethod
    def get_ec2_instance_name(ec2_instance, default_name='EC2') -> str:
        tag_list = ec2_instance['Tags']

        for tag in tag_list:
            if tag['Key'] == 'Name':
                return tag['Value']

        return default_name

    @staticmethod
    def get_rds_instance_list_by_status(rds_instance_list, status) -> list:
        filtered_rds_instance_list = []

        for rds_instance in rds_instance_list:
            if ScheduleUtil.get_rds_instance_status(rds_instance) == status:
                filtered_rds_instance_list.append(rds_instance)

        return filtered_rds_instance_list

    @staticmethod
    def get_rds_instance_ids(rds_instance_list) -> list:
        rds_instance_ids = []

        for rds_instance in rds_instance_list:
            rds_instance_ids.append(rds_instance['DBInstanceIdentifier'])

        return rds_instance_ids

    @staticmethod
    def get_rds_instance_status(rds_instance) -> str:
        return rds_instance['DBInstanceStatus']

    @staticmethod
    def get_rds_instance_name(rds_instance, default_name='RDS') -> str:
        name = rds_instance['DBInstanceIdentifier']

        return default_name if not name else name

    @staticmethod
    def equals_rds_schedule_name(rds_tags, tag_value) -> bool:
        for t in rds_tags['TagList']:
            if t['Key'] != 'ScheduleName':
                continue
            if t['Value'] == tag_value:
                return True

        return False

    @staticmethod
    def get_diff_minute(d1, d2) -> float:
        diff = d1 - d2
        return (diff.days * 24 * 60) + (diff.seconds / 60)

    @staticmethod
    def hm_to_date_time(hm):
        cur = datetime.now()
        hour = hm.split(':')[0]
        minute = hm.split(':')[1]
        date_time = cur.replace(hour=int(hour), minute=int(minute), second=0, microsecond=0)

        return date_time

    @staticmethod
    def replace_time(date_time, hm):
        split_time = hm.split(':')
        hour = split_time[0]
        minute = split_time[1]
        return date_time.replace(hour=int(hour), minute=int(minute))

    @staticmethod
    def is_valid_time(hm):
        try:
            datetime.strptime(hm, '%H:%M')
            return True
        except ValueError:
            return False

    @staticmethod
    def is_valid_date(ymd):
        try:
            datetime.strptime(ymd, '%Y-%m-%d')
            return True
        except ValueError:
            return False

    @staticmethod
    def equals_rds_schedule_group_name(rds_tags, server_group) -> bool:
        for t in rds_tags['TagList']:
            if t['Key'] != 'ScheduleGroupName':
                continue
            if t['Value'] == server_group['GroupName']:
                return True

        return False