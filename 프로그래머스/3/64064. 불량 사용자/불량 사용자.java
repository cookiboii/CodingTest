import java.util.*;

class Solution {
    
    String [] userIds;
    String [] bannedIds;
    boolean[] visited;
    HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
         userIds = user_id;
        bannedIds = banned_id;
        visited = new boolean[userIds.length];
        dfs(new HashSet<>(),0);
        return result.size();
    }
    
    void dfs (HashSet<String>set ,int depth){  //dfs 사용해보자 
        if(depth == bannedIds.length){
            result.add(new HashSet<>(set));
            
            return ;
        }
        
        for( int i =0; i<userIds.length;i++){
            if(visited[i]){
                continue;
            }
            if(check(userIds[i],bannedIds[depth])){
                visited[i] =true;
                set.add(userIds[i]);
                dfs(set,depth+1);
                set.remove(userIds[i]);
                visited[i] =false;
            }
            
        }
    }
    boolean check(String userId, String bannedId){
        if(userId.length()!= bannedId.length()){
            return false;
        }
         for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
}