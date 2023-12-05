#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    
    for(int i = 0; i<numbers.size(); i++){
        
         answer.push_back(numbers[i]*2); // 넘버즈 배열값의 2배들을 push_back해서 넣어준다
    }
         
       
 
    
    return answer;
}