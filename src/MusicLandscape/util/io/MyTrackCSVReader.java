package MusicLandscape.util.io;

import MusicLandscape.entities.Artist;
import MusicLandscape.entities.Track;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class MyTrackCSVReader extends MyReader<Track> {

    private static int DURATION, PERFORMER, TITLE, WRITER, YEAR;

    public MyTrackCSVReader(java.io.BufferedReader in) {
        super(in);
    }

    @Override
    public Track get() {
        Track t = new Track();
        String input;

        try {
            input = in.readLine();
            String[] splited = input.split(",");

            if (splited.length > 0) {
                t.setTitle(splited[0]);
                t.setWriter(new Artist(splited[1]));
                t.setPerformer(new Artist(splited[2]));
                t.setDuration(Integer.parseInt(splited[3]));
                t.setYear(Integer.parseInt(splited[4]));
            } else {
                System.out.print(input);
                Integer.parseInt(input);
            }

        } catch(IOException e) {
            System.out.print("Error reading.");
            return null;
        } catch (Exception e) {
            System.out.print("Error parsing.");
            return null;
        }
        return t;
    }
}
