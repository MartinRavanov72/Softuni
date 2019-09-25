package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();
        int id = 0;
        while (true) {
            String line = scanner.readLine();
            if ("End".equals(line)) {
                break;
            }
            String[] inputParams = line.split("\\s+");
            switch (inputParams[0]) {
                case "Create":
                    id++;
                    bankAccounts.put(id, new BankAccount());
                    bankAccounts.get(id).setId(id);
                    System.out.println("Account " + bankAccounts.get(id).toString() + " created");
                    break;
                case "Deposit":
                    if (bankAccounts.containsKey(Integer.parseInt(inputParams[1]))) {
                        bankAccounts.get(Integer.parseInt(inputParams[1])).deposit(Double.parseDouble(inputParams[2]));
                        DecimalFormat df = new DecimalFormat("#.##");
                        System.out.printf("Deposited %s to %s%n", df.format(Double.valueOf(inputParams[2])), bankAccounts.get(Integer.parseInt(inputParams[1])).toString());
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.valueOf(inputParams[1]));
                    break;
                case "GetInterest":
                    if (bankAccounts.containsKey(Integer.parseInt(inputParams[1]))) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        System.out.println(df.format(bankAccounts.get(Integer.parseInt(inputParams[1])).getInterest(Integer.valueOf(inputParams[2]))));
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

        }
    }
}
