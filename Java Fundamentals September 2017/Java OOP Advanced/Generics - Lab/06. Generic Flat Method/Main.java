package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3);
        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.3, 2.4, 3.3);
        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, integers, doubles);
        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest, jagged);
        System.out.println(dest);
    }
}