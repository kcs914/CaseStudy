package com.casestudy.payload.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import lombok.Data;

@Data
public class AddScheduleRequest {
  @NotNull private LocalTime startTime;

  @NotNull private LocalTime endTime;

  @NotNull private String busRegNum;

  @NotNull private Long routeId;
}
