package MusicLandscape.util.comparators;

import MusicLandscape.entities.Track;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class TitleComparator implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

    @Override
    public Comparator<Track> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Track> thenComparing(Comparator<? super Track> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Track> thenComparing(Function<? super Track, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Track> thenComparing(Function<? super Track, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Track> thenComparingInt(ToIntFunction<? super Track> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Track> thenComparingLong(ToLongFunction<? super Track> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Track> thenComparingDouble(ToDoubleFunction<? super Track> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }

    @Override
    public String toString() {
        return "by title";
    }
}
