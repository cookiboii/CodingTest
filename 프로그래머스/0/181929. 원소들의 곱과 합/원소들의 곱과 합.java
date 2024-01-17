class Solution {
    public int solution(int[] num_list) {
        
        int sum =0;
        int product =1;
        int answer = 0;
          for(int i =0; i<num_list.length;i++){
              sum+=num_list[i] ;
              product*=num_list[i];
          }
        
        sum  = sum *sum;
        if(sum > product){
            answer =1;
        }
         else{
             answer =0;
         }
      
        return answer;
    }
}