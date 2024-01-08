package com.jmc.casestudy.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jmc.casestudy.model.*;
import com.jmc.casestudy.payload.request.AddScheduleRequest;
import com.jmc.casestudy.payload.response.RouteDetailsResponse;
import com.jmc.casestudy.repository.ScheduleRepository;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;


@Service
public class ScheduleServiceImpl implements ScheduleService {

  @Autowired BusService busService;

  @Autowired RouteService routeService;

  @Autowired ScheduleRepository scheduleRepository;

  @Override
  public void addSchedule(AddScheduleRequest addScheduleRequest) {
    Optional<Bus> bus = busService.findByRegNum(addScheduleRequest.getBusRegNum());
    Optional<Route> route = routeService.getById(addScheduleRequest.getRouteId());
    if (bus.isPresent() && route.isPresent()) {
      List<Schedule> scheduleList = scheduleRepository.findByBus(bus.get());
      if (isTimeRangeAvailable(
          addScheduleRequest.getStartTime(), addScheduleRequest.getEndTime(), scheduleList)) {
        scheduleRepository.save(
            new Schedule(
                null,
                addScheduleRequest.getStartTime(),
                addScheduleRequest.getEndTime(),
                bus.get(),
                route.get()));
      } else {
        throw new RuntimeException(" not for the bus");
      }
    } else {
      throw new RuntimeException("not valid");
    }
  }

  private boolean isTimeRangeAvailable(
      LocalTime newStartTime, LocalTime newEndTime, List<Schedule> existingSchedules) {
    for (Schedule existingSchedule : existingSchedules) {
      if (isOverlap(
          newStartTime,
          newEndTime,
          existingSchedule.getStartTime(),
          existingSchedule.getEndTime())) {
        return false;
      }
    }
    return true;
  }

  private boolean isOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
    return !start1.isAfter(end2) && !end1.isBefore(start2);
  }

  @Override
  public List<Schedule> getAllSchedule() {
    return scheduleRepository.findAll();
  }

  @Override
  public List<RouteDetailsResponse> getScheduleByRouteId(Long routeId) {
    List<RouteDetailsResponse> routeDetailsResponseList = new ArrayList<>();
    for (Object[] row : scheduleRepository.getRouteDetails(routeId)) {
      RouteDetailsResponse routeDetails = new RouteDetailsResponse();
      routeDetails.setStartTime((Time) row[0]);
      routeDetails.setEndTime((Time) row[1]);
      routeDetails.setBusRegistrationNumber((String) row[2]);
      routeDetails.setStartLocation((String) row[3]);
      routeDetails.setEndLocation((String) row[4]);
      routeDetailsResponseList.add(routeDetails);
    }
    return routeDetailsResponseList;
  }
}
