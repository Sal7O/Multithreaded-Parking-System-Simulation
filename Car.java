public class Car extends Thread {
   private Log log;
   private Park park;


   public void arrive() {
      System.out.println("Car " + log.getName() + " from Gate " + log.getGate() + " arrived at time " + log.getArrive());
   }

   public void park() throws Exception {
      while(park.getTheoreticalTime().get() < log.getArrive()) {
         sleep(10);
      }
      arrive();
      if (park.getSpots().tryAcquire()) {
         System.out.println("Car " + log.getName() + " parked. (Parking Status: " + (4 - park.getSpots().availablePermits()) + " spots occupied)");
      } else {
         System.out.println("Car " + log.getName() + " from Gate " + log.getName() + " waiting for a spot.");
         while (!park.getSpots().tryAcquire()) {
            sleep(10);
         }
         System.out.println("Car " + log.getName() + " parked after waiting for " + (park.getTheoreticalTime().get() - log.getArrive()) + " units of time. (Parking Status: " + (4 - park.getSpots().availablePermits()) + " spots occupied)");
      }

   }

   public void leave() throws Exception{
      while(park.getTheoreticalTime().get() < log.getLeave()) {
         sleep(10);
      }
      System.out.println("Car " + log.getName() + " left after " + log.getLeave() + " units of time. (Parking Status: " + (3 - park.getSpots().availablePermits()) + " spots occupied)");
      park.getSpots().release();
   }


   public Car(Log log, Park park) {
      this.log = log;
      this.park = park;
   }

   public Log getLog() {
      return this.log;
   }

   public Park getPark() {
      return this.park;
   }


   @Override
   public void run() {
      try {
         park();
         leave();
      } catch(Exception e) {
         System.out.println(e.getMessage());
         System.exit(1);
      }

   }


   
}
