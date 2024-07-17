class Solution {
    public int solution(String binomial) {
          int answer = 0;
        String[] bin = binomial.split(" ");
        int a = Integer.parseInt(bin[0]);
        String op = bin[1];
        int b = Integer.parseInt(bin[2]);
        
        if(op.equals("+")) {
            answer = a + b;
        } else if (op.equals("-")) {
            answer = a - b;
        } else if(op.equals("*")) {
            answer = a * b;
        }
        
        return answer;
    }
}