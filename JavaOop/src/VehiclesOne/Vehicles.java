package VehiclesOne;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double currentConsumption = distance * fuelConsumption;
        if (currentConsumption > getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        } else {
            setFuelQuantity(getFuelQuantity() - currentConsumption);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
        }
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}