class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        StringBuilder oddStr = new StringBuilder();  
        StringBuilder evenStr = new StringBuilder();
        
         for (int num : num_list) {
            if (num % 2 == 0) {
                evenStr.append(num);
            } else {
                oddStr.append(num);
            }
        }
        
          int oddSum = Integer.parseInt(oddStr.toString());
        int evenSum = Integer.parseInt(evenStr.toString());
        
        answer = oddSum+evenSum;
        
        return answer;
    }
}