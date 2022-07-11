package MusicLandscape.util.io;

import MusicLandscape.util.MyFormatter;

import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class MyWriter<T> {
    protected java.io.FileWriter out;
    private MyFormatter<T> theFormat;

    public MyWriter(java.io.FileWriter file, MyFormatter<T> theFormat) {
        if (file == null)
            throw new IllegalArgumentException("expected non-null FileWriter");
        if (theFormat == null)
            throw new IllegalArgumentException("expected non-null MyFormatter");
        this.out = file;
        this.theFormat = theFormat;
    }

    public final boolean put (T t) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(out)) {
            bw.write(theFormat.format(t));
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public void close() throws java.io.IOException {

    }
}
