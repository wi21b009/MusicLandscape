package MusicLandscape.util.matcher;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class DurationMatcher extends MyMatcher<Track> {
    private int lower, upper;

    public DurationMatcher() {
        super(null);
        lower = 0;
        upper = 2147483647;
    }

    public DurationMatcher(String pat) {
        super(pat);
        lower = 2;
        upper = 5;
    }
    @Override
    public boolean matches(Track track) {
        if (track.getDuration() >= lower && track.getDuration() <= upper)
            return true;
        return false;
    }

    @Override
    public void setPattern(String pat) {
        if (pat == null)
            return;

        String[] strings = pat.split("\\s+");
        int[] ints = new int[strings.length];

        int i = 0;
        for (String s : strings) {
            try {
                ints[i] = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return;
            }

            i++;
        }

        if (ints[0] > lower)
            lower = ints[0];

        if (ints[1] < upper && ints[1] >= ints[0])
            upper = ints[1];
    }

    @Override
    public String getPattern() {
        return String.format("%d %d", lower, upper);
    }

    @Override
    public String toString() {
        return String.format("duration in range (%d %d)", lower, upper);
    }
}
