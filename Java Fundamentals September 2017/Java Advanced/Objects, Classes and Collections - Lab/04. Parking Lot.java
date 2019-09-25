import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> cars = new HashSet<>();
        String line = scanner.nextLine();
        while (!line.equals("END")){
            String[] inputParams = line.split(", ");
            if (inputParams[0].equals("IN")){
                cars.add(inputParams[1]);
            }
            else {
                if (cars.contains(inputParams[1])) {
                    cars.remove(inputParams[1]);
                }
            }
            line = scanner.nextLine();
        }
        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}