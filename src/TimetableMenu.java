import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TimetableMenu class contains the code for different user menu options.
 * Students can view student timetable, view module timetable, view programme timetable, and view room timetable.
 * Lecturer can view lecturer timetable, view module timetable, view programme timetable, and view room timetable.
 * Admin can view a student timetable, view a lecturer timetable, view a programme timetable, view a room timetable,
 * view a module timetable, and modify a timetable.
 */
public class TimetableMenu {
    private final timetableManager timetableManager;
    private final Scanner scanner;
    private List<User> users;

    /**
     * constructor which creates a new TimetableMenu with the passed in parameters.
     * @param timetableManager the timetableManager class is used for querying the different timetable menu options.
     * @param scanner scanner is used to read the user's input from the command line interface (CLI).
     * @param users the list of all users stored in a csv file. Used for determining type of logged-in user.
     */
    public TimetableMenu(timetableManager timetableManager, Scanner scanner, List<User> users) {
        this.timetableManager = timetableManager;
        this.scanner = scanner;
        this.users = users;
    }

    /**
     * this displayMenu method determines the menu that should be displayed for the type of logged-in user.
     * the user parameter is the list of users in the system.
     * checks what type of object the user is an instance of.
     * casts the user to be of the object type e.g. casts user to be of type Student.
     * calls the correct method and passes the user as a parameter.
     * prints a message if the user is not recognised in the system.
     * @param user the list of users in the system.
     */
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

    /**
     * method for displaying a students menu options.
     * different querying options.
     * uses scanner to get user's input from command line interface.
     * loops until user's input is valid.
     * calls the appropriate method for the user inputs option.
     * @param student the logged-in user which is of type Student.
     */
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

    /**
     * prompts the student to enter a semester for their student timetable.
     * this method returns the list of timetable slots for the logged-in student.
     * gets the user's input from the command line interface using scanner.
     * calls the getStudentSlots method in timetableManager and stores it in a list timetableSlots of type TimetableSlot.
     * calls the printTimetableSlots method and passes in the list of timetableSlots for this student.
     * @param student the logged-in user which is of type Student.
     */
    private void viewStudentTimetable(Student student) {
        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getStudentSlots(student, semesterInput);
        printTimetableSlots(timetableSlots);
        //System.exit(0);
    }

    /**
     * method for displaying a lecturers menu options.
     * different querying options.
     * displays the lecturers teaching timetable across all assigned modules.
     * uses scanner to get user's input from command line interface.
     * loops until user's input is valid.
     * calls the appropriate method for the user inputs option.
     * @param lecturer the logged-in user which is of type Lecturer.
     */
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

    /**
     * prompts the lecturer to enter a semester for their teaching timetable.
     * this method returns the list of teaching timetable slots for the logged-in lecturer.
     * gets the user's input from the command line interface using scanner.
     * calls the getLecturerSlots method in timetableManager and stores it in a list timetableSlots of type TimetableSlot.
     * calls the printTimetableSlots method and passes in the list of timetableSlots for this lecturer.
     * @param lecturer the logged-in user which is of type Lecturer.
     */
    private void viewLecturerTimetable(Lecturer lecturer) {
        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getLecturerSlots(lecturer, semesterInput);
        printTimetableSlots(timetableSlots);
        //System.exit(0);
    }

    /**
     * method for displaying an Admins menu options.
     * different querying options.
     * Admin can view any students timetable for a selected semester.
     * Admin can view any lecturers timetable for a selected semester.
     * Admin can view any programme timetable for a selected semester.
     * Admin can view any module timetable for a selected semester.
     * Admin can view any room timetable for a selected semester.
     * ability to modify a timetable slot.
     * uses scanner to get user's input from command line interface.
     * loops until user's input is valid.
     * calls the appropriate method for the user inputs option.
     * @param admin the logged-in user which is of type Admin.
     */
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

