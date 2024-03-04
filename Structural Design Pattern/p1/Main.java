import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Passenger passenger = null;
        while (true) {
            String input = scanner.nextLine();
            String[] token = input.split(" ");
            if (token[0].equalsIgnoreCase("login")) {
                if (passenger != null) {
                    System.out.println("Someone already logged in.");
                    continue;
                }
                String str = token[1].replaceAll("[^a-zA-Z]", "");
                if (str.equalsIgnoreCase("imp")) {
                    passenger = new ImposterDecorator(new Crewmate(token[1]));
                } else if (str.equalsIgnoreCase("crew")) {
                    passenger = new Crewmate(token[1]);
                }
                assert passenger != null;
                passenger.login();
            } else if (token[0].equalsIgnoreCase("repair")) {
                assert passenger != null;
                passenger.repair();
            } else if (token[0].equalsIgnoreCase("work")) {
                assert passenger != null;
                passenger.work();
            } else if (token[0].equalsIgnoreCase("logout")) {
                assert passenger != null;
                passenger.logout();
                passenger = null;
            } else {
                break;
            }
        }
    }
}