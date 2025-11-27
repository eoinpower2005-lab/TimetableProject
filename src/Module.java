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
    private String roomType;
    private String lectureRoomType;
    private String labRoomType;
    private String tutorialRoomType;
    private int lectureHours;
    private int labHours;
    private int tutorialHours;

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

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }
    public String getRoomType() {
        return roomType;
    }
    public String getLectureRoomType() {
        return lectureRoomType;
    }
    public String getLabRoomType() {
        return labRoomType;
    }

    public int getLectureHours() {
        return lectureHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public int getTutorialHours() {
        return tutorialHours;
    }

    public int getTotalHours() {
        return lectureHours + labHours + tutorialHours;
    }

    /**
     * checks if the module need a specific room type
     */
    public boolean canUseRoom(Rooms room,String classType){
        switch (classType.toLowerCase()){

            case "lecture":
                return lectureHours > 0 &&
                        room.getType().equalsIgnoreCase(lectureRoomType);

            case "lab":
                return labHours > 0 &&
                        room.getType().equalsIgnoreCase(labRoomType);

            case "tutorial":
                return tutorialHours > 0 &&
                        room.getType().equalsIgnoreCase(tutorialRoomType);

            default:
                return false;

        }
    }
}