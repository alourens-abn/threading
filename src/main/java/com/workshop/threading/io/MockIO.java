package com.workshop.threading.io;

public class MockIO {

  private static final int millisDb = 5000;
  private static final int millisRest = 10000;

  public static void makeDbCall() {
    try {
      Thread.sleep(millisDb);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void makeRestCall() {
    try {
      Thread.sleep(millisRest);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
