 class Solution {
    public int solution(int hp) {
        int answer = 0;
        int generals = hp / 5;  // 장군개미의 수 계산
        int soldiers = (hp % 5) / 3; 
        // 병정개미의 수 계산
        int workers = (hp % 5) % 3; 
        int ants = generals + soldiers+workers;  // 총 개미 수 계산
        return ants;

   }  
}
