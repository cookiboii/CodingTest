import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double lg2 = Math.log10(2);

        if (n % 2 != 0) {
            n -= 1;
        }

        System.out.println((int)(n * lg2));
    }
}
