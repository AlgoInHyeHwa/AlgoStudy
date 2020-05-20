public class Pb03 {
    static String solution(String[] reg_list, String new_id){
        String answer = "";
        int N = 0;      // 숫자 부분
        String S = "";   // 소문자 부분

        for(int i = 0; i < reg_list.length; i++) {
            if(new_id.equals(reg_list[i])) {
                for(int j = 0; j < new_id.length(); j++) {
                    if('0' <= new_id.indexOf(j) && new_id.indexOf(j) <= '9') {
                        N += new_id.indexOf(j) - '0';
                        N *= 10;
                    }
                    else {
                        S.concat(new_id.substring(1, new_id.indexOf(j)));       // 문자열 붙이기
                    }
                }
                N /= 10;
                N += 1;
                S.concat(Integer.toString(N));
                new_id = S;

            }
        }

        if(answer.equals(""))
            return new_id;

        return answer;
    }

    public static void main(String[] args){
        /* Case 1 */
        String[] registered_list    = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        String new_id             = "ace15";

        /* Case 2 */
//        String[] registered_list    = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
//        String new_id             = "cow";

        System.out.println(solution(registered_list, new_id));
    }
}
