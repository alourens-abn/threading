package com.workshop.threading.blocking;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;

@Path("/sandwich")
public class BlockingController {

  private final ExecutorService executorService;

  public BlockingController() {
    this.executorService = Executors.newFixedThreadPool(400);
  }

  @GET
  @Path("/cheese")
  public void blocking(@Suspended final AsyncResponse asyncResponse) {
    //todo: Add your code here
    asyncResponse.resume(new NotImplementedException("Not implemented yet"));
  }


}

