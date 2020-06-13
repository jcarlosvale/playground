package tests.hackerrank.certification;

import java.util.List;

public class GamingLaptopBatteryLife {
    public static int getBattery(List<Integer> events) {
        int initialEnergy = 50;
        for (Integer event: events) {
            initialEnergy += event;
            if (initialEnergy < 0) {
                initialEnergy = 0;
            } else {
                if (initialEnergy > 100) {
                    initialEnergy = 100;
                }
            }
        }
        return initialEnergy;
    }
}
