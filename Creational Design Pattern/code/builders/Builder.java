package builders;

import items.ingredients.additionals.AdditionalIngredient;
import items.ingredients.milk.Milk;
import items.ingredients.sweet.Sweet;
import items.ingredients.toppings.Topping;
import items.shakes.Shake;
import items.shakes.ShakeType;

import java.util.List;

public interface Builder {
    public void addTopping(Topping topping);

    public void setShakeName(String shakeName);

    public void setShakeType(ShakeType shakeType);

    public void setBasePrice(double basePrice);

    public void setToppings(List<Topping> toppings);

    public void setMilk(Milk milk);

    public void setSweet(Sweet sweet);

    public void setAdditionalIngredients(List<AdditionalIngredient> additionalIngredients);

    public Shake getShake();
}
