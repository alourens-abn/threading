package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/blocking")
public class BlockingController {

  @GetMapping()
  public Mono<String> blocking() {

    return Mono.when(MockIO.makeDbCall(), MockIO.makeRestCall()).thenReturn("ok");
  }


}

