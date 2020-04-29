import java.util.Scanner;
import java.util.Stack;

public class Baek10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();       // 스택 선언
        int num = sc.nextInt();                     // 명령 갯수

        for(int i = 0; i < num; i++) {
            String order = sc.next();

            // 다섯가지 명령에 대해 분리
            switch (order) {
                case "push":
                    stack.push(sc.nextInt());
                    break;

                case "pop":
                    if(stack.empty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stack.pop());
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if(stack.empty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;

                case "top":
                    if(stack.empty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}
