import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] params = scanner.readLine().split(" ");
        ArrayDeque<Integer> stones = new ArrayDeque<>();
        ArrayDeque<Integer> gold = new ArrayDeque<>();
        for (int i = 0; i < params.length; i++) {
            stones.offer(Integer.parseInt(params[i]));
        }
        while(true){
            String[] input = scanner.readLine().split("\\s+");
            if ("Revision".equals(input[0])) {
                break;
            }
            if ("Apply".equals(input[0])) {
                for (int i = 0; i < Integer.parseInt(input[2]); i++) {
                    if (stones.size() > 0) {
                        int temp = stones.peek();
                        if (stones.poll() - 1 > 0) {
                            stones.offer(temp - 1);
                        }
                        else {
                            gold.offer(1);
                        }
                    }
                }
            }
            else {
                if (gold.size() > 0) {
                    stones.offer(Integer.parseInt(input[2]));
                    gold.poll();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stones.size() > 0) {
            sb.append(stones.poll()).append(" ");
        }
        System.out.println(sb.toString());
        System.out.println(gold.size());
    }
}