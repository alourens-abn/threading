package com.workshop.threading.config;

import com.workshop.threading.blocking.BlockingController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
    register(BlockingController.class);
  }
}