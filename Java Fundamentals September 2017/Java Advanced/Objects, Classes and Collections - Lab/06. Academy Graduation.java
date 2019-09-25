import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Double> students = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            String[] lineParams = scanner.nextLine().split(" ");
            ArrayList<Double> grades = new ArrayList<>();
            for (int j = 0; j < lineParams.length; j++) {
                grades.add(Double.parseDouble(lineParams[j]));
            }
            double averageGrade = 0.0;
            for (double grade : grades) {
                averageGrade += grade;
            }
            averageGrade = averageGrade / grades.size();
            students.put(studentName, averageGrade);
        }
        for (Map.Entry<String, Double> value : students.entrySet()) {
            System.out.println(value.getKey()+ " is graduated with " + value.getValue());
        }
    }
}