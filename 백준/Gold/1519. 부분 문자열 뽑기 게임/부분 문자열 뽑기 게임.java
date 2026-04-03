import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] memo ;
    

    static int dfs(int num){
        if(num < 10){ // 안댐 뭘 말하든 지게됨 현재 숫자가 10보다 작으면 그래서 1임
            return -1; 
        }

        if(memo[num] != -2) return memo[num];
        
        String str = String.valueOf(num);
        int minans = 1999999999;

        for(int i = 0; i < str.length(); i++){

            for(int j = i + 1; j <= str.length(); j++){
                if(i==0 && j== str.length()) continue;

                String sub = str.substring(i,j);
                int tempnum = Integer.parseInt(sub);
                if(tempnum==0) continue;
                if(dfs(num-tempnum) == -1){
                    minans = Math.min(minans, tempnum);
                }
            }
        }
        if(minans== 1999999999){
            return memo[num] = -1;
        }
        return memo[num] = minans;
        

    }


    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        memo = new int[n+1];
        Arrays.fill(memo, -2);
        
        if(n<10){
            System.out.println(-1);
            return;
        }

        System.out.println(dfs(n));
        
    }
}


/*
음 무슨문제일까
플레이어는 현재 게임 판에 쓰여 있는 수의 진 부분 문자열인 양의 정수 M을 고를 수 있다.
그리고 나서 원래 수에서 M을 뺀다. 진 부분 문자열이란 자기 자신을 제외한 모든 연속된 부분 문자열을 말한다.

현재 게임 판에 2309가 써있을 때, 플레이어는 2, 3, 9, 23, 30, 230, 309를 고를 수 있다.
2를 고르면, 현재 게임 판에 쓰여 있는 수는 2307이 되고, 3은 2306, ..............., 309는 2000이 된다.

음 이게 그러니까

턴이 왔다 갔다 하네요 ?

그럼 뭘까요

진부분 문자열 이거는 매번 바뀌는거같은데
현재 게임 판에 쓰여 있는 수의 진 부분 문자열인 양의 정수 M을 고를 수 있다. 그
라고하니까


이게 음
하나라도 승리하는 길이 있으면 true 고
전부다 실패해야 false 로 체크하고

10 의 경우 1 말하면 이긴다는데
10
9

이게 한자리수 나오면
지네? 

두자리수 나와도 지는경우는 있나?
없는듯

한자리수면 진다 확인

그러면 처음으로 true 나오는수가 그건가본데 정답

재귀를 돌리면이제
현재수 짤라서 다 만들면 될듯 ?
이게 음
1 000 000 이면
100만인데
7자리니까
부분문자열이
7c2
7c3
두개가 최대인데
set 으로 중복없엔다 생각하고

현재수 - 해서 가져가면 될듯 ?

된다 2
안된다 1
해서 max 로 비교하면
초기값 그것도 해결할듯

이중포문으로 저 문자열 만들수있을까
시작과 끝만 정해지면 되니까

시작 +1
시작 +2
시작 +3.....
시작 + 전체-1
아 된다 ㅇㅇ
이중포문으로 만들어도
많이안나올거같은데
7이니까
해봤자 50개도 안나옴


그러니까 
지금 숫자에서 나온 모든 거 부분문자열 다 빼서 모든게 다 1자리수면
상대는 짐 ㅇㅇ 나는 트루임


*/