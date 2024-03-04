import java.time.Year;
import java.util.Scanner;

public class Main {
    public static int currentYear = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int role = 0;
        Account account = null;
        Employee employee = null;
        Bank bank = new Bank(currentYear, "MD", "S1", "S2", "C1", "C2", "C3", "C4", "C5");
        while (true) {
            String command = scn.nextLine();
            String commands[] = command.split(" ");
            if (commands[0].equals("Create")) {
                if (commands[2].equals("Student")) {
                    account = new StudentAccount(commands[1], Double.parseDouble(commands[3]), currentYear);
                } else if (commands[2].equals("Savings")) {
                    account = new SavingsAccount(commands[1], Double.parseDouble(commands[3]), currentYear);
                } else if (commands[2].equals("Fixed-deposit")) {
                    account = new FixedDepositAccount(commands[1], Double.parseDouble(commands[3]), currentYear);
                }
                role = 1;
            } else if (commands[0].equals("Open")) {
                if (commands[1].equals(bank.getManagingDirector().getName())) {
                    employee = bank.getManagingDirector();
                    role = 2;
                }
                if (employee == null) {
                    for (Employee officer : bank.getOfficers()) {
                        if (officer.getName().equals(commands[1])) {
                            employee = officer;
                        }
                    }
                    role = 2;
                }
                if (employee == null) {
                    for (Employee cashier : bank.getCashiers()) {
                        if (cashier.getName().equals(commands[1])) {
                            employee = cashier;
                        }
                    }
                    role = 2;
                }
                if (employee == null) {
                    for (Account acc : Bank.accounts) {
                        if (acc.accountHolder.equals(commands[1])) {
                            account = acc;
                            role = 1;
                        }
                    }
                    System.out.println("Welcome back " + account.getAccountHolder());
                }
                if (role == 2) {
                    System.out.println(employee.getName() + " active");
                    for (Account acc : Bank.accounts) {
                        if (acc.getLoanStatus() == 0 && acc.getLoan() > 0) {
                            System.out.println("There are loan approvals pending");
                            break;
                        }
                        System.out.println("There is no loan approval pending");
                    }
                }
            } else if (commands[0].equals("Close")) {
                if (role == 1) {
                    System.out.println("Transaction closed for " + account.getAccountHolder());
                } else if (role == 2) {
                    System.out.println("Operations for " + employee.getName() + " closed");
                }
                role = 0;
                employee = null;
                account = null;
            } else if (commands[0].equals("INC")) {
                currentYear++;
                int n = currentYear - bank.getCreationYear();
                System.out.println(n + " years have passed");
            } else {
                if (role == 0) {
                    System.out.println("Invalid role");
                } else if (role == 1) {
                    if (commands[0].equals("Deposit")) {
                        account.deposit(Integer.parseInt(commands[1]));
                    } else if (commands[0].equals("Withdraw")) {
                        account.withdraw(Integer.parseInt(commands[1]));
                    } else if (commands[0].equals("Query")) {
                        account.queryDeposit();
                    } else if (commands[0].equals("Request")) {
                        account.requestLoan(Integer.parseInt(commands[1]));
                    } else {
                        System.out.println("Invalid command");
                    }
                } else if (role == 2) {
                    if (commands[0].equals("Approve") && commands[1].equals("Loan")) {
                        for (Account acc : Bank.accounts) {
                            if (acc.getLoanStatus() == 0 && acc.getLoan() > 0) {
                                employee.approveLoan(acc.getAccountHolder());
                                break;
                            }
                        }
                    } else if (commands[0].equals("Change")) {
                        int type = 0;
                        if (commands[1].equals("Savings")) {
                            type = 1;
                        } else if (commands[1].equals("Student")) {
                            type = 2;
                        } else if (commands[1].equals("Fixed")) {
                            type = 3;
                        }
                        employee.changeInterestRate(type, Double.parseDouble(commands[2]));
                    } else if (commands[0].equals("Lookup")) {
                        employee.lookup(commands[1]);
                    } else if (commands[0].equals("See")) {
                        employee.internalFund();
                    } else {
                        System.out.println("Invalid command");
                    }
                }
            }
        }
//        }
    }
}