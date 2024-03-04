public class StudentAccount extends Account {

    public StudentAccount(String accountHolder, double initialDeposit, int creationYear) {
        createAccount(accountHolder, initialDeposit, creationYear, 0.05);
        System.out.println("Student account for " + accountHolder + " Created; initial balance " + initialDeposit + "$");
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
        double actualBalance = (balance + loan * loanStatus) * (1 + interestRate * n) - loan * loanStatus * 0.1 * n;
        return actualBalance;
    }

    @Override
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Error: Withdrawal amount exceeds the deposited sum");
            return;
        }
        if (amount > 10000) {
            System.out.println("A student account cannot withdraw more than 10000$ in one transaction");
            return;
        }
        balance -= amount;
        Bank.fund -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance + "$");
    }

    @Override
    void requestLoan(double amount) {
        if (amount > 1000) {
            System.out.println("The maximum allowable loan for student account is 1000$");
            return;
        }
        this.loan = amount;
        System.out.println("Loan request successful, sent for approval");
    }

    @Override
    protected double getMaxLoanAmount() {
        return 1000;
    }
}
