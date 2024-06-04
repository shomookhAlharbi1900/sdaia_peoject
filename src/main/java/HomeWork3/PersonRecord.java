package HomeWork3;

public abstract class PersonRecord {

    private String name ;
    private int age ;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public PersonRecord(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public abstract String getDetails();




}
