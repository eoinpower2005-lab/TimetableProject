/**
 * this class represents a module scheduled in a timetable slot.
 * a module belongs to a programme
 * it is associated with a studentGroup
 * a module has a module code, name, lecture/lab/tutorial hours
 * a module is assigned a lecturer
 */
public class Module {
    private String moduleCode;
    private String moduleName;
    private int lectureHours;
    private int labHours;
    private int tutorialHours;

    private Lecturer lecturer;
}
