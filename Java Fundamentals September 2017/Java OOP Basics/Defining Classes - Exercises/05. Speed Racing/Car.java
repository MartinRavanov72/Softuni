package a_DefiningClassesEx;

import java.text.DecimalFormat;

public class Car {
    private Double fuelAmount;
    private Double distanceTraveled;
    private Double fuelCost;
    private String model;

    Car (String model, Double fuelAmount, Double fuelCost){
        this.fuelAmount = fuelAmount;
        this.distanceTraveled = 0.0;
        this.fuelCost = fuelCost;
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public Double getFuelAmount() {
        return this.fuelAmount;
    }

    public Double getFuelCost() {
        return this.fuelCost;
    }

    public Double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public boolean drive (double kilometers){
        double fuelNeeded = kilometers * this.fuelCost;
        if (this.fuelAmount >= fuelNeeded){
            this.fuelAmount -= fuelNeeded;
            this.distanceTraveled += kilometers;
            return true;
        }
        return false;
    }

    @Override
    public String toString () {
        DecimalFormat df1 = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("#.##");
        return this.model + " " + df1.format(this.fuelAmount) + " " + df2.format(this.distanceTraveled);
    }
}
