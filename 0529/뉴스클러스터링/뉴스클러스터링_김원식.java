import java.util.ArrayList;

public class Pb03 {
    static int solution(String str1, String str2) {
        int answer = 0;
        /* 입력값 모두 소문자로 바꾸기 */
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 첫째 입력값 조건에 맞춰 배열에 넣기
        ArrayList<String> arr1 = new ArrayList<>();
        for(int i = 0; i < str1.length() - 1; ++i) {
            /* 두 글자씩 끊기 */
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);

            /* 영문자(소문자)로 된 글자 쌍만 유효 */
            if(('a' <= first && first <= 'z') && ('a' <= second && second <= 'z')) {
                arr1.add(first + "" + second);      // ex) fr, ra, an, nc, ce 형태 추가
            }
        }

        // 둘째 입력값 조건에 맞춰 배열에 넣기
        ArrayList<String> arr2 = new ArrayList<>();
        for(int i = 0; i < str2.length() - 1; ++i) {
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);

            if(('a' <= first && first <= 'z') && ('a' <= second && second <= 'z')) {
                arr2.add(first + "" + second);
            }
        }

        /* arr1, arr2를 이용하여 합집합 교집합 */
//        ArrayList<String> union = new ArrayList<>();
//        ArrayList<String> intersection = new ArrayList<>();
        int intersection = 0;
        int union = 0;

        for(int i = 0; i < arr1.size(); i++) {
            String s1 = arr1.get(i);
            for(int j = 0; j < arr2.size(); j++) {
                String s2 = arr2.get(j);
                if(s1.equals(s2)){
                    arr2.remove(arr2.get(j));
                    intersection++;
                    break;
                }
            }
        }

        union = arr1.size() + arr2.size();

        if(union == 0) {
            answer = 1;
        } else {
            answer = (int)((intersection / (double)union) * 65536);
        }

        return answer;

    }

    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";

        int result = solution(str1, str2);

        System.out.println(result);

    }
}
