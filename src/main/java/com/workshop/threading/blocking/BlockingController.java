package com.workshop.threading.blocking;

import com.workshop.threading.io.MockIO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path("/sandwich")
public class BlockingController {

  private final ExecutorService executorService;

  public BlockingController() {
    this.executorService = Executors.newFixedThreadPool(400);
  }

  @GET
  @Path("/cheese")
  public void blocking(@Suspended final AsyncResponse asyncResponse) {
    try {
      // Submit tasks to the executor service
      var future1 = executorService.submit(MockIO::cutCheese);
      var future2 = executorService.submit(MockIO::butterBread);

      // Wait for both tasks to complete
      future1.get();
      future2.get();
      asyncResponse.resume("ok");
    } catch (Exception e) {
      e.printStackTrace();
      asyncResponse.resume("error");
    }
  }


}

