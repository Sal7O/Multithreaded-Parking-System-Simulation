public class Car extends Thread {

  private Log log;
  private CustomSemaphore park;

  public Car(Log log, CustomSemaphore park) {
    this.log = log;
    this.park = park;
  }

  public Log getLog() {
    return this.log;
  }

  public CustomSemaphore getPark() {
    return this.park;
  }

  @Override
  public void run() {
    // Car 0 from Gate 1 arrived at time 0
    System.out.println(
      "Car " +
      log.getName() +
      " from Gate " +
      log.getGate() +
      " arrived at time " +
      log.getArrive()
    );
    try {
      park.acquire(this);
      Thread.sleep(log.getLeave());

      park.release(this);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
