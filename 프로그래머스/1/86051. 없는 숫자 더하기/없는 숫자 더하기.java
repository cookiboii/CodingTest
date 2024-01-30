public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        // Create an array to track which numbers are present
        boolean[] present = new boolean[10];

        // Mark the numbers present in the input array
        for (int num : numbers) {
            present[num] = true;
        }

        // Sum the missing numbers
        for (int i = 0; i < 10; i++) {
            if (!present[i]) {
                answer += i;
            }
        }

        return answer;
    }


}