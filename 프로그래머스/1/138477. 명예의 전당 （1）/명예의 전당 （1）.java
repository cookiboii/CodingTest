import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int [score.length];
        
        List<Integer> showList = new ArrayList();
        for(int i =0; i<score.length;i++){
            if(i<k){
                showList.add(score[i]);
                
            }
            else{
                if(score[i]>=showList.get(0)){
                    showList.remove(0);
                    showList.add(score[i]);
                }
            }
            Collections.sort(showList);
            answer[i] = showList.get(0);
        }
        
        return answer;
    }
}