public class Course {

    private String courseNumber; 
    private int numStudents;
    private int maxStudents;
    private int credits;

    public Course() {
        this.courseNumber = "Unknown";
        this.numStudents = 0;
        this.maxStudents = 0;
        this.credits = 0;
    }

    public Course(String courseNumber, int numStudents, int maxStudents, int credits) {
        this.courseNumber = courseNumber;
        this.numStudents = numStudents;
        this.maxStudents = maxStudents;
        this.credits = credits;
    }

    // Getters
    public String getCourseNumber() {
        return courseNumber;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public int getCredits() {
        return credits;
    }

    // Setters
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    // override toString method
    @Override
    public String toString() {
        return "--- Course Details ---" +
               "\nCourse Number: " + courseNumber +
               "\nNumber of Students: " + numStudents +
               "\nMaximum Students: " + maxStudents +
               "\nCredits: " + credits;
    }
}