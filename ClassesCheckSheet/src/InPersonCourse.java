public class InPersonCourse extends Course {
    
    private String roomNumber;

    
    public InPersonCourse() {
        super();
        this.roomNumber = "TBA";
    }

    
    public InPersonCourse(String courseNumber, int numStudents, int maxStudents, int credits, String roomNumber) {
        super(courseNumber, numStudents, maxStudents, credits);
        this.roomNumber = roomNumber;
    }

    // Getter 
    public String getRoomNumber() {
        return roomNumber;
    }

    // Setter 
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nCourse Type: In-Person" +
               "\nRoom Number: " + roomNumber;
    }
}