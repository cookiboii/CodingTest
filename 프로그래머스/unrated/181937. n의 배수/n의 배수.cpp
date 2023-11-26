#include <string>
#include <vector>

using namespace std;

int solution(int num, int n) {
    int answer = 0;
    
    answer=num;
  if(answer%n==0){
      return 1;
}
    else{
         return 0; 
    }
  
    return answer;
}