import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // HEAD, NUMBER, TAIL로 분리
                String[] file1 = splitFileName(s1);
                String[] file2 = splitFileName(s2);

                // HEAD 비교 (대소문자 무시)
                int headCompare = file1[0].compareToIgnoreCase(file2[0]);
                if (headCompare != 0) {
                    return headCompare;
                }

                // NUMBER 비교
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);
                if (num1 != num2) {
                    return num1 - num2;
                }

                // HEAD와 NUMBER가 같은 경우, 원래 순서 유지
                return 0;
            }
        });

        return files;
    }

    // 파일명을 HEAD, NUMBER, TAIL로 분리하는 메서드
    private String[] splitFileName(String fileName) {
        String head = "";
        String number = "";
        String tail = "";

        int idx = 0;
        // HEAD 추출
        while (idx < fileName.length() && !Character.isDigit(fileName.charAt(idx))) {
            head += fileName.charAt(idx);
            idx++;
        }
        // NUMBER 추출
        while (idx < fileName.length() && Character.isDigit(fileName.charAt(idx))) {
            number += fileName.charAt(idx);
            idx++;
        }
        // TAIL 추출
        while (idx < fileName.length()) {
            tail += fileName.charAt(idx);
            idx++;
        }

        return new String[]{head, number, tail};
    }
}
