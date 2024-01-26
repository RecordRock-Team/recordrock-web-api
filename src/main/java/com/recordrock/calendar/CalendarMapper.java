package com.recordrock.calendar;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarMapper {

    List<CalendarInfoVO> selectCalendarInfo() throws Exception;

    CalendarInfoDetailVO selectCalendarInfoDetail() throws Exception;

}
