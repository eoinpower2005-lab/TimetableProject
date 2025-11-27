import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

/*
 * Manages a collection of timetable slots and enforces basic constraints.
 */
public class timetableManager {

    private List<TimetableSlot> timetableSlots = new ArrayList<>();

    /**
     * No-arg constructor initialises an empty timetable.
     * (Optionally, you could load from a CSV here.)
     */
    public timetableManager() {
        String filename = "src/resources/Timetable.csv";
        File file = new File(filename);
        this.timetableSlots = loadTimetableCSVData(filename);

        if (this.timetableSlots == null || this.timetableSlots.isEmpty()) {
            this.timetableSlots = new ArrayList<>();
            System.out.println("DEBUG: List is empty, calling generateTimetable(1) and generateTimetable(2)");
            generateTimetable(1);
            generateTimetable(2);
            writeGeneratedTimetableToCSV(filename);
        } else {
            System.out.println("DEBUG: Loaded " + timetableSlots.size() + " slots from CSV. No generation needed.");
        }
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
                if (csvLine.isEmpty()) {
                    continue;
                }
                String[] fields = csvLine.split(",", -1);
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

    public static List<Programme> loadProgrammeStructureCSVData(String filename) {
        List<Programme> programmeStructureList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while ((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",");
                String programmeID = fields[0].trim();
                int programmeYear = Integer.parseInt(fields[1].trim());
                int programmeSemester = Integer.parseInt(fields[2].trim());
                String moduleID = fields[3].trim();

                programmeStructureList.add(new Programme(programmeID, programmeYear, programmeSemester, moduleID));
            }
        } catch (IOException e) {
            System.err.println("File not found: " + filename);
        }
        return programmeStructureList;
    }

