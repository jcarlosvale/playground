package tests.leetcode.challenge30days.march2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3678/

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card id equal to id, gets in the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card id equal to id, gets out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time to travel between the startStation and the endStation.
The average time is computed from all the previous traveling from startStation to endStation that happened directly.
Call to getAverageTime is always valid.
You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at time t1 at some
station, they get out at time t2 with t2 > t1. All events happen in chronological order.

Constraints:

There will be at most 20000 operations.
1 <= id, t <= 106
All strings consist of uppercase and lowercase English letters, and digits.
1 <= stationName.length <= 10
Answers within 10-5 of the actual value will be accepted as correct.
 */
public class DesignUndergroundSystem {

    class Route{
        String fromStation;
        String toStation;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Route route = (Route) o;
            return Objects.equals(fromStation, route.fromStation) && Objects.equals(toStation, route.toStation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fromStation, toStation);
        }
    }
    class Travel {
        Route route;
        int startTime;
        int endTime;
    }

    private final HashMap<Route, List<Travel>> hashTravels;
    private final HashMap<Integer, Travel> hashUsers;

    public DesignUndergroundSystem() {
        hashTravels = new HashMap();
        hashUsers = new HashMap();
    }

    public void checkIn(int id, String stationName, int t) {
        Route route = new Route();
        route.fromStation = stationName;

        Travel travel = new Travel();
        travel.startTime = t;
        travel.route = route;

        hashUsers.put(id, travel);
    }

    public void checkOut(int id, String stationName, int t) {
        Travel travel = hashUsers.get(id);
        travel.route.toStation = stationName;
        travel.endTime = t;
        List<Travel> travels = hashTravels.getOrDefault(travel.route, new ArrayList<>());
        travels.add(travel);
        hashTravels.put(travel.route, travels);
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = new Route();
        route.fromStation = startStation;
        route.toStation = endStation;
        List<Travel> travels = hashTravels.get(route);
        if (travels == null) return 0;
        double average = 0;
        for (Travel travel: travels) {
            average += travel.endTime - travel.startTime;
        }
        return average / (0.0 + travels.size());

    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
