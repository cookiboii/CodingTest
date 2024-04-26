import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        String[] words = {"A", "E", "I", "O", "U"};

        dfs("", 0, list, words);

        return list.indexOf(word);
    }

    private void dfs(String str, int len, List<String> list, String[] words) {
        list.add(str);
        if (len == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], len + 1, list, words);
        }
    }
}
