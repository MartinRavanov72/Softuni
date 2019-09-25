package interfaces;

public class Person<T> implements Comparable<Person>{
    private int age;
    private String name;
    private String town;

    public Person(String name, int age,  String town) {
        this.age = age;
        this.name = name;
        this.town = town;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.compareTo(person.getName()) == 0) {
            if (this.getAge() > person.getAge()) {
                return this.getTown().compareTo(person.getTown());
            }
            return Integer.compare(this.getAge(), person.getAge());
        }
        return this.name.compareTo(person.getName());
    }
}
