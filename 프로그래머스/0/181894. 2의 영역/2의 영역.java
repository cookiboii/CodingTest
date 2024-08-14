class Solution {
    public int[] solution(int[] arr) {
        int s = -1;  // 첫 번째 2의 위치
        int e = -1;  // 마지막 2의 위치
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2 && s == -1) {
                s = i;
            } else if (arr[i] == 2) {
                e = i;
            }
        }
        
        if (s == -1) {  // 배열에 2가 없는 경우
            return new int[]{-1};
        } else if (e == -1) {  // 배열에 2가 한 번만 있는 경우
            return new int[]{2};
        }

        // s부터 e까지의 배열 조각을 반환
        int[] answer = new int[e - s + 1];
        int index = 0;
        
        for (int i = s; i <= e; i++) {
            answer[index++] = arr[i];
        }
        
        return answer;
    }
}
