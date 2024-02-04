class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String number : numbers) {
            int value = Integer.parseInt(number);
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        
        answer = min + " " + max;
        return answer;
    }
}
