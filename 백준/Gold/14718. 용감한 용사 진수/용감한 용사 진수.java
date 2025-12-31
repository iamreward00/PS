import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
boj.ma/14718
용감한 용사 진수
*/
public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][3];

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            arr[i][0] = a; // 힘
            arr[i][1] = b; // 민
            arr[i][2] = c; // 지
        }

        int ans = 1999999999;

        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){

                int him = arr[i][0];
                int minn = arr[j][1];

                ArrayList<Integer> geelist = new ArrayList<>();

                for(int k = 0; k < n; k++){
                    if(arr[k][0] <= him && arr[k][1] <= minn){
                        geelist.add(arr[k][2]);
                    }
                }

                if(geelist.size()>=m){
                    Collections.sort(geelist);
                    int mingee = geelist.get(m-1);
                    ans = Math.min(ans, him + minn + mingee);
                }

            }
        }



        

        System.out.println(ans);

    }
}

/*

N은 100이네
적 병사가 가진 힘보다 진수의 힘이 크거나 같고,
적 병사가 가진 민첩보다 진수의 민첩이 크거나 같고,
적 병사가 가진 지능보다 진수의 지능이 크거나 같으면,
진수는 그 적 병사를 이길 수 있다.

그러면 이제 드는 생각이
일단
최소니까 
힘민지값은 적 병사꺼 선택하면 되겠네?
50이 있는데  55 할필요없으니까 

그러면
힘 민 지 다 선택하면
3중포문으로
for 힘
    for 민
        for 지
            여기서 이제 개수가 K개 이상이냐 ?
                그러면 min 비교 인데

이러면 4중포문인데 

힘,민 만 고르고
그때 이제 '지' 후보군 고르고
그게 K개 이상이면 이제 min 비교

for 힘
    for 민
        for 지능후보군 선택 
        min 비교

하면 3중포문이네 이거네 가자


*/