package items.shakes;

import items.ingredients.additionals.AdditionalIngredient;
import items.ingredients.milk.AlmondMilk;
import items.ingredients.milk.Milk;
import items.ingredients.milk.RegularMilk;
import items.ingredients.sweet.Sweet;
import items.ingredients.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Shake {
    private String name;
    private ShakeType shakeType;
    private List<Topping> toppings;
    private Milk milk;
    private Sweet sweet;
    private List<AdditionalIngredient> additionalIngredients;
    private double basePrice;

    public Shake(String name, ShakeType shakeType, List<Topping> toppings, Milk milk, Sweet sweet, List<AdditionalIngredient> additionalIngredients, double basePrice) {
        this.name = name;
        this.shakeType = shakeType;
        this.toppings = toppings;
        this.milk = milk;
        this.sweet = sweet;
        this.additionalIngredients = additionalIngredients;
        this.basePrice = basePrice;
    }

    public void makeLactoseFree() {
        milk = new AlmondMilk();
    }

    public void sweetType(Sweet sweet) {
        this.sweet = sweet;
    }

    public void addAdditionalIngredients(AdditionalIngredient additionalIngredient) {
        additionalIngredients.add(additionalIngredient);
    }

    public void addToppings(Topping topping) {
        toppings.add(topping);
    }

    public double totalPrice() {
        double price = basePrice;
        for (Topping topping : toppings) {
            price += topping.price();
        }
        price += milk.extraPrice();
        return price;
    }

    public void showInfo() {
        System.out.println(name + "\t Base Price: " + basePrice + "Tk");
        if (toppings.size() > 0) {
            System.out.println("Adding:");
            for (Topping topping : toppings) {
                System.out.println(topping.ingredientName() + "\t Price: " + topping.price() + "Tk");
            }
        }
        if (!milk.isLactosePresent()) {
            System.out.println("Additional " + milk.extraPrice() + "Tk added to make Lactose-Free");
        }
        System.out.println("Total Price: " + totalPrice() + "Tk");
    }
}
