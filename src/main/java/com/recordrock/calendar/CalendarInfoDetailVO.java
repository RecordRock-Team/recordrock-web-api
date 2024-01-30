package com.recordrock.calendar;

import lombok.Data;

@Data
public class CalendarInfoDetailVO {
    int clearNo;
    String center;
    String centerHeadquarter;
    String centerBranch;
    String clearRecord;
    String dailyMemo;
    String logoImgUrl;
    int day;
    int workoutTimeHour;
    int workoutTimeMinute;
}
