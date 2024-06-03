import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // BFS를 위한 큐와 방문한 노드를 저장할 집합을 초기화합니다.
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // 큐에 시작 노드 (x, 연산 횟수 0)를 추가합니다.
        queue.offer(new int[]{x, 0});
        visited.add(x);

        // BFS 탐색을 시작합니다.
        while (!queue.isEmpty()) {
            // 큐에서 현재 노드를 꺼냅니다.
            int[] current = queue.poll();
            int currentValue = current[0];
            int currentSteps = current[1];

            // 현재 값이 목표 값(y)와 같으면 연산 횟수를 반환합니다.
            if (currentValue == y) {
                return currentSteps;
            }

            // 다음 가능한 세 가지 연산을 수행합니다.
            int[] nextValues = new int[]{currentValue + n, currentValue * 2, currentValue * 3};

            for (int nextValue : nextValues) {
                // 연산 결과가 y보다 작거나 같고, 아직 방문하지 않은 경우에만 큐에 추가합니다.
                if (nextValue <= y && !visited.contains(nextValue)) {
                    queue.offer(new int[]{nextValue, currentSteps + 1});
                    visited.add(nextValue);
                }
            }
        }

        // 큐를 모두 탐색했는데 y에 도달하지 못한 경우 -1을 반환합니다.
        return -1;
    }
}
