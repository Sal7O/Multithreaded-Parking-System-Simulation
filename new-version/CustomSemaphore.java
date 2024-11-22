public class CustomSemaphore {
   private int permits;

   public CustomSemaphore(int permits) {
      if (permits < 0) {
         throw new IllegalArgumentException("Permits cannot be negative");
      }
      this.permits = permits;
   }

   public synchronized void acquire(Car car, Park park) throws Exception {
      boolean waiting = false;
      while (permits == 0) {
         waiting = true;
         System.out.println(
               "Car " +
                     car.getLog().getName() +
                     " from Gate " +
                     car.getLog().getGate() +
                     " waiting for a spot.");
         wait();
      }
      permits--;
      if (waiting) {
         System.out.println(
               "Car " +
                     car.getLog().getName() +
                     " parked after waiting for " +
                     (park.getSimulationTime() - car.getLog().getArrive() + 1) +
                     " units of time. (Parking Status: " +
                     (4-permits) +
                     " spots occupied)");
      } else {
         System.out.println(
               "Car " +
                     car.getLog().getName() +
                     " parked. (Parking Status: " +
                     (4-permits) +
                     " spots occupied)");
      }

   }

   public synchronized void release(Car car) {
      permits++;
      System.out.println(
            "Car " +
                  car.getLog().getName() +
                  " from gate " +
                  car.getLog().getGate() +
                  " left after " +
                  car.getLog().getparking() +
                  " units of time. (Parking Status: " +
                  (4-permits) +
                  " spots occupied)");
      notify();
   }

}
