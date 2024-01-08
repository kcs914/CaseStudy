package com.casestudy.repository;

import com.casestudy.model.Bus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

  @Transactional
  void deleteByRegNum(String regNum);

  Optional<Bus> findBusByRegNum(String regNum);
}
