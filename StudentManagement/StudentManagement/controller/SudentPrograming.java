package StudentManagement.controller;

import java.util.Scanner;

import StudentManagement.common.Input;
import StudentManagement.common.StudentManagement;
import StudentManagement.model.Report;
import StudentManagement.model.Student;
import StudentManagement.view.Menu;

public class SudentPrograming extends Menu<String> {

    Scanner sc = new Scanner(System.in);
    StudentManagement studentManagement = new StudentManagement();
    Input input = new Input();

    static String[] mc = { "Create", "Find and Sort", "Update/Delete", "Report", "Exit" };

    public SudentPrograming() {
        super("STUDENT MANAGEMENT SYSTEM", mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                createNewStudent();
                break;
            }

            case 2: {
                findAndSort();
                break;
            }

            case 3: {
                updateAndDelete();
                break;
            }

            case 4: {
                report();
                break;
            }

            case 5: {
                System.exit(0);
            }
        }
    }

    public void createNewStudent() {
        int n = 1;
        while (true) {

            System.out.println("Enter ID: ");
            String id = input.getString();
            String name;

            if (studentManagement.checkExistID(id) == 1) {
                name = studentManagement.getNameStudentById(id);
                System.out.println("Student Name: " + name +"\n");

            } else {

                System.out.println("Enter Student Name: ");
                name = input.getString();
            }

            String semester = input.getSemester();

            String courseName = input.getCourseName();

            Student student = new Student(id, name, semester, courseName);
            studentManagement.CreateNewStudent(student);

            if (studentManagement.getAllReportList().isEmpty()) {
                Report report = new Report(id, name, courseName, 1);
                studentManagement.addNewReport(report);
            } else {
                int z = 0;
                for (Report report : studentManagement.getAllReportList()) {

                    if (report.getId().equals(id) && report.getCourse().equals(courseName)) {
                        int total = report.getTotal() + 1;
                        report.setTotal(total);
                        z = 1;
                    }
                }
                if (z == 0) {
                    studentManagement.addNewReport(new Report(id, name, courseName, 1));
                }
            }

            n = n + 1;

            // System.out.println("Do you want to DK new Semester and Course or not?(Y/N)");
            // if (input.chooseYN() == false) {
            // break;
            // }

            if (n == 5) {
                System.out.println(
                        "Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
                n = 1;
                if (input.chooseYN() == false) {
                    return;
                }
            }

        }
    }

    public void findAndSort() {
        System.out.println("inputs student name or a part of student name: ");
        String name = input.getString();
        studentManagement.findAndSort(name);
    }

    public void updateAndDelete() {
        if (studentManagement.getAllStudentList().isEmpty()) {
            System.out.println("Empty");
            return;
        }
        String id;
        do {
            System.out.println("ENTER ID: ");
            id = input.getString();
            if (studentManagement.checkExistID(id) == 0) {
                System.out.println("No exist");
            }
        } while (studentManagement.checkExistID(id) == 0);
        studentManagement.DisplayAllStudentList(studentManagement.getStudentListbyId(id));

        while (true) {

            int choice = input.getInt("ENTER your choice: \n" +
                      "1. Update\n"
                    + "2. Delete\n"
                    + "3. Return", 1, 3);
            switch (choice) {
                case 1: {
                    studentManagement.updateStudent(id);
                    break;
                }
                case 2: {
                    studentManagement.DeleteStudentById(id);
                    studentManagement.deleteReportById(id);
                    return;
                }

                case 3: {
                    return;
                }
            }
        }
    }

    public void report() {
        // studentManagement.addReport();
        studentManagement.DisplayReport();
    }

}
