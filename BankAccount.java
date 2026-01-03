package Session14.gioi1;

public class BankAccount {
    private String id;
    private double balance;

    public BankAccount(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void withdraw(double amount) {
        this.balance -= amount;
    }
    @Override
    public String toString() {
        return String.format("ID: %s - Balance: %.0f", id, balance);
    }
}
