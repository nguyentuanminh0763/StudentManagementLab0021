package StudentManagement.common;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Input {
    Scanner sc = new Scanner(System.in);

    public String getString() {
        while (true) {
            String res = sc.nextLine().trim();

            if (!res.isEmpty()) {
                return res;
            } else {
                System.out.println("you cannot enter empty!");
            }
        }
    }

    public int getInt(String message, int min, int max) {
        int number = 0;

        while (true) {
            System.out.println(message);
            try {
                number = Integer.parseInt(getString());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Number out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number invalid!");
            }
        }
    }

    public String getName() {
        while (true) {
            Pattern pname = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)?$");
            String name = getString();
            if (pname.matcher(name).find()) {
                return name;
            } else {
                System.out.println("format 'Name Name'");
            }
        }
    }

    public boolean chooseYN() {
        while (true) {
            String choose = getString();

            switch (choose) {
                case "y", "Y":
                    return true;
                case "n", "N":
                    return false;
                default:
                    System.out.println("Enter Y/N only!");
            }
        }
    }

    public String getSemester() {
        while (true) {
            int choice = getInt("Choice Semester\n" +
                    "1. Spring\n" +
                    "2. Summer\n" +
                    "3. Fall", 1, 3);
            switch (choice) {
                case 1:
                    return "Spring";
                case 2:
                    return "Summer";
                case 3:
                    return "Fall";
            }
        }
    }

    public String getCourseName() {
        while (true) {
            int choice = getInt("Choice Course\n" +
                    "1. Java\n" +
                    "2. C\n" +
                    "3. C++", 1, 3);
            switch (choice) {
                case 1:
                    return "Java";
                case 2:
                    return ".Net";
                case 3:
                    return "C/C++";
            }
        }
    }

    



    

    // public String getID(ArrayList<Candidate> candidateList){
    // return String.valueOf(candidateList.size()+1);
    // }
}
