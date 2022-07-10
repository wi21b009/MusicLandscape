package MusicLandscape.entities;

public abstract class Release {
    private Artist artist;
    private int year;
    private String title;

    public Release(String title, Artist artist, int year) {
        setArtist(artist);
        if (year > 1900)
            setYear(year);
        else setYear(1900);
        setTitle(title);
    }

    public Release() {
        this(null, new Artist(), 0);
    }

    public Release(Release other) {
        setArtist(new Artist(other.artist));
        setYear(other.year);
        setTitle(other.title);
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 0)
            this.year = year;
    }

    public String getTitle() {
        if (title.equals("unknown"))
            return null;
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract int totalTime();

    @Override
    public String toString() {
        try {
            return String.format("%s-%s-%d-%d", getTitle(), getArtist().getName(), getYear(), totalTime());

        } catch (NullPointerException e1) {
            try {
                int i = getYear();
                if (i > 0)
                    return String.format("unknown-unknown-%d-%d", getYear(), totalTime());
                return String.format("unknown-unknown-unknown-0");
            } catch (NullPointerException ignored) {}
            return String.format("unknown-unknown-unknown-0");
        }
    }
}
