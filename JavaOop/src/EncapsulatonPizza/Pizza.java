package EncapsulatonPizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.dough = null;
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(this.numberOfToppings);
    }

    private void setName(String name) {
        ValidatorUtil.validatePizzaName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setToppings(int numberOfToppings) {
        ValidatorUtil.validateNumberOfToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() < this.numberOfToppings) {
            this.toppings.add(topping);
        }
    }

    public double getOverallCalories() {
        return this.dough.calculateCalories()
                + this.toppings.stream()
                .mapToDouble(Topping::calculateCalories)
                .sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getOverallCalories());
    }
}