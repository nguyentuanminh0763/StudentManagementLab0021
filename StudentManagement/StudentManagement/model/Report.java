package StudentManagement.model;

public class Report {
    private String id;
    private String name;
    private String course;
    private int total;
    public Report(String id, String name, String course, int total) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.total = total;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "Report [id=" + id + ", name=" + name + ", course=" + course + ", total=" + total + "]";
    }


}
