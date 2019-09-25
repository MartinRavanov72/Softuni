package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Class reflectionClass = Reflection.class;
        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get")).sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(method.getName() + " will return " +
                        method.getReturnType()));

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set")).sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(method.getName() + " and will set field of " +
                        method.getParameterTypes()[0]));
    }
}