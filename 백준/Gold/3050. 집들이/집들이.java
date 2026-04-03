import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = false;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;


    static int query(int startidx, int endidx,int right){

        
        int a = endidx - startidx + 1;
        int b = right;
        if(dbg)System.out.println(startidx + " " + endidx + " " + right);
        return 2*(a+b)- 1;
    }


    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m ; j++){
                map[i][j] = str.charAt(j);
            }
        }



        int[][] prv = new int[n][m+1];
        for(int i = 0; i < n; i++){
            for(int j = m-1; j >= 0 ; j--){
                
                if(map[i][j] == '.'){
                    prv[i][j] = prv[i][j+1] + 1;
                }
                else{
                    prv[i][j] = 0;
                }
            }
        }

        if(dbg){
            for(int i = 0; i < n ;i++){
                System.out.println(Arrays.toString(prv[i]));
            }
        }

        int ans = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                int minright = 1999999999;
                if(prv[i][j]==0) continue;
                for(int k = i; k < n; k ++){
                    if(prv[k][j]==0) break;
                    minright = Math.min(minright, prv[k][j]);
                    ans = Math.max(ans, query(i, k, minright));
                }
            }
        }
        System.out.println(ans);

    }
}

/*

집들이래요
식탁에 앉을 수 있는 사람의 수는 식탁의 둘레 길이와 같다. (네 변의 길이의 합)

음
왜 1번예제가
7이지
2+2+2+2 해서 8인데
아 자신뺴야하는구나
ㅇㅋㅇㅋ

음
완탐은
음
역시 6중포문이죠
시작 i j 
종료 i j 
탐색용 i j 

그리고 이제 탐색 쭉 하기 ?
이제 시작부터 종료까지 싹 뒤져서 다 . 이면 ok 하고 기록 저장해두기 인데
음
그러니까 이게 싹 뒤지는게
누적합하면 결국 된단말이야 저 범위에 . 이몇개인지 X 가 몇개이닞
X 1로잡고 하면됨 ㅇㅇㅇ

근데 그러면 4중포문인데
이게 안터지냐? 그거임

160000 * 160000
256억 인데

음 그러면 뭐없나

i 를 선택하고 j 를 선택하는걸 줄일 수 있나 ?

흐으음
시작과 끝점을 선택하긴하는데

음 그러면 이제
다른완탐으로 가면

흐으으음 이게 바닥에서 부터 시작해볼까
현재 이제 연속된거 쭉 다 적고


이게 그러니까 

지금 4중 포문인게 문제잖아
근데 이게

음 머라해야하지 

좌상단 고정하고
아래로 내려가면서 쭉 하면?
이제 이때는 현재 내 위치에서 오른쪽에 몇개 연결되어있다 알아야지
.x... 이면
10321 인거지
이거를 이제 구해두면


i,j  에서   아래로 쭉탐색 돌리면
min 해가지고 하면 될거같은데 

3중포문으로
와
그냥
개어렵네




자자자자자ㅏ
결론 내립니다

첨에 6중 포문했습니다
시작 i  j
종료 i  j 
탐색 i  j  
근데 탐색 i  j 는 누적합 처리해서 4중포문했습니다
근데 이거 뭔가 더 생각안나서 

좌상단  i  j  를잡고
아래로 쭈우우우욱 내려가면서 탐색합니다

예를들어

..x... 
210321   이런 행으로 바꾸는겁니다
그러면 이제 저 3이며ㅕㄴ 3만큼 오른쪽있는거아니까
3중포문으로 쭉 탐색이 된다는거지


5 4
X.XX
X..X
..X.
..XX
.....



*/