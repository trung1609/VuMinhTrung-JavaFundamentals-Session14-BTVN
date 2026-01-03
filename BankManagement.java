package Session14.xuatsac1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankManagement {
    static List<BankAccount> bankAccounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount user1 = new BankAccount("A01", 4000);
        BankAccount user2 = new BankAccount("A02", 5000);
        BankAccount user3 = new BankAccount("A03", 10000);
        BankAccount user4 = new BankAccount("A04", 15000);
        bankAccounts.add(user1);
        bankAccounts.add(user2);
        bankAccounts.add(user3);
        bankAccounts.add(user4);
        do {
            System.out.println("============= MENU =============");
            System.out.println("1. Rut tien");
            System.out.println("2. Chuyen tien");
            System.out.println("3. Gui tien");
            System.out.println("4. Kiem tra so du tai khoan");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    withdrawAccount(sc);
                    break;
                case 2:
                    transferAccount(sc);
                    break;
                case 3:
                    depositAccount(sc);
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap lai lua chon phu hop");
            }
        } while (true);
    }

    public static void withdrawAccount(Scanner sc) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            System.out.println(bankAccounts.get(i));
        }
        System.out.print("Chon tai khoan can rut tien: ");
        String bank_account_id = sc.nextLine();
        int index = checkBankAccount(bank_account_id);
        if (index == -1) {
            System.err.println("Khong tim thay tai khoan.");
        } else {
            bankAccounts.get(index).withdraw(sc);
            System.out.println("Rut tien thanh cong");
        }
    }

    public static int checkBankAccount(String bankAccountId) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getAccountId().equals(bankAccountId)) {
                return i;
            }
        }
        return -1;
    }

    public static void checkBalance() {
        for (int i = 0; i < bankAccounts.size(); i++) {
            System.out.println("So du cua tai khoan " + bankAccounts.get(i).getAccountId() + ": " + bankAccounts.get(i).getBalance());
        }
    }

    public static void depositAccount(Scanner sc) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            System.out.println(bankAccounts.get(i));
        }
        System.out.print("Chon tai khoan can gui tien: ");
        String bank_account_id = sc.nextLine();
        int index = checkBankAccount(bank_account_id);
        if (index == -1) {
            System.err.println("Khong tim thay tai khoan.");
        } else {
            bankAccounts.get(index).deposit(sc);
            System.out.println("Gui tien thanh cong");
        }
    }

    public static void transferAccount(Scanner sc) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            System.out.println(bankAccounts.get(i));
        }
        System.out.print("Chon tai khoan chuyen: ");
        String bank_from = sc.nextLine();
        int index_from = checkBankAccount(bank_from);
        if (index_from == -1) {
            System.err.println("Khong tim thay tai khoan chuyen.");
            return;
        }
        System.out.print("Chon tai khoan nhan: ");
        String bank_to = sc.nextLine();
        int index_to = checkBankAccount(bank_to);
        if (index_to == -1) {
            System.err.println("Khong tim thay tai khoan nhan.");
            return;
        }
        bankAccounts.get(index_from).transfer(bankAccounts.get(index_from), bankAccounts.get(index_to), sc);
        System.out.println("Chuyen tien thanh cong");
    }
}
