class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] count = new int[4001];  // 무게의 범위는 1부터 4000까지이므로 크기를 4001로 설정

        // 주어진 weights 배열에서 각 무게의 빈도를 카운트
        for (int weight : weights) {
            count[weight]++;
        }

        // 중복 없이 weights 배열을 사용하여 계산
        for (int i = 100; i <= 1000; i++) {
            for (int j = i; j <= 4000; j++) {
                // 같은 무게의 경우
                if (i == j) {
                    answer += (long) count[i] * (count[i] - 1) / 2;
                } else {
                    if (i * 2 == j) {
                        answer += (long) count[i] * count[j];
                    }
                    if (i * 3 == j * 2) {
                        answer += (long) count[i] * count[j];
                    }
                    if (i * 4 == j * 3) {
                        answer += (long) count[i] * count[j];
                    }
                }
            }
        }

        return answer;
    }
}
