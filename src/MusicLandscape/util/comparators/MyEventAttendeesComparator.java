package MusicLandscape.util.comparators;

import MusicLandscape.entities.Event;

public class MyEventAttendeesComparator extends MyEventComparator{

    public MyEventAttendeesComparator() {}

    @Override
    public int compare (Event e1, Event e2) {
        //event = null
        if (e1 == null || e2 == null) {
            if (e1 == null && e2 == null)
                return 0;
            if (e1 == null)
                return -1;
            if (e2 == null)
                return 1;
        }

        return e1.getAttendees() - e2.getAttendees();
    }
}
