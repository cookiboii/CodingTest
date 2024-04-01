import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        List<List<Integer>> combinations = generateCombinations(nums);

        for (List<Integer> comb : combinations) {

            int sum = comb.get(0) + comb.get(1) + comb.get(2);

            if (isPrime(sum))
                answer++;
        }

        return answer;
    }

    private List<List<Integer>> generateCombinations(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {

                    List<Integer> comb = new ArrayList<>();
                    comb.add(nums[i]);
                    comb.add(nums[j]);
                    comb.add(nums[k]);
                    combinations.add(comb);
                }
            }
        }

        return combinations;

    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {

                return false;
            }

        }
        return true;
    }

}
