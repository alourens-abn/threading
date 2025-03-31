package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blocking")
public class BlockingController {

  private final ExecutorService executorService;

  public BlockingController() {
    this.executorService = Executors.newFixedThreadPool(400);
  }

  @GetMapping()
  public String blocking() {

    Future<?> dbFuture = executorService.submit(() -> {
      MockIO.makeDbCall();
      return null;
    });
    Future<?> restFuture = executorService.submit(() -> {
      MockIO.makeRestCall();
      return null;
    });

    try {
      dbFuture.get(); // Wait for the DB call to complete
      restFuture.get(); // Wait for the REST call to complete
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    List<Thread> myThreads = Thread.getAllStackTraces()
        .keySet()
        .stream()
        .collect(Collectors.toList());

    List<Thread> execThreads = myThreads.stream().filter(thread -> thread.getName().contains("exec")).toList();
    System.out.println("My threads size: " + myThreads.size());
//    System.out.println("My threads: " + myThreads);
    return "ok";
  }


}

