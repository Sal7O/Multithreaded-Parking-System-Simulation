import java.util.ArrayList;

public class Main {

  private static ArrayList<Car> cars;
  private static CustomSemaphore park;

  public static void checkArrive() {
    cars.forEach(car -> {
      if (car.getLog().getArrive() == park.getTheoreticalTime().get()) {
        car.start();
      }
    });
  }

  public static void main(String[] args) {
    try {
      ArrayList<Log> logs = FileHandler.parseFile();
      cars = new ArrayList<>();
      park = new CustomSemaphore(4);
      logs.forEach(log -> {
        cars.add(new Car(log, park));
      });
      Timer time = new Timer(park);
      time.start();
    } catch (Exception e) {
      System.out.println("55555555555555");
    }
  }
}
