import builders.Builder;
import builders.ShakeBuilder;
import director.Director;
import items.shakes.Shake;
import orders.Order;

import java.util.Scanner;

public class Main {
    private static void showMenu() {
        System.out.println("Menu: (Base prices included)");
        System.out.println("1. Chocolate Shake - 250Tk");
        System.out.println("2. Coffee Shake - 230Tk");
        System.out.println("3. Strawberry Shake - 200Tk");
        System.out.println("4. Vanilla Shake - 190Tk");
        System.out.println("5. Zero Shake - 240Tk");
        System.out.println("Enter the number you want to order: (Press 'e' to exit)");
    }

    private static void showToppings() {
        System.out.println("Additional topping available:");
        System.out.println("1. Candy Topping - 50Tk");
        System.out.println("2. Cookies Topping - 40Tk");
        System.out.println("3. None");
        System.out.println("Enter the number you want to add:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order currentOrder = null;
        Director director = new Director();
        System.out.print("Press 'o' to open an order: ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("e")) {
                if (currentOrder != null && currentOrder.itemCount() > 0) {
                    System.out.println("Order closed");
                    currentOrder.showOrder();
                    break;
                } else {
                    System.out.println("You must order at least one item");
                }
            } else if (input.equalsIgnoreCase("o")) {
                if (currentOrder == null) {
                    currentOrder = new Order();
                    System.out.println("To place an order, please see our menu.");
                    showMenu();
                } else {
                    System.out.println("An order already opened. To order, see our menu.");
                    showMenu();
                }
            } else if (currentOrder == null) {
                System.out.println("There is currently no order opened");

            } else {
                int n;
                try {
                    n = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
                if (n < 1 || n > 5) {
                    System.out.println("Invalid Command");
                } else {
                    Builder builder = new ShakeBuilder();
                    if (n == 1) {
                        director.makeChocolateShake(builder);
                    } else if (n == 2) {
                        director.makeCoffeeShake(builder);
                    } else if (n == 3) {
                        director.makeStrawberryShake(builder);
                    } else if (n == 4) {
                        director.makeVanillaShake(builder);
                    } else {
                        director.makeZeroShake(builder);
                    }
                    while (true) {
                        System.out.println("Do you want Lactose-Free? (y/n)");
                        String s2 = scanner.nextLine();
                        if (s2.equalsIgnoreCase("y")) {
                            director.lactoseFree(builder);
                            break;
                        } else if (s2.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.println("Invalid Command");
                        }
                    }
                    while (true) {
                        showToppings();
                        String s3 = scanner.nextLine();
                        int m;
                        try {
                            m = Integer.parseInt(s3);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException(e);
                        }
                        if (m > 3 || m < 1) {
                            System.out.println("Invalid Command");
                        } else {
                            if (m == 1) {
                                director.addCandy(builder);
                            } else if (m == 2) {
                                director.addCookies(builder);
                            }
                            break;
                        }
                    }
                    Shake shake = builder.getShake();
                    currentOrder.addShake(shake);
                    System.out.println("Successfully added to your offer");
                    showMenu();
                }
            }
        }
    }
}
