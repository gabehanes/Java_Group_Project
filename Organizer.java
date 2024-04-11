import java.util.ArrayList;

public class Organizer {
    private String organizerName;
    private ArrayList<Event> events;

    public Organizer(String name) {
        this.organizerName = name;
        this.events = new ArrayList<>();
    }

    public void createEvent(String name, String date, String type, int max, ArrayList<String> speakers) {
        if (type.equals("Conference")) {
            events.add(new Conference(name, date, max, speakers));
        } else {
            // Handle other types of events
        }
    }

    public void manageGuestList(String eventName, ArrayList<String> guests) {
        for (Event event : events) {
            if (event.getEventName().equals(eventName)) {
                // Add guests to event's guest list
            }
        }
    }

    public void sendInvitations(String eventName, ArrayList<String> guests) {
        // Send invitations to guests
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
}
