package capgemini;

import java.util.*;

public class ProblemBMain {

    public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      String[] firstLine = scanner.nextLine().split(" ");
      int nrOfUpcomingReq = Integer.parseInt(firstLine[0]);
      int maxReqPerSec = Integer.parseInt(firstLine[1]);
      int oneReqTimeMs = 1000;
      double maxAmountOfReqInASec = 0.0;
      List<Integer> requests = new ArrayList<>();

      for (int i = 0; i < nrOfUpcomingReq; i++) {
          int reqTimeStamp = Integer.parseInt(scanner.nextLine());
          int limit = reqTimeStamp - oneReqTimeMs;

          for (int y = 0; y < requests.size(); y++) {
              if (requests.get(y) <= limit) {
                  requests.remove(requests.get(y));
              } else {
                  break;
              }
          }

          requests.add(reqTimeStamp);
          if (requests.size() >= maxAmountOfReqInASec) maxAmountOfReqInASec = requests.size();
      }

      int minAmountOfServers = (int) Math.ceil(maxAmountOfReqInASec / maxReqPerSec);
      System.out.println(minAmountOfServers);
      scanner.close();
    }
 }
