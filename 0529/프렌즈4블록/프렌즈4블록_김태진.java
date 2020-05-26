import java.util.ArrayList;

class Solution {
    private ArrayList<ArrayList<String>> map = null;
    private ArrayList<ArrayList<Integer>> visited = null;
    public int check(int x, int y){
        String s = map.get(x).get(y);
        if(map.get(x + 1).size() < y + 2)
            return 0;
        if((map.get(x).get(y + 1).equals(s)) && (map.get(x + 1).get(y).equals(s)) && (map.get(x + 1).get(y + 1).equals(s))){
            int sum = 0;
            if(visited.get(x).get(y) == 0){
                sum++;
                visited.get(x).set(y, 1);
            }
            if(visited.get(x + 1).get(y) == 0){
                sum++;
                visited.get(x + 1).set(y, 1);
            }
            
            if(visited.get(x).get(y + 1) == 0){
                sum++;
                visited.get(x).set(y + 1, 1);
            }
            
            if(visited.get(x + 1).get(y + 1) == 0){
                sum++;
                visited.get(x + 1).set(y + 1, 1);
            }
            return sum;
        }
        else
            return 0;
    }
    
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new ArrayList<ArrayList<String>>();
        visited = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            ArrayList<String> temp1 = new ArrayList<String>();
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
            for(int j = m - 1; j > -1; j--){
                temp1.add(Character.toString(board[j].charAt(i)));
                temp2.add(0);
            }
            map.add(temp1);
            visited.add(temp2);
        }
        int cnt;
        do{
            cnt = 0;
            for(int i = 0; i < map.size() - 1; i++){
                for(int j = 0; j < map.get(i).size() - 1; j++)
                    cnt += check(i, j);
            }
            answer += cnt;
            for(int i = 0; i < visited.size(); i++){
                for(int j = visited.get(i).size() - 1; j > -1; j--){
                    if(visited.get(i).get(j) == 1){
                        visited.get(i).set(j, 0);
                        map.get(i).remove(j);
                    }
                }
            }
        }while(cnt != 0);
        return answer;
    }
}