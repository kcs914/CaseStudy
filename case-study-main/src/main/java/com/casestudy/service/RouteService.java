package com.jmc.casestudy.service;

import com.jmc.casestudy.model.Route;
import java.util.List;
import java.util.Optional;

public interface RouteService {
  void addRoute(Route route);

  Optional<Route> getById(Long id);

  List<Route> getAllRoute();
}
