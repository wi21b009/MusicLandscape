package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyFormatter;

public class CSVTrackFormatter implements MyFormatter<Track> {
    @Override
    public String header() {
        return "Title, Writer, Performer, duration, year";
    }

    @Override
    public String format(Track track) {
        return String.format("%s,%s,%s,%d,%d", track.getTitle(), track.getPerformer().getName(), track.getWriter().getName(), track.getYear(), track.getDuration());
    }

    @Override
    public String topSeparator() {
        return "";
    }

    @Override
    public String toString() {
        return "CSV format [Title, Writer, Performer, duration, year]";
    }
}
