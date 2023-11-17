package ada;

import java.util.TreeMap;

class BankCalendar {
    private TreeMap<Integer, Integer> timeline = new TreeMap<>();

    public BankCalendar() {

    }

    public boolean book(int start, int end) {
        Integer low = timeline.lowerKey(end);

        if (low == null || timeline.get(low) <= start) {
            timeline.put(start, end);
            return true;
        }

        return false;
    }
}
