import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/// 백준 1922 네트워크 연결
/// https://www.acmicpc.net/problem/1766
public class Main {

    
    /// 자 이문제는 무엇이냐
    /// 네트워크를 구축하려고한다
    /// 모든컴퓨터가 연결되어이써양한다
    /// a - b 연결이라는건 a- b 경로가있다는말
    /// 근데 컴ㅠ터 연결 비용 최소로 해야함
    /// 연결비용 최소
    /// 최소연결비용
    /// 근데 모두다 연결되어야함
    /// 최소 연결 비용 mst
    

    static int N,M;
    static int[][] graph;
    static int[] parent;


    static int find(int a ){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        int aroot = find(a);
        int broot = find(b);

        if(aroot == broot ) return true;
        if(aroot> broot) parent[broot] = aroot;
        else parent[aroot] = broot;
        return false;

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[M][3];
        parent = new int[N+1]; /// 1번부터시작함
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[i][0] = a;
            graph[i][1] = b;
            graph[i][2] = c;
        }

        Arrays.sort(graph, (o1, o2) ->  Integer.compare(o1[2], o2[2]));

        int sum = 0 ;
        int cnt = 0;
        int end = N-1;
        for(int[] cur : graph){
            if(union(cur[0], cur[1])) continue;
            sum+= cur[2];
            if(++cnt == end) break;
        }
        System.out.println(sum);

    }
}



    /// 2년전에 푼문제다
    /// 2년전의 나는 도대체 왜 알고리즘을 포기했는다
    /// 진짜 후회스럽다
    /// 만약 2년후 이코드를 또 보게된다면
    /// 그때는 알고리즘을 쭉 하고 있길 바란다...
    /// 근데 그때 열심히해서 지금 어느정도 아 그랬었지 기억하면서 하는걸지도'