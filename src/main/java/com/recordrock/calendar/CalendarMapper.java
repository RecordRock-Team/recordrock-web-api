package com.recordrock.calendar;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarMapper {

    List<CalendarInfoVO> selectCalendarInfo() throws Exception;

    CalendarInfoDetailVO selectCalendarInfoDetail() throws Exception;

}
