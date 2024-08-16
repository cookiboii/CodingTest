class Solution {
    public int[] solution(int[] arr) {
        
        int n =1;
        // 초기값을 무조건 1로잡은이유는 2*0
        while (arr.length > n) {
            n *= 2;
        }
        
        int[] answer = new int [n];
        
        for(int i =0; i<arr.length;i++){
            
            answer[i] = arr[i];
        }
        
        
        return answer;
    }
}