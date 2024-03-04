abstract class Employee {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(String name) {
        this.name = name;
    }

    public void lookup(String accountHolder) {
        for (Account account : Bank.accounts) {
            if (account.accountHolder.equals(accountHolder)) {
                System.out.println(accountHolder + "'s current balance is " + account.getBalance() + "$");
                return;
            }
        }
        System.out.println("No account for this user");
    }

    abstract void approveLoan(String accountHolder);

    abstract void changeInterestRate(int accountType, double interestRate);

    abstract void internalFund();
}
