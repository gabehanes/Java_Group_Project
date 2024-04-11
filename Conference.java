import java.util.ArrayList;

public class Conference extends Event {
    private int maxAttendees;
    private ArrayList<String> guestSpeakers;

    public Conference(String name, String date, int max, ArrayList<String> speakers) {
        super(name, date, "Conference");
        this.maxAttendees = max;
        this.guestSpeakers = speakers;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public ArrayList<String> getGuestSpeakers() {
        return guestSpeakers;
    }
}
