import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/// BOJ 2636 치즈
/// https://www.acmicpc.net/problem/2636
public class Main {
    
    /// 테두리 찾을때 절때 색종이2 처럼 상하좌우 0이면 테두리이다! 를 해선안된다
    /// 왜냐하면 중간에 구멍이 뚤려있기때문이다
    /// 그러면 테두리를 어떻게찾을까?
    /// 테두리는 0,0 에서 시작한다 여기는 항상 비어있다
    /// 여기서 4방으로 쭉뻗어나가면서 치즈만나면 거기 0으로 이거 치즈다하럐ㄸ까지
    /// 이거를반복하면 테두리만 찾을수있다
    
    static boolean dbg = true;


    static int N,M,cnt;
    static int[][] arr;
    static boolean[][] vis;
    
    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        vis = new boolean[N][M];

        queue.add(new int[] {0,0});

        int[] di = {-1,1,0,0};
        int[] dj = {0,0,1,-1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + di[i];
                int nc = cur[1] + dj[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    if (arr[nr][nc] == 0) {
                        queue.add(new int[]{nr, nc});
                    } else { 
                        arr[nr][nc] = 0; 
                        cnt--;  
                    }
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        vis = new boolean[N][M];
        cnt = 0;
        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    cnt++;
                }
            }
        }

        int time = 0;
        int last = 0;
        while (cnt > 0) {
            time++;
            last = cnt; 
            bfs(); 
        }
        
        System.out.println(time);
        System.out.println(last);
        


    }
    
}

