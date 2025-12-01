/**
 * This class represents a module scheduled in a timetable slot. It stores information related to its contact hours
 * and the types of rooms required for each class type
 * A module belongs to a programme, it is associated with a studentGroup.
 * Module has a module code, name, lecture/lab/tutorial hours.
 * These values may be loaded from the CSV files and used by timetableManager when generating timetable or checking
 * room availability.
 *
 */
public class Module {
    private String moduleCode;
    private String moduleName;
    private String roomType;
    private String lectureRoomType;
    private String labRoomType;
    private String tutorialRoomType;
    private int lectureHours;
    private int labHours;
    private int tutorialHours;

    /**
     *Constructs a new Module with the specified parameters
     * @param moduleCode the code that is used to identify the module e.g. "CS4013"
     * @param moduleName the name of the module e.g. "Software Development"
     * @param roomType the general room type
     * @param lectureRoomType room type appropriate for lecturers
     * @param labRoomType room type appropriate for labs
     * @param tutorialRoomType room type appropriate for tutorials
     * @param lectureHours the total number of lecture hours per week that a module has
     * @param labHours the total number of lab hours per week that a module has
     * @param tutorialHours the total number of tutorial hours per week that a module has
     */

    public Module(String moduleCode, String moduleName, String roomType, String lectureRoomType, String labRoomType,
                  String tutorialRoomType, int lectureHours, int labHours, int tutorialHours) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.roomType = roomType;
        this.lectureRoomType = lectureRoomType;
        this.labRoomType = labRoomType;
        this.tutorialRoomType = tutorialRoomType;
        this.lectureHours = lectureHours;
        this.labHours = labHours;
        this.tutorialHours = tutorialHours;

    }

    /**
     *
     * @return the code that represents a specific module as a String e.g. "CS4013"
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     *
     * @return the full module name as a String e.g. "Software Development"
     */

    public String getModuleName() {
        return moduleName;
    }

    /**
     *
     * @return the general room type as a String
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     *
     * @return the specific room type needed for lecture session as a String
     */
    public String getLectureRoomType() {
        return lectureRoomType;
    }

    /**
     *
     * @return the specific room type needed for lab sessions as a String
     */
    public String getLabRoomType() {
        return labRoomType;
    }

    /**
     *
     * @return the number of lecture hours required for this module as an Integer
     */

    public int getLectureHours() {
        return lectureHours;
    }

    /**
     *
     * @return the number of lab hours required for this module as an Integer
     */

    public int getLabHours() {
        return labHours;
    }

    /**
     *
     * @return the number of tutorial hours required for this module as an Integer
     */

    public int getTutorialHours() {
        return tutorialHours;
    }

    /**
     *
     * @return the total weekly hours commitment required for a specific module(labhours + tutorialhours + lecturehours)
     */

    public int getTotalHours() {
        return lectureHours + labHours + tutorialHours;
    }

    /**
     * Checks if the module need a specific room type (lecture, lab, or tutorial)
     * this method checks two conditions, if the module actually has hours of the given class type and return true if
     * the room matches the specific room type that is needed for the class
     * @param room the room being checked for suitability
     * @param classType the type of
     */
    public boolean canUseRoom(Rooms room, String classType) {
        String type = classType.toLowerCase();

        if (type.equals("lecture")) {
            return lectureHours > 0 &&
                    room.getType().equalsIgnoreCase(lectureRoomType);
        }

        if (type.equals("lab")) {
            return labHours > 0 &&
                    room.getType().equalsIgnoreCase(labRoomType);
        }

        if (type.equals("tutorial")) {
            return tutorialHours > 0 &&
                    room.getType().equalsIgnoreCase(tutorialRoomType);
        }

        return false;
    }

}
