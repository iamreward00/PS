import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;



/// 백준 15650 - N과 M (2)
/// https://www.acmicpc.net/problem/15650
public class Main { 
    /// M 자리 N 진수라 생각하면 편하긴해
    /// 출력 길이는 M 개
    /// 중복 x 순서상관 x 조합 ㄱㄱㄱㄱㄱㄱ
    /// 
    static int N,M;
    static boolean[] vis;

    static int dfs(int idx, int cnt){ // idx 는 현재 보는수 cnt 는 몇개 추가했는지
        if(cnt == M){
            for(int i = 1; i <= N; i++){
                if(vis[i]){
                    System.out.print(i +" ");
                }
            }
            System.out.println();
            return 0;
        }
        if(idx > N){
            return 0;
        }

        vis[idx] = true;
        dfs(idx+1, cnt+1);
        vis[idx] = false;
        dfs(idx+1, cnt);

        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        vis = new boolean[N+1]; // 1부터시작이라
        /// 1부터 시작해야겠네
        dfs(1,0);
        }
    
}
