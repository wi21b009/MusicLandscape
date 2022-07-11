package MusicLandscape;

import MusicLandscape.entities.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Artist writer = new Artist("Tobias Jahodinsky");
        Artist performer = new Artist("Rebecca Jaksch");

        Track one = new Track("gfy", 230, 2022, writer,performer);
        Track two = new Track("Daki", 20, 2021, writer, performer);
        Track three = new Track(one);


        Event eins = new Event(new Artist("Max Mustermann"), new Venue(), new Date(), "Frequenzy", 500000);
        Event zwei = new Event(eins);
        Event drei = new Event(zwei);

        Concert concert01 = new Concert();
        Album album01 = new Album();

        concert01.addTrack(one);
        concert01.addTrack(two);
        concert01.addTrack(three);

        album01.addTrack(one);
        album01.addTrack(two);
        album01.addTrack(three);

        System.out.printf("duration: %d", one.getDuration());
        System.out.printf("duration: %d", two.getDuration());
        System.out.printf("duration: %d", three.getDuration());

        System.out.printf("%s", album01);

        System.out.printf("duration: %d", album01.totalTime());



        Track[] testList = concert01.getSetList();

        for (int i = 0; i < testList.length; i++) {
            System.out.printf("%s\n", testList[i].getTitle());
        }

        //boolean four = new Track().scan();

        String test12 = ",,,,,,,,,";
        String[] test13 = test12.split(",");

        for (String s : test13) {
            System.out.println(s);
            System.out.print("Seas");
        }
        System.out.print(test13.length);

    }
}