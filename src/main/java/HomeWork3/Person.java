package HomeWork3;
public class Person extends PersonRecord {
    private String name;
    private int age;

    public Person(String name, int age, String address) {
        super(name, age, address);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
                throw new IllegalArgumentException(" Age must be between 0 and 150");
        }
        this.age = age;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Address: " + getAddress();
    }

    @Override
    public String getDetails() {
        return toString();
    }

    public static void main(String[] args) {
        Person person1 = new Person(" Shomookh", 24, " Al Qassim");
        Person person2 = new Person("Rifal", 18, " Riyadh");
        System.out.println(person1);
        // Try person with an invalid age
        try {
            person2.setAge(-55);
            System.out.println(person2.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println( person1.details(person1));
        System.out.println( person1.details(person2));

    }
    public String details(Person p){
        return p.getDetails();
    }




}

