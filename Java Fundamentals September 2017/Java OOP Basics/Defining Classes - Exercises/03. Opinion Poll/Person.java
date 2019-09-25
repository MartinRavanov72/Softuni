package a_DefiningClassesEx;

public class Person {
    private String name;
    private int age;

    public Person(){
        this(1);
    }

    public Person(int age){
        this("No name", age);
    }

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}
