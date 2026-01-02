package Session13.xuatsac2;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagement {
    static ArrayList<Contact> contactsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("============== MENU ==============");
            System.out.println("1. Them lien lac");
            System.out.println("2. Xoa lien lac theo so dien thoai");
            System.out.println("3. Tim kiem lien lac");
            System.out.println("4. Hien thi danh ba");
            System.out.println("0. Thoat");
            System.out.println("==================================");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addContact(sc);
                    break;
                case 2:
                    removeContact(sc);
                    break;
                case 3:
                    searchContact(sc);
                    break;
                case 4:
                    displayContacts();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap lua chon phu hop.");
            }
        } while (true);
    }

    public static void addContact(Scanner sc) {
        Contact contact = new Contact();
        contact.inputData(sc, contactsList);
        contactsList.add(contact);
        System.out.println("Them lien lac thanh cong.");
    }

    public static void displayContacts() {
        if (contactsList.isEmpty()) {
            System.out.println("Chua co lien lac.");
        } else {
            for (Contact contact : contactsList) {
                System.out.println(contact);
            }
        }
    }

    public static int checkPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().contains(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

    public static void removeContact(Scanner sc) {
        if (contactsList.isEmpty()) {
            System.out.println("Chua co lien lac.");
        } else {
            displayContacts();
            System.out.print("Nhap so dien thoai can xoa: ");
            String phoneNumber = sc.nextLine();
            int indexDelete = checkPhoneNumber(phoneNumber);
            if (indexDelete == -1) {
                System.out.println("Khong tim thay lien lac");
            } else {
                contactsList.remove(indexDelete);
                System.out.println("Xoa thanh cong");
            }
        }
    }

    public static void searchContact(Scanner sc) {
        if (contactsList.isEmpty()) {
            System.out.println("Chua co lien lac.");
        } else {
            System.out.print("Nhap so dien thoai can tim: ");
            String findPhoneNumber = sc.nextLine();
            boolean isFound = false;
            for (int i = 0; i < contactsList.size(); i++) {
                if (contactsList.get(i).getPhoneNumber().equals(findPhoneNumber)) {
                    System.out.println(contactsList.get(i));
                    isFound = true;
                }
            }
            if (!isFound) {
                System.out.println("Khong tim thay lien lac");
            }
        }
    }
}
