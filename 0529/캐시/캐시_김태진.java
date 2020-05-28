import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0)
            return cities.length * 5;
        ArrayList<String> s = new ArrayList<>();
        for(int i = 0; i < cities.length; i++){
            int j;
            cities[i] = cities[i].toLowerCase();
            for(j = 0; j < s.size(); j++){
                if(cities[i].equals(s.get(j))){
                    s.remove(j);
                    s.add(cities[i]);
                    answer++;
                    break;
                }
            }
            if(j == s.size()){
                answer += 5;
                if(s.size() >= cacheSize)
                    s.remove(0);
                s.add(cities[i]);
            }
        }
        return answer;
    }
}