package HomeWork2;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(" Shomookh Alharbi ", 1);
        Student student2 = new Student("Ahmed Saad ", 2);
        Student student3 = new Student(" Jedia Aharbi", 3);

        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);

        Student retrievedStudent = studentManager.getStudentById(1);
        System.out.println("Retrieved Student by ID: " + retrievedStudent.getName());

        System.out.println("  All students:");
        for (Student student : studentManager.getAllStudents()) {
            System.out.println(student.getName());
        }

        boolean removed = studentManager.removeStudentById(1);
        if (removed) {
            System.out.println(" removed successfully");
        } else {
            System.out.println("Student not found");
        }

        System.out.println("All students after removal:");
        for (Student student : studentManager.getAllStudents()) {
            System.out.println(student.getName());
        }
    }
}
