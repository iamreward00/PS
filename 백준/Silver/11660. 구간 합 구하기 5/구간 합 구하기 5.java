import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;



/// 백준 11660 - 구간 합 구하기 5
/// https://www.acmicpc.net/problem/11660
public class Main { 
    /// 구간합 구하기 4를 풀어봤다면 1차원 누적합을 할수있을거다
    /// 이건 2차원 누적합이다 
    /// N * N 크기
    /// 3개의 구해야하는 구간들
    /// 전체 배열 1개 누적합 배열 1개
    /// N,M 해서 하면 될듯 드가즈아
    /// 이번에는 인덱스 1부텃 ㅣ작하게해서 i-1 이거 다 되게 하면 좋을듯 다 통일되니까
    /// ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ
    static int N, M;
    static int[][] sums;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        sums = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j<= N; j++){
                sums[i][j] = sums[i-1][j] + sums[i][j-1] + arr[i][j] - sums[i-1][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){ // M 번의 정답 출력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int ans = sums[c][d] + sums[a-1][b-1] - sums[a-1][d] - sums[c][b-1];
            sb.append(ans+"\n");
        }   
        System.out.println(sb);
    }
    
}
