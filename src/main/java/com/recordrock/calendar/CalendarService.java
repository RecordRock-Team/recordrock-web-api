package com.recordrock.calendar;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Transactional
public class CalendarService {

    @Autowired
    CalendarMapper calendarMapper;

    public List<CalenderInfoVO> selectCalendarInfo() throws Exception{
        return calendarMapper.selectCalendarInfo();
    }

}
