package MusicLandscape.container;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

import java.util.Iterator;
import java.util.List;

public class MyTrackContainer {
    private java.util.List<Track> selection;
    private java.util.Set<Track> tracks;

    public MyTrackContainer() {}

    public MyTrackContainer(Iterable<Track> t) {

        for (Track tracklist : t) {
            selection.add(tracklist);
        }
    }

    public MyTrackContainer(Track[] t) {}

    public void sort(java.util.Comparator<Track> theComp, boolean asc) {}

    public int filter(MyMatcher<Track> matcher) {
        return 10;
    }

    public void reset() {};

    public int remove() {
        return 10;
    }

    public int addAll(Track[] t) {
        return 10;
    }

    public int size() {
        return 10;
    }

    public Track[] selection() {
        return null;
    }

    public boolean add(Track t) {
        return true;
    }

}
