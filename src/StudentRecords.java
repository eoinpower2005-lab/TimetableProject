public class StudentRecords {
    private String ModuleCode;
    private int NumStudents;
    /**
     * Constructs a StudentRecords object with the specified module code
     * and number of students
     *
     * @param moduleCode the code of the module
     * @param numStudents the amount of students enrolled in this module
     */
    public StudentRecords(String moduleCode, int numStudents) {
        this.ModuleCode = moduleCode;
        this.NumStudents = numStudents;
    }
    /**
     * @return the modules code
     */
    public String getModuleCode() {
        return ModuleCode;
    }
    /**
     * Returns the number of students enrolled in a module
     * @return the number of students
     */
    public int getNumStudents() {
        return NumStudents;
    }
    /**
     * Sets a new student count for a module
     * @param numStudents sets a new student count
     */
    public void setNumStudents(int numStudents) {
        this.NumStudents = numStudents;
    }
    /**
     * sets a new module code
     * @param ModuleCode the new module code
     */
    public void setModuleCode(String ModuleCode) {
        this.ModuleCode = ModuleCode;
    }
}
