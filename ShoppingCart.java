package Session14.xuatsac2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> listCartItems = new ArrayList<CartItem>();

    public List<CartItem> getListCartItems() {
        return listCartItems;
    }

    public void setListCartItems(List<CartItem> listCartItems) {
        listCartItems = listCartItems;
    }

    public void addCartItem(Product product, int quantity) {
        if (getListCartItems().isEmpty()) {
            CartItem cartItem = new CartItem(product, quantity);
            listCartItems.add(cartItem);
        } else {
            boolean isExist = false;
            for (CartItem cartItem : getListCartItems()) {
                if (cartItem.getProduct().getId().equals(product.getId())) {
                    isExist = true;
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                    break;
                }
            }
            if (!isExist) {
                CartItem cartItem = new CartItem(product, quantity);
                listCartItems.add(cartItem);
            }
        }
        System.out.println("Them san pham thanh cong.");
    }

    public void removeCartItem(String productId) throws Exception {
        if (getListCartItems().isEmpty()) {
            System.out.println("Gio hang trong");
            return;
        }
        //foreach lam viec truc tiep tren CartItem -> khong xoa duoc cartItem khi dang dung tai do
        for (int i = 0; i < listCartItems.size(); i++) {
            if (listCartItems.get(i).getProduct().getId().equals(productId)) {
                listCartItems.remove(i);
                return;
            }
        }
        throw new Exception("Loi: Khong tim thay san pham trong gio hang");
    }

    public void displayCart() {
        for (CartItem cartItem : listCartItems) {
            System.out.printf("San pham: %s - So luong: %d\n", cartItem.getProduct(), cartItem.getQuantity());
        }
    }

    public void checkout() {
        double total = 0;
        for (CartItem cartItem : listCartItems) {
            total += cartItem.totalProductPrice();
        }
        System.out.println("Gio hang da duoc thanh toan voi so tien: " + total);
    }
}
