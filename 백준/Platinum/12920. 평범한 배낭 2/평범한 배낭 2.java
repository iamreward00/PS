import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/// 백준 12920 평범한 배낭 2
/// https://www.acmicpc.net/problem/12920
public class Main {

    /// 무게 종류 최대무게
    /// 무게 만족도 개수
    /// 개수도 변수로 써야하니까 차원 만드나? 그런가? 그러네? 아닌가?
    /// 아니네 만드는게 맞네?
    /// O N 배낭 문제에서
    /// 이진분할 이라는 기술이 필요하네
    /// 이거 안하면 시간초과남 
    /// 내생각은 물건 100개있으면
    /// 100개의 개별물건으로 보는건데
    /// 이러면 10000만에 100해서 아무튼 시간초과남근데
    /// 이진분할하면
    /// 물건을
    /// 1 2 4 8....
    /// 하면서 분할해서 저걸 다 개별로봄
    /// 그래도 다 표현할수있음 우리가 이진수로 다 표현하듯이
    /// 지린다
    /// 
    
    static int N,M;
    static ArrayList<int[]> list;
    static int[][] memo;    

    static int dfs(int idx, int kg){
        

        if(kg > M) return -199999999;
        if(idx == list.size()) return 0;
        if(memo[idx][kg]!= -1 ) return memo[idx][kg];
        
        
        
        int a = dfs(idx+1,kg);
        int b = dfs(idx+1,kg+list.get(idx)[0]) + list.get(idx)[1];
        memo[idx][kg] = Math.max(a, b);
        return memo[idx][kg];

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());// 무게
            int b = Integer.parseInt(st.nextToken());// 만족도
            int c = Integer.parseInt(st.nextToken());// 개수
            for(int  j = 1; c > 0; j*=2){
                int cnt = Math.min(j,c);
                list.add(new int[] { a * cnt , b * cnt});
                c -= cnt;
            }


        }
        memo = new int[list.size()][M+1];
        for(int i = 0; i < list.size(); i++){    
            Arrays.fill(memo[i], -1);
        }

        System.out.println(dfs(0,0));

    }
}