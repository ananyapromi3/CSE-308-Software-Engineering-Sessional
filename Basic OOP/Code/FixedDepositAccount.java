public class FixedDepositAccount extends Account {
    public FixedDepositAccount(String accountHolder, double initialDeposit, int creationYear) {
        if (initialDeposit < 100000) {
            System.out.println("A fixed deposit account must ensure the first deposit is at least 100000$");
            return;
        }
        createAccount(accountHolder, initialDeposit, creationYear, 0.15);
        System.out.println("Fixed Deposit account for " + accountHolder + " Created; initial balance " + initialDeposit + "$");
    }

    @Override
    public void deposit(double amount) {
        if (amount < 50000) {
            System.out.println("For fixed deposit account, the deposit amount must not be less than 50000$");
            return;
        }
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
        if (Main.currentYear - creationYear < 1) {
            System.out.println("A fixed deposit account cannot withdraw if it has not reached a maturity period of one year");
            return;
        }
        balance -= amount;
        Bank.fund -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance + "$");
    }

    @Override
    void requestLoan(double amount) {
        if (amount > 100000) {
            System.out.println("The maximum allowable loan for fixed deposit account is 100000$");
            return;
        }
        this.loan = amount;
        System.out.println("Loan request successful, sent for approval");
    }

    @Override
    protected double getMaxLoanAmount() {
        return 100000;
    }
}