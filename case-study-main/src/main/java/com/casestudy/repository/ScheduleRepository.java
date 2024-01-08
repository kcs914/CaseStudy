package com.casestudy.repository;

import com.casestudy.model.Bus;
import com.casestudy.model.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

  List<Schedule> findByBus(Bus bus);

  @Query(value = "CALL GetRouteDetails(:routeId)", nativeQuery = true)
  List<Object[]> getRouteDetails(@Param("routeId") Long routeId);
}
