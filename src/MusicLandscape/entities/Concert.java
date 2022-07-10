package MusicLandscape.entities;

import java.util.Arrays;

import static java.util.Arrays.copyOf;

public class Concert extends Event {
    private Track[] setList;
    private int nextIdx;

    public boolean addTrack (Track track) {
        if (track == null)
            return false;

        if(setList == null) {
            setList = new Track[0];
            nextIdx = 0;
        }

        if(setList.length < nextIdx + 1) {
            //new array without any informations > new array is one place longer than setList
            Track[] memoryList = new Track[nextIdx + 1];

            //copying the old array to the new one (just if there is anything in the array)
            if (setList.length > 0) {
                for (int i = 0; i < setList.length; i++) {
                    memoryList[i] = setList[i];
                }
            }

            //adding the new track and setting up the nextIdx
            memoryList[nextIdx] = track;
            nextIdx++;

            //setting the setList to the new array
            setList = copyOf(memoryList, memoryList.length);
        } else {
            setList[nextIdx] = track;
            nextIdx++;
        }

        return true;
    }

    public void ensureCapacity(int capacity) {
        return;
    }

    public Track[] getSetList() {
        Track[] tmp = new Track[setList.length];

        for (int i = 0; i < setList.length; i++) {
            tmp[i] = new Track(setList[i]);
        }

        return tmp;
    }

    public void setSetList(Track[] tracks) {
        int i = 0, j = 0, k = 0;

        //counts length of non-null entries
        for ( ; j < tracks.length; j ++) {
            if (tracks[j] != null)
                j++;
        }

        //creating new array with the length of array without null entries
        setList = new Track[j];

        //filling the new array with non-null entries of the origin array
        for ( ; i < tracks.length; i ++) {
            if (tracks[i] != null) {
                setList[k] = new Track(tracks[i]);
                k++;
            }
        }
    }

    public void resetSetList() {
        setList = new Track[0];
        nextIdx = 0;
    }

    public int nrTracks() {
        int nr = 0;
        if (nextIdx == 0)
            return 0;
        for (int i = 0 ; i < setList.length; i++)
            nr++;
        return nr;
    }

    public int duration() {
        if (nextIdx == 0)
            return 0;
        int duration = 0;
        for (int i = 0; i < setList.length; i++)
            duration += setList[i].getDuration();
        return duration;
    }

    public String durationHour() {
        int hoursFormated = duration() / 3600;
        int minutesFormated = (duration() - hoursFormated * 3600) / 60;
        return String.format("%02d:%02d.", hoursFormated, minutesFormated);
    }

    @Override
    public int impact() {
        return getAttendees() * 3;
    }


    @Override
    public String toString() {
        return String.format("%s\n%d tracks played, total duration %s", super.toString(), setList.length, durationHour());
    }
}
