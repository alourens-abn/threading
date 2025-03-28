package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blocking")
public class BlockingController {

  @GetMapping()
  public String blocking() {
    MockIO.makeDbCall();
    MockIO.makeRestCall();

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

