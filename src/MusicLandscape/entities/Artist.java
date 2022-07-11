package MusicLandscape.entities;

public class Artist implements Comparable<Artist>{

    //attributes
    private String name;



    //constructor
    public Artist(String name) {
        name = name.trim();
        this.name = name;
    }

    public Artist() {
        this("unknown");
    }

    public Artist(Artist other) {
        name = other.name;
    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.matches("") && !name.matches(" {2}")) {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Artist o) {
        return name.compareTo(o.getName());
    }
}
