import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



/// 백준 16562 친구비
/// https://www.acmicpc.net/problem/16562
public class Main {

    /// 친구비 내야하는데 
    /// 내야할 사람이 너무많다...
    /// 100만원 다 친구비로 빠져나가겠다.. ㅠ^ㅠ
    /// 첫번째줄 N M Money
    /// 총 N 명 M 개의 관계 내 총자산 Money
    /// 친구 다 사귈수있다면 그때 최소비용
    /// 사귈수없으면 Oh no! 출력
    /// 이거 탐색한번할때마다 그때의 최소값 리턴하고
    /// 이거 반복하면될거같은데?
    /// 유니온 파인드라던가~ 분리된 집합~ 이라던가~ 섬개수 라던가~ 그런문제같네요
    

    static boolean dbg = false; /// 디버깅용

    static int N,M,money;
    static int[] arr;
    static ArrayList<Integer>[] list;
    static boolean[] vis;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int bfs(int idx){
        int min = arr[idx];
        Queue<Integer>queue = new LinkedList<>();
        
        queue.add(idx);
        vis[idx] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int i : list[cur]){
                if(vis[i]) continue;
                queue.add(i);
                vis[i] = true;
                if(min > arr[i]){
                    min = arr[i];
                }
            }

        }

        return min;
    }

    public static void main(String[] args) throws Exception{
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        vis = new boolean[N+1];
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int sum = 0;
        for(int i = 1; i <= N; i++){
            if(vis[i]) continue;
            sum += bfs(i);
            
        }
        if(sum <= money) System.out.println(sum);
        else System.out.println("Oh no");
    }
}
