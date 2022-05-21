package LowLevelDesign;

import com.chicago.Jan2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.jar.JarOutputStream;

public class UndergroundSystem {
    Map<Integer, TravelInfo> travelInfoMap;
    Map<String, Journey>  journeyMap;
    private static class TravelInfo {
        int id;
        String stationName;
        int time;
        TravelInfo(int id, String stationName, int t) {
            this.id = id;
            this.stationName = stationName;
            this.time = t;
        }
    }

    private class Journey {
        private double total = 0; // sum of all the travel happened between two stations
        private int count = 0; // Count is the amount of customers that travel between
        // two stations previously
        // We can easily compute the average any time by simply doing (total/count)

        // Update the travel time data with this trip.
        public void updateAverage(int diff) {
            count++;
            total+=diff;
        }
        // The average is simply the total divided by the number of trips(count).
        public double getAverage() {
            return total/count;
        }
    }


    public UndergroundSystem() {
        travelInfoMap = new HashMap<Integer, TravelInfo>();
        journeyMap = new HashMap<String, Journey>();
    }

    public void checkIn(int id, String stationName, int t) {
        // Check in
        travelInfoMap.put(id, new TravelInfo(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        TravelInfo travelInfo = travelInfoMap.get(id);
        // Removing old entries is an O(1)O(1) time complexity operation.
        // Therefore, it's best to remove the entries to save memory.
        // Note that this is optional, we'll talk about it in the space
        // complexity analysis.
        travelInfoMap.remove(id);
        int diff = t - travelInfo.time;
        String stationKey = stationKey(travelInfo.stationName, stationName);
        Journey journeyData = journeyMap.containsKey(stationKey) ?
                              journeyMap.get(stationKey): new Journey();
        journeyData.updateAverage(diff);
        journeyMap.put(stationKey, journeyData);
    }

    public double getAverageTime(String startStation, String endStation) {
        String stationKey  = stationKey(startStation, endStation);
        return journeyMap.get(stationKey).getAverage();
    }

    private String stationKey(String startStation, String endStation)  {
        return startStation + "->" + endStation;
    }
}
