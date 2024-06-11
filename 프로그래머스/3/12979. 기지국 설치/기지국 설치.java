class Solution {
    public int solution(int N, int[] stations, int W) {
        int answer = 0; // 추가로 설치해야 할 기지국의 수
        int current = 1; // 현재 전파가 도달하지 않는 첫 아파트의 위치
        int index = 0; // stations 배열의 인덱스
        int range = 2 * W + 1; // 한 기지국이 커버할 수 있는 아파트의 범위
        
        while (current <= N) {
            if (index < stations.length && stations[index] - W <= current) {
                // 현재 기지국이 커버하는 범위 내에 있다면
                current = stations[index] + W + 1; // 해당 기지국의 커버 범위 끝 다음 아파트로 이동
                index++; // 다음 기지국으로 이동
            } else {
                // 현재 기지국이 커버하는 범위 밖에 있다면
                answer++; // 새로운 기지국을 추가
                current += range; // 새로운 기지국의 커버 범위 끝 다음 아파트로 이동
            }
        }
  
        return answer; // 추가로 설치해야 할 기지국의 수 반환
    }
}
