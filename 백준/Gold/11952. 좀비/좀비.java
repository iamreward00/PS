import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
boj.ma/11952
좀비
*/
public class Main {

    static int n,m,k,s;
    static int p,q;

    static HashSet<Integer> zombie;
    static ArrayList<Integer>[] list;

    static HashSet<Integer> weehum;


    static long dijk(){

        long[] minD = new long[n+1];
        Arrays.fill(minD, 1L*100000*100000*3);
        minD[1] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        pq.add(new long[] {1,minD[1]});


        boolean[] vis = new boolean[n+1];

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int a = (int) cur[0];
            long w = cur[1];

            if(vis[a]) continue;
            vis[a] = true;

            
            for(int i : list[a]){
                if(zombie.contains(i)) continue;
                int pay = p;
                if(weehum.contains(i)) pay = q;
                
                if(minD[i] > w + pay){
                    minD[i] = (long)w+pay;
                    pq.add(new long[] { i,minD[i]});
                }
            }

        }

        int pay = p;
        if(weehum.contains(n)) pay = q;
        //System.out.println(Arrays.toString(minD));
        return minD[n]- pay;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        zombie = new HashSet<>();
        for(int i = 0; i < k; i++){
            int a = Integer.parseInt(br.readLine());
            zombie.add(a);
        }

        list = new ArrayList[n+1];
        for(int i = 1; i<=n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        weehum = new HashSet<>();
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[] vis = new boolean[n+1];

        for(int i : zombie){
            queue.add(new int[] { i,0});
            vis[i] = true;
        }

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int a = cur[0];
            int cnt = cur[1];

            if(cnt >= s) continue;

            for(int i : list[a]){
                if(zombie.contains(i) || vis[i]) continue;
                queue.add(new int[] { i,cnt+1} );
                vis[i] = true;
            }
        }

        for(int i = 0; i < n; i++){
            if(vis[i]){
                weehum.add(i);
            }
        }

        System.out.println(dijk());
        

    }
}

/*

N개의 도시와 M개의 도로
K개의 도시는 좀비에 의해서 점령

현재 1번 도시에 살고 있으며, 벙커가 있는 가장 안전한 피난처는 N번 도시
각 도시를 이동할 때마다 1박을 해야하고, 1박을 할 때 숙박비를 지불해야 한다.
그 도시가 좀비에게 점령당했다면 숙박이 불가능하다.
좀비에게 점령당한 도시로 부터 S번 이하의 이동으로 이동할 수 있는 모든 도시는 위험한 도시
그 이외의 도시는 안전한 도시로 정의할 때
그 도시가 안전한 도시라면 숙박비가 p원이고, 만약 그 도시가 위험한 도시라면 숙박비는 q원이다. 

좀비가 퍼지나 ?
그건 없네

N, M, K, S
각 값은 도시의 수, 길의 수, 좀비에게 점령당한 도시의 수, 위험한 도시의 범위 를 의미한다

n : 2 ~ 10만
m : 1 ~ 20만
k : 0 ~ n-2
s : 0 ~ 10만
p : 1 ~ 10만
q : 1 ~ 10만 


양방향 이동 가능


우선 위험한 도시인지 체크 해야겠네요 ? 
위험한 도시인지 체크하는거 그냥 BFS 로? 하면 될거같은데 
방문체크 하면서 

그러면 각 도시 숙박 비용이 나오니까 
이거는 뭘까
1~14 가는 다익인가
간선의 비용이 그 노드의 비용으로 대체하면 뭐 안될것도없지
대충 비용이
현재 비용 + q or p  인거네요 
이거가지고 다익 1번돌리면 되네요

이제
1번이랑
N번은 숙박비 x 네 ?
1번은 minD 에서 0 할수이쓴데
마지막꺼는 숙박비 나중에 빼주면될듯


숫자 범위보면
이게
10만 * 10만 나올수있지않을까
어디 long 으로 잡아야할듯 ?


*/