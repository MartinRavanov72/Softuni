import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().toLowerCase();
        String wordSearched = scanner.nextLine().toLowerCase();
        int cnt = 0;
        int index1 = 0;
        while(index1!= -1){
            index1 = line.indexOf(wordSearched);
            if (index1 != -1) {
                line = line.substring(index1 + 1, line.length());
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}