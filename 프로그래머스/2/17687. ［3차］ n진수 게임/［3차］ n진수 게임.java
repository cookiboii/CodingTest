
import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {       
        StringBuilder convert = new StringBuilder();
    StringBuilder answer = new StringBuilder();
        //convert 의 길이가 미리 구할숫자 개수 * 게임 참가 인원만큼 될떄까지 n진수로 변환
        for(int i=0; convert.length()<=t*m;i++){
            convert.append(Integer.toString(i,n));
        }
        
    for(int i=p-1; answer.length()<t;i+=m){
        answer.append(convert.charAt(i));
    }
  
        
        
        return answer.toString().toUpperCase();
    }
}