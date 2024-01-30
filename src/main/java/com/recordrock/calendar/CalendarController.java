package com.recordrock.calendar;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @RequestMapping("/calendar/getCenterRecord")
    public CalendarInfoDetailVO getCalendarInfoDetail() throws Exception {
        CalendarInfoDetailVO calendarInfoDetailVO = calendarService.selectCalendarInfoDetail();
        return calendarInfoDetailVO;
    }

    @RequestMapping("/calendar/getCalendarList")
    public List<CalendarInfoVO> getCalendarList() throws Exception {
        return calendarService.selectCalendarInfoList();
    }
}
