package a_DefiningClassesEx;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        if (firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        } else if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        } else if (age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        } else if (salary < 460.0) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
        }
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " get " + this.salary + " leva";
    }
}
