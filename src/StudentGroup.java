/**
 * Represents a group of students enrolled in a module and programme
 * Student groups are formed from the students enrolled in a programme and year.
 * This data is read from a csv file of all users
 * In this way rooms and modules can be scheduled for an entire studentGroup rather than per student.
 * Student groups are split into sub-groups for labs and tutorials.
 * The capacity of a room is compared against the size of the sub-groups.

 */
public class StudentGroup {
    private String groupID1; //ID for the group so it can be identified "LM124H1S1_CS4141_Lab1"
    private String programmeID1;
    private int programmeYear1;
    private int groupSize1;

    public StudentGroup(String programmeID, int programmeYear, String groupID, int groupSize) {
        this.groupID1 = groupID;
        this.programmeID1 = programmeID;
        this.programmeYear1 = programmeYear;
        this.groupSize1 = groupSize;

    }

    public String getGroupID() {
        return groupID1;
    }

    public void setGroupID(String groupID) {
        this.groupID1 = groupID;
    }

    public String getProgrammeID() {
        return programmeID1;
    }

    public void setProgrammeID(String programmeID) {
        this.programmeID1 = programmeID;
    }

    public int getProgrammeYear() {
        return programmeYear1;
    }

    public void setProgrammeYear(int programmeYear) {
        this.programmeYear1 = programmeYear;
    }

    public int getGroupSize() {
        return groupSize1;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize1 = groupSize;
    }



}
