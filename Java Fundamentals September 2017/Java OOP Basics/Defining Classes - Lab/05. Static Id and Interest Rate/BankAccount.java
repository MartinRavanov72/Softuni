package a_DefiningClassesEx;

import java.text.DecimalFormat;

public class BankAccount {

    private Integer id;
    private double balance = 0;
    private static double rate = 0.02;

    public void setId(int id) {
        this.id = id;
    }

    public static void setInterestRate(double interest) {
        rate = interest;
    }

    public double getInterest(int years) {
        return this.balance * rate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
