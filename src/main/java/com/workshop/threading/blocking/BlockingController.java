package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Path("/sandwich")
public class BlockingController {

  private final ExecutorService executorService;

  public BlockingController() {
    this.executorService = Executors.newFixedThreadPool(400);
  }

  @GET
  @Path("/cheese")
  public void blocking(@Suspended final AsyncResponse asyncResponse) {

    Future<?> breadFuture = executorService.submit(() -> {
      MockIO.butterBread();
      return null;
    });
    Future<?> cheeseFuture = executorService.submit(() -> {
      MockIO.cutCheese();
      return null;
    });

    executorService.submit(() -> {
      try {
        breadFuture.get(); // Wait for the DB call to complete
        cheeseFuture.get(); // Wait for the REST call to complete
        asyncResponse.resume("ok");
      } catch (InterruptedException | ExecutionException e) {
        asyncResponse.resume(e);
      }
    });
  }


}

