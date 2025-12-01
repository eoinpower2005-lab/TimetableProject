import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * This class represents a timetable slot in the university timetable
 * every Timetable slot has information about classes, time, location, module, lecturer, and student group
 * this class provides attribute used in the timetabling system used to display schedules, check for
 * conflicts and managing room/lecturer allocations and prevent clashing.
 *
 * TimetableSlot objects are created when loading an existing timetable from the CSV.
 */

public class TimetableSlot {
    private String day;
    private String startTime;
    private String endTime;
    private String moduleCode;
    private ClassType classType;
    private String lecturerName;
    private String roomID;
    private int semester;
    private String timetableID;

    /** This constructor creates a TimetableSlot with all required scheduling information.
     *
     * @param day the day of the week when this slot occurs e.g. "Monday", "Tuesday"
     * @param startTime the start time of the slot e.g. "11:00"
     * @param endTime the end time of the slot e.g. "12:00"
     * @param moduleCode the code of the module scheduled in this slot
     * @param classType the type of class (Lecture,lab or tutorial)
     * @param lecturerName the lecturers name that is assigned to teach the module in the timetable slot
     * @param roomID the ID if the room where the class is held
     * @param semester the number associated with a semester (1 = Autumn, 2 = Spring)
     * @param timetableID the ID linking this slot to a specific student group e.g. "1A", "2B"
     */


    public TimetableSlot(String day, String startTime, String endTime, String moduleCode, ClassType classType, String lecturerName, String roomID, int semester, String timetableID) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.moduleCode = moduleCode;
        this.classType = classType;
        this.lecturerName = lecturerName;
        this.roomID = roomID;
        this.semester = semester;
        this.timetableID = timetableID;
    }

    /**
     * @return the day of the scheduled class in the timetable slot as a string e.g. "Monday", "Tuesday"
     */
    public String getDay() {
        return day;
    }

    /**
     *
     * @param day of the week for this timetable slot e.g. "Monday", "Tuesday"
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     *
     * @return the module code, which is associated with this timetable slot, as a String e.g. "CS4013", "Ma4052"
     */
    public String getModule() {
        return moduleCode;
    }

    /**
     *
     * @param moduleCode is the new module code for this timetable slot e.g. "CS4013"
     */
    public void setModule(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     *
     * @return the start time of this timetable slot e.g. "09:00"
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     *
     * @param startTime the new start time for this timetable slot
     */

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @return the end time of this timetable slot e.g. "10:00"
     */

    public String getEndTime() {
        return endTime;
    }

    /**
     *
     * @param endTime the new end time for this timetable slot
     */

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @return the ClassType enum value for this timetable slot e.g. lecture, lab, or tutorial
     */

    public ClassType getClassType() {
        return classType;
    }

    /**
     *
     * @param classType the new ClassType value for this timetable slot
     */

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    /**
     *
     * @return the lecturers name as a String that is assigned to this timetable slot e.g. "Alan T Ryan"
     */

    public String getLecturerName() {
        return lecturerName;
    }

    /**
     *
     * @param lecturerName the new lecturer name for this timetable slot.
     */

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    /**
     *
     * @return the room ID as a String e.g. "CSG001", this is the room identifier where this timetable slot occurs.
     */


    public String getRoomID() {
        return roomID;
    }

    /**
     *
     * @param roomID is the new room ID which sets the room identifier for this timetable slot
     */

    public void setRoom(String roomID) {
        this.roomID = roomID;
    }

    /**
     *
     * @return the academic semester when this timetable slot occurs (1 = autumn, 2 = spring)
     */

    public int getSemester() {
        return semester;
    }

    /**
     *
     * @param semester the new semester number 1 = Autumn 2 = Spring, sets the academic semester for this timetable slot
     */

    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     *
     * @return the timetable ID linking this slot to a student group, the ID acts as a group identifier that connects this slot to a specific group of students e.g "1A", "2B"
     */

    public String getTimetableID() {
        return timetableID;
    }

    /**
     *
     * @param timetableID the new timetable ID, sets the timetable ID for this timetable slot
     */

    public void setTimetableID(String timetableID) {
        this.timetableID = timetableID;
    }

    /**
     * Determines whether this slot clashes with another slot,
     * a clash happens when both slots occur on the same day and their times overlap.
     * This method compares strings directly, it is used to prevent scheduling two classes in the same room or with the same
     * time slot as another class
     * @param other checks the other TimetableSlots to check for clashes
     * @return true if the slots clash, it prevents t is used
     * to prevent scheduling two classes in the same room or with the same lecturer
     * at the same time, otherwise it's false.
     */

    public boolean clashesWith(TimetableSlot other) {
        if(this.day != other.day) {
            return false;
        }
        return (this.startTime != other.endTime);
    }
}

