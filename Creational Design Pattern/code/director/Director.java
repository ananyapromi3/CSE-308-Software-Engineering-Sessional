package director;

import builders.Builder;
import items.ingredients.additionals.AdditionalIngredient;
import items.ingredients.additionals.flavoring.Vanilla;
import items.ingredients.additionals.icecream.ChocolateIceCream;
import items.ingredients.additionals.icecream.StrawberryIceCream;
import items.ingredients.additionals.jello.RegularJello;
import items.ingredients.additionals.jello.SugarFreeJello;
import items.ingredients.additionals.syrup.ChocolateSyrup;
import items.ingredients.additionals.syrup.Coffee;
import items.ingredients.additionals.syrup.StrawberrySyrup;
import items.ingredients.milk.AlmondMilk;
import items.ingredients.milk.RegularMilk;
import items.ingredients.sweet.Sugar;
import items.ingredients.sweet.Sweetener;
import items.ingredients.toppings.Candy;
import items.ingredients.toppings.Cookies;
import items.ingredients.toppings.Topping;
import items.shakes.ShakeType;

import java.util.ArrayList;
import java.util.List;

public class Director {
    public void makeChocolateShake(Builder builder) {
        List<AdditionalIngredient> additionalIngredients = new ArrayList<AdditionalIngredient>();
        additionalIngredients.add(new ChocolateSyrup());
        additionalIngredients.add(new ChocolateIceCream());
        builder.setShakeName("Chocolate Shake");
        builder.setShakeType(ShakeType.ChocolateShake);
        builder.setBasePrice(230.0);
        builder.setAdditionalIngredients(additionalIngredients);
        builder.setMilk(new RegularMilk());
        builder.setSweet(new Sugar());
        builder.setToppings(new ArrayList<Topping>());
    }

    public void makeCoffeeShake(Builder builder) {
        List<AdditionalIngredient> additionalIngredients = new ArrayList<AdditionalIngredient>();
        additionalIngredients.add(new Coffee());
        additionalIngredients.add(new RegularJello());
        builder.setShakeName("Coffee Shake");
        builder.setShakeType(ShakeType.CoffeeShake);
        builder.setBasePrice(250.0);
        builder.setAdditionalIngredients(additionalIngredients);
        builder.setMilk(new RegularMilk());
        builder.setSweet(new Sugar());
        builder.setToppings(new ArrayList<Topping>());
    }

    public void makeStrawberryShake(Builder builder) {
        List<AdditionalIngredient> additionalIngredients = new ArrayList<AdditionalIngredient>();
        additionalIngredients.add(new StrawberrySyrup());
        additionalIngredients.add(new StrawberryIceCream());
        builder.setShakeName("Strawberry Shake");
        builder.setShakeType(ShakeType.StrawberryShake);
        builder.setBasePrice(200.0);
        builder.setAdditionalIngredients(additionalIngredients);
        builder.setMilk(new RegularMilk());
        builder.setSweet(new Sugar());
        builder.setToppings(new ArrayList<Topping>());
    }

    public void makeVanillaShake(Builder builder) {
        List<AdditionalIngredient> additionalIngredients = new ArrayList<AdditionalIngredient>();
        additionalIngredients.add(new Vanilla());
        additionalIngredients.add(new RegularJello());
        builder.setShakeName("Vanilla Shake");
        builder.setShakeType(ShakeType.VanillaShake);
        builder.setBasePrice(190.0);
        builder.setAdditionalIngredients(additionalIngredients);
        builder.setMilk(new RegularMilk());
        builder.setSweet(new Sugar());
        builder.setToppings(new ArrayList<Topping>());
    }

    public void makeZeroShake(Builder builder) {
        List<AdditionalIngredient> additionalIngredients = new ArrayList<AdditionalIngredient>();
        additionalIngredients.add(new Vanilla());
        additionalIngredients.add(new SugarFreeJello());
        builder.setShakeName("Zero Shake");
        builder.setShakeType(ShakeType.ZeroShake);
        builder.setBasePrice(240.0);
        builder.setAdditionalIngredients(additionalIngredients);
        builder.setMilk(new RegularMilk());
        builder.setSweet(new Sweetener());
        builder.setToppings(new ArrayList<Topping>());
    }

    public void addCandy(Builder builder) {
        builder.addTopping(new Candy());
    }

    public void addCookies(Builder builder) {
        builder.addTopping(new Cookies());
    }
    public void lactoseFree(Builder builder){
        builder.setMilk(new AlmondMilk());
    }
}
