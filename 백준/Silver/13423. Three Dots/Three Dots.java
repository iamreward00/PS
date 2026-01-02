import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
boj.ma/13423
Three Dots
*/
public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i] = a;
                set.add(a);
            }

            Arrays.sort(arr);
            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    int a = arr[i];
                    int b = arr[j];
                    int c = 2*b - a;
                    if(set.contains(c)) cnt++;
                }
            }
            
            
            sb.append(cnt + "\n");

        }

        System.out.println(sb);

    }
}

/*
일점둘점세점

서로 다른 N개의 점이 찍혀 있다
점 i의 위치는 Xi이다
N개의 점 중 3개를 골라 가장 왼쪽에 있는 점을 a, 가운데 있는 점을 b, 가장 오른쪽에 있는 점을 c
Xa, Xb, Xc
Xb - Xa = Xc – Xb일 때 세 점의 간격이 같다. 
간격이 같은 세 점으로 가능한 경우가 모두 몇 가지 있는지 출력하는 프로그램을 작성하시오.

1초
N : 3 ~ 1000

삼중 포문 돌리면
1000 C 3 으로 풀리는데
1000 999 998 / 3 2 1 ? 
이게 1억 6천언저리인데

시간제한이 1초네
그러면 이제
for a 
    for b  
        for c 
            여기서 검사 로직 인데 결국 여기서 하는 행동은 a = b = c ? 인데 
            이거를 다 할필요가 있을까 ?
            서로다른 N 점이란말이야
            그러면 앞에 a b 가 결정되면 c는 단 하나밖에 나올수없어 
            그런데 N 번을 다 보니까 시간이 오래 걸리는거잖아 그렇다면
            숫자 단 1개를 찾는거네 ? a b 고정하면 ? 
이중포문으로 되는게
a b 하고 그 차이있지?
그러면 b-a = c - b 인데
이걸 다르게 하면
2b - a = c 인데
저 숫자가 있는지 없는지만 보면 되겠네 ? 
이중포문 이네요

숫자를 그러면 해쉬맵에 있는지없는지 저장해둘까
-100,000,000이상 100,000,000이하의 정수
1억 이네
다행이다
10억이였으면 2b -a  에서 long 써야했는데
다 int 해도 되겠네 

일차원 int 하나 -> 이중포문돌릴떄쓰기 
해쉬셋하나 -> 숫자 있는지없는지 체크 용


*/