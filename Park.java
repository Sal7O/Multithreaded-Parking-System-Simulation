public class Park {
   private CustomSemaphore sem;
   private int simulationTime;

   public Park(int spots) {
      this.sem = new CustomSemaphore(spots);
      simulationTime = 0;
   }

   public CustomSemaphore getSem() {
      return this.sem;
   }

   public void setSem(CustomSemaphore sem) {
      this.sem = sem;
   }

   public int getSimulationTime() {
      return this.simulationTime;
   }

   public void setSimulationTime(int simulationTime) {
      this.simulationTime = simulationTime;
   }

   public void increment_time() {
      simulationTime++;
   }

}
