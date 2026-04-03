import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;


    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 199999999;
        boolean check = false;
        while (left < n) {
            
            while (right < n && sum < m) {
                sum += arr[right++];
            }

            if(sum >= m){
                ans = Math.min(ans, right-left);
                check = true;
            }
            sum -= arr[left++];
            
        }
        if(check) System.out.println(ans);
        else System.out.println(0);

    }
}

/*
음 10달전에 파이썬으로 풀었네
이때면 딱 싸피 준비할때인데
그때인가보다

어디보자
부분합 중에 그 합이 S 이상이 되는 것 중
가장 짧은 것의 길이

음 그러면

N이 10만이고
1만이하의 수니까

다합해도
얼마나오지

10억이네
int 써도 되겠당


음 그러면 어떻게 할수있을까 

투포인터로 이제
합이클때까지 옮기고
left 왼쪽으로하나

그러다가 합 작아지면 right 옮기고
그둘비교하면 될텐데



*/