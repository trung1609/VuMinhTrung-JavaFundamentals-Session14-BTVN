package Session14.xuatsac2;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartManagement {
    static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        addData(products);
        ShoppingCart shoppingCartManagement = new ShoppingCart();
        do {
            System.out.println("============ MENU ===========");
            System.out.println("1. Xem danh sach san pham");
            System.out.println("2. Them san pham vao gio hang");
            System.out.println("3. Xoa san pham khoi gio hang");
            System.out.println("4. Xem gio hang");
            System.out.println("5. Thanh toan");
            System.out.println("0. Thoat");
            System.out.println("=============================");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    ShoppingCartManagement.addProductToCart(sc, shoppingCartManagement);
                    break;
                case 3:
                    ShoppingCartManagement.removeProductFromCart(sc, shoppingCartManagement);
                    break;
                case 4:
                    ShoppingCartManagement.displayCart(shoppingCartManagement);
                    break;
                case 5:
                    ShoppingCartManagement.paymentShoppingCart(shoppingCartManagement);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap lua chon phu hop");
            }
        } while (true);
    }

    public static void addData(ArrayList<Product> products) {
        products.add(new Product("P001", "Ao Polo", 10000));
        products.add(new Product("P002", "Ao Phao", 20000));
        products.add(new Product("P003", "Ao Khoac", 15000));
        products.add(new Product("P004", "Quan bo", 50000));

    }

    public static void addProductToCart(Scanner sc, ShoppingCart shoppingCart) {
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s\n", i, products.get(i).getName());
        }

        System.out.print("Chon id san pham can them: ");
        int index = Integer.parseInt(sc.nextLine());
        int quantity;
        do {
            try {
                System.out.print("Nhap so luong can mua: ");
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity <= 0) {
                    System.err.println("Vui long nhap so luong lon hon hoac bang 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Loi: so luong khong hop le. Vui long nhap lai");
            }
        } while (true);

        shoppingCart.addCartItem(products.get(index), quantity);
    }

    public static void removeProductFromCart(Scanner sc, ShoppingCart shoppingCart) throws Exception {
        System.out.print("Nhap ma san pham can xoa: ");
        String productId = sc.nextLine();
        shoppingCart.removeCartItem(productId);
    }

    public static void displayCart(ShoppingCart shoppingCart) {
        shoppingCart.displayCart();
    }

    public static void paymentShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart.checkout();
    }
}
