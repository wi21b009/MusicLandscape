package MusicLandscape.entities;

public class TrackListItem {
    TrackListItem next;
    Track track;

    public TrackListItem(Track track) {
        this.track = track;
        this.next = null;
    }
}
