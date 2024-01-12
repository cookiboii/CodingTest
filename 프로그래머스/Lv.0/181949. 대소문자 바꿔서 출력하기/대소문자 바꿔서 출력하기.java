import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char tmp;
        String output ="";
        for(int i = 0; i<a.length();i++){
            tmp = a.charAt(i);
          if((65<=tmp)&&(90>=tmp)){
              output += a.valueOf(tmp).toLowerCase();
          }else if((97<=tmp)&&(tmp<=122)){
              output +=a.valueOf(tmp).toUpperCase();
          }else{
              output+=(char)tmp;
          }
            
        }
        System.out.println(output); 
    }
   
    }