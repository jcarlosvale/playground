package tests.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fuel {

    class Pump {
        boolean busy;
        int available;
        int used;

        Pump(int available) {
            this.busy = false;
            this.available = available;
            this.used = 0;
        }

        void usePump(int demand) {
            busy = true;
            used = used + demand;
            available = available - demand;
        }
    }

    public int solution(int[] A, int X, int Y, int Z) {
        List<Pump> pumpList = new ArrayList<>();
        pumpList.add(new Pump(X));
        pumpList.add(new Pump(Y));
        pumpList.add(new Pump(Z));
        //wait time for each car
        int [] waitTimes = new int[A.length];

        for(int i=0; i<A.length; i++) {
            int wait = selectPump(A[i], pumpList);
            if (wait == -1) return wait;
            waitTimes[i] = wait;
        }
        return Arrays.stream(waitTimes).max().getAsInt();
    }

    private int selectPump(int carDemand, List<Pump> pumpList) {
        //exists available and cover the demand
        List<Pump> availablePumps = pumpList.stream().filter(pump -> !pump.busy).collect(Collectors.toList());
        List<Pump> busyPumps = pumpList.stream().filter(pump -> pump.busy).collect(Collectors.toList());
        for (Pump pump: availablePumps) {
            if (pump.available >= carDemand) {
                pump.usePump(carDemand);
                return 0;
            }
        }
        //search busy
        for (Pump pump: busyPumps) {
            if (pump.available >= carDemand) {
                int wait = pump.used;
                pump.usePump(carDemand);
                return wait;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Fuel fuel = new Fuel();
        int [] A = new int[] {2,8,4,3,2};
        int X = 7, Y=11, Z=3;
        System.out.println(fuel.solution(A, X, Y, Z));
        X = 4; Y=0; Z=3;
        A = new int[] {5};
        System.out.println(fuel.solution(A, X, Y, Z));
    }


}
