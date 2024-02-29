import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 사람들의 몸무게를 정렬
        
        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스
        int boats = 0; // 필요한 구명보트 개수
        
        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람을 태워서 무게가 limit 이하인지 확인
            if (people[left] + people[right] <= limit) {
                left++; // 가장 가벼운 사람을 태우고 다음으로 넘어감
            }
            right--; // 가장 무거운 사람은 항상 태우므로 다음으로 넘어감
            boats++; // 구명보트를 사용함
        }
        
        return boats;
    }
}
