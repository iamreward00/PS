import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



/// 백준 1920 - 수 찾기
/// https://www.acmicpc.net/problem/1920
public class Main {

    static int N,M;
    static int[] narr;
    static int[] marr;
    static StringBuilder sb = new StringBuilder();

    static int check(int target){
        

        int left = 0;
        int right = N-1;

        while(left <= right){
            int mid = (left+right)/2;
            if(narr[mid] == target){
                return 1;
            }
            if(narr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

        }


        return 0;


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        narr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            narr[i] = Integer.parseInt(st.nextToken());
        }


        M = Integer.parseInt(br.readLine());
        marr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            marr[i] = Integer.parseInt(st.nextToken());
        }
        /// 입력다받고 이제 정렬부터 시작 ㄱㄱㄱ
        
        Arrays.sort(narr);
        for(int i = 0; i < M; i++){
            sb.append(check(marr[i]) + "\n");
        }

        System.out.println(sb);


    }
}
