package StudentManagement.common;

import java.util.ArrayList;
import java.util.Collections;

import StudentManagement.model.Report;
import StudentManagement.model.Student;

public class StudentManagement {
    ArrayList<Report> reportList = new ArrayList<>();
    ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getAllStudentList() {
        return studentList;
    }

    public void CreateNewStudent(Student student) {
        studentList.add(student);
    }

    public void DeleteStudentbyIndex(int index) {
        studentList.remove(index);
    }

    public void DeleteStudentbyO(Student student) {
        studentList.remove(student);
    }

    public void UpdateStudent(int index, Student student) {
        studentList.set(index, student);
    }

    public void findAndSort(String input) {
        Collections.sort(studentList);
        for (Student student : studentList) {
            if (student.getNameStudent().toLowerCase().contains(input)) {
                System.out.println(
                        student.getNameStudent() + " | " + student.getSemester() + " | " + student.getCourseName());
            }
        }
    }

    public ArrayList<Student> getStudentListbyId(String id) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getIdStudent().equals(id)) {
                students.add(student);
            }
        }
        return students;
    }

    public void DeleteStudentById(String id) {
        for (Student student : getStudentListbyId(id)) {
            studentList.remove(student);
        }
    }

    public String getNameStudentById(String id) {
        for (Student student : studentList) {
            if (student.getIdStudent().equals(id)) {
                return student.getNameStudent();
            }
        }
        return "no";
    }

    public void DisplayAllStudentList(ArrayList<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student.getIdStudent() + " | " + student.getNameStudent() + " | " + student.getSemester()
                    + " | " + student.getCourseName());
        }
        System.out.println("--------------------------------");
    }

    public int checkExistID(String id) {
        for (Student student : studentList) {
            if (student.getIdStudent().equals(id)) {
                return 1;
            }
        }
        return 0;
    }

    // -----------------------------------------UPDATE------------------------------------------
    public void updateStudent(String inputId) {
        for (Student student : getStudentListbyId(inputId)) {
            System.out.println(
                    studentList.indexOf(student) + " | " + student.getIdStudent() + " | " + student.getNameStudent()
                            + " | " + student.getSemester() + " | " + student.getCourseName());
        }

        while (true) {
            Input input = new Input();
            int choice = input.getInt("Enter choice: ", 0, 100);

            studentList.get(choice);
            System.out.println("Enter name: ");
            String newName = input.getString();

            String newSemester;
            String newSourseName;
            int check;
            do {
                newSemester = input.getSemester();
                newSourseName = input.getCourseName();
                Student newStudent = new Student(inputId, newName, newSemester, newSourseName);
                check = checkSourseName(getStudentListbyId(inputId), newStudent);
            } while (check == 0);
            
               studentList.get(choice).setCourseName(newSourseName);
               studentList.get(choice).setSemester(newSemester);

            for (Student student : getStudentListbyId(inputId)) {
                studentList.get(studentList.indexOf(student)).setNameStudent(newName);
            }
            return;

        }
    }

    public int checkSourseName(ArrayList<Student> studentIdList, Student newStudent) {
        for (Student oldStudent : studentIdList) {
            if (newStudent.getSemester().equals(oldStudent.getSemester())
                    && newStudent.getCourseName().equals(oldStudent.getCourseName())) {
                System.out.println("Trung`Khoa'Hoc");
                return 0;
            }
        }

        return 1;

    }

    // --------------------------------------------------------------------------------------

    // REPORT

    public ArrayList<Report> getAllReportList() {
        return reportList;
    }

    public void addNewReport(Report report) {
        reportList.add(report);
    }

    public void deleteReportById(String id) {
        for (Report report : reportList) {
            if (report.getId().equals(id)) {
                reportList.remove(report);
            }
        }
    }

    public void DisplayReport() {
        for (Report report : reportList) {
            System.out.println(
                    report.getId() + " | " + report.getName() + " | " + report.getCourse() + " | " + report.getTotal());
        }
        System.out.println("-------------------------------------\n");
    }

}
