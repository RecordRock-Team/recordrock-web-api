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

    // 상세 조회
    public CalendarInfoDetailVO selectCalendarInfoDetail() throws Exception{
        CalendarInfoDetailVO vo = new CalendarInfoDetailVO();
        vo.setClearNo(1);
        return calendarMapper.selectCalendarInfoDetail();
    }

    // 달력 리스트 조회
    public List<CalendarInfoVO> selectCalendarInfoList() throws Exception {
        return calendarMapper.selectCalendarInfo();
    }
}
