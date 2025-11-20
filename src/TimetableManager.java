import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of timetable slots and enforces basic constraints.
 */
public class TimetableManager {

    private List<TimetableSlot> timetableSlots;

    /**
     * No-arg constructor initialises an empty timetable.
     * (Optionally, you could load from a CSV here.)
     */
    public TimetableManager() {
        this.timetableSlots = new ArrayList<>();
    }

    /**
     * Adds a new slot to the timetable if there are no clashes.
     *
     * @throws IllegalArgumentException if the slot clashes with existing slots.
     */

    public void addSlot(TimetableSlot newSlot) {
         //Check for classes in same room
        for (TimetableSlot existing : timetableSlots) {
            if (existing.getRoom().equals(newSlot.getRoom())
                    && existing.clashesWith(newSlot)) {
                throw new IllegalArgumentException("Room clash detected with existing slot.");
            }
            if (existing.getLecturerID() == (newSlot.getLecturerID())
                    && existing.clashesWith(newSlot)) {
                throw new IllegalArgumentException("Lecturer clash detected with existing slot.");
            }
        }
        timetableSlots.add(newSlot);
    }

    public TimetableManager(List<TimetableSlot> timetableSlots) {
        this.timetableSlots = timetableSlots;
    }

    public List<TimetableSlot> getTimetableSlots() {
        return timetableSlots;
    }

    public List<TimetableSlot> getStudentSlots(Student student, int semesterInput) {
        List<TimetableSlot> studentSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput) {
                studentSlots.add(slot);
            }
        }
        return studentSlots;
    }

    public List<TimetableSlot> getLecturerSlots(Lecturer lecturer, int semesterInput) {
        List<TimetableSlot> lecturerSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput) {
                lecturerSlots.add(slot);
            }
        }
        return lecturerSlots;
    }

    public List<TimetableSlot> getModuleSlots(String module, int semesterInput) {
        List<TimetableSlot> moduleSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput) {
                moduleSlots.add(slot);
            }
        }
        return moduleSlots;
    }

    public List<TimetableSlot> getProgrammeSlots(String programmeCode, int semesterInput) {
        List<TimetableSlot> programmeSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput) {
                programmeSlots.add(slot);
            }
        }
        return programmeSlots;
    }

    public List<TimetableSlot> getRoomSlots(String roomCode, int semesterInput) {
        List<TimetableSlot> roomSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput) {
                roomSlots.add(slot);
            }
        }
        return roomSlots;
    }

    public List<TimetableSlot> getStudentIDSlots(int studentID, int semesterInput) {
        List<TimetableSlot> studentIDSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput) {
                studentIDSlots.add(slot);
            }
        }
        return studentIDSlots;
    }

    public List<TimetableSlot> getLecturerIDSlots(int lecturerID, int semesterInput) {
        List<TimetableSlot> lecturerIDSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput) {
                lecturerIDSlots.add(slot);
            }
        }
        return lecturerIDSlots;
    }
}
