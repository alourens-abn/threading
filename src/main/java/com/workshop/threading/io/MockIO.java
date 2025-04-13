package com.workshop.threading.io;

public class MockIO {

  private static final int CUT_CHEESE = 5000;
  private static final int BUTTER_BREAD = 10000;

  //todo task 3: these methods need to be changed to mono methods
  //hint task 3: you need to make use of a non-blocking IO library to prevent freezing up your threads
  public static void cutCheese() {
    try {
      Thread.sleep(CUT_CHEESE);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void butterBread() {
    try {
      Thread.sleep(BUTTER_BREAD);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
