package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = scanner.readLine();
            if (line.equals("Beast!")) {
                break;
            }
            String[] animalParams = scanner.readLine().split("\\s+");
            Animal animal;
            try {
                switch (line) {
                    case "Frog":
                        animal = createFrog(animalParams);
                        break;
                    case "Dog":
                        animal = createDog(animalParams);
                        break;
                    case "Cat":
                        animal = createCat(animalParams);
                        break;
                    case "Kitten":
                        animal = createKitten(animalParams);
                        break;
                    case "Tomcat":
                        animal = createTomcat(animalParams);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }
                if (animal != null) {
                    System.out.println(animal);
                    System.out.println(animal.produceSound());
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static Tomcat createTomcat(String[] params) {
        String name = params[0];
        int age = Integer.parseInt(params[1]);
        return new Tomcat(name, age);
    }

    private static Kitten createKitten(String[] params) {
        String name = params[0];
        int age = Integer.parseInt(params[1]);
        return new Kitten(name, age);
    }

    private static Cat createCat(String[] params) {
        String name = params[0];
        int age = Integer.parseInt(params[1]);
        String gender = params[2];
        return new Cat(name, age, gender);
    }

    private static Dog createDog(String[] params) {
        String name = params[0];
        int age = Integer.parseInt(params[1]);
        String gender = params[2];
        return new Dog(name, age, gender);
    }

    private static Frog createFrog(String[] params) {
        String name = params[0];
        int age = Integer.parseInt(params[1]);
        String gender = params[2];
        return new Frog(name, age, gender);
    }
}
