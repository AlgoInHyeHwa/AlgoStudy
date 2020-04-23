class Solution {
    static boolean[][] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
           if(!visited[i][i]){
              dfs(i, n, computers);
              answer++;
}
}


        return answer;
    }
    static void dfs(int start, int n, int[][] computers){
        for(int i=0; i<n; i++){
           if(!visited[start][i] && computers[start][i]==1 ){
               visited[start][i]=visited[i][start]=true;
               dfs(i,n,computers);
           }
}
}
}
