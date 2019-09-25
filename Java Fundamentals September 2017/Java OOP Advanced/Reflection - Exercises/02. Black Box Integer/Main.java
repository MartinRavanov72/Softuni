package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Class blackBoxIntClass = BlackBoxInt.class;
        Constructor constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();
        while (true) {
            String[] inputParams = scanner.readLine().split("_");
            if ("END".equalsIgnoreCase(inputParams[0])) {
                break;
            }
            Method method = blackBoxIntClass.getDeclaredMethod(inputParams[0], int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, Integer.parseInt(inputParams[1]));
            Field field = blackBoxIntClass.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));
        }
	}
}
