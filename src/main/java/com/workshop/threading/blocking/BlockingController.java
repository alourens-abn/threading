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

    try {
      // Submit tasks to the executor service
      var future1 = executorService.submit(MockIO::cutCheese);
      var future2 = executorService.submit(MockIO::butterBread);

      // Wait for both tasks to complete
      future1.get();
      future2.get();
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }

    return "ok";
  }
}

