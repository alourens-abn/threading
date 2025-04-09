package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sandwich")
public class BlockingController {

  private final ExecutorService executorService;

  public BlockingController() {
    //don't change any values here
    this.executorService = Executors.newFixedThreadPool(400);
  }

  @GetMapping("/cheese")
  public String getCheeseSandwich() {
    //todo: add your executor thread pool implementation here
    MockIO.cutCheese();
    MockIO.butterBread();

    return "ok";
  }
}

