package Session14.gioi2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNumberManagement {
    public static void validatePhoneNumber(String phone)
            throws InvalidPhoneNumberLengthException, InvalidPhoneNumberCharacterException {
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("So dien thoai phai dung 10 chu so");
        }
        String regex = "\\d{10}";
        if (!Pattern.matches(regex, phone)) {
            throw new InvalidPhoneNumberCharacterException("Chua ky tu khong hop le");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap cac so dien thoai (cach nhau boi dau phay): ");
        String input = sc.nextLine();
        String[] phoneNumbers = input.split(",");
        List<String> validPhone = new ArrayList<>();
        List<String> invalidPhone = new ArrayList<>();
        for (String phone : phoneNumbers) {
            phone = phone.trim();
            try {
                validatePhoneNumber(phone);
                validPhone.add(phone);
            }catch (Exception e) {
                invalidPhone.add(phone + " : " + e.getMessage());
            }
        }
        System.out.println("So dien thoai hop le:");
        for (String p : validPhone) {
            System.out.println(p);
        }

        System.out.println("So dien thoai khong hop le:");
        for (String p : invalidPhone) {
            System.out.println(p);
        }
    }
}
