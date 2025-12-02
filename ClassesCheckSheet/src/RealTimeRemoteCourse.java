public class RealTimeRemoteCourse extends OnlineCourse {

    private String zoomInfo;

    public RealTimeRemoteCourse() {
        super();
        this.zoomInfo = "See LMS for link";
    }

    public RealTimeRemoteCourse(String courseNumber, int numStudents, int maxStudents, int credits, String zoomInfo) {
        super(courseNumber, numStudents, maxStudents, credits);
        this.zoomInfo = zoomInfo;
    }

    // Getter 
    public String getZoomInfo() {
        return zoomInfo;
    }

    // Setter 
    public void setZoomInfo(String zoomInfo) {
        this.zoomInfo = zoomInfo;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nRemote Type: Real-Time Remote (Synchronous)" +
               "\nZoom Information: " + zoomInfo;
    }
}