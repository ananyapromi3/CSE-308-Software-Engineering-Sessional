public class SavingsAccount extends Account {

    public SavingsAccount(String accountHolder, double initialDeposit, int creationYear) {
        createAccount(accountHolder, initialDeposit, creationYear, 0.1);
        System.out.println("Savings account for " + accountHolder + " Created; initial balance " + initialDeposit + "$");
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        Bank.fund += amount;
        System.out.println(amount + "$ deposited; current balance " + balance + "$");
    }

    @Override
    double getBalance() {
        int n = Main.currentYear - creationYear;
        double actualBalance = (balance + loan * loanStatus) * (1 + interestRate * n) - n * 500 - loan * loanStatus * 0.1 * n;
        return actualBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Error: Withdrawal amount exceeds the deposited sum");
            return;
        }
        if (balance - amount < 1000) {
            System.out.println("A savings account cannot withdraw if the withdrawal results in a deposit of less than 1000$");
            return;
        }
        balance -= amount;
        Bank.fund -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance + "$");
    }

    @Override
    void requestLoan(double amount) {
        if (amount > 10000) {
            System.out.println("The maximum allowable loan for savings account is 10000$");
            return;
        }
        this.loan = amount;
        System.out.println("Loan request successful, sent for approval");
    }

    @Override
    protected double getMaxLoanAmount() {
        return 10000;
    }
}

