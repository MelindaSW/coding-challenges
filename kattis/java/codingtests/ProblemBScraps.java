package capgemini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemBScraps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int nrOfUpcomingReq = Integer.parseInt(firstLine[0]);
        int maxReqPerSecond = Integer.parseInt(firstLine[1]);
        int prevTimeStamp = 0;
        int reqCounter = 0;
        int largestReqCount = 0;
        int minServersNeeded = 1;

        for (int i = 0; i < nrOfUpcomingReq; i++) {
            int currentTimeStamp = Integer.parseInt(scanner.nextLine());
            int timeDiff = currentTimeStamp - prevTimeStamp;

            if (timeDiff >= 1000) {
                reqCounter = 1;
            } else {
                reqCounter += 1;
                if (reqCounter > maxReqPerSecond && reqCounter > largestReqCount) {
                    largestReqCount = reqCounter;
                    minServersNeeded += 1;
                }
            }

            prevTimeStamp = currentTimeStamp;
        }

        System.out.println(minServersNeeded);
        scanner.close();
    }
}

//          requests.removeIf(n -> (n <= limit));


// for every request in list, remove the ones that are < req - 1000.
// add the new request to the end of the list.
// if the size of the list is > maxAmountOfRequests - store the new size in maxAmountOfRequests
// Do this until the requests end
// print the maxAmountOfRequests / maxReqPerSec as the result
//class Server {
//    private int nrOfOngoingRequests;
//    private List<Integer> requests;
//
//    public Server(int nrOfOngoingRequests, int initialRequest) {
//        this.nrOfOngoingRequests = nrOfOngoingRequests;
//        requests = new ArrayList<>();
//        requests.add(initialRequest);
//    }
//
//    public int getNrOfOngoingRequests() {
//        return nrOfOngoingRequests;
//    }
//
//    public void setNrOfOngoingRequests(int nrOfOngoingRequests) {
//        this.nrOfOngoingRequests = nrOfOngoingRequests;
//    }
//
//    public int getEarliestRequest() {
//        return requests.get(0);
//    }
//
//    public List<Integer> getRequests() {
//        return requests;
//    }
//
//    public void setRequests(List<Integer> requests) {
//        this.requests = requests;
//    }
//}

// for (int i = 0; i < nrOfUpcomingReq; i++) {
//        int req = Integer.parseInt(scanner.nextLine());
//        requests.add(req);
//        }
//
//        List<Server> servers = new ArrayList<>();
//        servers.add(new Server(0, 0));
//
//        ListIterator<Integer> reqIterator = requests.listIterator();
//        while (reqIterator.hasNext()) {
//        int currentReq = reqIterator.next();
//        boolean allServersAreBusy = false;
//
//        ListIterator<Server> serversIterator = servers.listIterator();
//        while (serversIterator.hasNext()) {
//        Server server = serversIterator.next();
//        int timeDiff = currentReq - server.getEarliestRequest();
//
//// if timeDiff <= oneReqTimeMs && nrOfOngoingRequests < maxReqPerSec : add current to requests, add 1 to nrOfOngoingRequests,  break
//// if timeDiff >= oneReqTimeMs && nrOfOngoingRequests >= maxReqPerSec :
//
//// if server is the last in the list and has not matched with any of the other conditions above
//// : create a new server, add it to the servers list and update its values with the current.
//
//        if (timeDiff <= oneReqTimeMs) {
//        server.getRequests().add(currentReq);
//        server.setNrOfOngoingRequests(server.getNrOfOngoingRequests() + 1);
//        if (server.getRequests().size() > maxReqPerSec) {
//        server.getRequests().remove(0);
//        }
//        break;
//        }
//        else if (servers.indexOf(server) == servers.size() - 1) {
//        allServersAreBusy = true;
//        break;
//        }
//        }
//        if (allServersAreBusy) servers.add(new Server(1, currentReq));
//        }
//
//        int minimumAmountOfServers = servers.size();



// For each server, check if it is busy, if all servers are, add another server

//    boolean allAreBusy = true; // Set to false if one is not busy.
//          for (int y = 0; y < servers.size(); y++)  {
//        boolean serverIsBusy = (maxReqPerSecond * oneReqTimeMs) + servers.get(y) <= reqTimeStamp;
//
//        System.out.println((maxReqPerSecond * oneReqTimeMs) + servers.get(y));
//
//        // if not busy, store newReq in the non busy server and break the loop.
//        if (!serverIsBusy) {
//        servers.set(y, reqTimeStamp);
//        allAreBusy = false;
//        break;
//        }
//        }
//        // If all are busy, add another server and store the value there.
//        if (allAreBusy) {
//        servers.add(reqTimeStamp);
//        }

//  static boolean areAllServersBusy(HashMap<Integer, Integer> servers, int time) {
//      boolean response = false;
//    for (Integer key : servers.keySet()) {
//      boolean serverIsBusy = time - key >= 1000;
//      if (serverIsBusy) {
//        response = true;
//      }
//    }
//      return response;
//  }

// Make a hashmap containing one initial server.
// For every value:
// Store the request in the latest server if the previous value and the new is less than maxReqmillisec
//
//
//for (Map.Entry<String, Object> entry : map.entrySet()) {
//        String key = entry.getKey();
//        Object value = entry.getValue();
//        // ...
//        }
//
//  boolean serverIsBusy = reqTime - servers.get(servers.size()) >= maxReqPerSecInMilliSec;
//        if (serverIsBusy) {
//                // Start a new server
//                servers.put(servers.size() + 1, reqTime);
//                }