    /**
     * this viewModuleTimetable method is used by all users - Student, Lecturer, and Admin.
     * prompts the user to enter a module code and the semester. e.g. CS4012, semester 1.
     * this method returns a list of all timetable slots for the entered module code and semester.
     * gets the user's input from the command line interface using scanner.
     * calls the getModuleSlots method in timetableManager and stores it in a list timetableSlots of type TimetableSlot.
     * calls the printTimetableSlots method and passes in the list of timetableSlots for the module and semester.
     */
    private void viewModuleTimetable() {
        System.out.print("Enter the Module Code: ");
        String moduleCode = scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getModuleSlots(moduleCode, semesterInput);
        printTimetableSlots(timetableSlots);
        //System.exit(0);
    }

    /**
     * this viewProgrammeTimetable method is used by all users - Student, Lecturer, and Admin.
     * prompts the user to enter a programme code and the semester. e.g. LM121, semester 1.
     * this method returns a list of all timetable slots for the entered programme code and semester.
     * gets the user's input from the command line interface using scanner.
     * calls the getProgrammeSlots method in timetableManager and stores it in a list timetableSlots of type TimetableSlot.
     * calls the printTimetableSlots method and passes in the list of timetableSlots for the programme and semester.
     */
    private void viewProgrammeTimetable() {
        System.out.print("Enter the Programme Code: ");
        String programmeCode = scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getProgrammeSlots(programmeCode, semesterInput);
        printTimetableSlots(timetableSlots);
        //System.exit(0);
    }

    /**
     * this viewRoomTimetable method is used by all users - Student, Lecturer, and Admin.
     * prompts the user to enter a room code and the semester.
     * this method returns a list of all timetable slots for the entered room code and semester.
     * gets the user's input from the command line interface using scanner.
     * calls the getRoomSlots method in timetableManager and stores it in a list timetableSlots of type TimetableSlot.
     * calls the printTimetableSlots method and passes in the list of timetableSlots for the room and semester.
     */
    private void viewRoomTimetable() {
        System.out.print("Enter the Room Code: ");
        String roomID = scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        List<TimetableSlot> timetableSlots = timetableManager.getRoomSlots(roomID, semesterInput);
        printTimetableSlots(timetableSlots);
        //System.exit(0);
    }

