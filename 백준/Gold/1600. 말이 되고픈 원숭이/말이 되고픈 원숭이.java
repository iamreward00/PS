import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K,N,M;
	static int[][][] vis;
	static int[][] map ;

	static int bfs(){
		int ans = -1;

		int[][] jump = {{-2,-1},{-1,-2},{1,2},{2,1},{-2,1},{-1,2},{2,-1},{1,-2}};
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int ei = N-1;
		int ej = M-1;


		vis = new int[N][M][K+1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,0,0}); /// i j jump cnt
		vis[0][0][0] = 0;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int idx = cur[0];
			int jdx = cur[1];
			int jpcnt = cur[2];
			int cnt = cur[3];
			if(idx == ei && jdx == ej){
				ans = cnt;
				break;
			}

			for(int i = 0; i < 8; i++){
				int ni = idx + jump[i][0];
				int nj = jdx + jump[i][1];
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || jpcnt >= K || vis[ni][nj][jpcnt+1] > 0 || map[ni][nj] == 1) continue;
				q.add(new int[] {ni,nj,jpcnt+1,cnt+1});
				vis[ni][nj][jpcnt+1] = cnt+1;
			}
			for(int i = 0; i < 4; i++){
				int ni = idx + di[i];
				int nj = jdx + dj[i];
				if(ni < 0 || ni >= N || nj < 0 || nj >= M ||  vis[ni][nj][jpcnt] > 0 || map[ni][nj] == 1 ) continue;
				q.add(new int[] {ni,nj,jpcnt,cnt+1});
				vis[ni][nj][jpcnt] = cnt+1;
			}
			

		}

		return ans;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}

		System.out.println(bfs());
	}
}