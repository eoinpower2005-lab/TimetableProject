/**
 * Represents a group of students enrolled in a module and programme
 * Student groups are formed from the students enrolled in a programme and year.
 * This data is read from a csv file of all users
 * In this way rooms and modules can be scheduled for an entire studentGroup rather than per student.
 * Student groups are split into sub-groups for labs and tutorials.
 * The capacity of a room is compared against the size of the sub-groups.

 */
public class StudentGroup {
    private String groupID; //ID for the group so it can be identified "LM124H1S1_CS4141_Lab1"
    private String programmeID;
    private int programmeYear;
    private int groupSize;

    /**
     *
     * @param programmeID The id of the programme
     * @param programmeYear The year of the programme
     * @param groupID The group id
     * @param groupSize
     */
    public StudentGroup(String programmeID, int programmeYear, String groupID, int groupSize) {
        this.groupID = groupID;
        this.programmeID = programmeID;
        this.programmeYear = programmeYear;
        this.groupSize = groupSize;
    }
    public String getGroupID() {
        return groupID;
    }
    public void setGroupID(String groupID) {
        this.groupID = this.groupID;
    }
    public String getProgrammeID() {
        return programmeID;
    }
    public void setProgrammeID(String programmeID) {
        this.programmeID = programmeID;
    }
    public int getProgrammeYear() {
        return programmeYear;
    }
    public void setProgrammeYear(int programmeYear) {
        this.programmeYear = programmeYear;
    }
    public int getGroupSize() {
        return groupSize;
    }
    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }
}
