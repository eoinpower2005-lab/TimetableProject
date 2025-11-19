/**
 * represents a group of students enrolled in a module and programme
 * student groups are formed from the students enrolled in a programme and year.
 * this data is read from a csv file of all users
 * in this way rooms and modules can be scheduled for an entire studentGroup rather than per student.
 * student groups are split into sub-groups for labs and tutorials.
 * the capacity of a room is compared against the size of the sub-groups.
 */
public class StudentGroup {
    private String groupId;
    private String programmeId;
    private String moduleCode;
    private int year;
    private int semester;
    private String groupType;
    private int groupSize ;

    public StudentGroup(String groupId, String programmeId, String moduleCode, int year, int semester, String groupType, int groupSize) {
        this.groupId = groupId;
        this.programmeId = programmeId;
        this.moduleCode = moduleCode;
        this.year = year;
        this.semester = semester;
        this.groupType = groupType;
        this.groupSize = groupSize;

    }
    public String getGroupId() {
        return groupId;
    }
    public String getProgrammeId() {
        return programmeId;
    }
    public String getModuleCode() {
        return moduleCode;
    }
    public int getYear() {
        return year;
    }
    public int getSemester() {
        return semester;
    }
    public String getGroupType() {
        return groupType;
    }
    public int getGroupSize() {
        return groupSize;
    }


}