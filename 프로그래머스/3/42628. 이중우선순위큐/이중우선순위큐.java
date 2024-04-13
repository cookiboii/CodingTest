import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        for (String op : operations) {
            String[] split = op.split(" ");
            String command = split[0];
            int value = Integer.parseInt(split[1]);
            
            switch (command) {
                case "I":
                    maxQueue.offer(value);
                    minQueue.offer(value);
                    break;
                case "D":
                    if (!maxQueue.isEmpty()) {
                        if (value == 1) {
                            int max = maxQueue.poll();
                            minQueue.remove(max);
                        } else if (value == -1) {
                            int min = minQueue.poll();
                            maxQueue.remove(min);
                        }
                    }
                    break;
            }
        }
        
        int[] answer = new int[]{0, 0};
        if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        
        return answer;
    }
}
