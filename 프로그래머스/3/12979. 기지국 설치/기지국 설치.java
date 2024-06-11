class Solution {
    public int solution(int N, int[] stations, int W) {
        int answer = 0;
        int current = 1;
        int index = 0;
        int range = 2 * W + 1;
        
        while (current <= N) {
            if (index < stations.length && stations[index] - W <= current) {
                current = stations[index] + W + 1;
                index++;
            } else {
                answer++;
                current += range;
            }
        }
  
        return answer;
    }
}
