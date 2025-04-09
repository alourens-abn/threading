package com.workshop.threading.loadTest;

import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class MyApiSimulation extends Simulation {

  HttpProtocolBuilder httpProtocol =
      http.baseUrl("http://localhost:8080")
          .acceptHeader("text/html");

  ScenarioBuilder myScenario = scenario("My Scenario")
      .exec(http("Request to /sandwich/cheese").get("/sandwich/cheese"));

  {
    setUp(
        myScenario.injectOpen(rampUsers(100).during(3))
    ).protocols(httpProtocol);
  }

}
