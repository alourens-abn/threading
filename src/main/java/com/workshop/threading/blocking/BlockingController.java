package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/sandwich")
public class BlockingController {

  //todo task 2: uncomment this code when you are told to implement task 2
  ExecutorService executorService = Executors.newFixedThreadPool(400);


  @GetMapping("/cheese")
  public String getCheeseSandwich() {
    try {
      Future<?> cheeseFuture = executorService.submit(MockIO::cutCheese);
      Future<?> butterFuture = executorService.submit(MockIO::butterBread);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "ok";
  }
}

