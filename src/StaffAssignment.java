public class StaffAssignment {
    private String moduleCode;
    private String classType;
    private int maxCapacity;
    private String assignedTeacher;

    public StaffAssignment(String moduleCode, String classType, int maxCapacity, String assignedTeacher) {
        this.moduleCode = moduleCode;
        this.classType = classType;
        this.maxCapacity = maxCapacity;
        this.assignedTeacher = assignedTeacher;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getAssignedTeacher() {
        return assignedTeacher;
    }

    public void setAssignedTeacher(String assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }
}

