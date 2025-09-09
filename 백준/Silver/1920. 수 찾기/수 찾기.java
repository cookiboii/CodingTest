import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] arr = new int[number];

        for (int i = 0; i < arr.length; i++) {

           arr[i] = sc.nextInt();

        }
      Arrays.sort(arr);




       int m  = sc.nextInt();
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < m; i++) {
           int target = sc.nextInt();
           if(Arrays.binarySearch(arr,target)>=0){
           sb.append(1).append("\n");


            }
           else {
               sb.append(0).append("\n");
               }

       }

     System.out.println(sb);
     }


}
