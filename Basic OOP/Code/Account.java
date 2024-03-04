abstract class Account {
    protected String accountHolder;
    protected double balance;
    protected int creationYear;
    protected double loan;
    protected int loanStatus;
    static double interestRate;

    public int getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(int loanStatus) {
        this.loanStatus = loanStatus;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void createAccount(String accountHolder, double initialDeposit, int creationYear, double interestRate) {
        if (Bank.accountExists(accountHolder)) {
            System.out.println("Error: An account already exists for the given account holder");
            return;
        }
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.creationYear = creationYear;
        this.loan = 0;
        this.loanStatus = 0;
        this.interestRate = interestRate;
        Bank.accounts.add(this);
    }

    abstract void deposit(double amount);

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    abstract double getBalance();

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    abstract void withdraw(double amount);

    abstract void requestLoan(double amount);

    public void approveLoan() {
        loanStatus = 1;
        Bank.fund -= loan;
    }

    abstract double getMaxLoanAmount();

    public void queryDeposit() {
        System.out.println("You have a balance of " + getBalance() + "$");
        if (loanStatus == 1) {
            System.out.println("Loan: " + loan + "$");
        }
    }
}
