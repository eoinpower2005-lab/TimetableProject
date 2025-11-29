/**
 * Represents a group of students enrolled in a module and programme
 * Student groups are formed from the students enrolled in a programme and year.
 * This data is read from a csv file of all users
 * In this way rooms and modules can be scheduled for an entire studentGroup rather than per student.
 * Student groups are split into sub-groups for labs and tutorials.
 * The capacity of a room is compared against the size of the sub-groups.

 */
public class StudentGroup {
    private String groupIDs; //ID for the group so it can be identified "LM124H1S1_CS4141_Lab1"
    private String programmeIDs;
    private int programmeYears;
    private int groupSizes;

    public StudentGroup(String programmeIDs, int programmeYears, String groupIDs, int groupSizes) {
        this.groupIDs = groupIDs;
        this.programmeIDs = programmeIDs;
        this.programmeYears = programmeYears;
        this.groupSizes = groupSizes;

    }

    public String getGroupIDs() {
        return groupIDs;
    }

    public void setGroupID(String groupID) {
        this.groupIDs = groupIDs;
    }

    public String getProgrammeIDs() {
        return programmeIDs;
    }

    public void setProgrammeIDs(String programmeIDs) {
        this.programmeIDs = programmeIDs;
    }

    public int getProgrammeYears() {
        return programmeYears;
    }

    public void setProgrammeYears(int programmeYears) {
        this.programmeYears = programmeYears;
    }

    public int getGroupSizes() { //
        return groupSizes;
    }

    public void setGroupSizes(int groupSizes) {
        this.groupSizes = groupSizes;
    }
}
