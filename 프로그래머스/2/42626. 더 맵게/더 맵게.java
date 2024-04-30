import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 우선순위 큐에 스코빌 지수 저장
        for (int s : scoville) {
            pq.offer(s);
        }
        
        // 가장 작은 스코빌 지수가 K 이상이 될 때까지 반복
        while (pq.peek() < K) {
            // 스코빌 지수를 K 이상으로 만들 수 없는 경우
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            // 가장 작은 두 개의 스코빌 지수를 꺼내서 섞음
            int first = pq.poll();
            int second = pq.poll();
            int mixed = first + (second * 2);
            pq.offer(mixed);
            answer++;
        } 
        
        return answer;
    }
}
