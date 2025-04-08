

import java.io.*;
import java.util.*;

public class Main {

        static long N;
        static long M;
        static long cnt=1;

       public static long  bfs (){

            Queue<Long> q = new ArrayDeque<>();
              q.offer(N);
             while(!q.isEmpty()){
               int size = q.size();
               for(int i = 0; i < size; i++){
                   long tmp = q.poll();
                   if(tmp == M){
                       return cnt;
                   }
                   if(tmp*2 <= M){
                       q.offer(tmp*2);
                   }
                   if(tmp*10+1<=M){
                       q.offer(tmp*10+1);
                   }
               }
               cnt++;

             }


             return  -1;
            }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        System.out.println(bfs());


    }

}
