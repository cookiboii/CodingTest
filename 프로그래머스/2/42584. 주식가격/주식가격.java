import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        
        Queue <Integer> q = new LinkedList<>();
        for(int i : prices){
            
            q.offer(i);  //큐에 데이터 삽입
        }
        int index =0;
        while(!q.isEmpty()){
             int currPrice = q.poll();
            
            for (int i =(prices.length - q.size()) ;i<prices.length;i++ ){
                if( currPrice >prices[i]){
                    answer[index]++;
                    break;
                }
                if(currPrice <= prices[i]){
                    
                    answer[index]++;
                }
            }
            index++;
            
        }
        
        return answer;
    }
}