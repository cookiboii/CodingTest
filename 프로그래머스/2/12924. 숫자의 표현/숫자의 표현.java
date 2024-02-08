class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum =0;
       int  start =0;
        for (int i =start; i<=n;i++){
            sum += i;
            
            if(sum ==n){
                
                answer++;
            }
             while (sum > n) {
                sum -= start;
                start++;
                
                // 다시 합이 n과 같으면 방법의 수를 증가
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}