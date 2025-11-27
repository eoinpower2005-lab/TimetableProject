public class StudentRecords {
    private String moduleCode;
    private int numStudents;

    public StudentRecords(String moduleCode, int numStudents) {
        this.moduleCode = moduleCode;
        this.numStudents = numStudents;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}

