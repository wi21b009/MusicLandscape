package MusicLandscape.util.io;

import MusicLandscape.util.MyFormatter;

public class MyWriter<T> {
    protected java.io.FileWriter out;
    private MyFormatter<T> theFormat;

    public MyWriter(java.io.FileWriter file, MyFormatter<T> theFormat) {
        this.out = file;
        this.theFormat = theFormat;
    }

    public final boolean put (T t) {
        return false;
    }

    public void close() throws java.io.IOException {

    }
}
