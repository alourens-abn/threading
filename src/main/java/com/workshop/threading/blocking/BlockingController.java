package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sandwich")
public class BlockingController {

  @GetMapping("/cheese")
  public String getCheeseSandwich() {
    MockIO.cutCheese();
    MockIO.butterBread();

    return "ok";
  }
}

