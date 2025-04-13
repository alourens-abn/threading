package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sandwich")
public class BlockingController {

  //todo task 2: uncomment this code when you are told to implement task 2
//  ExecutorService executorService = Executors.newFixedThreadPool(400);


  @GetMapping("/cheese")
  public String getCheeseSandwich() {
    //todo task 2: use your executor service to make these 2 methods run concurrently
    //hint task 2: you do not need to change the MockIO class
    MockIO.cutCheese();
    MockIO.butterBread();

    return "ok";
  }
}

