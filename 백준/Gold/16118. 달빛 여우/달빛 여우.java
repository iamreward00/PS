import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	/// minD 배열 두개 만들어서 서로 비교하면될거같은데 여우꺼하나 늑대꺼하나
	/// 그러면 필요해지는게 여우는 정속도고
	/// 늑대가 2배속, 0.5 배속 인데 이거 그러면 가중치 떠블로 해야할거같은데?
	
	static int N,M;
	static ArrayList<int[]>[] list;
	
	static int[] foxminD;
	static double[][] wolfminD;
	
	
	
	static void foxdijk() {
		boolean[] vis = new boolean[N+1];
		foxminD = new int[N+1];
		Arrays.fill(foxminD, 1999999999);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		foxminD[1] = 0;
		pq.add(new int[] { 1, foxminD[1] } );
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			int w = cur[1];
			
			if(vis[to]) continue;
			vis[to] = true;
			
			for(int[] i : list[to]) {
				int a = i[0];
				int b = i[1];
				if(vis[a]) continue;
				if(foxminD[a] > w + b) {
					foxminD[a] = w + b;
					pq.add(new int[] { a, foxminD[a]});
				}
			}
		}
	}
	
	static void wolfdijk() {
		boolean[][] vis = new boolean[N+1][2];
		wolfminD = new double[N+1][2]; //때는 '느리게' 도착했다고 가정해야 첫 걸음을 '빠르게' 뗄
		for(int i = 0; i <= N; i++){    
            for(int j = 0; j < 2; j++) wolfminD[i][j] = 1999999999;

        }
		
		PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1[1], o2[1]));
		
        wolfminD[1][1] = 0;
		pq.add(new double[] {1, wolfminD[1][1], 1}); /// 1느림 0 빠르게

		
		while(!pq.isEmpty()) {
			double[] cur = pq.poll();
			int to = (int) cur[0];
			double w = cur[1];
            int state = (int) cur[2];

            if(vis[to][state]) continue;
            vis[to][state] = true;

            for(int[] i : list[to]){
                int a = i[0];
                int p = i[1];
                if(state == 1){
                    double next = p/2.0;
                    int nextstate = 0;
                    if(wolfminD[a][nextstate] > w + next){
                        wolfminD[a][nextstate] = w + next;
                        pq.add(new double[] { a, wolfminD[a][nextstate], nextstate});
                    }

                }
                else{
                    double next = p * 2.0;
                    int nextstate = 1;
                    if(wolfminD[a][nextstate] > w + next){
                        wolfminD[a][nextstate] = w + next;
                        pq.add(new double[] { a, wolfminD[a][nextstate], nextstate});
                    }
                }
            }


		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
		}
		
		foxdijk();
		wolfdijk();
		int cnt = 0;
		for(int i = 2; i <= N; i++) {
			double wt = Math.min(wolfminD[i][0], wolfminD[i][1]);
            if(foxminD[i] < wt) cnt ++;
		}
		
		System.out.println(cnt);
		
		
		
	}
	
}