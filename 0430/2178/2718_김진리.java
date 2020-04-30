import java.util.*;


class xy{ //xy좌표 저장 클래스
	int x;
	int y;
	
	public xy(int x,int y) {
		this.x= x;
		this.y =y;
	}
}

public class Main {
	static int node[][]; // 2차원 미로 배열
	static int check[][]; // 2차원 방문여부 배열
	static int cnt =1; // 시작점인 (1,1)은 카운트된 상태로 시작하기 때문에 1로 초기화
	static int n,m;
	
	
	public static void bfs(int a,int b) { //BFS메소드
		Queue<xy> queue = new LinkedList<>(); // 큐
		a-=1; // 시작점이 1,1로 들어오므로 -1한 상태를 저장해준다.
		b-=1;
		check[a][b]= cnt; // 초기 cnt변수 값을 방문배열에서 시작점에 저장한다.
		
		queue.offer(new xy(a,b)); // 시작점의 객체를 큐에 삽입
		while(!queue.isEmpty()) { // 이제 큐가 공백이 될 때 까지 반복한다.
			int x = queue.peek().x; // 큐에 저장되어 있는 객체에서 x,y좌표를 저장
			int y = queue.peek().y;
			queue.poll(); // 큐에서 peek후 저장한 것이기 때문에 별도이 poll()수행으로 해당 객체 소멸
			
					//아래의 조건문은 DFS게시글에서 사용한 조건문과 동일
                    //다른분들은 별도의 2개 배열로 동,서,남,북을 탐색하는 방법을 사용하는데 
                    //나중에 시간을 내어 분석 해봐야겠다.
					if(y<node[x].length-1&&node[x][y]==1&&node[x][y+1]==1 && check[x][y+1]==0) {
						check[x][y+1]=check[x][y]+1; // 현재 점이 가지고 있는 경로값을 인접한 점의 방문배열에 저장 
						queue.offer(new xy(x,y+1)); // 인접한 점을 큐에 넣어준다.
					//아래는 모두 이와 동일
					}
					 if(x<node.length-1&&node[x][y]==1&&node[x+1][y]==1 && check[x+1][y]==0) {
						check[x+1][y]=check[x][y]+1;
						
						queue.offer(new xy(x+1,y));
						
					}  if(x>0&&node[x][y]==1&&node[x-1][y]==1 && check[x-1][y]==0) {
						check[x-1][y]=check[x][y]+1;
						
						queue.offer(new xy(x-1,y));
						
					}
					 if(y>0&&node[x][y]==1&&node[x][y-1]==1 && check[x][y-1]==0) {
						check[x][y-1]=check[x][y]+1;
						queue.offer(new xy(x,y-1));
						
					}
					 
					
					 
					
				}
			
			
		
		
	}
			
			
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		 n = sc.nextInt();
		 m = sc.nextInt();
		node = new int [n][m];
		check = new int[n][m];
		for(int i=0;i<n;i++) { // 줄단위로 입력이 이루어질 때 값을 저장하는 방식
			String row = sc.next();
			for(int j=0;j<m;j++) {
				
				node[i][j] = row.charAt(j)-'0';
			}
		}
		
		
		
		bfs(1,1); // 시작점 전달
		
		System.out.println(check[n-1][m-1]); // 방문배열의 마지막 원소 즉, 도착지점의 값을 반환하면 
        									// 그것이 최단경로가 된다.
		
		
		
	}
	
}
