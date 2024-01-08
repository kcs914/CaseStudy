package com.casestudy;

import com.casestudy.controller.AuthController;
import com.casestudy.model.Route;
import com.casestudy.payload.request.SignupRequest;
import com.casestudy.service.RouteService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaseStudyApplication implements CommandLineRunner {
  @Autowired AuthController authController;
  @Autowired RouteService routeService;
  public static void main(String[] args) {
    SpringApplication.run(CaseStudyApplication.class, args);
  }
  @Override
  public void run(String... args) throws Exception {
    authController.registerUser(
        new SignupRequest("admin", "admin@gmail.com", "admin", "123456789"));
    routeService.addRoute(new Route(1L, "chennai", "pondicheery"));
    routeService.addRoute(new Route(2L, "mumbai", "pune"));
    routeService.addRoute(new Route(3L, "delhi", "lucknow"));
    routeService.addRoute(new Route(4L, "lucknow", "Chennai"));
  }
}
