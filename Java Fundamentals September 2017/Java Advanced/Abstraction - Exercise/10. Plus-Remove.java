import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> matrix = new ArrayList<>();
        List<List<String>> matrix2 = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")){
            List<String> row = Arrays.asList(input.split(""));
            matrix.add(row);
            List<String> result2 = row.stream().map(String::toUpperCase).collect(Collectors.toList());
            matrix2.add(result2);
            input = scanner.nextLine();
        }
        for (int i = 0; i < matrix.size()-2; i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if(j > 0 && matrix.get(i+1).size() > j+1 && matrix.get(i+2).size() > j){
                    if(matrix2.get(i).get(j).equals(matrix2.get(i+1).get(j)) && matrix2.get(i).get(j).equals(matrix2.get(i+1).get(j+1))){
                        if(matrix2.get(i).get(j).equals(matrix2.get(i+1).get(j-1)) && matrix2.get(i).get(j).equals(matrix2.get(i+2).get(j))){
                            matrix.get(i).set(j,"");
                            matrix.get(i+1).set(j,"");
                            matrix.get(i+1).set(j+1,"");
                            matrix.get(i+1).set(j-1,"");
                            matrix.get(i+2).set(j,"");
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(matrix.get(i).toArray()).replace("]","").replace("[","").replace(",","").replace(" ",""));
        }
        System.out.println(Arrays.toString(matrix.get(matrix.size()-2).toArray()).replace("]","").replace("[","").replace(",","").replace(" ",""));
        System.out.println(Arrays.toString(matrix.get(matrix.size()-1).toArray()).replace("]","").replace("[","").replace(",","").replace(" ",""));
    }
}
