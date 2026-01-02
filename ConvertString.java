package Session14.kha2;

import java.util.ArrayList;
import java.util.Scanner;

public class ConvertString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int countValid = 0;
        int countInvalid = 0;
        do {
            try {
                System.out.print("Nhap chuoi hoac nhap exit de dung nhap chuoi: ");
                String number = sc.nextLine();
                if (number.equals("exit")) break;
                int value = Integer.parseInt(number);
                list.add(value);
                System.out.println("Chuyen doi thanh cong sang so nguyen");
                countValid++;
            } catch (NumberFormatException e) {
                System.out.println("Khong chuyen doi duoc sang so nguyen");
                countInvalid++;
            }
        } while (true);
        System.out.println("So chuoi hop le: " + countValid);
        System.out.println("So chuoi khong hop le: " + countInvalid);
        System.out.print("Danh sach so nguyen hop le: ");
        System.out.println(list);
    }
}
