import java.util.ArrayList;

public class Main {
   
   public static void main(String[] args) {
      try {
         ArrayList<Log> log = FileHandler.parseFile();
         
      } catch(Exception e) {
         System.out.println(e.getMessage());
         System.exit(1);
      }
   }
}