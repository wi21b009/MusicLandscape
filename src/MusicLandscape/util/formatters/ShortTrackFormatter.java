// **************************************************
//		
//       git.rev = 234
//  git.revision = fdd4980be270473bdd7e8206afeda65ab6e4c3a4
//         stage = ES04
//
// ***************************************************
package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyFormatter;

/**
 * This class represents the concept of short formatting of a track containing
 * only some information.
 * 
 * 
 * @author TeM, JS
 * @version 234
 * @Stage ES04
 * @ProgrammingProblem.Category abstract class
 * @ProgrammingProblem.Introduced ExerciseSheet04
 */
public class ShortTrackFormatter implements MyFormatter<Track>{

	/**
	 * Creates a short format of a track.<br>
	 * 
	 * The short representation of a track is
	 * "title" "performer"
	 * (without quotes)
	 * Both title, and performer are exactly ten characters wide with leading blanks (if any).
	 * 
	 */
	@Override
	public String format(Track t) {
		return String.format("%-10.10s (%s)", t.getTitle(), durationFormated(t));
	}

	public String durationFormated(Track t) {
		int minutesFormated = t.getDuration() / 60;
		int secondsFormated = (t.getDuration() % 60);
		return String.format("%02d:%02d", minutesFormated, secondsFormated);
	}

	@Override
	public String topSeparator() {
		return "--------------------";
	}

	@Override
	public String header() {
		return "Title      (min:sec)";
	}

	@Override
	public String toString() {
		return "short format [Title (min:sec)]";
	}

}
