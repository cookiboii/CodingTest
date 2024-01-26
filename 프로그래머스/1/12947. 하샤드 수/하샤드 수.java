class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String str = String.valueOf(x);

        for (int i = 0; i < str.length(); i++) {
            // Convert each character to its numeric value and add to sum
            sum += Character.getNumericValue(str.charAt(i));
        }

        if (x % sum != 0) {
            answer = false;
        }

        return answer;
    }
}