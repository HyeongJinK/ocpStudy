
import boto3
from module.group_schedule import GroupSchedule

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