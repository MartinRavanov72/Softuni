package a_DefiningClassesEx;

import java.text.DecimalFormat;

public class BankAccount {

    private Integer id;
    private Double balance = 0.0;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(Double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(Double amount) {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
        }
        else {
            System.out.println("Insufficient balance");
        }
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Account ID" + this.id + ", balance " + df.format(this.balance);
    }
}
