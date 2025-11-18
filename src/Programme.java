/**
 * provides programme details for timetable
 * Represents the academic programmes offered by the university
 * The programme collects the modules that belongs to the specific
 * programme and is also associated with student groups and lecturers.
 * Stores programme information (programmeId, programmeName, programmeModule)
 */
public class Programme {
    private String programmeId;
    private String programmeName;

    public Programme(String programmeId, String programmeName) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
    }
    public String getProgrammeId() {
        return programmeId;
    }
    public String getProgrammeName() {
        return programmeName;
    }
}
