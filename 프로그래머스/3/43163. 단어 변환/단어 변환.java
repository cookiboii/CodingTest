import java.util.*;

class Solution {
    static boolean[] visited; // 방문한 단어를 체크하기 위한 배열
    static int answer = 0; // 최소 변환 횟수를 저장할 변수
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length]; // 방문한 단어를 체크하기 위한 배열 초기화
        dfs(begin, target, words, 0); // DFS를 이용하여 최소 변환 횟수 구하기
        return answer;
    }
    
    // DFS로 최소 변환 횟수 구하는 함수
    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) { // 시작 단어가 목표 단어와 같을 경우
            answer = cnt; // 최소 변환 횟수를 저장하고 함수 종료
            return;
        }
        
        for (int i = 0; i < words.length; i++) { // 단어 리스트를 순회하면서
            if (visited[i]) { // 이미 방문한 단어인 경우 건너뜀
                continue;
            }
            
            int k = 0;
            for (int j = 0; j < begin.length(); j++) { // 시작 단어와 현재 단어를 비교하여 일치하는 문자 개수 세기
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }
            
            if (k == begin.length() - 1) { // 일치하는 문자가 하나 빼고 모두 같은 경우
                visited[i] = true; // 현재 단어를 방문했다고 체크하고
                dfs(words[i], target, words, cnt + 1); // 현재 단어로부터 DFS 호출하여 다음 단계로 진행
                visited[i] = false; // DFS가 종료되면 방문 체크를 해제하여 다음 탐색을 위해 준비
            }
        }
    }
}
