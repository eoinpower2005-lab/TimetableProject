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

    /**
     * Returns the group id
     * @return the group id
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * @param groupID Sets a new group id
     */
    public void setGroupID(String groupID) {
        this.groupID = this.groupID;
    }

    /**
     * @return the programmes id
     */
    public String getProgrammeID() {
        return programmeID;
    }

    /**
     * @param programmeID Sets the new programmes id
     */
    public void setProgrammeID(String programmeID) {
        this.programmeID = programmeID;
    }

    /**
     * @return the programmes year
     */
    public int getProgrammeYear() {
        return programmeYear;
    }

    /**
     * @param programmeYear sets the new programmes year
     */
    public void setProgrammeYear(int programmeYear) {
        this.programmeYear = programmeYear;
    }

    /**
     * @return the group size
     */
    public int getGroupSize() {
        return groupSize;
    }

    /**
     * @param groupSize sets a new group size
     */
    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }
}
