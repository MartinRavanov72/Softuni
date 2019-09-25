package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        List<CTrafficLight> trafficLightList = new ArrayList<>();
        String[] input = scanner.readLine().split("\\s+");
        for (String inp : input) {
            TrafficLight currentLight = TrafficLight.valueOf(inp);
            CTrafficLight trafficLight = new CTrafficLight(currentLight);
            trafficLightList.add(trafficLight);
        }
        int n = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (CTrafficLight cTrafficLight : trafficLightList) {
                sb.append(cTrafficLight.next()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}