package items.ingredients.sweet;

import items.ingredients.Ingredient;

public abstract class Sweet implements Ingredient {
    protected String name;

    public String ingredientName() {
        return name;
    }
}
