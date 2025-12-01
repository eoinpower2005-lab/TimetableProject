public class StudentRecords { //
    private String ModuleCode;
    private int NumStudents;
    /**
     * @param moduleCode the code of the module
     * @param numStudents the amount of students enrolled in this module
     */
    public StudentRecords(String moduleCode, int numStudents) { //
        this.ModuleCode = moduleCode;
        this.NumStudents = numStudents;
    }//
    /**
     * @return the codes module
     */
    public String getModuleCode() { //
        return ModuleCode;
    } //
    /**
     *
     * @return the number of students
     */
    public int getNumStudents() {
        return NumStudents;
    } //
    /**
     * @param numStudents sets a new student count
     */
    public void setNumStudents(int numStudents) {
        this.NumStudents = numStudents;
    } //
    /**
     * @param ModuleCode sets a new module code
     */
    public void setModuleCode(String ModuleCode) {
        this.ModuleCode = ModuleCode;
    } //
} //
