package Model;

public class Account {

    private String name;
    private String accountID;
    private String balance;
    private String loan;
    //private String pin;

    public Account(String name, String accountID, String balance, String loan) {
        this.name = name;
        this.accountID = accountID;
        this.balance = balance;
        this.loan = loan;
        //this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    /*public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }*/


}
