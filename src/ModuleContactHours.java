public class ModuleContactHours {
    private String moduleCode;
    private int lectureHours;
    private int tutorialHours;
    private int labHours;

    public ModuleContactHours(String moduleCode, int lectureHours, int tutorialHours, int labHours) {
        this.moduleCode = moduleCode;
        this.lectureHours = lectureHours;
        this.tutorialHours = tutorialHours;
        this.labHours = labHours;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
    }

    public int getTutorialHours() {
        return tutorialHours;
    }

    public void setTutorialHours(int tutorialHours) {
        this.tutorialHours = tutorialHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }
}

