import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /// 테이블하나
    /// 입력되는 N 하나
    /// 카운트용몇개
    /// 십자 탐색 조진다음에 방문배열하면서 카운트 하면 될거같은데
    /// 그리고 다음거는 replace 해가지고 똑같이만들고 또 돌리고 그전에 방문배열 초기화하고 하면될듯?
    /// bfs 하거나 dfs 해도 다 될거같은데 머할까 둘다 ㄱㄱ혓
    /// 방문배열 만들고(이차원임) 탐색 조지고 하면될거같은데 N 이최대 100이라 1만개 인덱스니까 시초안뜰꺼고
    /// 원트클 ㄱㄱㄱ할만할듯?
    /// N, 배열, 방문배열, 총 카운트  4개면 될듯
    /// ij 인거 처음에 확인하고 양옆으로 쭉 뻩으면서 true 로 바꾸면될듯 ㅇㅇ
    static int N, cnt;
    static char[][] arr;
    static boolean[][] vis;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static int bfs(int idx, int jdx){
        char check = arr[idx][jdx];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {idx,jdx});

        while(!queue.isEmpty()){
            int[] dxdy = queue.poll();
            for(int t = 0; t < 4; t++){
                int nidx = dxdy[0]+dx[t];
                int njdx = dxdy[1]+dy[t];
                if(nidx>=0 && nidx < N && njdx >= 0 && njdx < N && arr[nidx][njdx] == check){
                    if(!vis[nidx][njdx]){
                        vis[nidx][njdx] = true;
                        queue.add(new int[] {nidx, njdx});
                    }
                }
            }
        }
        return 0;
    }

    public static int dfs(int idx, int jdx, char ch){
        for(int i = 0; i < 4; i++){
            int nidx = idx+dx[i];
            int njdx = jdx+dy[i];
            if((nidx>=0 && nidx < N && njdx >= 0 && njdx < N && arr[nidx][njdx] == ch)){
                if(vis[nidx][njdx]) continue;
                vis[nidx][njdx] = true;
                dfs(nidx,njdx,ch);
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        vis = new boolean[N][N];

        for(int i = 0; i < N ; i++){
            String st = br.readLine();
            for (int j = 0; j < N ; j++){
                arr[i][j] = st.charAt(j);
            }
        }

        for(int i = 0; i < N ; i++){
            for (int j = 0; j < N ; j++){
                if(vis[i][j]) continue;
                cnt++;
                int a = bfs(i,j);
            }
        }   
        System.out.print(cnt + " ");
        cnt = 0;
        vis = new boolean[N][N];
        for(int i = 0; i < N ; i++){
            for (int j = 0; j < N ; j++){
                if(arr[i][j] == 'R'){
                    arr[i][j] = 'G';
                }
            }
        }
        
        for(int i = 0; i < N ; i++){
            for (int j = 0; j < N ; j++){
                if(vis[i][j]) continue;
                cnt++;
                int b = dfs(i,j,arr[i][j]);
            }
        }   
        System.out.println(cnt);



    }
}
//// 입력되는거 R R R R 인줄알았는데 RRRRR 이여서 입력잘못받아서 틀림
/// bfs 다 안맏르었음 -:> 큐에 뺴고 넣는거 안함 다안맏릉썽ㅆ었음