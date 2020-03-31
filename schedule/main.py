import boto3
# from module.exception_schedule import ExceptionSchedule

from boto3.dynamodb.conditions import Key, Attr

# rds = boto3.client('rds')
class ExceptionSchedule(GroupSchedule):
    schedule_exception_list = None

    def __init__(self, schedule_name):
        super().__init__(schedule_name)

    def print_schedule_data(self):

        print('========================================================================')
        print('Schedule Name : ' + self.schedule_name)
        print('Today : ' + self.get_exception_date_ymd())
        print('Enabled : ' + str(self.is_enable()))
        print('ActiveDays : ' + str(self.get_schedule_property('DaysActive')))
        print('Start Time : ' + str(self.get_start_date_time()))
        print('Stop Time : ' + str(self.get_stop_date_time()))
        print('IsActiveDay : ' + str(self.is_active_day()))
        print('IsStartTime : ' + str(self.is_start_time()))
        print('IsStopTime : ' + str(self.is_stop_time()))
        print('TagValue : ' + str(self.get_schedule_property('TagValue')))
        print('========================================================================')

def s3TableName():
    s3 = boto3.resource('s3')
    for bucket in s3.buckets.all():
        print(bucket.name)

def db():
    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table('Schedule2')
    print(table.creation_date_time)

    response = table.scan(
        FilterExpression=Attr('ScheduleName').begins_with('Sample')
    )
    items = response['Items']
    print(items)

def run_job():
    db = boto3.resource('dynamodb')
    table = db.Table('Schedule2')
    response = table.scan()

    for item in response['Items']:
        # print(item['ScheduleName'])
        schedule = ExceptionSchedule(item['ScheduleName'])
        schedule.print_schedule_data()
        # schedule.run()
        # Scheduler.print_line()



run_job()

# print('Hello Python!')

# ec2 = boto3.client('ec2')
# response = ec2.describe_instances()
# for ec2_instance in response['Reservations']:
#     print(ec2_instance)