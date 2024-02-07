class Solution {
    public int solution(int n) {

 int answer = 0;
        int len = 1;
        int num = n;

        // n을 3진법으로 변환했을 때의 자릿수 계산
        while(num / 3 > 0){
            num /= 3;
            len++;
        }

        // 3진법을 10진법으로 변환
        num = n;
        for(int i = 1; i <= len; i++){
            answer += (num % 3) * Math.pow(3, len - i);
            num /= 3;
        }

        return answer;
    } 
    }