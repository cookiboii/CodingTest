import java.util.*;



class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int[] dept = Arrays.copyOf(d, d.length);
        Arrays.sort(dept);
        int sum = 0;
        for (int inx=0; inx<dept.length; inx++) {
            sum += dept[inx];
            if (sum<=budget) {
                answer++;
            }
        }
        return answer;
    }
}