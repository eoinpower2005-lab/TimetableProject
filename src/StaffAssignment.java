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

