package MusicLandscape.entities;

import MusicLandscape.util.ConsoleScanable;
import java.util.Scanner;

public class Track implements ConsoleScanable {

    //attributes
    private String title;
    private int duration, year = 1900;
    private Artist writer, performer;


    //constructor
    public Track(String title, int duration, int year, Artist writer, Artist performer) {
        this.title = title;
        this.duration = duration;
        setYear(year);
        this.writer = writer;
        this.performer = performer;
    }

    public Track() {
        this(null, 0, 0, new Artist(), new Artist());

        writer.setName("unknown");
        performer.setName("unknown");
    }

    public Track(String title) {
        this(title, 0, 0, new Artist(), new Artist());
    }

    public Track(Track other) {
        title = other.title;
        duration = other.duration;
        year = other.year;
        writer = new Artist(other.writer);
        performer = new Artist(other.performer);
    }

    //methodes
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1900 && year < 3000)
            this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration > 0)
            this.duration = duration;
    }

    public String getTitle() {
        if (this.title == null)
            return "unknown title";
        return title;
    }

    public void setTitle(String title) {
        if (title != null)
            this.title = title;
    }

    public Artist getWriter() {
        return writer;
    }

    public void setWriter(Artist writer) {
        if (writer != null)
            this.writer = writer;
    }

    public Artist getPerformer() {
        return performer;
    }

    public void setPerformer(Artist performer) {
        if (performer != null)
            this.performer = performer;
    }

    public boolean writerIsKnown () {
        if (writer == null || writer.getName() == null)
            return false;
        return true;
    }

    public String getString() {
        if (writerIsKnown()) {
            return String.format("%10.10s by %10.10s performed by %10.10s (%02d:%02d)",getTitle(), getWriter().getName(), getPerformer().getName(), (getDuration() / 60), (getDuration() % 60));
        }
        else if (title == null) {
            return String.format("%10.10s by %10.10s performed by %10.10s (%02d:%02d)", "unknown", "unknown", "unknown", (getDuration() / 60), (getDuration() % 60));

        }
        return String.format("%10.10s by %10.10s performed by %10.10s (%02d:%02d)", getTitle(), "unknown", "unknown", (getDuration() / 60), (getDuration() % 60));
    }

    @Override
    public String toString() {
        return getString();
    }

    @Override
    public boolean scan() {
        Scanner sc = new Scanner(System.in);
        String input;

        //title
        System.out.printf("title: %s\n", this.getTitle());

        input = sc.nextLine();
        if (input != null && !input.equals(""))
            this.setTitle(input);

        //duration
        System.out.printf("duration: %d\n", this.getDuration());

        int duration;
        input = sc.nextLine();
        if (input.matches("\\d+")) {
            duration = Integer.parseInt(input);
            this.setDuration(duration);
        }

        if (sc.hasNext() && getDuration() == 0) {
            input = sc.nextLine();
            if (input.matches("\\d+")) {
                duration = Integer.parseInt(input);
                this.setDuration(duration);
            }
        }

        sc.close();
        return true;
    }
}
