import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        
        
          HashMap<String, Character> map = new HashMap<>();
        map.put(".-", 'a');     map.put("-.", 'n');
        map.put("-...", 'b');   map.put("---", 'o');
        map.put("-.-.", 'c');   map.put(".--.", 'p');
        map.put("-..", 'd');    map.put("--.-", 'q');
        map.put(".", 'e');      map.put(".-.", 'r');
        map.put("..-.", 'f');   map.put("...", 's');
        map.put("--.", 'g');    map.put("-", 't');
        map.put("....", 'h');   map.put("..-", 'u');
        map.put("..", 'i');     map.put("...-", 'v');
        map.put(".---", 'j');   map.put(".--", 'w');
        map.put("-.-", 'k');    map.put("-..-", 'x');
        map.put(".-..",'l');    map.put("-.--", 'y');
        map.put("--",'m');      map.put("--..", 'z');
        
        String[] res = letter.split(" ");
        for (int i=0; i<res.length; i++) {
            if (map.containsKey(res[i]))
                answer+=map.get(res[i]);
        }
        return answer;
    }
}