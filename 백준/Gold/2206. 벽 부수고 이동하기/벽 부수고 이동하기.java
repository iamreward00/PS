import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++){
			String str = br.readLine();
			for(int j = 0; j< M; j++){
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}

		int ed1 = N-1;
		int ed2 = M-1;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};

		int[][][] vis = new int[N][M][2];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0,0,1});
		vis[0][0][0] = 1;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int idx = cur[0];
			int jdx = cur[1];
			int state = cur[2];
			int cnt = cur[3];
			if(idx==ed1 && jdx == ed2){
				System.out.println(cnt);
				return;
			} 
			for(int i = 0; i < 4; i++){
				int ni = idx + di[i];
				int nj = jdx + dj[i];
				if(ni < 0 || ni >= N || nj < 0 || nj>=M || vis[ni][nj][state] > 0) continue;
				if(map[ni][nj] == 0){
					q.add(new int[] { ni,nj,state,cnt+1});
					vis[ni][nj][state] = cnt+1;
				}
				else{
					if(state == 1) continue;
					q.add(new int[] { ni,nj,1,cnt+1});
					vis[ni][nj][1] = cnt+1;
				}
			}
		}
		
		System.out.println(-1);


	}
}