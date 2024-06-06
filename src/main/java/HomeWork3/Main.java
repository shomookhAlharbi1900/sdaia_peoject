package HomeWork3;

public class Main {

    public static void main(String[] args) {
        // Create some Person objects
        Person person1 = new Person("Shomookh", 24, "Al Qassim");
        Person person2 = new Person("Rifal", 18, "Riyadh");

        // Print the person objects
        System.out.println(person1);
        System.out.println(person2);


        // Try setting an invalid age for person2
        try {
            person2.setAge(-55);
            System.out.println(person2.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Get the details of the persons
        System.out.println(person1.getDetails());
        System.out.println(person1.details(person2));

        // Create some Student objects
        Student student1 = new Student("Shomookh", 24, "Al Qssim", 200, "JAVA");
        Student student2 = new Student("Rifal", 18, "Riyadh", 201, "DATABASE");
        Student student3 = new Student("Sarah", 22, "Al Qssim", 203, "WEB");

        // Test the Student class
        System.out.println(student1.compareById(200));
        try {
            student1.setStudentId(-300);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Create a School object and add students
        School school = new School();
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        // Display all students
        System.out.println("\nAll Students:");
        school.displayAllStudents();

        // Sort the students by name
        school.sortStudent();
        System.out.println("\nStudents sorted by name:");
        school.displayAllStudents();

        // Write students to a file
        school.writeStudentsToFile();

        // Read students from the file
        School s = new School();
        s.readStudentsFromFile();
        System.out.println("\nStudents read from file:");
        school.displayAllStudents();
    }









}