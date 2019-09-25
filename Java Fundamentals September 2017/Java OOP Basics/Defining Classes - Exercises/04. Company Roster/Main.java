package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        HashMap<String, List<Employee>> departments = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.readLine().split("\\s+");
            if (inputParams.length == 4) {
                Employee employee = new Employee(inputParams[0], Double.parseDouble(inputParams[1]), inputParams[2], inputParams[3]);
                if (!departments.containsKey(inputParams[3])) {
                    departments.put(inputParams[3], new ArrayList<>());
                }
                departments.get(inputParams[3]).add(employee);
            }
            else if (inputParams.length == 5) {
                boolean isEmail = false;
                try{
                    double num = Double.parseDouble(inputParams[4]);
                }
                catch (Exception e){
                    isEmail = true;
                }
                if (isEmail) {
                    Employee employee = new Employee(inputParams[0], Double.parseDouble(inputParams[1]), inputParams[2], inputParams[3], inputParams[4]);
                    if (!departments.containsKey(inputParams[3])) {
                        departments.put(inputParams[3], new ArrayList<>());
                    }
                    departments.get(inputParams[3]).add(employee);
                }
                else {
                    Employee employee = new Employee(inputParams[0], Double.parseDouble(inputParams[1]), inputParams[2], inputParams[3], Integer.parseInt(inputParams[4]));
                    if (!departments.containsKey(inputParams[3])) {
                        departments.put(inputParams[3], new ArrayList<>());
                    }
                    departments.get(inputParams[3]).add(employee);
                }
            }
            else {
                Employee employee = new Employee(inputParams[0], Double.parseDouble(inputParams[1]), inputParams[2], inputParams[3], inputParams[4], Integer.parseInt(inputParams[5]));
                if (!departments.containsKey(inputParams[3])) {
                    departments.put(inputParams[3], new ArrayList<>());
                }
                departments.get(inputParams[3]).add(employee);
            }
        }
        List<Map.Entry<String, List<Employee>>> list = new ArrayList<>(departments.entrySet());
        Comparator<Map.Entry<String, List<Employee>>> comp = (x, y) -> Double.compare(y.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                x.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble());
        Collections.sort(list, comp);
        for (Map.Entry<String, List<Employee>> kvp : list.stream().limit(1).collect(Collectors.toList())) {
            System.out.println("Highest Average Salary: " + kvp.getKey());
            List<Employee> list1 = new ArrayList<>(kvp.getValue());
            Comparator<Employee> comp1 = (x, y) -> Double.compare(y.getSalary(), x.getSalary());
            Collections.sort(list1, comp1);
            for (Employee employee : list1) {
                System.out.printf("%s %.2f %s %d", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
                System.out.println();
            }
        }
    }
}
