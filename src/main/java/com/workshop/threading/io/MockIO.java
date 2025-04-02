package com.workshop.threading.io;

import java.time.Duration;
import reactor.core.publisher.Mono;

public class MockIO {

  private static final int millisDb = 5000;
  private static final int millisRest = 10000;

  public static Mono<Void> makeDbCall() {
    return Mono.delay(Duration.ofMillis(millisDb)).then();
  }

  public static Mono<Void> makeRestCall() {
    return Mono.delay(Duration.ofMillis(millisRest)).then();
  }

}
