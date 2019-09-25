package b_secondPrinciple;

import b_secondPrinciple.models.Footman;
import b_secondPrinciple.models.King;
import b_secondPrinciple.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        King king = new King(scanner.readLine());
        String[] royalGuardsParams = scanner.readLine().split("\\s+");
        for (String s : royalGuardsParams) {
            king.addRoyalGuards(new RoyalGuard(s, king));
        }
        String[] footmenParams = scanner.readLine().split("\\s+");
        for (String s : footmenParams) {
            king.addFootmen(new Footman(s, king));
        }
        while(true){
            String line = scanner.readLine();
            if (line.equalsIgnoreCase("End")) {
                break;
            }
            if (line.equalsIgnoreCase("Attack King")) {
                king.attacked();
            } else {
                String[] lineParams = line.split("\\s+");
                king.removeRoyal(king.getRoyals().get(lineParams[1]));
            }
        }
    }
}