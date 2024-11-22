import java.util.concurrent.atomic.AtomicInteger;

public class CustomSemaphore {

  private int permits; // The number of available permits
  private AtomicInteger theoreticalTime;

  public CustomSemaphore(int initialPermits) {
    if (initialPermits < 0) {
      throw new IllegalArgumentException("Permits cannot be negative");
    }
    this.permits = initialPermits;
    theoreticalTime = new AtomicInteger(0);
  }

  // Acquire a permit
  public synchronized void acquire(Car car) throws InterruptedException {
    boolean waiting = false;
    while (permits == 0) {
      System.out.println(
        "Car " +
        car.getLog().getName() +
        " from Gate " +
        car.getLog().getGate() +
        " waiting for a spot."
      );
      waiting = true;
      wait(); // Wait until a permit becomes available
    }
    if (waiting) {
      System.out.println(
        "Car " +
        car.getLog().getName() +
        " parked after waiting for " +
        (this.getTheoreticalTime().get() - car.getLog().getArrive()) +
        " units of time. (Parking Status: " +
        (permits - 1) +
        " spots occupied)"
      );
      car.getLog().setArrive(theoreticalTime.get());
    } else {
      System.out.println(
        "Car " +
        car.getLog().getName() +
        " parked. (Parking Status: " +
        (permits - 1) +
        " spots occupied)"
      );
    }
    permits--; // Consume a permit
  }

  // Release a permit
  public synchronized void release(Car car) {
    permits++; // Increase the available permits
    System.out.println(
      "Car " +
      car.getLog().getName() +
      " From Gate " +
      car.getLog().getGate() +
      " left after " +
      car.getLog().getLeave() +
      " units of time. (Parking Status: " +
      (permits) +
      " spots occupied)"
    );
    notify(); // Notify a waiting thread
  }

  public AtomicInteger getTheoreticalTime() {
    return this.theoreticalTime;
  }

  public void incrementSimulationTime() {
    theoreticalTime.incrementAndGet();
  }
}
