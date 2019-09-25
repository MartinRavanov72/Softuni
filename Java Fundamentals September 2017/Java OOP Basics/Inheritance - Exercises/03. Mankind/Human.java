package a_DefiningClassesEx;

public class Human {
    String firstName;
    String lastName;

    public Human(String firstName, String lastName) {
        if (!((int)firstName.charAt(0) >= 65 && (int)firstName.charAt(0) <= 90)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        if (!((int)lastName.charAt(0) >= 65 && (int)lastName.charAt(0) <= 90)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "First Name: " + this.firstName + System.lineSeparator() + "Last Name: " + this.lastName + System.lineSeparator();
    }
}
