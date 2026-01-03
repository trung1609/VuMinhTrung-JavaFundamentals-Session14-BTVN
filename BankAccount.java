package Session14.xuatsac1;

import java.util.Scanner;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(Scanner sc) {
        do {
            try {
                System.out.print("Nhap so tien can gui: ");
                double amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.err.println("Vui long nhap so tien lon hon hoac bang 0");
                    continue;
                }
                this.balance += amount;
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui long nhap lai so tien can gui.");
            }
        } while (true);
    }

    public void withdraw( Scanner sc) {
        do{
            try {
                System.out.print("Nhap so tien can rut: ");
                double amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.err.println("Vui long nhap so tien lon hoac bang 0");
                    continue;
                }
                if(this.balance < amount){
                    System.err.println("So du khong du.");
                    continue;
                }
                this.balance -= amount;
                break;
            }catch (NumberFormatException e) {
                System.err.println("Vui long nhap lai so tien can gui.");
            }
        }while (true);
    }

    public void transfer(BankAccount bankAccountFrom, BankAccount bankAccountTo, Scanner sc) {
        do{
            try {
                System.out.print("Nhap so tien chuyen: ");
                double amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.err.println("Vui long nhap so tien lon hoac bang 0");
                    continue;
                }
                if(bankAccountFrom.getBalance() < amount){
                    System.err.println("So du khong du tai khoan chuyen khong du.");
                    continue;
                }
                bankAccountFrom.setBalance(bankAccountFrom.getBalance() - amount);
                bankAccountTo.setBalance(bankAccountTo.getBalance() + amount);
                break;
            }catch (NumberFormatException e) {
                System.err.println("Vui long nhap lai so tien can chuyen.");
            }
        }while (true);
    }

    @Override
    public String toString() {
        return String.format("AccountId: %s, Balance: %.2f", accountId, balance);
    }
}
