package StudentManagement.model;

public class Student implements Comparable<Student>{
    private String idStudent;
    private String nameStudent;
    private String semester;
    private String courseName;
    
    public Student(String idStudent, String nameStudent, String semester, String courseName) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
         this.semester = semester;
        this.courseName = courseName;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student [idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", Semester=" + semester
                + ", courseName=" + courseName + "]";
    }

    @Override
    public int compareTo(Student t){
        return this.nameStudent.compareTo(t.getNameStudent());
    }

    
}
