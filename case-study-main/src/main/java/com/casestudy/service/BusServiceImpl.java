package com.jmc.casestudy.service;

import com.jmc.casestudy.model.Bus;
import com.jmc.casestudy.repository.BusRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {

  @Autowired BusRepository busRepository;

  @Override
  public void add(Bus bus) {
    busRepository.save(bus);
  }

  @Override
  public void delete(String regNum) {
    busRepository.deleteByRegNum(regNum);
  }

  @Override
  public void edit(Bus bus) {
    Optional<Bus> existingBus = busRepository.findBusByRegNum(bus.getRegNum());
    if (existingBus.isPresent()) {
      bus.setId(existingBus.get().getId());
      busRepository.save(bus);
    } else {
      throw new RuntimeException("Bus Not Found");
    }
  }

  @Override
  public Optional<Bus> findByRegNum(String regNum) {
    return busRepository.findBusByRegNum(regNum);
  }

  @Override
  public List<Bus> getAllBus() {
    return busRepository.findAll();
  }
}
