public class Log {
   public int arrive;
   public int park;
   public int leave;

   public Log(int arrive, int park, int leave) {
      this.arrive = arrive;
      this.park = park;
      this.leave = leave;
   }
   

   public int getArrive() {
      return this.arrive;
   }

   public void setArrive(int arrive) {
      this.arrive = arrive;
   }

   public int getPark() {
      return this.park;
   }

   public void setPark(int park) {
      this.park = park;
   }

   public int getLeave() {
      return this.leave;
   }

   public void setLeave(int leave) {
      this.leave = leave;
   }
   
}
