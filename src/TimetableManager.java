import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.time.DayOfWeek;
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
        this.timetableSlots = loadTimetableCSVData("src/resources/Timetable.csv");

    }

    /**
     * Adds a new slot to the timetable if there are no clashes.
     *
     * @throws IllegalArgumentException if the slot clashes with existing slots.
     */

    public static List<TimetableSlot> loadTimetableCSVData(String filename) {
        List<TimetableSlot> timetableSlots = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while ((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",");
                String day = fields[0].trim();
                String startTime = fields[1].trim();
                String endTime = fields[2].trim();
                String moduleCode = fields[3].trim();
                ClassType classType = ClassType.valueOf(fields[4].trim().toUpperCase());
                String lecturerName = fields[5].trim();
                String roomID = fields[6].trim();
                int semester = Integer.parseInt(fields[7].trim());
                String timetableID = fields[8].trim();

                timetableSlots.add(new TimetableSlot(day, startTime, endTime, moduleCode, classType, lecturerName, roomID, semester, timetableID));
            }
        } catch (IOException e) {
            System.err.println("File not found: " + filename);
        }
        return timetableSlots;
    }

    public void addSlot(TimetableSlot newSlot) {
        //Check for classes in same room
        for (TimetableSlot existing : timetableSlots) {
            if (existing.getRoomID().equals(newSlot.getRoomID())
                    && existing.clashesWith(newSlot)) {
                throw new IllegalArgumentException("Room clash detected with existing slot.");
            }
            if (existing.getLecturerName().equals(newSlot.getLecturerName())
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
        String timetableID = student.getTimetableID();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput && slot.getTimetableID().equals(timetableID)) {
                studentSlots.add(slot);
            }
        }
        return studentSlots;
    }

    public List<TimetableSlot> getLecturerSlots(Lecturer lecturer, int semesterInput) {
        List<TimetableSlot> lecturerSlots = new ArrayList<>();
        String timetableID = lecturer.getTimetableID();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput && slot.getTimetableID().equals(timetableID)) {
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