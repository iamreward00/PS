import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[] memo; // DP 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    
        
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2]; 

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 기간
            int b = Integer.parseInt(st.nextToken()); // 이익
            
            arr[i][0] = a;
            arr[i][1] = b;
        }
        memo = new int[n + 2];


        for(int i = n - 1; i >= 0; i--) {
            int cur = arr[i][0]; // 기간
            int profit = arr[i][1]; // 이익

            if (i + cur <= n) {

                memo[i] = Math.max(memo[i + 1], memo[i + cur] + profit);
            } 
            else {
                memo[i] = memo[i + 1];
            }
        }

        System.out.println(memo[0]);
    }
}
/*
퇴사네요
입사하고싶네요

선택 하고 안하고
하면서  쭉 
백트랑
메모이제이션하면
풀리는
디피의 전형적인 문제네요


*/