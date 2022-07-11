package MusicLandscape.container;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

import java.util.*;

public class MyTrackContainer {
    private java.util.List<Track> selection;
    private java.util.Set<Track> tracks;

    public MyTrackContainer() {
        this.selection = new LinkedList<Track>();
        this.tracks = new HashSet<Track>();
    }

    public MyTrackContainer(Iterable<Track> t) {
        this.selection = new LinkedList<Track>();
        this.tracks = new HashSet<Track>();

        for (Track track : t) {
            tracks.add(track);
            selection.add(track);
        }
    }

    public MyTrackContainer(Track[] t) {
        this.selection = new LinkedList<Track>();
        this.tracks = new HashSet<Track>();

        for (Track track : t) {
            selection.add(track);
            tracks.add(track);
        }
    }

    public void sort(java.util.Comparator<Track> theComp, boolean asc) {
        selection.sort(theComp);
    }

    public int filter(MyMatcher<Track> matcher) {
        int i = 0;

        Track[] track = new Track[selection.size()];

        for (Track t : selection.toArray(track)) {
            if (!matcher.matches(t)) {
                i++;
                selection.remove(t);
            }
        }

        return i;
    }

    public void reset() {
        selection.clear();

        selection.addAll(tracks);

        tracks.clear();
    }

    public int remove() {
        int i = 0;

        //Track[] track = new Track[selection.size()];

        for (Track t : selection) {
            tracks.remove(t);
            i++;
        }
        selection.clear();

        selection.addAll(tracks);

        return i;
    }

    public int addAll(Track[] t) {
        int i = 0;
        for (Track track : t) {
            tracks.add(track);
            i++;
        }

        return i;
    }

    public int size() {
        return tracks.size();
    }

    public Track[] selection() {
        Track[] track = new Track[selection.size()];
        return selection.toArray(track);
    }

    public boolean add(Track t) {
        if (t == null)
            return false;

        boolean unique = tracks.add(t);

        if (!unique)
            selection.add(t);

        return unique;
    }

}
