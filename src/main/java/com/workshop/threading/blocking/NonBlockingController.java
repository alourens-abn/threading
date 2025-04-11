package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sandwich")
public class NonBlockingController {

  @GetMapping("/cheese")
  public Mono<String> getCheeseSandwich() {
    return Mono.when(
        MockIO.makeDbCall(),
        MockIO.makeRestCall()
    ).then(Mono.just("cheese sandwich"));
  }


}

