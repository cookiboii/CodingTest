class Solution {
    public int[] solution(int[] arr) {
        // Check if the array is empty or has only one element
        if (arr == null || arr.length <= 1) {
            return new int[]{-1};
        }

        // Find the minimum value in the array
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        // Create a new array without the minimum value
        int[] result = new int[arr.length - 1];
        
        // Copy elements before the minimum value
        for (int i = 0; i < minIndex; i++) {
            result[i] = arr[i];
        }

        // Copy elements after the minimum value
        for (int i = minIndex; i < arr.length - 1; i++) {
            result[i] = arr[i + 1];
        }

        return result;
    }
}
