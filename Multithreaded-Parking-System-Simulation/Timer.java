public class Timer extends Thread{
   CustomSemaphore park;

   public Timer(CustomSemaphore park) {
      this.park = park;
      setDaemon(true);
   }

   public CustomSemaphore getPark() {
      return this.park;
   }

   public void setPark(CustomSemaphore park) {
      this.park = park;
   }

   @Override
   public void run() {
      while(true) {
         try {
            Main.checkArrive();
            Thread.sleep(1000);
            park.incrementSimulationTime();
         } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
         }
      }
   }
}
