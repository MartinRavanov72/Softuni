package a_DefiningClassesEx;

public class Parent {
    private String name;
    private String birthday;

    Parent (String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString () {
        return this.name + " " + this.birthday + "\n";
    }
}
