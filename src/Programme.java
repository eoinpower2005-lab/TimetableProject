import java.util.ArrayList;
import java.util.List;
/**
 * This class provides programme details for timetable
 * Represents the academic programmes offered by the university
 * The programme collects the modules that belongs to the specific
 * programme and is also associated with student groups and lecturers.
 * Stores programme information (programmeId, programmeName, programmeModule)
 */
public class Programme {
    private String programmeID;
    private int programmeYear;
    private int programmeSemester;
    private String moduleID;

    public Programme(String programmeID, int programmeYear, int programmeSemester, String moduleID) {
        this.programmeID = programmeID;
        this.programmeYear = programmeYear;
        this.programmeSemester = programmeSemester;
        this.moduleID = moduleID;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeID = programmeId;
    }

    public String getProgrammeID() {
        return programmeID;
    }

    public void setProgrammeYear(int programmeYear) {
        this.programmeYear = programmeYear;
    }

    public int getProgrammeYear() {
        return programmeYear;
    }

    public void setProgrammeSemester(int programmeSemester) {
        this.programmeSemester = programmeSemester;
    }

    public int getProgrammeSemester() {
        return programmeSemester;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleID() {
        return moduleID;
    }
}
