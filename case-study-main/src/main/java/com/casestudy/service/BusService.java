package com.jmc.casestudy.service;

import com.jmc.casestudy.model.Bus;
import java.util.List;
import java.util.Optional;

public interface BusService {
  void add(Bus bus);

  void delete(String regNum);

  void edit(Bus bus);

  Optional<Bus> findByRegNum(String regNum);

  List<Bus> getAllBus();
}
