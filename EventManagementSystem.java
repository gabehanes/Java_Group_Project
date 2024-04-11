import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class EventManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an Organizer
        System.out.println("Enter organizer name:");
        String organizerName = scanner.nextLine();
        Organizer organizer = new Organizer(organizerName);

        // Creating an Attendee
        System.out.println("Enter attendee name:");
        String attendeeName = scanner.nextLine();
        Attendee attendee = new Attendee(attendeeName);

        // Creating a conference event
        ArrayList<String> speakers = new ArrayList<>();
        speakers.add("Speaker 1");
        speakers.add("Speaker 2");
        System.out.println("Enter event name:");
        String eventName = scanner.nextLine();
        System.out.println("Enter event date:");
        String eventDate = scanner.nextLine();
        System.out.println("Enter maximum number of attendees:");
        int maxAttendees = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        organizer.createEvent(eventName, eventDate, "Conference", maxAttendees, speakers);

        // RSVPing to the conference
        System.out.println("Would you like to RSVP to the conference? (yes/no)");
        String rsvpChoice = scanner.nextLine();
        if (rsvpChoice.equalsIgnoreCase("yes")) {
            attendee.RSVP(eventName);
            System.out.println("You have successfully RSVP'd to the conference.");
        } else {
            System.out.println("You chose not to RSVP to the conference.");
        }

        // Managing guest list and sending invitations
        System.out.println("Enter guest name (enter 'done' to finish adding guests):");
        ArrayList<String> guests = new ArrayList<>();
        String guestName = scanner.nextLine();
        while (!guestName.equalsIgnoreCase("done")) {
            guests.add(guestName);
            System.out.println("Enter guest name (enter 'done' to finish adding guests):");
            guestName = scanner.nextLine();
        }
        organizer.manageGuestList(eventName, guests);
        organizer.sendInvitations(eventName, guests);

        // Submitting feedback for the conference
        System.out.println("Would you like to submit feedback for the conference? (yes/no)");
        String feedbackChoice = scanner.nextLine();
        if (feedbackChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter your feedback:");
            String feedback = scanner.nextLine();
            attendee.submitFeedback(eventName, feedback);
            System.out.println("Thank you for your feedback!");
        } else {
            System.out.println("You chose not to submit feedback for the conference.");
        }

        // Printing information about the event and attendee
        System.out.println("\nEvent Details:");
        for (Event event : organizer.getEvents()) {
            System.out.println("Event Name: " + event.getEventName());
            System.out.println("Event Date: " + event.getEventDate());
            if (event instanceof Conference) {
                Conference conference = (Conference) event;
                System.out.println("Max Attendees: " + conference.getMaxAttendees());
                System.out.println("Guest Speakers: " + conference.getGuestSpeakers());
            }
        }

        System.out.println("\nAttendee Details:");
        System.out.println("Attendee Name: " + attendee.getAttendeeName());
        System.out.println("Attended Events: " + attendee.getAttendedEvents());

        // Closing scanner
        scanner.close();
    }
}
