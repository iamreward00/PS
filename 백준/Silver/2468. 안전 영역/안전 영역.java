import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/// N, N*N 배열, idx? max max_cnt
/// 1부터 최대값 max 까지
/// 각인덱스 다도는게아니라 그냥 1번 장마올떄 2장마 3장마일때 섬 몇개인지 찾는거
/// 그러면 그냥 for문하고 max 까지만 주고 함수 따로 ㄱㄱ
/// 
/// 
/// 
public class Main {


    static int N;
    static int max_num = 0;
    static int max_cnt = 0;
    static int rain;
    static int[][] arr;
    static boolean[][] visited;

    static void dfs(int idx, int jdx){
        ///여기에 섬 찾는 거 추가하면 될듯
        
        visited[idx][jdx] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0; i < 4; i++){
            int nidx = idx + dx[i];
            int njdx = jdx + dy[i];
            if(nidx >=0 && nidx < N && njdx >= 0 && njdx < N){
                if(!visited[nidx][njdx] && arr[nidx][njdx] > rain){
                    dfs(nidx, njdx);
                }
            }
        }
        


    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > max_num){
                    max_num = arr[i][j];
                }
            }
        }
        
        for(int t = 0; t <= max_num; t++){
            
            rain = t;
            int temp = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && arr[i][j] > rain){
                        dfs(i,j);
                        temp++;
                    }
                }
            }

            if(temp > max_cnt){
                max_cnt = temp;
            }



        }
        

        System.out.println(max_cnt);
        



    }
}