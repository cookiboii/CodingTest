

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         int num  =  Integer.parseInt(br.readLine());
        HashSet<String> set=new HashSet<>();

        for (int i = 0; i <num ; i++) {
            String [] input = br.readLine().split(" ");
            String name = input[0];
            String action = input[1];

             if(action.equals("enter")) {
                 set.add(name);
             }
             else{

                 set.remove(name);

             }

        }

        List<String> list=new ArrayList<>(set);
        Collections.sort(list,Collections.reverseOrder());

        StringBuilder sb=new StringBuilder();
        for(String name:list){
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
