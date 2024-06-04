package HomeWork3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class School {
    private ArrayList<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void reomveStudent(int id) {
        for (var c : students) {
            if (c.getStudentId() == id) {
                students.remove(c);
                return;
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void sortStudent() {
        Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    public Student findStudentById(int studentId) {
        int left = 0;
        int right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = students.get(mid).getStudentId();
            if (midId == studentId) {
                return students.get(mid);
            } else if (midId < studentId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public void writeStudentsToFile() {
        File file = new File("students.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Created new file: students.txt");
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                return;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getAge() + "," + student.getAddress() + ","
                        + student.getStudentId() + "," + student.getCourse());
                writer.newLine();
            }

            System.out.println("Students written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing students to file: " + e.getMessage());
        }
    }

    public void readStudentsFromFile() {
        File file = new File("students.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    int studentId = Integer.parseInt(parts[3]);
                    String course = parts[4];
                    students.add(new Student(name, age, address, studentId, course));
                }
            }
            System.out.println("Students read from file successfully.");
        } catch (IOException e) {
            System.err.println("Error reading students from file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        School s= new School();
        School school = new School();
        Student student1 = new Student("Shomookh", 24, "Al Qssim", 200, "JAVA");
        Student student2 = new Student("Rifal", 18, "Riyadh", 201, "DATABASE");
        Student student3 = new Student("Sarah", 22, "Al Qssim", 203, "WEB");
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        System.out.println(" All Students : ");
        school.displayAllStudents();

        school.sortStudent();
        System.out.println(" All Students sorted by Name : ");
        school.displayAllStudents();
        school.writeStudentsToFile();
        s.readStudentsFromFile();
        s.displayAllStudents();

        System.out.println(" Removing ID Student 200 ");
        school.reomveStudent(200);
        school.displayAllStudents();
        Student foundSTD = school.findStudentById(201);
        System.out.println(" Student with ID 201 " + foundSTD);



    }


}
