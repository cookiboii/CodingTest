
import java.io.*;
import java.util.*;

public class Main {

    public static long fact(long n) {
        if (n <= 1)
            return 1;


        return n * fact(n - 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fact(n));
    }
}