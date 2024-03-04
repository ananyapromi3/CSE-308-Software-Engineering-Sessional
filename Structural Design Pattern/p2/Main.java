import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Root root = Root.getInstance("promi@linux-desktop");
        Component currentDirectory = root;
        while (true) {
            System.out.print(currentDirectory.getDirectory() + "$ ");
            String input = scanner.nextLine();
            String[] token = input.split(" ");
            if (token[0].equals("cd")) {
                if (token.length < 2) {
                    System.out.println("Error: Command not appropriate");
                    continue;
                }
                if (token[1].equals("~")) {
                    currentDirectory = root;
                } else {
                    currentDirectory = currentDirectory.changingDirectory(token[1]);
                }
            } else if (token[0].equals("ls")) {
                if (token.length < 2) {
                    System.out.println("Error: Command not appropriate");
                    continue;
                }
                currentDirectory.details(token[1]);
            } else if (token[0].equals("list")) {
                if (token.length != 1) {
                    System.out.println("Error: Command not appropriate");
                    continue;
                }
                currentDirectory.listing();
            } else if (token[0].equals("delete")) {
                if (token.length < 2) {
                    System.out.println("Error: Command not appropriate");
                    continue;
                }
                if (token[1].equals("-r")) {
                    currentDirectory.recursiveDelete(token[2]);
                } else {
                    currentDirectory.delete(token[1]);
                }
            } else if (token[0].equals("mkdir")) {
                if (token.length < 2) {
                    System.out.println("Error: Command not appropriate");
                    continue;
                }
                currentDirectory.makeDir(token[1]);
            } else if (token[0].equals("touch")) {
                if (token.length < 3) {
                    System.out.println("Error: Command not appropriate");
                    continue;
                }
                currentDirectory.touch(token[1], Double.parseDouble(token[2]));
            } else if (token[0].equals("mkdrive")) {
                if (token.length < 2) {
                    System.out.println("Error: Command not appropriate");
                    continue;
                }
                currentDirectory.makeDrive(token[1]);
            } else if (token[0].equals("exit")) {
                if (token.length != 1) {
                    System.out.println("Error: Command not appropriate");
                    continue;
                }
                break;
            } else {
                System.out.println("Error: Unknown command");
            }
        }
    }
}