package Session14.kha1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckNumberPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhap 1 so bat ki: ");
            int number = Integer.parseInt(sc.nextLine());
            InvalidNumberException.validate(number);
            if (PrimeService.isPrime(number)) {
                System.out.println("La so nguyen to.");
            } else {
                System.out.println("Khong phai la so nguyen to.");
            }
        } catch (NumberFormatException e) {
            System.out.println("LOI: Vui long nhap so nguyen.");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
