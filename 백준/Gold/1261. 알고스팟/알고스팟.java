import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N,M;
	static int INF = 1999999999;

	static int dijk(int ed1,int ed2){
		int cnt = 0;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		int[][] minD = new int[N][M];
		for(int i = 0;i <N; i++) Arrays.fill(minD[i], INF);
		
		minD[0][0] = 0;
		pq.add(new int[] { 0,0, minD[0][0]});
		boolean[][] vis = new boolean[N][M];

		while(!pq.isEmpty()){
			int[] cur = pq.poll();

			int idx = cur[0];
			int jdx = cur[1];
			int p = cur[2];
			if(vis[idx][jdx]) continue;
			vis[idx][jdx] = true;
			if(idx==ed1 && jdx == ed2){
				cnt = p;
				break;
			}
			for(int i = 0; i < 4; i++){
				int ni = idx + di[i];
				int nj = jdx + dj[i];
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || vis[ni][nj] ) continue;
				if(minD[ni][nj] > p + map[ni][nj]){
					minD[ni][nj] = p + map[ni][nj];
					pq.add(new int[] { ni,nj,minD[ni][nj]});
				}
			}

		}



		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++){
			String str = br.readLine();
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		System.out.println(dijk(N-1,M-1));


		
	}
}

