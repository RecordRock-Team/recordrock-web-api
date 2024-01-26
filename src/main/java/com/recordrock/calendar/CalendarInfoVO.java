package com.recordrock.calendar;

import lombok.Data;

@Data
public class CalendarInfoVO {
    String centerFullName;
    String clearRecord;
    String dailyMemo;
    String logoImgUrl;
    int day;
    int workoutTimeHour;
    int workoutTimeMinute;
}
