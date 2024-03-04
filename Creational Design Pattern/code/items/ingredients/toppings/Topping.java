package items.ingredients.toppings;

import items.ingredients.Ingredient;

public abstract class Topping implements Ingredient {
    protected  String toppingName;
    protected double price;

    public double price() {
        return price;
    }

    @Override
    public String ingredientName(){
        return toppingName;
    }
}
