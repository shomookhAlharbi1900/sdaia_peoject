package HomeWork3;
public class Student extends PersonRecord implements ComparableById  {
    private int studentId;
    private String course;

    public Student(String name, int age, String address, int studentId, String course) {
        super(name, age, address);
        this.studentId = studentId;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }
    public void setStudentId(int studentId) throws IllegalArgumentException{
        if (studentId <= 0) {
            throw new IllegalArgumentException(" Student ID must be a positive integer");
        }
        this.studentId = studentId;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {

        return "Name : "+ getName() +
                ",  Age :  " +getAge() +
                " , Adress :  " + getAddress()+
                " , Student ID:  " + studentId
                + ", Course:  " + course ;
    }

    @Override
    public String getDetails() {
        return toString();
    }

    @Override
    public boolean compareById(int id) {
        if (studentId ==id){
            System.out.println(" StudentId matches the given id ");
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Shomookh", 24, "Al Qssim", 200, "JAVA");
        System.out.println(student1.compareById(200));
        try {
            student1.setStudentId(-300);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}