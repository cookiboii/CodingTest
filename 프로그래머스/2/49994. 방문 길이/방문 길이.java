import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        // 명령어와 좌표 변화량을 저장하는 Map
        Map<String, int[]> map = new HashMap<>();
        map.put("U", new int[] {0, 1});
        map.put("D", new int[] {0, -1});
        map.put("R", new int[] {1, 0});
        map.put("L", new int[] {-1, 0});

        // 입력된 명령어를 배열로 변환
        String[] arr = dirs.split("");

        // 방문한 좌표를 저장하는 Set
        Set<String> set = new HashSet<>();        
        // 현재 캐릭터의 좌표
        int cx = 0;
        int cy = 0;

        // 명령어 배열을 순회하면서 캐릭터의 이동과 방문한 길의 좌표를 처리
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            // 현재 명령어에 따른 좌표 변화량
            int x = map.get(s)[0];
            int y = map.get(s)[1];

            // 캐릭터의 새로운 좌표 계산
            cx += x;
            cy += y;

            // 새로운 좌표가 좌표평면의 경계를 벗어나는지 확인하고 처리
            if (cx < -5 || cx > 5) {
                cx -= x;
                continue;
            }
            if (cy < -5 || cy > 5) {
                cy -= y;
                continue;
            }
            // 캐릭터의 이동으로 생성된 길의 좌표를 Set에 추가
            set.add("" + (cx - x) + "" + (cy - y) + "" + cx + "" + cy);
            set.add("" + cx + "" + cy + "" + (cx - x) + "" + (cy - y));
        } 
        // 방문한 길의 수를 2로 나누어서 캐릭터가 처음 걸어본 길의 수를 반환
        return set.size() / 2;
    }
}
