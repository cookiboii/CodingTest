import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

       PriorityQueue<Integer> pqA  = new PriorityQueue<>(Collections.reverseOrder());  //오름 차순 정렬
         PriorityQueue<Integer> pqB  = new PriorityQueue<>(Collections.reverseOrder());      
      for( int i =0; i<A.length;i++){
          
          pqA.add(A[i]);  //  우선순위 queue 배열 삽입
          pqB.add(B[i]);   // 
      }
       for(int i =0; i<A.length;i++){
              if( pqA.peek()<pqB.peek()){
                    //첫번쨰값끼리 비교하여 b가 더크면 1삽입 후 재거
                  answer+=1;
                  pqA.poll();
                  pqB.poll();
                  
              }
           else{
               pqA.poll();  //그헣지않으며 a제거
           }
           
       }
        
        
        return answer;
    }
}