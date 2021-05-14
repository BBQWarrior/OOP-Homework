package fel_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Process {
    private HashMap<Integer, Student> students = new HashMap<>();

    public Process(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(" ");
                int id = Integer.parseInt(items[0].trim());
                String firstName = items[1].trim();
                String lastName = items[2].trim();
                students.put(id, new Student(id, firstName, lastName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setMath(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(" ");
                int id = Integer.parseInt(items[0].trim());
                double math = Double.parseDouble(items[1].trim());
                students.get(id).setMath(math);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setHuLit(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(" ");
                int id = Integer.parseInt(items[0].trim());
                double huLit = Double.parseDouble(items[1].trim());
                students.get(id).setHuLit(huLit);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setRoLit(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(" ");
                int id = Integer.parseInt(items[0].trim());
                double roLit = Double.parseDouble(items[1].trim());
                students.get(id).setRoLit(roLit);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int numStudentsPassed() {
        int passed = 0;
        for (Map.Entry<Integer, Student> student : students.entrySet()) {
            if (student.getValue().passed()) {
                passed++;
            }
        }
        return passed;
    }

    public void printFailed(PrintStream out) {
        ArrayList<Student> failedStudents = new ArrayList<>();
        for (Map.Entry<Integer, Student> student : students.entrySet()) {
            if (!student.getValue().passed()) {
                failedStudents.add(student.getValue());
            }
        }
        failedStudents.sort(Student::compareTo);
        for (Student student : failedStudents) {
            out.println(student);
        }
    }
}
