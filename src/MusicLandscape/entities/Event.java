package MusicLandscape.entities;


public class Event {

    //attributes
    protected Artist artist;
    protected Venue venue;
    protected Date date;
    protected String description;
    protected int attendees;

    //constructors

    public Event(Artist artist, Venue venue, Date date, String description, int attendees) {
        this.artist = artist;
        this.venue = venue;
        this.date = date;
        this.description = description;
        this.attendees = attendees;
    }

    public Event(){
        this(new Artist(), null, null, "", 0);
    }

    public Event(Event other) {
        artist = new Artist(other.artist);
        venue = new Venue(other.venue);
        date = new Date(other.date);
        description = other.description;
        attendees = other.attendees;
    }

    //methods

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        if (artist != null)
            this.artist = artist;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Date getDate() {
        if (date != null)
            return new Date(date);
        return date;
    }

    public void setDate(Date date) {
        if (date != null)
            this.date = new Date(date);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description != null)
            this.description = description;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        if (attendees > 0)
            this.attendees = attendees;
    }

    public int impact() {
        return getAttendees() * 2;
    }

    @Override
    public String toString() {
        if (artist != null && venue != null)
            return String.format(artist.getName() + " @ " + venue.getName() + " on " + date + "\n" + description + "\n(%d attending (%d))", attendees, impact());
        return String.format("unknown @ unknown on " + date + "\n" + description + "\n(%d attending (%d))", attendees, impact());
    }
}
