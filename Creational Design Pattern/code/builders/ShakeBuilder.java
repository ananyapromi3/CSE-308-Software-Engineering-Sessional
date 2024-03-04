package builders;

import items.ingredients.Ingredient;
import items.ingredients.additionals.AdditionalIngredient;
import items.ingredients.milk.Milk;
import items.ingredients.sweet.Sweet;
import items.ingredients.toppings.Topping;
import items.shakes.Shake;
import items.shakes.ShakeType;

import java.util.ArrayList;
import java.util.List;

public class ShakeBuilder implements Builder {
    private String shakeName;
    private ShakeType shakeType;
    private double basePrice;
    private List<Topping> toppings;
    private Milk milk;
    private Sweet sweet;
    private List<AdditionalIngredient> additionalIngredients;

    @Override
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public void setShakeName(String shakeName) {
        this.shakeName = shakeName;
    }

    @Override
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    @Override
    public void setSweet(Sweet sweet) {
        this.sweet = sweet;
    }

    @Override

    public void setAdditionalIngredients(List<AdditionalIngredient> additionalIngredients) {
        this.additionalIngredients = additionalIngredients;
    }

    @Override
    public void setShakeType(ShakeType shakeType) {
        this.shakeType = shakeType;
    }

    @Override
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }


    @Override
    public Shake getShake() {
        return new Shake(shakeName, shakeType, toppings, milk, sweet, additionalIngredients, basePrice);
    }
}
