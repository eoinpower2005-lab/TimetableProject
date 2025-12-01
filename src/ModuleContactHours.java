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

    public ModuleContactHours(String moduleCode, int lectureHours, int tutorialHours, int labHours) {
        this.moduleCode = moduleCode;
        this.lectureHours = lectureHours;
        this.tutorialHours = tutorialHours;
        this.labHours = labHours;
    }

    /**
     *
     * @return the module code as a String identifying the module e.g. "CS4013"
     */

    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Sets the moduleCode
     * @param moduleCode the new module code for this contract hours recorded
     */

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     *
     * @return the number of lecture hours as positive Integers required for the module.
     * Lecture hours represent large group teaching sessions delivered in halls or classrooms
     */

    public int getLectureHours() {
        return lectureHours;
    }

    /**
     * Sets the weekly lecture hours
     * @param lectureHours the new number of lecture hours as a positive Integer required for the module
     */

    public void setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
    }

    /**
     *
     * @return the number of tutorial hours as a positive integer required for the module
     * the tutorial hours represent a small group teaching sessions held in classes
     */

    public int getTutorialHours() {
        return tutorialHours;
    }

    /**
     * Sets the weekly tutorial hours
     * @param tutorialHours the new number of weekly tutorial hours required for the module
     */

    public void setTutorialHours(int tutorialHours) {
        this.tutorialHours = tutorialHours;
    }

    /**
     *
     * @return the number of weekly lab hours required for a module
     */

    public int getLabHours() {
        return labHours;
    }

    /**
     * Sets the weekly lab hours
     * @param labHours the new number of weekly lab hours required for the module
     */

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }
}

