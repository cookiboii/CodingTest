class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries) {
            int n = query[0];
            int m = query[1];
            
            // Swap the elements at index n and m
            int tmp = arr[n];
            arr[n] = arr[m];
            arr[m] = tmp;
        }
        
        return arr;  // Swaps are done, return the modified array
    }
}
