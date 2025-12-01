/**
 * Represents a staff assignment for a specific module and class type.
 * This class represents one row from the Staff_assignment.csv  file.
 */
public class StaffAssignment {
    private String moduleCode;
    private String classType;
    private int maxCapacity;
    private String assignedTeacher;

    /**
     * Constructs a staff assignment objects
     * @param moduleCode module code this person is linked to
     * @param classType  the type of class (lecture, lab, or tutorial)
     * @param maxCapacity maximum number of students for this class type
     * @param assignedTeacher the full name of the lecturer teaching this class
     */
    public StaffAssignment(String moduleCode, String classType, int maxCapacity, String assignedTeacher) {
        this.moduleCode = moduleCode;
        this.classType = classType;
        this.maxCapacity = maxCapacity;
        this.assignedTeacher = assignedTeacher;
    }

    /**
     *
     * @return module code associated with this staff assignment
     */

    public String getModuleCode() {
         return moduleCode;
    }

    /**
     *
     * sets the module code
     */
    public void setModuleCode(String moduleCode) {
         this.moduleCode = moduleCode;
    }

    /**
     *
     * @return the class type (lecture, lab, tutorial)
     */

    public String getClassType() {
         return classType;
    }

    /**
     *
     * sets the class type (lecture, lab, tutorial)
     */

    public void setClassType(String classType) {
        this.classType = classType;
    }

    /**
     *
     * @return the maximum student capacity for this class
     */

    public int getMaxCapacity() {
         return maxCapacity;
    }

    /**
     *
     * Sets the maximum student capacity for this class.
     * */


    public void setMaxCapacity(int maxCapacity) {
         this.maxCapacity = maxCapacity;
    }

    /**
     *
     * @return the name of the assigned lecturer
     */

    public String getAssignedTeacher() {
         return assignedTeacher;
    }

    /**
     *
     * Sets the lecturer who is assigned to this class.
     */

    public void setAssignedTeacher(String assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }
}



