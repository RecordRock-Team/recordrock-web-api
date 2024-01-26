package com.recordrock.calendar;

import lombok.Data;

@Data
public class CalendarInfoDetailVO {
    int clearNo;
    String centerFullName;
    String clearRecord;
    String dailyMemo;
    String logoImgUrl;
    int day;
    int workoutTimeHour;
    int workoutTimeMinute;
}
