import java.util.*;

class Solution {
    // Solution 클래스의 멤버 함수로서, 요금을 계산하여 반환하는 메서드
    public int[] solution(int[] fees, String[] records) {
        // 주차 요금 요소 추출
        int stdTime = fees[0]; // 기본 시간(분)
        int stdFee = fees[1]; // 기본 요금(원)
        int addTime = fees[2]; // 추가 시간(분)
        int addFee = fees[3]; // 추가 요금(원)

        // 입차 기록을 저장할 해시맵 생성
        HashMap<String, Integer> input = new HashMap<>();
        // 출차 기록을 저장할 해시맵 생성
        HashMap<String, Integer> out = new HashMap<>();

        // 모든 주차 기록을 반복하여 처리
        for (int i = 0; i < records.length; i++) {
            String[] temp = records[i].split(" "); // 공백을 기준으로 문자열을 분할하여 배열에 저장
            int m = time(temp[0]); // 시간을 분 단위로 변환하여 저장

            // 입차 기록일 경우
            if (temp[2].equals("IN")) {
                input.put(temp[1], m); // 차량번호와 입차 시간을 저장
            }
            // 출차 기록일 경우
            else {
                int diff = m - input.get(temp[1]); // 주차 시간 계산
                input.remove(temp[1]); // 입차 기록 삭제
                out.put(temp[1], out.getOrDefault(temp[1], 0) + diff); // 출차 기록 저장
            }
        }

        int end = time("23:59"); // 하루 종료 시간(23:59)을 분 단위로 변환

        // 주차장에 남아있는 차량에 대한 처리
        for (String time : input.keySet()) {
            int diff = end - input.get(time); // 주차 시간 계산
            out.put(time, out.getOrDefault(time, 0) + diff); // 출차 기록에 추가
        }

        // 차량 번호를 오름차순으로 정렬하기 위한 리스트 생성
        ArrayList<String> numbers = new ArrayList<>();
        for (String num : out.keySet()) {
            numbers.add(num);
        }
        Collections.sort(numbers); // 차량 번호를 오름차순으로 정렬

        // 결과 배열 생성
        int[] answer = new int[numbers.size()];

        // 모든 차량에 대한 주차 요금 계산
        for (int i = 0; i < numbers.size(); i++) {
            int cur = out.get(numbers.get(i)); // 해당 차량의 주차 시간
            int fee = 0; // 주차 요금 초기화

            // 기본 시간을 초과한 경우
            if (cur > stdTime) {
                cur -= stdTime; // 초과한 시간 계산
                double t = Math.ceil((double) cur / addTime); // 추가 요금 계산
                fee = (int) t * addFee; // 총 주차 요금 계산
            }
            // 기본 시간 내에 주차한 경우
            answer[i] = stdFee + fee; // 기본 요금과 추가 요금 합산하여 결과 배열에 저장
        }
        return answer; // 결과 배열 반환
    }

    // 시간 문자열을 분 단위로 변환하는 메서드
    public static int time(String timestamp) {
        int hours = Integer.parseInt(timestamp.split(":")[0]) * 60; // 시간을 분 단위로 변환
        int minute = Integer.parseInt(timestamp.split(":")[1]); // 분을 분 단위로 변환
        return hours + minute; // 시간과 분을 합쳐서 반환
    }
}
