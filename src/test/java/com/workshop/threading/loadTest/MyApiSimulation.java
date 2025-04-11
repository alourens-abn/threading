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
    //Please change the value of the rampUsers and duration to the value specified for your task.
    //The duration is in seconds.
    //5 minutes = 300 seconds.
    setUp(
        myScenario.injectOpen(rampUsers(10_000).during(300))
    ).protocols(httpProtocol);
  }

}
