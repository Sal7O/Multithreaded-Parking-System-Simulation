import java.util.ArrayList;

public class Main {

   public static void main(String[] Args) {
      try {
         ArrayList<Log> logs = FileHandler.parseFile();
         ArrayList<Car> cars = new ArrayList<>();
         Park park = new Park(4);
         Timer timer = new Timer(park);
         timer.start();

         for (int i = 0; i < logs.size(); i++) {
            cars.add(new Car(logs.get(i), park));
         }
         for (int i = 0; i < cars.size(); i++) {
            cars.get(i).start();
         }
         for (int i = 0; i < cars.size(); i++) {
            cars.get(i).join();
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }

   }
}
