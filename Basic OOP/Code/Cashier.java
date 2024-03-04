public class Cashier extends Employee {
    public Cashier(String name) {
        super(name);
    }

    @Override
    void approveLoan(String accountHolder) {
        System.out.println("You do not have permission to approve loan");
    }

    @Override
    void changeInterestRate(int accountType, double interestRate) {
        System.out.println("You do not have permission to change interest rate");
    }

    @Override
    void internalFund() {
        System.out.println("You do not have permission to see internal fund");
    }
}
