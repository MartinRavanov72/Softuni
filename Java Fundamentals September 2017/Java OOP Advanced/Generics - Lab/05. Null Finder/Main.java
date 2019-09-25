package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        list.add("Vanio Painera");
        list.add("Niki Suplexa");
        list.add("Nikos");
        list.add(null);
        list.add(null);
        System.out.println(ListUtils.getMax(list));
        System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getNullIndices(list));
    }
}