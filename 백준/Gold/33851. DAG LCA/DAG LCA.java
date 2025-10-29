import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     * 21:10 시작
     * 
     * u랑 v가 들어오는데
     * 이거 아니 무슨말이야
     * 
     * u랑 v 가는 모든 정점에 대해
     * u와 v 로가는 두 최단 경로의 길이중
     * 작지않은 값의 최소값
     * 
     * u 랑 v 가는게없으면 -1 출력
     * 
     * 
     * 흠 먼말이지
     * 
     * 이게
     *  무가중치 방향 비순환 그래프인
     * 라는데
     * 흠 일단 생각나는건
     * u에서 모든 점에 대해서 bfs 돌리고
     * v에서도 모든 거에 대해 bfs 돌리면
     * 아
     * 아아아아아 이애함
     * 그러니까
     * u 랑 v 가있고
     * i 점에서 u 가는거
     * i 점에서 v 가는거 길이 2갠데
     * 이거 중 큰거
     * 그거를 다 모은것들중에서
     * 최소값을 구하는 문제네;;
     * 
     * 어우 한국어가 어렵다 ㅠ^ㅠ
     * 
     * 
     * 흠
     * 플루이드 워셜 같은게 있으면 좋을거같은데
     * N 이 2000 이네
     * 
     * 그러면 다익 N 번돌리면? 가중치 1이라고 잡고
     * 근데 가중치 동일하니까
     * BFS 로된다~ 
     * 
     * 
     * 
     */


    static int n,m,q;
    static ArrayList<Integer>[] list;
    static int[][] arr;
    static int SIZE = 999999999;


    static int[] bfs(int startNode) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, SIZE); 
        Queue<Integer> q = new LinkedList<>();
        
        q.add(startNode);
        dist[startNode] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int neighbor : list[current]) {
                
                if (dist[neighbor] == SIZE) {
                    dist[neighbor] = dist[current] + 1;
                    q.add(neighbor);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);

        }

        int[][] query = new int[q][2];
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            query[i][0] = a;
            query[i][1] = b;
        }

        arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = bfs(i);
        }
        //for(int i = 1; i <= n; i++) System.out.println(Arrays.toString(arr[i]));
        for(int i = 0; i < q; i++){
            int a = query[i][0];
            int b = query[i][1];
            int min = SIZE+1;
            for(int j = 1; j <= n; j++){
                int u = arr[j][a];
                int v = arr[j][b];
                int max = Math.max(u, v);
                min = Math.min(min, max);
            }
            if(min == SIZE){
                sb.append(-1 + "\n");
            }
            else{
                sb.append(min+"\n");
            }
        }
        System.out.println(sb);

    }
}