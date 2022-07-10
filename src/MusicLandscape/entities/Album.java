package MusicLandscape.entities;

public class Album extends Release{
    private TrackListItem trackListHead;

    public Album(String title, Artist artist, int year) {
        super(title, artist, year);
    }

    public Album() {
        this(null, new Artist(), 0);
    }

    public Album(Album other) {
        super(other);
    }

    @Override
    public int totalTime() {
        int time = 0;

        for (TrackListItem tmp = trackListHead; tmp != null; tmp = tmp.next) {
            time = time + tmp.track.getDuration();
        }

        return time;
    }

    public boolean addTrack(Track t) {
        if (t == null)
            return false;

        if (trackListHead == null) {
            trackListHead = new TrackListItem(t);

            return true;
        }

        if (trackListHead.next == null) {
            trackListHead.next = new TrackListItem(t);

            return true;
        }

        TrackListItem tmp = trackListHead;
        for ( ; ; tmp = tmp.next) {
            if (tmp.next == null)
                break;
        }
        tmp.next = new TrackListItem(t);

        return true;
    }

    public Track removeTrack(int n) {

        if (trackListHead == null)
            return null;

        Track toDelete;
        TrackListItem tmp = trackListHead;

        if (n == 0) {
            toDelete = trackListHead.track;
            trackListHead = trackListHead.next;
            return  toDelete;
        }

        for (int i = 0; ; i++) {
            if (i == n - 1) {
                toDelete = tmp.next.track;
                tmp.next = tmp.next.next;
                break;
            }

            if (tmp.next == null)
                return null;

            tmp = tmp.next;
        }

        return toDelete;
    }

    public int nrTracks() {
        int i = 0;
        TrackListItem tmp = trackListHead;
        if (tmp == null)
            return i;

        for ( ; ; tmp = tmp.next) {
            i++;
            if (tmp.next == null)
                break;
        }


        return i;
    }

    public Track[] getTracks() {
        Track[] arr = new Track[nrTracks()];
        TrackListItem tmp = trackListHead;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp.track;
            tmp = tmp.next;
        }

        return arr;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "\n[" + titleString() + "]");
    }

    public String titleString() {
        if (nrTracks() == 0)
            return "";

        Track[] tracks = getTracks();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < tracks.length; i++) {
            builder.append(String.format("[%s]", tracks[i].getTitle()));
        }

        return builder.toString();
    }
}
