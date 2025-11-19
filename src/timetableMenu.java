import java.util.Scanner;

public class timetableMenu {
    private final TimetableManager timetableManager;
    private final Scanner scanner;

    public timetableMenu(TimetableManager timetableManager, Scanner scanner) {
        this.timetableManager = timetableManager;
        this.scanner = new Scanner(System.in);
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

            int userInput = new Scanner(System.in).nextInt();

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
        System.out.println("Enter a semester: (1 = Autumn, 2 = Spring");
        int semesterInput = new Scanner(System.in).nextInt();

        List<TimetableSlot> timetableSlots = timetableManager.getStudentSlots(student, semesterInput);
        printTimetableSlots(timetableSlots);
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

            int userInput = new Scanner(System.in).nextInt();
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
        System.out.println("Enter a semester: (1 = Autumn, 2 = Spring");
        int semesterInput = new Scanner(System.in).nextInt();

        List<TimetableSlot> timetableSlots = timetableManager.getLecturerSlots(lecturer, semesterInput);
        printTimetableSlots(timetableSlots);
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
            System.out.println("6. Exit");

            int userInput = new Scanner(System.in).nextInt();
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
                validInput = false;
            } else {
                System.out.println("Invalid choice. Try again!");
            }
        }
    }

    private void viewModuleTimetable() {
        System.out.println("Enter the Module Code: ");
        String moduleCode = new Scanner(System.in).nextLine();

        System.out.println("Enter a semester: (1 = Autumn, 2 = Spring");
        int semesterInput = new Scanner(System.in).nextInt();

        List<TimetableSlot> timetableSlots = timetableManager.getModuleSlots(moduleCode, semesterInput);
        printTimetableSlot(timetableSlots);
    }

    private void viewProgrammeTimetable() {
        System.out.println("Enter the Programme Code: ");
        String programmeCode = new Scanner(System.in).nextLine();

        System.out.println("Enter a semester: (1 = Autumn, 2 = Spring");
        int semesterInput = new Scanner(System.in).nextInt();

        List<TimetableSlot> timetableSlots = timetableManager.getProgrammeSlots(programmeCode, semesterInput);
        printTimetableSlot(timetableSlots);
    }

    private void viewRoomTimetable() {
        System.out.println("Enter the Room Code: ");
        String roomID = new Scanner(System.in).nextLine();

        System.out.println("Enter a semester: (1 = Autumn, 2 = Spring");
        int semesterInput = new Scanner(System.in).nextInt();

        List<TimetableSlot> timetableSlots = timetableManager.getRoomSlots(roomID, semesterInput);
        printTimetableSlot(timetableSlots);
    }

    private void adminViewStudentTimetable() {
        System.out.println("Enter the Student ID: ");
        String studentID = new Scanner(System.in).nextLine();

        System.out.println("Enter a semester: (1 = Autumn, 2 = Spring");
        int semesterInput = new Scanner(System.in).nextInt();

        List<TimetableSlot> timetableSlots = timetableManager.getStudentIDSlots(studentID, semesterInput);
        printTimetableSlot(timetableSlots);
    }

    private void adminViewLecturerTimetable() {
        System.out.println("Enter the Lecturer ID: ");
        String lecturerID = new Scanner(System.in).nextLine();

        System.out.println("Enter a semester: (1 = Autumn, 2 = Spring");
        int semesterInput = new Scanner(System.in).nextInt();

        List<TimetableSlot> timetableSlots = timetableManager.getLecturerIDSLots(lecturerID, semesterInput);
        printTimetableSlot(timetableSlots);
    }

    private void printTimetableSlots(List<TimetableSlot> timetableSlots) {
        if (timetableSlots.isEmpty()) {
            System.out.println("No timetable slots found");
            return;
        }

        System.out.printf("%-12s %-14s %-8s %-11s %-15s %-7s%n", "Day", "Time", "Module", "Type", "Lecturer", "Room");
        for (TimetableSlot ts : timetableSlots) {
            System.out.printf("%-12s %-14s %-8s %-11s %-15s %-7s%n",
                    ts.getDay(),
                    ts.getTime(),
                    ts.getModule(),
                    ts.getClassType(),
                    ts.getLecturerID(),
                    ts.getRoom());
        }
    }

}
