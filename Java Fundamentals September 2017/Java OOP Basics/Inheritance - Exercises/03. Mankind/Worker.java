package a_DefiningClassesEx;

import java.text.DecimalFormat;

public class Worker extends Human {

    private int weekSalary;
    private int workHoursDaily;

    public Worker(String firstName, String lastName, int weekSalary, int workHoursDaily) {
        super(firstName, lastName);
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        if (workHoursDaily < 1 || workHoursDaily > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.weekSalary = weekSalary;
        this.workHoursDaily = workHoursDaily;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return super.toString()
                + "Week Salary: " + df.format(this.weekSalary)
                + System.lineSeparator()
                + "Hours per day: " + df.format(this.workHoursDaily)
                + System.lineSeparator()
                + "Salary per hour: " + df.format((this.weekSalary / (double)7) / this.workHoursDaily);
    }
}
