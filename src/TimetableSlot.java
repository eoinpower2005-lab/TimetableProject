import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimetableSlot {
    private String day;
    private String startTime;
    private String endTime;
    private String moduleCode;
    private ClassType classType;
    private String lecturerName;
    private String roomID;
    private int semester;
    private String timetableID;


    public TimetableSlot(String day, String startTime, String endTime, String moduleCode, ClassType classType, String lecturerName, String roomID, int semester, String timetableID) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.moduleCode = moduleCode;
        this.classType = classType;
        this.lecturerName = lecturerName;
        this.roomID = roomID;
        this.semester = semester;
        this.timetableID = timetableID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getModule() {
        return moduleCode;
    }

    public void setModule(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoom(String roomID) {
        this.roomID = roomID;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(String timetableID) {
        this.timetableID = timetableID;
    }

    public boolean clashesWith(TimetableSlot other) {
        if(this.day != other.day) {
            return false;
        }
        return (this.startTime != other.endTime);
    }
}