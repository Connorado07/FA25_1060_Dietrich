import java.util.ArrayList;
import java.util.List;

// 1. Driver Class
public class CSclasses {

    //print the details WITH callign the toString
    public static void printCourseDetailsWithToString(Course course) {
        System.out.println("\n--- Printing using toString() ---");
        System.out.println(course.toString());
    }

    // print details WITHOUT calling the toString
    public static void printCourseDetailsWithoutToString(Course course) {
        System.out.println("\n--- Printing without calling toString() ---");
        
        // print details with the getters
        System.out.println("Course Number: " + course.getCourseNumber());
        System.out.println("Number of Students: " + course.getNumStudents());
        System.out.println("Maximum Students: " + course.getMaxStudents());
        System.out.println("Credits: " + course.getCredits());

        // Check the actual type of the course to print specific data
        if (course instanceof InPersonCourse) {
            InPersonCourse ipCourse = (InPersonCourse) course;
            System.out.println("Course Type: In-Person");
            System.out.println("Room Number: " + ipCourse.getRoomNumber());
        } else if (course instanceof FullRemoteCourse) {
            FullRemoteCourse frCourse = (FullRemoteCourse) course;
            System.out.println("Course Type: Online");
            System.out.println("Remote Type: Full Remote (Asynchronous)");
            System.out.println("Course Contact Email: " + frCourse.getContactEmail());
        } else if (course instanceof RealTimeRemoteCourse) {
            RealTimeRemoteCourse rtCourse = (RealTimeRemoteCourse) course;
            System.out.println("Course Type: Online");
            System.out.println("Remote Type: Real-Time Remote (Synchronous)");
            System.out.println("Zoom Information: " + rtCourse.getZoomInfo());
        } else if (course instanceof OnlineCourse) {
            // A generic OnlineCourse if it was somehow created :(
            System.out.println("Course Type: Generic Online");
        }
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        
        // arraylist of course objects
        List<Course> courseList = new ArrayList<>();
        
        //InPersonCourse
        InPersonCourse inPerson = new InPersonCourse(
            "CSC1060", 
            12, 
            24, 
            4, 
            "BP119"
        );

        //FullRemoteCourse
        FullRemoteCourse fullRemote = new FullRemoteCourse(
            "ECO2002", 
            24, 
            24, 
            3, 
            "SomeEconProf@frcc.edu"
        );

        //RealTimeRemoteCourse
        RealTimeRemoteCourse realTime = new RealTimeRemoteCourse(
            "ENG1021", 
            24, 
            2, 
            3, 
            "Link in D2L"
        );
        
        // Add courses to the list
        courseList.add(inPerson);
        courseList.add(fullRemote);
        courseList.add(realTime);

        System.out.println("--- Course List Initialization Complete ---");
        
        // use the methods i just made
        System.out.println("\n--- Demonstration of printing without toString() ---");
        printCourseDetailsWithoutToString(inPerson);
        printCourseDetailsWithoutToString(fullRemote);

        // also use the cool methods
        System.out.println("\n=============================================");
        System.out.println("--- Traverse Course List using toString() ---");
        System.out.println("=============================================");
        for (Course course : courseList) {
            printCourseDetailsWithToString(course);
        }
    }
}