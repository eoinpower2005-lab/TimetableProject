import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimetableMenu {
    private final timetableManager timetableManager;
    private final Scanner scanner;
    private List<User> users;

    public TimetableMenu(timetableManager timetableManager, Scanner scanner, List<User> users) {
        this.timetableManager = timetableManager;
        this.scanner = scanner;
        this.users = users;
    }

    public void displayMenu(User user) {
        if (user instanceof Student) {
            displayStudentMenu((Student) user);
        } else if (user instanceof Lecturer) {
            displayLecturerMenu((Lecturer) user);
        } else if (user instanceof Admin) {
            displayAdminMenu((Admin) user);
        } else {
            System.out.println("User is not recognised");
        }
    }

    private void displayStudentMenu(Student student) {
        boolean validInput = true;

        while (validInput) {
            System.out.println("----Student Menu----");
            System.out.println("1. View Student Timetable");
            System.out.println("2. View Module Timetable");
            System.out.println("3. View Programme Timetable");
            System.out.println("4. View Room Timetable");
            System.out.println("5. Exit");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            if (userInput == 1) {
                viewStudentTimetable(student);
            } else if (userInput == 2) {
                viewModuleTimetable();
            } else if (userInput == 3) {
                viewProgrammeTimetable();
            } else if (userInput == 4) {
                viewRoomTimetable();
            } else if (userInput == 5) {
                validInput = false;
            } else {
                System.out.println("Invalid choice. Try again!");
            }
        }
    }

    private void viewStudentTimetable(Student student) {
        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getStudentSlots(student, semesterInput);
        printTimetableSlots(timetableSlots);
        System.exit(0);
    }

    private void displayLecturerMenu(Lecturer lecturer) {
        boolean validInput = true;
        while (validInput) {
            System.out.println("----Lecturer Menu----");
            System.out.println("1. View Lecturer Timetable");
            System.out.println("2. View Module Timetable");
            System.out.println("3. View Programme Timetable");
            System.out.println("4. View Room Timetable");
            System.out.println("5. Exit");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            if (userInput == 1) {
                viewLecturerTimetable(lecturer);
            } else if (userInput == 2) {
                viewModuleTimetable();
            } else if (userInput == 3) {
                viewProgrammeTimetable();
            } else if (userInput == 4) {
                viewRoomTimetable();
            } else if (userInput == 5) {
                validInput = false;
            } else {
                System.out.println("Invalid choice. Try again!");
            }
        }
    }

    private void viewLecturerTimetable(Lecturer lecturer) {
        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getLecturerSlots(lecturer, semesterInput);
        printTimetableSlots(timetableSlots);
        System.exit(0);
    }

    private void displayAdminMenu(Admin admin) {
        boolean validInput = true;
        while (validInput) {
            System.out.println("----Admin Menu----");
            System.out.println("1. View a Student Timetable");
            System.out.println("2. View a Lecturer Timetable");
            System.out.println("3. View a Programme Timetable");
            System.out.println("4. View a Module Timetable");
            System.out.println("5. View a Room Timetable");
            System.out.println("6. Modify a Timetable Slot");
            System.out.println("7. Exit");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            if (userInput == 1) {
                adminViewStudentTimetable();
            } else if (userInput == 2) {
                adminViewLecturerTimetable();
            } else if (userInput == 3) {
                viewProgrammeTimetable();
            } else if (userInput == 4) {
                viewModuleTimetable();
            } else if (userInput == 5) {
                viewRoomTimetable();
            } else if (userInput == 6) {
                adminModifySlot();
            } else if (userInput == 7) {
                validInput = false;
            } else {
                System.out.println("Invalid choice. Try again!");
            }
        }
    }

    private void viewModuleTimetable() {
        System.out.print("Enter the Module Code: ");
        String moduleCode = scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getModuleSlots(moduleCode, semesterInput);
        printTimetableSlots(timetableSlots);
        System.exit(0);
    }

    private void viewProgrammeTimetable() {
        System.out.print("Enter the Programme Code: ");
        String programmeCode = scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getProgrammeSlots(programmeCode, semesterInput);
        printTimetableSlots(timetableSlots);
        System.exit(0);
    }

    private void viewRoomTimetable() {
        System.out.print("Enter the Room Code: ");
        String roomID = scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getRoomSlots(roomID, semesterInput);
        printTimetableSlots(timetableSlots);
        System.exit(0);
    }

    private void adminViewStudentTimetable() {
        System.out.print("Enter the Student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        Student student = null;
        for (User user : users) {
            if (user instanceof Student && user.getId() == studentID) {
                student = (Student) user;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student ID not found");
        }

        List<TimetableSlot> timetableSlots = timetableManager.getStudentSlots(student, semesterInput);
        printTimetableSlots(timetableSlots);
        System.exit(0);
    }

    private void adminViewLecturerTimetable() {
        System.out.print("Enter the Lecturer ID: ");
        int lecturerID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getLecturerIDSlots(lecturerID, semesterInput);
        printTimetableSlots(timetableSlots);
        System.exit(0);
    }

    private void adminModifySlot() {
        List<TimetableSlot> allTimetableSlots = timetableManager.getTimetableSlots();
        List<TimetableSlot> allMatchingSlots = new ArrayList<>();

        System.out.println("Enter a Timetable ID: ");
        String timetableID = scanner.nextLine();

        System.out.println("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        for (TimetableSlot timetableSlot : allTimetableSlots) {
            if (timetableSlot.getSemester() == semesterInput && timetableSlot.getTimetableID().equalsIgnoreCase(timetableID)) {
                allMatchingSlots.add(timetableSlot);
            }
        }

        if (allMatchingSlots.isEmpty()) {
            System.out.println("There is no slots found for a timetable with timetableID " + timetableID + " in semester " + semesterInput);
            return;
        }

        for (int i = 0; i < allMatchingSlots.size(); i++) {
            TimetableSlot slot = allMatchingSlots.get(i);
            System.out.printf("%d: %s %s -%s | Module -> %s | Type -> %s | Lecturer -> %s | Room -> %s%n", i+1,
                    slot.getDay(), slot.getStartTime(), slot.getEndTime(), slot.getModule(), slot.getClassType(), slot.getLecturerName(), slot.getRoomID());

        }

        System.out.println("Pick a slot to update: ");
        int slotIndex = scanner.nextInt();
        scanner.nextLine();

        if (slotIndex < 1 || slotIndex > allTimetableSlots.size()) {
            System.out.println("Invalid slot index. Try again!");
            return;
        }

        TimetableSlot updatedSlot = allTimetableSlots.get(slotIndex - 1);
        System.out.println("Pick a slot field to update: ");
        System.out.println("1. Day");
        System.out.println("2. Start Time");
        System.out.println("3. End Time");
        System.out.println("4. Module Code");
        System.out.println("5. Class Type");
        System.out.println("6. Lecturer Name");
        System.out.println("7. Room ID");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();

        try {
            if (updateChoice == 1) {
                System.out.println("Enter a Day: ");
                String day = scanner.nextLine();
                updatedSlot.setDay(day);
            } else if (updateChoice == 2) {
                System.out.println("Enter a Start Time: ");
                String startTime = scanner.nextLine();
                updatedSlot.setStartTime(startTime);
            } else if (updateChoice == 3) {
                System.out.println("Enter an End Time: ");
                String endTime = scanner.nextLine();
                updatedSlot.setEndTime(endTime);
            } else if (updateChoice == 4) {
                System.out.println("Enter a Module Code: ");
                String moduleCode = scanner.nextLine();
                updatedSlot.setModule(moduleCode);
            } else if (updateChoice == 5) {
                System.out.println("Enter a Class Type: (LECTURE / LAB / TUT)");
                String classType = scanner.nextLine();
                ClassType cType = ClassType.valueOf(classType);
                updatedSlot.setClassType(cType);
            } else if (updateChoice == 6) {
                System.out.println("Enter a Lecturer Name: ");
                String lecturerName = scanner.nextLine();
                updatedSlot.setLecturerName(lecturerName);
            }
        } catch (Exception e) {
            System.out.println("Invalid choice. Try again!");
        }
    }

    private void printTimetableSlots(List<TimetableSlot> timetableSlots) {
        if (timetableSlots.isEmpty()) {
            System.out.println("No timetable slots found!");
            return;
        }

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] timeSlots = {"09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00"};
        String[][] timetableGrid = new String[timeSlots.length][days.length];

        for (int i = 0; i < timeSlots.length; i++) {
            for (int j = 0; j < days.length; j++) {
                timetableGrid[i][j] = "";
            }
        }

        for (TimetableSlot slot : timetableSlots) {
            String day = slot.getDay();
            String timeSlot = slot.getStartTime() + "-" + slot.getEndTime();

            int indexTime = 0;
            for (int i = 0; i < timeSlots.length; i++) {
                if (timeSlots[i].equals(timeSlot)) {
                    indexTime = i;
                    break;
                }
            }

            int indexDay = 0;
            for (int i = 0; i < days.length; i++) {
                if (days[i].equals(day)) {
                    indexDay = i;
                    break;
                }
            }

            String slotText = slot.getModule() + " " + slot.getClassType() + " " + slot.getLecturerName() + " " + slot.getRoomID();
            timetableGrid[indexTime][indexDay] = slotText;
        }

        int columnWidth = 40;
        System.out.println();
        System.out.printf("%-12s", "Time");

        for (String day : days) {
            System.out.printf("| %-"+columnWidth+"s", day);
        }
        System.out.println();

        int totalWidth = 12 + days.length * (columnWidth + 2);
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < timeSlots.length; i++) {
            System.out.printf("%-12s", timeSlots[i]);
            for (int j = 0; j < days.length; j++) {
                System.out.printf("| %-"+columnWidth+"s", timetableGrid[i][j]);
            }
            System.out.println();
        }

    }
}


