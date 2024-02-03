package com.recordrock.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CalendarService {

    @Autowired
    private CalendarMapper calendarMapper;

    // 달력 리스트 조회
    public List<CalendarInfoVO> selectCalendarInfoList() throws Exception {
        return calendarMapper.selectCalendarInfoList();
    }

    // 상세 조회
    public List<CalendarInfoDetailVO> selectCalendarInfoDetail() throws Exception{
        return calendarMapper.selectCalendarInfoDetail();
    }

}
