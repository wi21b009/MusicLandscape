package MusicLandscape.entities;

public class TVShow extends Event{
    private String name;
    private int viewers;

    public TVShow(String name, int viewers) {
        this.name = name;
        this.viewers = viewers;
    }

    public TVShow() {
        this(null, 0);
    }

    public TVShow(Event event) {
        super(event);
    }

    public TVShow(TVShow other) {
        super(other);
        name = other.name;
        viewers = other.viewers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        if (viewers >= 1)
            this.viewers = viewers;
    }

    @Override
    public String toString() {
        if (artist != null && venue != null)
            return String.format(artist.getName() + " @ " + getName() + " on " + date + "\n" + description + "\n(%d attending (%d))", viewers + attendees, impact());
        return String.format("unknown @ unknown on " + date + "\n" + description + "\n(%d attending (%d))", viewers + attendees, impact());
    }

    @Override
    public int impact() {
        return attendees * 2 + viewers * 2;
    }
}
