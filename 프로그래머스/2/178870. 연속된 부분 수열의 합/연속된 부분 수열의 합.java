

class Solution {
    public int[] solution(int[] sequence, int k) {
        // 초기 답은 전체 배열을 포함하는 구간 (0, sequence.length - 1)
        int[] answer = {0, sequence.length - 1};
        // 시작 포인터와 끝 포인터 초기화
        int start = 0;
        int end = 0;
        // 현재 구간의 합 초기화
        int sum = 0;
        // 초기 합은 첫 번째 원소
        sum += sequence[start];

        // 투 포인터 기법을 사용하여 start와 end가 배열의 범위를 벗어나지 않는 동안 반복
        while (start < sequence.length && end < sequence.length) {
            if (sum < k) {
                // 현재 구간의 합이 k보다 작으면 end 포인터를 오른쪽으로 이동
                end++;
                if (end >= sequence.length) break; // end가 배열의 범위를 벗어나면 종료
                sum += sequence[end]; // 새로 포함된 원소를 합에 추가
            } else if (sum > k) {
                // 현재 구간의 합이 k보다 크면 start 포인터를 오른쪽으로 이동
                sum -= sequence[start]; // 구간에서 제외되는 원소를 합에서 빼기
                start++;
            } else {
                // 현재 구간의 합이 k와 같으면
                // 기존의 답 구간보다 짧은 구간이거나, 같은 길이일 경우 더 왼쪽에 있는 구간을 선택
                if (answer[1] - answer[0] > end - start || 
                    (answer[1] - answer[0] == end - start && start < answer[0])) {
                    answer[0] = start; // 시작 인덱스 갱신
                    answer[1] = end;   // 끝 인덱스 갱신
                }
                // start 포인터를 오른쪽으로 이동하여 다음 구간을 탐색
                sum -= sequence[start];
                start++;
            }
        }
        
        return answer; // 최종 구간 반환
    }
}
