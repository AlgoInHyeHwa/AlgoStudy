import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> multi1 = new ArrayList<>();
        ArrayList<String> multi2 = new ArrayList<>();
        for(int i = 0; i < str1.length() - 1; ++i){
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);
            if('A' <= a && a <= 'Z' && 'A' <= b && b <= 'Z')
                multi1.add(a + "" + b);
        }
        
        for(int i = 0; i < str2.length() - 1; ++i){
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);
            if('A' <= a && a <= 'Z' && 'A' <= b && b <= 'Z')
                multi2.add(a + "" + b);
        }
        
        Collections.sort(multi1);
        Collections.sort(multi2);
        
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        for(String s : multi1){
            if(multi2.remove(s))
                intersection.add(s);
            union.add(s);
        }
        
        for(String s : multi2)
            union.add(s);
        
        double answer = 0;
        if(union.size() == 0)
            answer = 1;
        else
            answer = (double)intersection.size() / (double)union.size();
        
        return (int)(answer*65536);
    }
}