import java.util.ArrayList;
import java.util.List;

public class Bank {
    static List<Account> accounts = new ArrayList<>();
    protected ManagingDirector managingDirector;
    protected Officer[] officers;
    protected Cashier[] cashiers;
    protected int creationYear;
    static double fund;

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(List<Account> accounts) {
        Bank.accounts = accounts;
    }

    public ManagingDirector getManagingDirector() {
        return managingDirector;
    }

    public void setManagingDirector(ManagingDirector managingDirector) {
        this.managingDirector = managingDirector;
    }

    public Officer[] getOfficers() {
        return officers;
    }

    public void setOfficers(Officer[] officers) {
        this.officers = officers;
    }

    public Cashier[] getCashiers() {
        return cashiers;
    }

    public void setCashiers(Cashier[] cashiers) {
        this.cashiers = cashiers;
    }

    public static double getFund() {
        return fund;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public static void setFund(double fund) {
        Bank.fund = fund;
    }

    public Bank(int year, String MD, String O1, String O2, String C1, String C2, String C3, String C4, String C5) {
        this.creationYear = year;
        this.managingDirector = new ManagingDirector(MD);
        this.officers = new Officer[]{new Officer(O1), new Officer(O2)};
        this.cashiers = new Cashier[]{new Cashier(C1), new Cashier(C2), new Cashier(C3), new Cashier(C4), new Cashier(C5)};
        this.fund = 1000000;
        System.out.println("Bank created; " + MD + ", " + O1 + ", " + O2 + ", " + C1 + ", " + C2 + ", " + C3 + ", " + C4 + ", " + C5 + " created");
    }

    static boolean accountExists(String accountHolder) {
        for (Account account : Bank.accounts) {
            if (account.accountHolder.equals(accountHolder)) {
                return true;
            }
        }
        return false;
    }
}
