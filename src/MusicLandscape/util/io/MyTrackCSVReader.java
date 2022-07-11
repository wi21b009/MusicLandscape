package MusicLandscape.util.io;

import MusicLandscape.entities.Track;

public class MyTrackCSVReader extends MyReader<Track> {

    private static int DURATION, PERFORMER, TITLE, WRITER, YEAR;

    public MyTrackCSVReader(java.io.BufferedReader in) {
        super(in);
    }

    @Override
    public Track get() {
        return null;
    }
}
