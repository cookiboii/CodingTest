import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;  // Initialize count variable
       Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                count++;
            }
        }

        if (count == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[count];
        int index = 0;

        // Fill the answer array with elements meeting the criteria
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[index++] = arr[i];
            }
        }

        return answer;
    }
}

