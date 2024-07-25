class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int []aa = new int[included.length];
         aa[0] =a;
        for(int i=1; i<included.length;i++){
           aa[i]  =aa[i-1]+d; 
            
        }
        for(int i= 0;i<included.length;i++){
            if(included[i]){
                answer +=aa[i];
            }
        }
        
        
        return answer;
    }
}