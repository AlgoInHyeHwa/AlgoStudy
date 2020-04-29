import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**************************************************************
 *      스택 수열 문제
 *      ===============
 *      해석 : 스택에 n만큼 push해주면서 + 를 추가해준다. push 도중 찾는 숫자를 만났다면 - 를 추가해준다.
 *
 ***************************************************************/
public class Baek1874 {
    static Stack<Integer> stack;
    static ArrayList arr;               // +,- 값 보관하는 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack = new Stack<>();
        arr = new ArrayList();

        int n = sc.nextInt();
        int[] a = new int[n + 1];       // 0을 사용하지 않기 때문에 + 1 해줌.
        int m = 1;

        for(int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++) {
            stack.push(i);
            arr.add("+");
            while(!stack.empty() && stack.peek() == a[m]) {
                stack.pop();
                arr.add("-");
                m++;
            }
        }

        if (stack.empty()){
            for(int i=0; i<arr.size(); i++) {
                Object s = arr.get(i);
                System.out.println(s);
            }
        } else {
            System.out.println("No");
        }
    }
}
