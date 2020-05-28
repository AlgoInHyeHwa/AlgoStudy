import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        char c = 'A';
        for(int i = 0; i < 26; i++, c++)
            map.put(String.valueOf(c), i + 1);
        
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int n = msg.length();
        for(int i = 0; i < n; i++){
            sb.append(msg.charAt(i));
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), map.size() + 1);
                sb.setLength(sb.length() - 1);
                ans.append(map.get(sb.toString()) + ",");
                sb.setLength(0);
                i--;
            }
        }
        if(sb.length() > 0)
            ans.append(map.get(sb.toString()) + ",");
        
        String[] str = ans.toString().split(",");
        int[] answer = new int[str.length];
        int i = 0;
        for(String s : str)
            answer[i++] = Integer.parseInt(s);
        
        return answer;
    }
}