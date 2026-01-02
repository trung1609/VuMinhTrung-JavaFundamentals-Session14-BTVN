package Session14.kha1;

public class InvalidNumberException extends RuntimeException{
    public static void validate(int number){
        if(number <= 0){
            throw new IllegalArgumentException("Số không hợp lệ để kiểm tra số nguyên tố.");
        }
    }
}
