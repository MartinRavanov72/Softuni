package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> lakeParams = Arrays.stream(scanner.readLine().split("[ ,]+")).filter(x -> !x.isEmpty()).map(Integer::parseInt).collect(Collectors.toList());
        String str = scanner.readLine();
        Lake lake = new Lake(lakeParams);
        List<Integer> list = new ArrayList<>();
        lake.forEach(e -> list.add(Integer.parseInt(e + "")));
        System.out.println(Arrays.toString(list.toArray()).replaceAll("[\\]\\[]", ""));
    }
}