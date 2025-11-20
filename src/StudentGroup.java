/**
 * represents a group of students enrolled in a module and programme
 * student groups are formed from the students enrolled in a programme and year.
 * this data is read from a csv file of all users
 * in this way rooms and modules can be scheduled for an entire studentGroup rather than per student.
 * student groups are split into sub-groups for labs and tutorials.
 * the capacity of a room is compared against the size of the sub-groups.
 */
public class StudentGroup {
    private String groupId; //ID for the group so it can be identified "LM124H1S1_CS4141_Lab1"
    private String programmeId;
    private String moduleCode;
    private int year;
    private int semester;
    private String groupType;
    private int groupSize ;

    /**
     *
     * @param groupId unique identifier for this student group
     * @param programmeId id of the programme("LM121")
     * @param moduleCode module code this group is associated with
     * @param year year of the programme
     * @param semester semester number (1 or 2)
     * @param groupType type of group ("lecture" or "lab" or "tutorial")
     * @param groupSize number of students in the group
     */
//copy the values passed into the constructor into the fields of the object
// It stores the input values into the new StudentGroup object so you can use them later.
    public StudentGroup(String groupId, String programmeId, String moduleCode, int year, int semester, String groupType, int groupSize) {
        this.groupId = groupId;
        this.programmeId = programmeId;
        this.moduleCode = moduleCode;
        this.year = year;
        this.semester = semester;
        this.groupType = groupType;
        this.groupSize = groupSize;

    }
//accessible outside the class other classes can call these getter methods and return the variable (int, string)
    /**
     * Returns the unique ID of the student group.
     */
    public String getGroupId() {
        return groupId;
    }
    /**
     * Returns the programme this group belongs to.
     */
    public String getProgrammeId() {
        return programmeId;
    }
    /**
     * Returns the module code this group is taking.
     */
    public String getModuleCode() {
        return moduleCode;
    }
    /**
     * Returns the programme year of this group.
     */
    public int getYear() {
        return year;
    }
    /**
     * Returns the semester this group is in.
     */
    public int getSemester() {
        return semester;
    }
    /**
     * Returns the type of group (lecture, lab, or tutorial).
     */
    public String getGroupType() {
        return groupType;
    }
    /**
     * Returns the number of students in the group.
     */
    public int getGroupSize() {
        return groupSize;
    }


}