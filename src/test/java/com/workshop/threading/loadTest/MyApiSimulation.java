package com.workshop.threading.loadTest;

import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class MyApiSimulation extends Simulation {

  //Do not touch this code
  HttpProtocolBuilder httpProtocol =
      http.baseUrl("http://localhost:8080")
          .acceptHeader("text/html");

  ScenarioBuilder myScenario = scenario("My Scenario")
      .exec(http("Request to /sandwich/cheese").get("/sandwich/cheese"));

  {
    //Please change the value of the rampUsers and duration to the value specified for your task.
    //The duration is in seconds.
    //5 minutes = 300 seconds.

    //You only want to change the ramped users (100, 1000, 10000) and the during values for this excercise
    //Note: You need to start your application before running the load tests.
    //Note: Please restart your application between load tests to make sure there are no lingering requests
    setUp(
        myScenario.injectOpen(rampUsers(100).during(3))
    ).protocols(httpProtocol);
  }

}
