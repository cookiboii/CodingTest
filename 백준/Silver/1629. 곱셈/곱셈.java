



import java.util.*;



public class Main {

    public static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      Long A = sc.nextLong();
      Long B = sc.nextLong();
       C = sc.nextLong();

        System.out.println(power(A,B));

     sc.close();



    }

    public static long power(long A, long exponent) {

        if (exponent == 1) {
            return A%C;
        }
        long result = power(A, exponent / 2);
        if (exponent % 2 == 1) {
           return (result * result%C)*A%C;
        }
       return result*result%C;
    }


}


