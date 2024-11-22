import java.util.ArrayList;

public class Main {

  private static ArrayList<Car> cars;
  private static CustomSemaphore park;

  public static void checkArrive() {

    cars.forEach(car -> {
      if (car.getLog().getArrive()+car.getLog().getLeave() == park.getTheoreticalTime().get()) {
        park.release(car);
      }
    });
    cars.forEach(car -> {
      if (car.getLog().getArrive() == park.getTheoreticalTime().get()) {
        car.start();
      }
    });
  }

  public static void main(String[] args) {
    try {
      ArrayList<Log> logs = FileHandler.parseFile();
      Main.cars = new ArrayList<>();
      Main.park = new CustomSemaphore(4);
      logs.forEach(log -> {
        cars.add(new Car(log, Main.park));
      });
      Timer time = new Timer(Main.park);
      time.start();
      time.join();
    } catch (Exception e) {
      System.out.println("55555555555555");
    } 
  }
}
