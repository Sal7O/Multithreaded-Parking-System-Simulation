public class Log {
   private int gate;
   private int name;
   private int arrive;
   private int parking;

   public Log(int gate, int name, int arrive, int parking) {
      this.gate = gate;
      this.name = name;
      this.arrive = arrive;
      this.parking = parking;
   }

   public Log() {
      this.gate = 0;
      this.name = 0;
      this.arrive = 0;
      this.parking = 0;
   }

   public int getGate() {
      return this.gate;
   }

   public void setGate(int gate) {
      this.gate = gate;
   }

   public int getName() {
      return this.name;
   }

   public void setName(int name) {
      this.name = name;
   }

   public int getArrive() {
      return this.arrive;
   }

   public void setArrive(int arrive) {
      this.arrive = arrive;
   }

   public int getparking() {
      return this.parking;
   }

   public void setparking(int parking) {
      this.parking = parking;
   }

}