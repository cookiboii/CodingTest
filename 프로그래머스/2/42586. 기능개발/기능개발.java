import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 각 작업의 배포 일수 계산하여 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int remainProgress = 100 - progresses[i];
            int days = remainProgress / speeds[i];
            if (remainProgress % speeds[i] != 0) {
                days++;
            }
            queue.offer(days);
        }

        int count = 1;
        int prevDay = queue.poll();
        
        // 배포 일수를 이용하여 각 배포마다 몇 개의 기능이 배포되는지 계산
        while (!queue.isEmpty()) {
            int currDay = queue.poll();
            if (prevDay >= currDay) {
                count++;
            } else {
                list.add(count);
                count = 1;
                prevDay = currDay;
            }
        }
        list.add(count);

        // List를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
