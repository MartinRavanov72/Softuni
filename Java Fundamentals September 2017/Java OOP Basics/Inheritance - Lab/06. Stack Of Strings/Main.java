package a_DefiningClassesEx;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StackOfStrings sos = new StackOfStrings();
        sos.push("1");
        sos.push("2");
        sos.push("3");
        System.out.println(sos.peek());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.isEmpty());
    }
}