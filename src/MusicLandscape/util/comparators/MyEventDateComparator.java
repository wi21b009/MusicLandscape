package MusicLandscape.util.comparators;

import MusicLandscape.entities.Event;

public class MyEventDateComparator extends MyEventComparator {

    public MyEventDateComparator() {}

    @Override
    public int compare(Event e1, Event e2) {

        //event = null
        if (e1 == null || e2 == null) {
            if (e1 == null && e2 == null)
                return 0;
            if (e1 == null)
                return -1;
            if (e2 == null)
                return 1;
        }

        //getDate() = null
        if (e1.getDate() == null || e2.getDate() == null) {
            if (e1.getDate() == null && e2.getDate() == null)
                return 0;
            if (e1.getDate() == null)
                return -1;
            if (e2.getDate() == null)
                return 1;
        }


        if (e1.getDate().getYear() == e1.getDate().getYear()) {
            if (e1.getDate().getMonth() == e1.getDate().getMonth()) {
                return e1.getDate().getDay() - e2.getDate().getDay();
            }
            return e1.getDate().getMonth() - e2.getDate().getMonth();
        }
        return e1.getDate().getYear() - e2.getDate().getYear();
    }
}
