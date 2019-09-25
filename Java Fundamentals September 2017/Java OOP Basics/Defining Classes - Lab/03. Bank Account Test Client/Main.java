package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String line = scanner.readLine();
            if ("End".equals(line)) {
                break;
            }
            String[] inputParams = line.split("\\s+");
            int id = Integer.parseInt(inputParams[1]);
            switch (inputParams[0]){
                case "Create":
                    if (bankAccounts.containsKey(id)){
                        System.out.println("Account already exists");
                    }
                    else {
                        bankAccounts.put(id, new BankAccount());
                        bankAccounts.get(id).setId(id);
                    }
                    break;
                case "Deposit":
                    if (bankAccounts.containsKey(id)){
                        bankAccounts.get(id).deposit(Double.parseDouble(inputParams[2]));
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Withdraw":
                    if (bankAccounts.containsKey(id)){
                        bankAccounts.get(id).withdraw(Double.parseDouble(inputParams[2]));
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Print":
                    if (bankAccounts.containsKey(id)){
                        System.out.println(bankAccounts.get(id).toString());
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
        }
    }
}
