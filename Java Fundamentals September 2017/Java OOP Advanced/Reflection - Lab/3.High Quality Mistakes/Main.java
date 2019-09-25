package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Class reflectionClass = Reflection.class;
        
        Arrays.stream(reflectionClass.getDeclaredFields())
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.println(field.getName() + " must be private!"));

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(method.getName() + " have to be public!"));

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(method.getName() + " have to be private!"));
    }
}