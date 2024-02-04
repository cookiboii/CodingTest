import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the dimensions of the rectangle
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Nested loops to print the rectangle
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
