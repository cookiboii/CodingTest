#include <string>
#include <vector>
#include<algorithm>  /// 예시에는 없지만  include 추가 적으로 사용하면 문제일까요? cpp뿐만아니라 자바에서도 import 같은거말입니다
using namespace std;

vector<int> solution(vector<int> emergency) {
    vector<int> answer;
     
    vector<int > temp= emergency;
     sort(temp.begin(),temp.end(),greater<>());//내림 차순 정렬 STL 이용해봤습니다
    for(int i =0;i<emergency.size();i++) 
       for(int j =0; j<temp.size();j++)
           if(emergency[i]==temp[j])
               answer.push_back(j+1);
           
    
    return answer;
}