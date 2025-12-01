import java.util.ArrayList;
import java.util.List;
/**
 * This class provides programme details for timetable
 * Represents the academic programmes offered by the university
 * This class models the relationship between a programme, its academic year, the semester and
 * the module assigned to that year and semester.
 * Each Programme object corresponds to a row in the Programme_structure.csv file.
 * Programme is used by timetableManager during timetable generation to determine
 * which module each student group should be scheduled for based on their programme, year of study and the semester
 * that was selected
 * Stores programme information (programmeID e.g. "LM121", programmeYear e.g. year 1,2,3,4, programmeSemester e.g. 1or2)
 * moduleID e.g. "CS4013").
 */
public class Programme {
    private String programmeID;
    private int programmeYear;
    private int programmeSemester;
    private String moduleID;

    /**
     * This constructor constructs a Programme object representing a single programme requirement for a certain
     * year/semester
     *
     * @param programmeID the ID of the programme/course e.g. "LM121"
     * @param programmeYear the academic year of the programme
     * @param programmeSemester the semester number e.g. 1=Autumn 2=Spring
     * @param moduleID the module ID that is assigned to this programme/year/semester
     */

    public Programme( String programmeID, int programmeYear, int programmeSemester, String moduleID ) {
         this.programmeID = programmeID;
         this.programmeYear = programmeYear;
         this.programmeSemester = programmeSemester;
         this.moduleID = moduleID;
    }

    /**
     * Sets the ID for this programme
     * @param programmeId the new programme ID
     */
    public void setProgrammeId (String programmeId) {
         this.programmeID = programmeId;
    }

    /**
     *
     * @returnthe programme ID as a String e.g."LM121"
     */

    public String getProgrammeID () {
         return programmeID;
    }

    /**
     * Sets the year of study for this programme structure
     * @param programmeYear the new programme year
     */

    public void setProgrammeYear(int programmeYear)  {
         this.programmeYear = programmeYear;
    }

    /**
     *
     * @return the year of study for this programme structure as a positive integer
     */

    public int getProgrammeYear()  {
         return programmeYear;
    }

    /**
     * Sets the semester when this module was thought in the programme
     * @param programmeSemester the new programme semester e.g. 1=Autumn 2=Spring
     */

    public void setProgrammeSemester(int programmeSemester)  {
         this.programmeSemester = programmeSemester;
    }

    /**
     *
     * @return the semester when this module is thought in the programme
     */

    public int getProgrammeSemester()  {
         return programmeSemester;
    }

    /**
     * Sets the module identifier for this programme structure object
     * @param moduleID the new module ID which is needed to see if this specific module is part of the programme
     */

    public void setModuleID(String moduleID)  {
         this.moduleID = moduleID;
    }

    /**
     *
     * @return the module ID as a String e.g. "CS4013", this identifies the module for this programme structure
     */

    public String getModuleID()  {
         return moduleID;
    }
}
