import java.util.Scanner;
import java.util.Stack;

/**************************************************************
 *      VPS -> 스택 문제
 *      ===============
 *      스택에 무엇을 넣을까? -> '(' 와 ')' 둘 다 넣는건 비효율적
 *      스택에는 '(' 저장하고 ')'가 나오면 pop 하기.
 *      단, 둘의 수가 다르다면 VPS 아님
 ***************************************************************/
public class Baek9012 {

    static String[] word;
    static Stack<String> stack;
    static boolean check;       // VPS 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();         // 테스트 데이터 개수

        // 테스트 데이터 갯수만큼 반복
        for(int i=0; i<num; i++) {
            word = sc.next().split("");     // 한글자씩 자르기
            stack = new Stack<>();
            check = true;

            for(int j=0; j<word.length; j++) {
                switch (word[j]) {
                    case "(":
                        stack.push("(");
                        break;
                    case ")":
                        // 스택이 비어있다면 개수가 맞지 않는 것
                        if(stack.empty()) {
                            check = false;
                        } else {
                            stack.pop();
                        }
                        break;
                }
            }

            // "(" 와 ")" 개수 일치하는지 확인
            if(check == true && stack.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
