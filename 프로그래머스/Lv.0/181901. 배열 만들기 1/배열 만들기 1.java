class Solution {
    public int[] solution(int n, int k) {
        
        int cnt= n/k; // 10/3 이면 3
        int[] answer =new int[cnt]; 
        
        for(int i =0;i<cnt;i++){  
            answer[i] = k*(i+1);  //3*1 3*2 3*3
        }
        
       
        return answer;
    }
}