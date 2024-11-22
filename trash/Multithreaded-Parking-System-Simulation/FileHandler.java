import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class FileHandler {

   public static ArrayList<Log> parseFile() throws Exception {
      ArrayList<Log> log = new ArrayList<>();
      String format = "Gate #, Car #, Arrive #, Parks #,";
      String fileName = "file.txt";
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line;
      while((line = br.readLine()) != null) {
         int a = -1, b = -1, c = -1, d = -1;
         line = line + ",";
         int i, j;
         for(i = 0, j = 0; i < format.length(); i++) {
            if(format.charAt(i) == '#') {
               StringBuilder s = new StringBuilder();
               while(line.charAt(j) != ',') {
                  if(line.charAt(j) < '0' || line.charAt(j) > '9') {
                     br.close();
                     throw new Exception("Incorrect format");
                  }
                  s.append(line.charAt(j));
                  j++;
               }
               int x = Integer.parseInt(s.toString());
               if(a == -1) {
                  a = x;
               } else if(b == -1) {
                  b = x;
               } else if(c == -1) {
                  c = x;
               } else {
                  d = x;
               }

            } else {
               if(format.charAt(i) != line.charAt(j++)) {
                  br.close();
                  throw new Exception("Incorrect format");
               }
            }
         }
         if(j < i || j < line.length()) {
            br.close();
            throw new Exception("Incorrect format");
         }
         log.add(new Log(a, b, c, d));
      }

      br.close();
      return log;
   }

}

