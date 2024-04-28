class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] dart = dartResult.split("");
        int[] scores = new int[3];
        int index = -1;

        for (int i = 0; i < dart.length; i++) {
            // 숫자인 경우
            if (dart[i].matches("[0-9]")) {
                index++;
                scores[index] = Integer.parseInt(dart[i]);
                // 10 처리
                if (dart[i + 1].matches("[0-9]")) {
                    scores[index] *= 10;
                    i++;
                }
            }
            // 제곱, 스타상, 아차상 처리
            switch (dart[i]) {
                case "D":
                    scores[index] = (int) Math.pow(scores[index], 2);
                    break;
                case "T":
                    scores[index] = (int) Math.pow(scores[index], 3);
                    break;
                case "*":
                    scores[index] *= 2;
                    if (index - 1 >= 0) {
                        scores[index - 1] *= 2;
                    }
                    break;
                case "#":
                    scores[index] *= -1;
                    break;
            }
        }
        // 최종 점수 계산
        for (int score : scores) {
            answer += score;
        }

        return answer;
    }
}
