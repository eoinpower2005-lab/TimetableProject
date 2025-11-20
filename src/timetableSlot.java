import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimetableSlot {
    private DayOfWeek day;
    private int slotID;
    private String moduleCode;
    private LocalTime startTime;
    private LocalTime endTime;
    private ClassType classType;
    private int lecturerID;
    private String roomType;
    private int semester;


    public TimetableSlot(DayOfWeek day, int slotID, String moduleCode, LocalTime startTime, LocalTime endTime, ClassType classType, int lecturerID, String roomType, int semester) {
        this.day = day;
        this.slotID = slotID;
        this.moduleCode = moduleCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classType = classType;
        this.lecturerID = lecturerID;
        this.roomType = roomType;
        this.semester = semester;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public String getModule() {
        return moduleCode;
    }

    public void setModule(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getRoom() {
        return roomType;
    }

    public void setRoom(String roomType) {
        this.roomType = roomType;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
