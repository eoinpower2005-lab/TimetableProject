import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of timetable slots and enforces basic constraints.
 */
public class timetableManager {

    private List<TimeTableSlot> slots;

    /**
     * No-arg constructor initialises an empty timetable.
     * (Optionally, you could load from a CSV here.)
     */
    public TimeTableManager() {
        this.slots = new ArrayList<>();
    }

    /**
     * Adds a new slot to the timetable if there are no clashes.
     *
     * @throws IllegalArgumentException if the slot clashes with existing slots.
     */
    public void addSlot(TimeTableSlot newSlot) {
        // Check for clashes in same room
        for (TimeTableSlot existing : slots) {
            if (existing.getRoom().equals(newSlot.getRoom())
                    && existing.clashesWith(newSlot)) {
                throw new IllegalArgumentException("Room clash detected with existing slot.");
            }
            if (existing.getLecturer().equals(newSlot.getLecturer())
                    && existing.clashesWith(newSlot)) {
                throw new IllegalArgumentException("Lecturer clash detected with existing slot.");
            }
        }
        slots.add(newSlot);
    }
}
