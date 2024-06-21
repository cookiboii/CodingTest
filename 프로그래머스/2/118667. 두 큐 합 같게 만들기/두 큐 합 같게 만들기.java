import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long total1 = 0;
        long total2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q1.add(queue1[i]);
            total1 += queue1[i];
        }

        for (int i = 0; i < n; i++) {
            q2.add(queue2[i]);
            total2 += queue2[i];
        }

        int maxOperations = 4 * n;
        for (int i = 0; i < maxOperations; i++) {
            if (total1 == total2) {
                return i;
            }

            if (total1 < total2) {
                int x = q2.poll();
                total1 += x;
                total2 -= x;
                q1.add(x);
            } else {
                int x = q1.poll();
                total2 += x;
                total1 -= x;
                q2.add(x);
            }
        }

        return -1; // If no solution is found within the max operations, return -1
    }
}
