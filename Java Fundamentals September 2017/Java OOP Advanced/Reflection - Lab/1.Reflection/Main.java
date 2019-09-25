import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Class reflectionClass = Reflection.class;
        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());
        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Reflection reflection = (Reflection) reflectionClass.newInstance();
        System.out.println(reflection);
    }
}