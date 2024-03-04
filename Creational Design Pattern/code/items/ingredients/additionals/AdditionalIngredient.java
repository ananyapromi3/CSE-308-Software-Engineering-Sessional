package items.ingredients.additionals;

import items.ingredients.Ingredient;

public abstract class AdditionalIngredient implements Ingredient {
    protected String ingredientName;

    @Override
    public String ingredientName() {
        return ingredientName;
    }
}
