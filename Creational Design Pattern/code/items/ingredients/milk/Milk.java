package items.ingredients.milk;

import items.ingredients.Ingredient;

public abstract class Milk implements Ingredient {
    protected String milkName;
    protected double extraPrice;
    protected boolean lactose;

    public double extraPrice() {
        return extraPrice;
    }

    public boolean isLactosePresent() {
        return lactose;
    }

    @Override
    public String ingredientName() {
        return milkName;
    }
}
