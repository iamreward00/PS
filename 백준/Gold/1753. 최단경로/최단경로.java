import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;


class Edge implements Comparable<Edge>{
	int i, v;
	public Edge(int i, int v) {
		this.i = i;
		this.v = v;
	}
	@Override
	public int compareTo(Edge o) {
		return this.v - o.v;
	}	
}
public class Main{
	static ArrayList<Edge> list[];
	static int dist[]; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] in = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
		int dot = in[0];
        int line= in[1];
		int start = Integer.parseInt(br.readLine());
		
		
		list = new ArrayList[dot+1]; 
		for(int i=1;i<list.length;i++) 
			list[i] = new ArrayList<Edge>();
		for(int i=0;i<line;i++) {            
			String [] tt = br.readLine().split(" ");
	        int a = Integer.parseInt(tt[0]);   
	        int b = Integer.parseInt(tt[1]);  
	        int w = Integer.parseInt(tt[2]);   
	        list[a].add(new Edge(b,w));		
		}
			
		
		dist = new int[dot+1];
		Arrays.fill(dist, Integer.MAX_VALUE); 
		dist[start] = 0; 
		
		dijkstra(start);
		
		for(int i=1;i<dist.length;i++) {
			if(dist[i]== Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
	private static void dijkstra(int s) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(s,0)); 
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			for(Edge next : list[now.i]) {
				if(dist[next.i] > now.v + next.v) {
					dist[next.i] = now.v + next.v;
					pq.add(new Edge(next.i, dist[next.i]));
				}
			}			
		}
	}
}