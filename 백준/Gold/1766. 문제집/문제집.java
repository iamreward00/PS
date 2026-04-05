import java.util.*;
import java.io.*;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static ArrayList<Integer>[] list;
    static int deg[];
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        deg = new int[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            deg[b]++;
            list[a].add(b);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i<=n; i++){
            if(deg[i]==0){
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur +" ");

            for(int i : list[cur]){
                deg[i]--;
                if(deg[i]==0){
                    pq.add(i);
                }
            }

        }
        System.out.println(sb);



    }
}

/*




*/