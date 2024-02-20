import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
char[][] map1 = binaryToMap(n, arr1);
        char[][] map2 = binaryToMap(n, arr2);
        
        // 두 개의 지도를 겹쳐서 하나의 지도로 만듦
        char[][] mergedMap = mergeMaps(map1, map2);
        
        // 결과를 문자열로 변환
        for (int i = 0; i < n; i++) {
            result[i] = new String(mergedMap[i]);
        }
        
        return result;
    }
    
    private char[][] binaryToMap(int n, int[] binaryArray) {
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String binaryString = Integer.toBinaryString(binaryArray[i]);
            // 이진수의 길이가 n보다 작으면 앞쪽에 0을 채움
            while (binaryString.length() < n) {
                binaryString = "0" + binaryString;
            }
            map[i] = binaryString.toCharArray();
        }
        return map;
    }

    // 두 개의 이차원 배열을 겹쳐서 하나의 지도로 만드는 메소드
    private char[][] mergeMaps(char[][] map1, char[][] map2) {
        char[][] mergedMap = new char[map1.length][map1[0].length];
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[0].length; j++) {
                if (map1[i][j] == '1' || map2[i][j] == '1') {
                    mergedMap[i][j] = '#';
                } else {
                    mergedMap[i][j] = ' ';
                }
            }
        }
        return mergedMap;
    }
}