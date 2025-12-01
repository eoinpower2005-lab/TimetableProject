/**
 * Represents the weekly contact hours required for a specific module
 * It has the number of lecture, tutorial, and lab hours that are scheduled to be in the timetable each week for
 * the module.
 * this class uses a row in the Module_contact_hours.csv file.
 * The class is used by TimetableManager to determine how many sessions of each class
 * type need to be scheduled when building the timetable.
 * TimetableManager uses this class to get lecture hours for scheduling, check if a module requires lab or tutorial
 * sessions and also associate modules with correct weekly workload
 */

public class ModuleContactHours {
    private String moduleCode;
    private int lectureHours;
    private int tutorialHours;
    private int labHours;

    /**
     * This constructor constructs a ModuleContactHours Object with the required weekly contact hours for the given
     * module.
     * @param moduleCode the modules code specific to one module e.g. "CS4013"
     * @param lectureHours the weekly lecture hours required for a module
     * @param tutorialHours the weekly tutorial hours required for a module
     * @param labHours the weekly lab hours required for a module
     */


