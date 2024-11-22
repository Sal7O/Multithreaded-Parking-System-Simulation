public class Car extends Thread {
   private Log log;
   private Park park;

   public Car(Log log, Park park) {
      this.log = log;
      this.park = park;
   }

   public Log getLog() {
      return this.log;
   }

   public void setLog(Log log) {
      this.log = log;
   }

   @Override
   public void run() {
      try {
         sleep(log.getArrive() * 1000);
         System.out.println(
               "Car " +
                     log.getName() +
                     " from Gate " +
                     log.getGate() +
                     " arrived at time " +
                     log.getArrive());
         park.getSem().acquire(this, park);
         sleep(log.getparking() * 1000);

         park.getSem().release(this);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

}