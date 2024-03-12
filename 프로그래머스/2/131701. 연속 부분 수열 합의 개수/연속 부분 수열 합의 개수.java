import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        Set<Integer> sums = new HashSet<>();
        
        for (int i = 0; i < length; i++) {
            int start = i;
            int currentSum = 0;
            int count = 0;
            
            while (count < length) {
                currentSum += elements[start % length];
                sums.add(currentSum);
                start++;
                count++;
            }
        }
        
        return sums.size();
    }
}

