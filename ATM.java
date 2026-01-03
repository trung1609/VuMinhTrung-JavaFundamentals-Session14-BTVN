package Session14.gioi1;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount user1 = new BankAccount("A01", 1000000);
        do {
            try {
                System.out.print("Nhap so tien muon rut: ");
                double amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.err.println("Vui long nhap so tien lon hon hoac bang 0");
                    continue;
                }
                if (user1.getBalance() < amount) {
                    System.err.println("Lỗi: Số tiền rút vượt quá số dư!");
                    continue;
                }
                if (user1.getBalance() - amount < 50000) {
                    System.err.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
                    continue;
                }
                user1.withdraw(amount);
                System.out.println(user1);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Loi: Vui long nhap 1 so hop le!");
            }
        } while (true);
    }
}
