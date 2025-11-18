
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Represents a single scheduled class in the timetable.
 */
public class TimeTableSlot {

    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String moduleCode;
    private Rooms room;
    private Lecturer lecturer;

    /**
     * Constructs a timetable slot.
     *
     * @param day        day of the class (e.g. MONDAY)
     * @param startTime  start time of the class
     * @param endTime    end time of the class
     * @param moduleCode module code (e.g. CS4013)
     * @param room       room where the class takes place
     * @param lecturer   lecturer delivering the class
     */
    public TimeTableSlot(DayOfWeek day,
                         LocalTime startTime,
                         LocalTime endTime,
                         String moduleCode,
                         Rooms room,
                         Lecturer lecturer) {

        if (day == null || startTime == null || endTime == null ||
                moduleCode == null || room == null || lecturer == null) {
            throw new IllegalArgumentException("Null argument provided to TimeTableSlot.");
        }
        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("End time must be after start time.");
        }

        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.moduleCode = moduleCode;
        this.room = room;
        this.lecturer = lecturer;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public Rooms getRoom() {
        return room;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    /**
     * Checks if this slot clashes in time with another slot
     * on the same day.
     */
    public boolean clashesWith(TimeTableSlot other) {
        if (this.day != other.day) {
            return false;
        }
return this.startTime.equals(other.startTime) && this.endTime.equals(other.endTime);
}

}




