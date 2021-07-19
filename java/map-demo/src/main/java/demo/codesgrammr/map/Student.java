package demo.codesgrammr.map;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private int grade;

    public Student(String firstName, String lastName, int age, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
