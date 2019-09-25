package a_DefiningClassesEx;

import java.util.LinkedList;

public class Trainer {
    private String name;
    private int numberOfBadges;
    LinkedList<Pokemon> pokemonCollection;

    protected Trainer (String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonCollection = new LinkedList<>();
    }

    public void addPokemon (Pokemon pokemon) {
        this.pokemonCollection.add(pokemon);
    }

    public boolean checkForElement (String element) {
        for (int i = 0; i < this.pokemonCollection.size(); i++) {
            if (pokemonCollection.get(i).getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void addBadge(){
        this.numberOfBadges++;
    }

    public void increaseHealth(){
        LinkedList<Integer> pokemonsForRemoval = new LinkedList<>();
        for (int i = 0; i < pokemonCollection.size(); i++) {
            if (pokemonCollection.get(i).getHealth() - 10 <= 0) {
                pokemonsForRemoval.add(i);
            }
            else {
                pokemonCollection.get(i).decreaseHealth();
            }
        }
        this.removePokemons(pokemonsForRemoval);
    }

    private void removePokemons (LinkedList<Integer> pokemonIndexes) {
        for (int i = pokemonIndexes.size()-1; i >= 0; i--) {
            pokemonCollection.remove((int)pokemonIndexes.get(i));
        }
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    @Override
    public String toString() {
        return this.name + " " + this.numberOfBadges + " " + this.pokemonCollection.size();
    }

}
