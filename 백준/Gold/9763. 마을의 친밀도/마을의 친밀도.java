import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

*/
public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        
        int ans = 1999999999;
        for(int i = 0; i < n; i++){
            
            int cur1 = arr[i][0];
            int cur2 = arr[i][1];
            int cur3 = arr[i][2];

            int min1 = 999999999;
            int min2 = 999999999;


            for(int j = 0; j < n; j++){
                if(i==j)continue;

                int tur1 = arr[j][0];
                int tur2 = arr[j][1];
                int tur3 = arr[j][2];

                int num = Math.abs(cur1-tur1) + Math.abs(cur2-tur2) + Math.abs(cur3-tur3);

                if(num <= min1){
                    min2 = min1;
                    min1 = num;
                }
                else if(num <= min2){
                    min2=num;
                }

            }
            ans = Math.min(ans, min1+min2);

        }
        System.out.println(ans);

    }
}

/*
흠
당장이제
3중포문돌리면되는데
1만이네

그러면흠

근데 이게

d2 기준으로
1,3 을선택하면
되는거아닌가

2 기준 가장 가까운 2개 선택하는거지

그러면 이제 이중포문으로 되긴한드ㅔ

1만인데 애매하네
흠

결국 이중포문 하면서
현재 d2 랑 가장 가까운 2점 가져오기 인데

이거는 변수 두개써서하면될듯?
ㅇㅋㄱ ㄱㄱ



*/