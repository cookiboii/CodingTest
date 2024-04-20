import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 올바른 PriorityQueue 생성
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        while (n > 0) {
            int work = pq.poll();
            if (work == 0) break; // 더이상 줄일 수 있는 일이 없음
            work -= 1; // 일 한 시간 줄임
            pq.offer(work);
            n -= 1; // 남은 작업 시간 한 시간 줄임
        }
        
        long answer = 0;
        for (int work : pq) {
            answer += (long) work * work;
        }
        
        return answer;
    }
}
