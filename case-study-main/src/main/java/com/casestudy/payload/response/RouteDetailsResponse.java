package com.casestudy.payload.response;

import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDetailsResponse {
  private Time startTime;

  private Time endTime;

  private String busRegistrationNumber;

  private String startLocation;

  private String endLocation;
}
