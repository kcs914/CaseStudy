package com.casestudy.controller;

import com.casestudy.payload.request.AddScheduleRequest;
import com.casestudy.model.Bus;
import com.casestudy.payload.response.GenericResponse;
import com.casestudy.service.BusService;
import com.casestudy.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired BusService busService;

  @Autowired ScheduleService scheduleService;

  @PostMapping("/add-bus")
  public ResponseEntity<GenericResponse> addBus(@Valid @RequestBody Bus bus) {
    busService.add(bus);
    return ResponseEntity.ok(new GenericResponse("Added"));
  }

  @PostMapping("/edit-bus")
  public ResponseEntity<GenericResponse> editBus(@Valid @RequestBody Bus bus) {
    busService.edit(bus);
    return ResponseEntity.ok(new GenericResponse("Edited"));
  }

  @PostMapping("/delete-bus/{regNum}")
  public ResponseEntity<GenericResponse> deleteBus(@PathVariable String regNum) {
    busService.delete(regNum);
    return ResponseEntity.ok(new GenericResponse("Deleted"));
  }

  @PostMapping("/add-schedule")
  public ResponseEntity<GenericResponse> addSchedule(
      @RequestBody AddScheduleRequest addScheduleRequest) {
    scheduleService.addSchedule(addScheduleRequest);
    return ResponseEntity.ok(new GenericResponse("Deleted successfully"));
  }
}
