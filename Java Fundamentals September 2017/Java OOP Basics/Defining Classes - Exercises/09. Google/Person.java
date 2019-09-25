package a_DefiningClassesEx;

import java.util.LinkedList;

public class Person {
    private String name;
    private Car car;
    private Company company;
    private LinkedList<Parent> parents;
    private LinkedList<Children> children;
    private LinkedList<Pokemon> pokemons;

    Person (String name){
        this.name = name;
        this.car = new Car("","");
        this.company = new Company("","");
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
        this.pokemons = new LinkedList<>();
    }

    public void updateProperty (Object property) {
        String objectType = (property.getClass() + "").split("\\.")[1];
        switch (objectType) {
            case "Company":
                this.company = (Company) property;
                break;
            case "Car":
                this.car = (Car) property;
                break;
            default:
                break;
        }
    }

    public void addProperty (Object property) {
        String objectType = (property.getClass() + "").split("\\.")[1];
        switch (objectType) {
            case "Pokemon":
                this.pokemons.add((Pokemon) property);
                break;
            case "Parent":
                this.parents.add((Parent) property);
                break;
            case "Children":
                this.children.add((Children) property);
                break;
            default:
                break;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.name).append("\n");
        result.append(this.company.toString()).append("\n");
        result.append(this.car.toString()).append("\n");
        result.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            result.append(pokemon.toString());
        }
        result.append("Parents:").append("\n");
        for (Parent parent : parents) {
            result.append(parent.toString());
        }
        result.append("Children:").append("\n");
        for (Children child : children) {
            result.append(child.toString());
        }
        return result.toString();
    }
}
