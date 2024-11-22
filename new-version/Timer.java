public class Timer extends Thread {
   Park park;

   public Timer(Park park) {
      this.park = park;
      setDaemon(true);
   }

   public Park getPark() {
      return this.park;
   }

   public void setPark(Park park) {
      this.park = park;
   }

   @Override
   public void run() {
      while (true) {
         try {
            Thread.sleep(1000);
            park.increment_time();
         } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
         }
      }
   }
}