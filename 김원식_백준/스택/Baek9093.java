import java.util.Scanner;
import java.util.Stack;

/* 단어 뒤집기 */
public class chap02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            Stack st = new Stack();
            String s = sc.next();

            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == ' '){
                    while(!st.empty())
                        System.out.print(st.pop());
                    System.out.print(" ");
                } else
                    st.add(s.charAt(j));
            }

            while(!st.empty())
                System.out.print(st.pop());
            System.out.println();
        }
    }
}
