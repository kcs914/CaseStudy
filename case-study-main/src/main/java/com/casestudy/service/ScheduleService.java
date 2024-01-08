package com.jmc.casestudy.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jmc.casestudy.payload.request.AddScheduleRequest;
import java.util.List;
public interface ScheduleService {
  void addSchedule(AddScheduleRequest addScheduleRequest);
  List<RouteDetailsResponse> getScheduleByRouteId(Long routeId);
  List<Schedule> getAllSchedule();
}
