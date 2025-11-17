public class FullRemoteCourse extends OnlineCourse {
    
    private String contactEmail;

    public FullRemoteCourse() {
        super();
        this.contactEmail = "none@university.edu";
    }

    public FullRemoteCourse(String courseNumber, int numStudents, int maxStudents, int credits, String contactEmail) {
        super(courseNumber, numStudents, maxStudents, credits);
        this.contactEmail = contactEmail;
    }

    // Getter 
    public String getContactEmail() {
        return contactEmail;
    }

    // Setter 
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nRemote Type: Full Remote (Asynchronous)" +
               "\nCourse Contact Email: " + contactEmail;
    }
}