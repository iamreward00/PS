import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int dijk(int st, int ed){
		int cnt = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		boolean[] vis = new boolean[222222];
		int[] minD = new int[222222];
		Arrays.fill(minD, 199999999);
		minD[st] = 0;
		
		pq.add(new int[] { st, minD[st]});
		
		while(!pq.isEmpty()){
			
			int[] cur = pq.poll();
			int a= cur[0];
			int p = cur[1];
			if(a == ed){
				cnt = p;
				break;
			}
			if(vis[a])continue;
			
			vis[a] = true;
			
			int[][] temp = { {a*2,0}, {a +1,1}, {a-1,1}};
			for(int[] i : temp){
				int aa = i[0];
				int pp = i[1];
				if(aa < 0 || aa > 202020) continue;
				if(vis[aa]) continue;
				if(minD[aa] > p + pp){
					minD[aa] = p + pp;
					pq.add(new int[] {aa,minD[aa]});
				}
			}
		}


		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println(dijk(N,M));


		
	}
}

