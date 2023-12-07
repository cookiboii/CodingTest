#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    
     int n=nums.size()/2;
     
    sort(nums.begin(),nums.end(),greater<>());// 내림 차순정렬 
   nums.erase(unique(nums.begin(),nums.end()),nums.end()); // 중복된거 지운다
    if (n > nums.size()) {
    answer = nums.size();
} else {
    answer = n;
}  // 
    
    
    return answer;
}