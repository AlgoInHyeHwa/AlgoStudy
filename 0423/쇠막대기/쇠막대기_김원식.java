import java.util.*;

// 괄호 맞추는 문제 = 스택
// '('가 나왔을때 스택에 쌓고 ') '가 나왔을때 현재 스택 크기만큼 값을 더하기
// '()'가 되었을때 스택사이즈만큼 더하고 '))'인 경우에는 하나의 층이 제거되기 때문에 스택에서 하나를 빼주고 값에 1을 더함. 
class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<arrangement.length(); i++){
            char c = arrangement.charAt(i);
            if(c==')'){
                stack.pop();
                if(arrangement.charAt(i-1) == '(')
                    answer += stack.size();
                else
                    answer++;
            }else{
                stack.push(c);
            }
        }
        return answer;
    }
}
