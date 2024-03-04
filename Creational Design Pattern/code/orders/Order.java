package orders;

import items.shakes.Shake;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Shake> shakes;

    public Order() {
        shakes = new ArrayList<Shake>();
    }

    public void addShake(Shake shake) {
        shakes.add(shake);
    }

    public double totalCost() {
        double cost = 0.0;
        for (Shake shake : shakes) {
            cost += shake.totalPrice();
        }
        return cost;
    }

    public int itemCount() {
        return shakes.size();
    }

    public void showOrder() {
        System.out.println("Your Order:");
        for (Shake shake : shakes) {
            shake.showInfo();
        }
        System.out.println("Total Bill: " + totalCost() + "Tk");
    }
}
