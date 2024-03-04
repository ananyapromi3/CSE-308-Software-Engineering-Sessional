public class Officer extends Employee {
    public Officer(String name) {
        super(name);
    }

//    @Override
//    void lookup(String accountHolder) {
//
//    }

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
        System.out.println("You do not have permission to change interest rate");
    }

    @Override
    void internalFund() {
        System.out.println("You do not have permission to see internal fund");
    }
}
