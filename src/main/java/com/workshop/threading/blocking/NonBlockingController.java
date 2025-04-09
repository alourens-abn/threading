package com.workshop.threading.blocking;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sandwich")
public class NonBlockingController {

  @GetMapping("/cheese")
  public Mono<String> getCheeseSandwich() {

    //todo: implement your solution here
    return Mono.error(new NotImplementedException("Implement the cheese sandwich endpoint"));
  }


}