    public static List<ModuleContactHours> loadModuleContactHoursCSVData(String filename) {
        List<ModuleContactHours> moduleContactHoursList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while ((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",");
                String moduleCode = fields[0].trim();
                int lectureHours = Integer.parseInt(fields[1].trim());
                int tutorialHours = Integer.parseInt(fields[2].trim());
                int labHours = Integer.parseInt(fields[3].trim());

                moduleContactHoursList.add(new ModuleContactHours(moduleCode, lectureHours, tutorialHours, labHours));
            }
        } catch (IOException e) {
            System.err.println("File not found: " + filename);
        }
        return moduleContactHoursList;
    }

    public static List<Rooms> loadRoomsCSVData(String filename) {
        List<Rooms> roomsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while ((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",");
                String roomID = fields[0].trim();
                String roomType = fields[1].trim();
                int roomCapacity = Integer.parseInt(fields[2].trim());

                roomsList.add(new Rooms(roomID, roomType, roomCapacity));
            }
        } catch (IOException e) {
            System.err.println("File not found: " + filename);
        }
        return roomsList;
    }

    public static List<StaffAssignment> loadStaffAssignmentCSVData(String filename) {
        List<StaffAssignment> staffAssignmentList  = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while ((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",", -1);
                String moduleCode = fields[0].trim();
                String classType = fields[1].trim();
                int maxCapacity = 0;
                String assignedTeacher = "";

                if (fields.length == 3) {
                    assignedTeacher = fields[2].trim();
                    maxCapacity = 0;
                } else if (fields.length == 4) {
                    maxCapacity = Integer.parseInt(fields[2].trim());
                    assignedTeacher = fields[3].trim();
                }

                staffAssignmentList.add(new StaffAssignment(moduleCode, classType, maxCapacity, assignedTeacher));
            }
        } catch (IOException e) {
            System.err.println("File not found: " + filename);
        }
        return staffAssignmentList;
    }

    public static List<StudentRecords> loadModuleEnrollmentCSVData(String filename) {
        List<StudentRecords> moduleEnrollmentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while ((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",");
                String moduleCode = fields[0].trim();
                int numStudents = Integer.parseInt(fields[1].trim());

                moduleEnrollmentList.add(new StudentRecords(moduleCode, numStudents));
            }
        } catch (IOException e) {
            System.err.println("File not found: " + filename);
        }
        return moduleEnrollmentList;
    }

    public static List<StudentGroup> loadStudentGroupCSVData(String filename) {
        List<StudentGroup> studentGroupList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while ((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",");
                String programmeID = fields[0].trim();
                int programmeYear = Integer.parseInt(fields[1].trim());
                String groupID = fields[2].trim();
                int groupSize = Integer.parseInt(fields[3].trim());

                studentGroupList.add(new StudentGroup(programmeID, programmeYear, groupID, groupSize));
            }
        } catch (IOException e) {
            System.err.println("File not found: " + filename);
        }
        return studentGroupList;
    }

    private boolean clashOccurs(String day, String startTime, String endTime, String roomID, int semester, String lecturerName, String timetableID) {
        for (TimetableSlot timetableSlot : timetableSlots) {
            if (timetableSlot.getSemester() != semester) {
                continue;
            }
            if (timetableSlot.getDay().equals(day) && timetableSlot.getStartTime().equals(startTime) && timetableSlot.getEndTime().equals(endTime)) {
                if (timetableSlot.getRoomID().equals(roomID)) {
                    return true;
                }

                if (timetableSlot.getLecturerName().equals(lecturerName)) {
                    return true;
                }

                if (timetableSlot.getTimetableID().equals(timetableID)) {
                    return true;
                }
            }
        }
        return false;
    }

    private ModuleContactHours getContactHours(String moduleCode, List<ModuleContactHours> moduleContactHoursList) {
        for (ModuleContactHours m : moduleContactHoursList) {
            if (m.getModuleCode().equals(moduleCode)) {
                return m;
            }
        }
        return null;
    }

    private StaffAssignment getStaffAssignment(String moduleCode, String classType, List<StaffAssignment> staffAssignmentList) {
        System.out.println("Looking for staff assignment: module = " + moduleCode + ", classType = " + classType);
        for (StaffAssignment s : staffAssignmentList) {
            System.out.println("    checking against: " + s.getModuleCode() + ", " + s.getClassType());
            if (s.getModuleCode().equalsIgnoreCase(moduleCode) && s.getClassType().equalsIgnoreCase(classType)) {
                System.out.println("    -> Match");
                return s;
            }
        }
        System.out.println("    -> No Match found, returns null");
        return null;
    }

    private Rooms getRooms(List<Rooms> roomsList) {
        if (roomsList.isEmpty()) {
            return null;
        }
        return roomsList.get(0);
    }

    private void scheduleClass(String classType, String moduleID, int requiredHours, String timetableID, int semester, String[] days, String[] timeSlots, List<StaffAssignment> staffAssignmentList, List<Rooms> roomsList, int groupSize) {

        if (requiredHours <= 0) {
            return;
        }

        StaffAssignment s = getStaffAssignment(moduleID, classType, staffAssignmentList);
        String lecturerName;
        if (s != null) {
            lecturerName = s.getAssignedTeacher();
        } else {
            lecturerName = "TBA";
        }

        ClassType cType;
        if (classType.equalsIgnoreCase("lab")) {
            cType = ClassType.LAB;
        } else if (classType.equalsIgnoreCase("tutorial")) {
            cType = ClassType.TUT;
        } else {
            cType = ClassType.LECTURE;
        }

        boolean[][] slotsTried = new boolean[days.length][timeSlots.length];
        int totalSlotCombinations = days.length * timeSlots.length;
        int triedSlots = 0;

        Random random = new Random();
        int scheduledHours = 0;

        while (scheduledHours < requiredHours && triedSlots < totalSlotCombinations) {
            int indexOfDay;
            int indexOfTimeSlot;

            do {
                indexOfDay = random.nextInt(days.length);
                indexOfTimeSlot = random.nextInt(timeSlots.length);
            } while (slotsTried[indexOfDay][indexOfTimeSlot] && triedSlots < totalSlotCombinations);

            slotsTried[indexOfDay][indexOfTimeSlot] = true;
            triedSlots++;

            String day = days[indexOfDay];
            String timeSlot = timeSlots[indexOfTimeSlot];
            String[] parts = timeSlot.split("-");
            String startSlot = parts[0].trim();
            String endSlot = parts[1].trim();

            String roomID = isRoomSuitable(day, classType, groupSize, roomsList, startSlot, endSlot, semester, lecturerName, timetableID);

            if (roomID == "TBA") {
                continue;
            }

            timetableSlots.add(new TimetableSlot(
                    day,
                    startSlot,
                    endSlot,
                    moduleID,
                    cType,
                    lecturerName,
                    roomID,
                    semester,
                    timetableID
            ));
            scheduledHours++;
        }

        if (scheduledHours < requiredHours) {
            System.out.println("WARNING: Could not schedule all " + requiredHours + " hours of "
                    + classType + " for module " + moduleID
                    + " (group " + timetableID + ", semester " + semester + "). "
                    + "Scheduled only " + scheduledHours + " hour(s).");
        }
    }


    public void generateTimetable(int semester) {
        List<Programme> programmeList = loadProgrammeStructureCSVData("src/resources/Programme_structure.csv");
        List<ModuleContactHours> moduleContactHoursList = loadModuleContactHoursCSVData("src/resources/Module_contact_hours.csv");
        List<Rooms> roomsList = loadRoomsCSVData("src/resources/Rooms.csv");
        List<StaffAssignment> staffAssignmentList = loadStaffAssignmentCSVData("src/resources/Staff_assignment.csv");
        List<StudentRecords> moduleEnrollmentList = loadModuleEnrollmentCSVData("src/resources/Module_Enrollment.csv");
        List<StudentGroup> studentGroupList = loadStudentGroupCSVData("src/resources/Student_Groups.csv");

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] timeSlots = {"09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00"};

        //timetableSlots.clear();

        System.out.println("DEBUG: Generating timetable for semester " + semester);
        System.out.println("DEBUG: Total student groups: " + studentGroupList.size());
        System.out.println("DEBUG: Total programmes: " + programmeList.size());

        for (StudentGroup g : studentGroupList) {
            String timetableID = g.getGroupID();
            System.out.println("DEBUG: Processing student group: " + timetableID);
            for (Programme p : programmeList) {
                if (p.getProgrammeSemester() != semester) {
                    continue;
                }

                if (!p.getProgrammeID().equals(g.getProgrammeID()) || p.getProgrammeYear() != g.getProgrammeYear()) {
                    continue;
                }

                String moduleID = p.getModuleID();
                System.out.println("DEBUG: Found matching module: " + moduleID + " for semester " + semester);

                ModuleContactHours m = getContactHours(moduleID, moduleContactHoursList);
                if (m == null) {
                    System.out.println("DEBUG: No contact hours found for " + moduleID);
                    continue;
                }

                try {
                    scheduleClass("lecture", moduleID, m.getLectureHours(), timetableID, semester, days, timeSlots, staffAssignmentList, roomsList, g.getGroupSize());
                    scheduleClass("lab", moduleID, m.getLabHours(), timetableID, semester, days, timeSlots, staffAssignmentList, roomsList, g.getGroupSize());
                    scheduleClass("tutorial", moduleID, m.getTutorialHours(), timetableID, semester, days, timeSlots, staffAssignmentList, roomsList, g.getGroupSize());
                } catch (Exception e) {
                    System.out.println("Error: moduled skipped " + moduleID + " due to a clash " + e.getMessage());
                }


            }
        }
        System.out.println("DEBUG: Generated " + timetableSlots.size() + " slots for semester " + semester);
    }

    private boolean isSlotUsed(String day, String startTime, String endTime, String timetableID, String roomID, int semester, String lecturerName) {
        return clashOccurs(day, startTime, endTime, roomID, semester, lecturerName, timetableID);
    }

    private String isRoomSuitable(String day, String classType, int groupSize, List<Rooms> roomsList, String startTime, String endTime, int semester, String lecturerName, String timetableID) {
        for (Rooms r : roomsList) {
            String roomType = r.getType();
            int capacity = r.getCapacity();

            boolean isLabRoom = roomType.equalsIgnoreCase("CSlab");
            boolean isTeachingRoom = roomType.equalsIgnoreCase("teaching");

            boolean roomTypeMatches = (classType.equalsIgnoreCase("lab") && isLabRoom) || (!classType.equalsIgnoreCase("lab") && isTeachingRoom);
            if (!roomTypeMatches) {
                continue;
            }

            if (capacity < groupSize) {
                continue;
            }

            if (!clashOccurs(day, startTime, endTime, r.getRoomId(), semester, lecturerName, timetableID)) {
                return r.getRoomId();
            }
        }
        return "TBA";
    }

    public void writeGeneratedTimetableToCSV(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("day, start_time, end_time, module_code, class_type, assigned_lecturer, room_id, semester, timetable_id");

            for (TimetableSlot timetableSlot : timetableSlots) {
                pw.printf("%s, %s, %s, %s, %s, %s, %s, %d, %s%n", timetableSlot.getDay(), timetableSlot.getStartTime(),
                        timetableSlot.getEndTime(), timetableSlot.getModule(), timetableSlot.getClassType(),
                        timetableSlot.getLecturerName(), timetableSlot.getRoomID(), timetableSlot.getSemester(),
                        timetableSlot.getTimetableID());
            }
        } catch (IOException e) {
            System.err.println("Error writing to a CSV file that does not exist: " + filename);
        }
    }

    public void addSlot(TimetableSlot newSlot) {
        //Check for classes in same room
        for (TimetableSlot existing : timetableSlots) {
            if (existing.getRoomID().equals(newSlot.getRoomID())
                    && existing.clashesWith(newSlot)) {
                throw new IllegalArgumentException("Room clash detected with existing slot.");
            }
            if (existing.getLecturerName() == (newSlot.getLecturerName())
                    && existing.clashesWith(newSlot)) {
                throw new IllegalArgumentException("Lecturer clash detected with existing slot.");
            }
        }
        timetableSlots.add(newSlot);
    }

    public timetableManager(List<TimetableSlot> timetableSlots) {
        this.timetableSlots = timetableSlots;
    }

    public List<TimetableSlot> getTimetableSlots() {
        return timetableSlots;
    }

    public List<TimetableSlot> getStudentSlots(Student student, int semesterInput) {
        List<TimetableSlot> studentSlots = new ArrayList<>();
        String timetableID = student.getTimetableID();

        System.out.println("DEBUG: Looking for student timetableID " + timetableID + " in semester " + semesterInput);
        System.out.println("DEBUG: Total available slots: " + timetableSlots.size());
        for (TimetableSlot slot : timetableSlots) {
            System.out.println("DEBUG: Slot - ID: " + slot.getTimetableID() + ", Semester: " + slot.getSemester() + ", module: " + slot.getModule());
            if (slot.getSemester() == semesterInput && slot.getTimetableID().equals(timetableID)) {
                studentSlots.add(slot);
            }
        }
        System.out.println("DEBUG: Found " + studentSlots.size() + " slots for student");
        return studentSlots;
    }

    public List<TimetableSlot> getLecturerSlots(Lecturer lecturer, int semesterInput) {
        List<TimetableSlot> lecturerSlots = new ArrayList<>();
        String lecturerName = lecturer.getName();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput && slot.getLecturerName().equalsIgnoreCase(lecturerName)) {
                lecturerSlots.add(slot);
            }
        }
        return lecturerSlots;
    }

    public List<TimetableSlot> getModuleSlots(String module, int semesterInput) {
        List<TimetableSlot> moduleSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput && slot.getModule().equals(module)) {
                moduleSlots.add(slot);
            }
        }
        return moduleSlots;
    }

    public List<TimetableSlot> getProgrammeSlots(String programmeCode, int semesterInput) {
        List<TimetableSlot> programmeSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput && slot.getTimetableID().equals(programmeCode)) {
                programmeSlots.add(slot);
            }
        }
        return programmeSlots;
    }

    public List<TimetableSlot> getRoomSlots(String roomCode, int semesterInput) {
        List<TimetableSlot> roomSlots = new ArrayList<>();
        for (TimetableSlot slot : timetableSlots) {
            if (slot.getSemester() == semesterInput && slot.getRoomID().equals(roomCode)) {
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