import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] map;

    static void bfs(int idx, int jdx){
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {idx, jdx});
        map[idx][jdx] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int ni = cur[0] + di[i];
                int nj = cur[1] + dj[i];
                if(ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni][nj] == 0) continue;
                q.add(new int[] { ni,nj});
                map[ni][nj] = 0;
            }

        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 0 ; t< T ;t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }
            int cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j]==0) continue;
                    bfs(i,j);
                    cnt++;
                }
            }
            System.out.println(cnt);

        }
    }
}