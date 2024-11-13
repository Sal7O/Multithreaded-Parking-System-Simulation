import java.util.ArrayList;

public class Main {
   
   public static void main(String[] args) {
      try {
         ArrayList<Log> log = FileHandler.parseFile();
         ArrayList<Car> cars = new ArrayList<>();
         Park park = new Park();

         for(int i = 0; i < log.size(); i++) {
            cars.add(new Car(log.get(i), park));
         }
         
         for (Car car : cars) {
            car.start();
         }
         Timer timer = new Timer(park);
         timer.start();
         for (Car car : cars) {
            car.join();
         }
         
      } catch(Exception e) {
         System.out.println(e.getMessage());
         System.exit(1);
      }
   }
}