public class ManagingDirector extends Employee {
    public ManagingDirector(String name) {
        super(name);
    }

    @Override
    void approveLoan(String accountHolder) {
        for (Account account : Bank.accounts) {
            if (account.accountHolder.equals(accountHolder)) {
                if (account.getLoanStatus() == 0) {
                    account.setLoanStatus(1);
//                    Bank.fund -= account.loan;
                    System.out.println("Loan for " + accountHolder + " approved");
                    return;
                } else {
                    System.out.println("No pending loan for this user");
                }
            }
        }
        System.out.println("No account for this user");
    }

    @Override
    void changeInterestRate(int accountType, double interestRate) {
        if (accountType == 2) {
            StudentAccount.interestRate = interestRate;
            System.out.println("Interest Rate changed to " + interestRate + " for student account");
        } else if (accountType == 1) {
            SavingsAccount.interestRate = interestRate;
            System.out.println("Interest Rate changed to " + interestRate + " for savings account");
        } else {
            FixedDepositAccount.interestRate = interestRate;
            System.out.println("Interest Rate changed to " + interestRate + " for fixed deposit account");
        }
    }

    @Override
    void internalFund() {
        double temp = Bank.fund;
        for (Account account : Bank.accounts) {
            int n = Main.currentYear - account.creationYear;
            temp -= account.balance * account.getInterestRate() * n;
            temp += account.loan * 0.1 * n * account.loanStatus;
        }
        System.out.println("Internal fund: " + temp + "$");
    }
}
