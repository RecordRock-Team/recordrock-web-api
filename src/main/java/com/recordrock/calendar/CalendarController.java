package com.recordrock.calendar;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @RequestMapping("calendar/getCenterRecord")
    @ResponseBody
    public List<CalendarInfoDetailVO> getCalendarInfoDetail() throws Exception {
        return calendarService.selectCalendarInfoDetail();
    }

    // 달력 조회
    @RequestMapping("calendar/getCalendarList")
    @ResponseBody
    public List<CalendarInfoVO> getCalendarList() throws Exception {
        return calendarService.selectCalendarInfoList();
    }
}
