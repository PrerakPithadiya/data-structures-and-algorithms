
import java.util.ArrayList;
import java.util.List;

/**
 * MyCalendarTwo class represents a calendar system that allows booking of
 * events and prevents triple booking.
 */
class MyCalendarTwo {

    private final List<int[]> calendar;
    private final List<int[]> overlaps;

    /**
     * Constructs a new MyCalendarTwo object. Initializes the calendar and
     * overlaps lists.
     */
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    /**
     * Attempts to book an event with the given start and end times.
     *
     * @param start The start time of the event.
     * @param end The end time of the event.
     * @return true if the event can be booked without causing a triple booking,
     * false otherwise.
     */
    public boolean book(int start, int end) {
        // Check if this new event overlaps with any double booking
        for (int[] overlap : overlaps) {
            if (Math.max(overlap[0], start) < Math.min(overlap[1], end)) {
                // There is a triple booking
                return false;
            }
        }

        // Check if this new event overlaps with any single booking
        for (int[] event : calendar) {
            int overlapStart = Math.max(event[0], start);
            int overlapEnd = Math.min(event[1], end);
            if (overlapStart < overlapEnd) {
                // There is an overlap, so add it to the double booking list
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        // Add the new event to the single booking list
        calendar.add(new int[]{start, end});
        return true;
    }

    /**
     * Main method to demonstrate the usage of MyCalendarTwo class.
     */
    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();

        // Test case 1: Book non-overlapping events
        System.out.println(myCalendar.book(10, 20)); // true
        System.out.println(myCalendar.book(50, 60)); // true
        System.out.println(myCalendar.book(30, 40)); // true

        // Test case 2: Book overlapping events (double booking)
        System.out.println(myCalendar.book(15, 25)); // true
        System.out.println(myCalendar.book(5, 15));  // true

        // Test case 3: Attempt triple booking
        System.out.println(myCalendar.book(12, 18)); // false

        // Test case 4: Book event after failed attempt
        System.out.println(myCalendar.book(70, 80)); // true
    }
}

/**
 * Usage Instructions: 1. Create an instance of MyCalendarTwo. 2. Use the book()
 * method to attempt booking events. 3. The book() method returns true if the
 * event can be booked, false otherwise. 4. The system allows single and double
 * bookings but prevents triple bookings.
 *
 * Design and Implementation Notes: - The class uses two lists: 'calendar' for
 * all booked events and 'overlaps' for overlapping events. - When booking, it
 * first checks for triple bookings by comparing with the 'overlaps' list. - If
 * no triple booking is found, it checks for overlaps with existing events in
 * the 'calendar' list. - Overlapping events are added to the 'overlaps' list to
 * track double bookings. - All events, regardless of overlap, are added to the
 * 'calendar' list. - Time complexity for booking is O(n), where n is the number
 * of booked events.
 */
