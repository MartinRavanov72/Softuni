import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if(Arrays.asList(citizenInterfaces).contains(Person.class)){
            Method[] fields = Person.class.getDeclaredMethods();
            System.out.println(fields.length);
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            Person person = new Citizen(name,age);
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }
}