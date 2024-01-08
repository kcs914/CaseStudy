package com.jmc.casestudy.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jmc.casestudy.model.Route;
import com.jmc.casestudy.repository.RouteRepository;
import java.util.List;
@Service
public class RouteServiceImpl implements RouteService {
  @Autowired RouteRepository routeRepository;
  @Override
  public void addRoute(Route route) {
    routeRepository.save(route);
  }
  @Override
  public Optional<Route> getById(Long id) {
    return routeRepository.findById(id);
  }
  @Override
  public List<Route> getAllRoute() {
    return routeRepository.findAll();
  }
}
