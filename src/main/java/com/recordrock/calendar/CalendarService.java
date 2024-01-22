package com.recordrock.calendar;

import com.recordrock.mapper.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CalendarService {

    CalendarMapper calendarMapper;

    public CalendarService(CalendarMapper calendarMapper) {
        this.calendarMapper = calendarMapper;
    }

    // 암장 기록 조회
    @GetMapping("/calendar/getCenterRecord")
    public void getCenterRecord(int clear_no){

    }

}
