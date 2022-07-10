package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;

public class MyCSVTrackFormatter extends MyTrackFormatter {

    public MyCSVTrackFormatter() {
    }

    @Override
    public String format(Track t) {
        return String.format(t.getTitle() + "," + t.getPerformer() + "," + t.getWriter() + "," +t.getYear() + "," + t.getDuration() + ";");
    }
}
