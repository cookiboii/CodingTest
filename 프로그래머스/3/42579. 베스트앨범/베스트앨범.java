import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장할 맵
        Map<String, Integer> gp = new HashMap<>();
        // 장르별 노래 목록을 저장할 맵
        Map<String, List<int[]>> gs = new HashMap<>();

        // 각 노래 정보를 맵에 저장
        for (int i = 0; i < genres.length; i++) {
            gp.put(genres[i], gp.getOrDefault(genres[i], 0) + plays[i]);
            gs.putIfAbsent(genres[i], new ArrayList<>());
            gs.get(genres[i]).add(new int[]{i, plays[i]});
        }

        // 장르별로 노래 목록을 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬
        for (List<int[]> songList : gs.values()) {
            songList.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);
        }

        // 장르를 총 재생 횟수에 따라 내림차순으로 정렬
        List<String> sortedGenres = new ArrayList<>(gp.keySet());
        sortedGenres.sort((a, b) -> gp.get(b) - gp.get(a));

        // 결과 리스트에 장르별로 최대 두 곡씩 추가
        List<Integer> answer = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songList = gs.get(genre);
            for (int i = 0; i < Math.min(2, songList.size()); i++) {
                answer.add(songList.get(i)[0]);
            }
        }

        // 결과 리스트를 배열로 변환하여 반환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
