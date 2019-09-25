package a_DefiningClassesEx;

import java.text.DecimalFormat;

public class Company {
    private String name;
    private String department;

    Company (String name , String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");
        if (this.name.equals("")){
            return "Company:";
        }
        result.append("Company:").append("\n").append(this.name).append(" ").append(df.format(Double.parseDouble(this.department)));
        return result.toString();
    }
}
