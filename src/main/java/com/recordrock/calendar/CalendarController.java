package com.recordrock.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/calendar/getCenterRecord")
    @ResponseBody
    public CalendarInfoDetailVO getCalendarInfoDetail() throws Exception {
        CalendarInfoDetailVO calendarInfoDetailVO = calendarService.selectCalendarInfoDetail();
        return calendarInfoDetailVO;
    }

    @RequestMapping("/calendar/getCalendarList")
    public List<CalendarInfoVO> getCalendarList() throws Exception {
        return calendarService.selectCalendarInfoList();
    }
}
