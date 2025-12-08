import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int[][] memo;
    static int mod = 1000000007;

    static int dfs(int idx, int check){ // 0일때 하나선택했다는거 1일때 두개 선택했다는거 이전깨 
        if(idx == n) return 1;
        if(idx > n ) return 0;

        if(memo[idx][check] != -1) return memo[idx][check];
        int a = 0;
        int b = 0;
        int c = 0;
        if(check == 0){
            a = ((dfs(idx+1,0)%mod) * 2)%mod ;
            b = dfs(idx+1,1)%mod ;
        }
        if(check == 1){
            c = ((dfs(idx+1,0)%mod) * 2)%mod ;
        }

        memo[idx][check] = (a+b+c)%mod;

        return memo[idx][check];
    }
    

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        memo = new int[n][2];
        
        for(int[] i : memo){
            Arrays.fill(i, -1);
        }

        System.out.println(dfs(0,0));
        
        

    }
}

/*
풀이 전달

학생은 총 2 * N 명

한줄에 두명씩 짝을지어 N 줄에 앉아이음
자신의 짝꿍이 풀이를 듣지 못했다면 짝꿍에게 풀이를 전달해 준다.

모든 학생이 현이 또는 짝꿍에게 풀이를 들어야 하며
연속된 두 줄 중 적어도 한 줄에서는 짝꿍에게의 풀이 전달이 일어나야 한다.
학생을 부를 수 있는 경우의 수는 몇 가지
10^9+7 로 나눈 나머지

나 나나 이해못함
뭔말이야 그러니까 

N = 1 일때
학생은 총 2명
1 2

이렇게 앉아있는건가 
그치 N 줄이니까 
아 그러면
1
2
1 , 2
이렇게 해서 3인데

N = 2 일때
학생은 총 4명
1 2
3 4

1, 3
1, 4
2, 3
2, 4
1, 2, 3
1, 2, 4
1, 3, 4
2, 3, 4

해서 8개

근데 이제
연속된 두 줄 중 적어도 한 줄에서는 짝꿍에게의 풀이 전달이 일어나야 한다.
라는데 ?

둘다 부르거나 짝중 하나만 부르거나 ?
근데 이제 둘다 부르는거 연속 2번이 안된다는거야  ?
그럼 저거 N=2 예시는 ?
1, 2, 3, 4 가안되는군요

탑다운한다면
이전이 하나선택한지 두개선택한지 체크하는 int 하나
그리고 현재 몇번째줄인지 
그러면 얼추 
1000000
백만 * 2 해서
이백만? 이면 충분하네요

가봅시다 



*/