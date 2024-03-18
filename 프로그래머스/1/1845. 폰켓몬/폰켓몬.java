import java.util.*;

class Solution {
    public int solution(int[] nums) {
            int answer=0;
        // 중복을 제거하기 위한 HashSet 선언
        Set<Integer> set = new HashSet<>();

        // 배열을 순회하면서 HashSet에 숫자를 추가합니다.
        for (int i = 0; i < nums.length; i++) {
            // HashSet에 해당 숫자가 없을 때만 추가합니다.
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }

    
        // 만약 중복을 제거한 숫자의 종류가 nums의 절반보다 크다면
        if (set.size() > nums.length / 2) {
            // nums의 길이의 절반을 반환합니다.
            answer = nums.length / 2;
        } else {
            // 아니라면 중복을 제거한 숫자의 종류의 개수를 반환합니다.
            answer = set.size();
        }

        return answer;
    }
}