    /**
     * this adminViewStudentTimetable method is used only by the Admin.
     * prompts the admin user to enter a students ID and the semester.
     * student is of type Student and initialized to null.
     * a for-each loop that loops through the list of users stored in the system.
     * checks if the user is an instance of Student and the entered student ID matches the user ID associated with that student.
     * casts the user to be of type Student and stores it in the local variable student, and exits the loop.
     * checks if the student is null and prints a message if it is.
     * gets the user's input from the command line interface using scanner.
     * calls the getStudentSlots method in timetableManager and stores it in a list timetableSlots of type TimetableSlot.
     * calls the printTimetableSlots method and passes in the list of timetableSlots for the students ID and semester.
     */
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
        //System.exit(0);
    }

    /**
     * this adminViewLecturerTimetable method is used only by the Admin.
     * prompts the admin user to enter a lecturers ID and the semester.
     * lecturer is of type Lecturer and initialized to null.
     * a for-each loop that loops through the list of users stored in the system.
     * checks if the user is an instance of Lecturer and the entered lecturer ID matches the user ID associated with that lecturer.
     * casts the user to be of type Lecturer and stores it in the local variable lecturer, and exits the loop.
     * checks if the lecturer is null and prints a message if it is.
     * gets the user's input from the command line interface using scanner.
     * calls the getLecturerSlots method in timetableManager and stores it in a list timetableSlots of type TimetableSlot.
     * calls the printTimetableSlots method and passes in the list of timetableSlots for the lecturers ID and semester.
     */
    private void adminViewLecturerTimetable() {
        System.out.print("Enter the Lecturer ID: ");
        int lecturerID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a semester: (1 = Autumn, 2 = Spring)    ");
        int semesterInput = scanner.nextInt();
        scanner.nextLine();

        Lecturer lecturer = null;
        for (User user : users) {
            if (user instanceof Lecturer && user.getId() == lecturerID) {
                lecturer = (Lecturer) user;
            }
        }

        if (lecturer == null) {
            System.out.println("Lecturer ID not found");
        }

        List<TimetableSlot> timetableSlots = timetableManager.getLecturerSlots(lecturer, semesterInput);
        printTimetableSlots(timetableSlots);
        //System.exit(0);
    }

    /**
     * this adminModifySlot method is used only by the Admin.
     * list of all generated timetable slots.
     * list of timetable slots from the entire allTimetableSlots list that match the entered timetable id and semester.
     * prompts the admin user to enter a timetable ID and semester. e.g. 1A, semester 1
     * a for-each loop that loops through the list allTimetableSlots.
     * checks if the entered semester and timetable ID matches the list using getter methods defined in TimetableSlot class.
     * adds the matching ones to a list allMatchingSlots.
     * checks if allMatchingSlots list is empty and prints a message if it is.
     * a for loop that loops through allMatchingSlots list, gets the element at index i, and format prints it to the command line interface.
     * prompts the admin user to pick a slot to modify.
     * prompts the admin user to pick an option to modify the timetable.
     * calls the setter methods in the TimetableSlot class to set the change to the timetable slot.
     * writes the updated timetable to the Timetable.csv file.
     */
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

        if (slotIndex < 1 || slotIndex > allMatchingSlots.size()) {
            System.out.println("Invalid slot index. Try again!");
            return;
        }

        TimetableSlot updatedSlot = allMatchingSlots.get(slotIndex - 1);
        System.out.println("Pick a slot field to update: ");
        System.out.println("1. Day");
        System.out.println("2. Start Time & End Time");
        System.out.println("3. Module Code");
        System.out.println("4. Class Type");
        System.out.println("5. Lecturer Name");
        System.out.println("6. Room ID");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            if (choice == 1) {
                System.out.println("Enter a Day: ");
                String day = scanner.nextLine();
                updatedSlot.setDay(day);
            } else if (choice == 2) {
                System.out.println("Enter a Start Time and End Time: ");
                String startTime = scanner.nextLine();
                String endTime = scanner.nextLine();
                updatedSlot.setStartTime(startTime);
                System.out.println();
                updatedSlot.setEndTime(endTime);
            } else if (choice == 3) {
                System.out.println("Enter a Module Code: ");
                String moduleCode = scanner.nextLine();
                updatedSlot.setModule(moduleCode);
            } else if (choice == 4) {
                System.out.println("Enter a Class Type: (LECTURE / LAB / TUT)");
                String classType = scanner.nextLine();
                ClassType cType = ClassType.valueOf(classType);
                updatedSlot.setClassType(cType);
            } else if (choice == 5) {
                System.out.println("Enter a Lecturer Name: ");
                String lecturerName = scanner.nextLine();
                updatedSlot.setLecturerName(lecturerName);
            } else if (choice == 6) {
                System.out.println("Enter a Room ID: ");
                String roomID = scanner.nextLine();
                updatedSlot.setRoom(roomID);
            }
        } catch (Exception e) {
            System.out.println("Invalid choice. Try again!");
        }

        timetableManager.writeGeneratedTimetableToCSV("src/resources/Timetable.csv");
    }

    /**
     * this printTimetableSlots method is used by all query methods for the menu.
     * list timetableSlots passed in as a parameter which contains the slots to be printed.
     * checks if the list timetableSlots is empty and prints a message if it is.
     * String array of days and a String array of time slots available each day from monday to friday.
     * 2D array for the timetable grid which is of size timeSlots length by days length.
     * a nested for loop which loops through the time slots in the array and the days in the array.
     * initializes the timetable grid to empty strings.
     * a for-each loop that loops through the list timetableSlots, gets the day and stores it in a local variable day.
     * gets the start time and end time, separated by a dash and stored in a local variable timeSlot of type String.
     * a for loop that loops through the array of time slots and checks if it equals the variable timeSlot.
     * a for loop that loops through the array of days and checks if it equals the variable day.
     * sets the timetable grid indexes equal to the slotText variable.
     * for loops to print the formatting of the timetable grid.
     * prompt used for timetable formatting -> java timetable print positioning (stack overflow).
     * @param timetableSlots the list of all timetable slots to be printed.
     */
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