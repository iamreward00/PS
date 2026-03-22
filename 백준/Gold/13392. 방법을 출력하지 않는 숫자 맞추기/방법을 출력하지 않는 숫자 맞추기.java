import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;

    static String str;
    static String target;

    static int[][] memo;

    static int dfs(int idx, int cnt){ // 왼쪽돌리기 -> 다같이 커짐 / 오른쪽 돌리기 -> 나혼자 작아짐

        cnt = cnt%10;

        if(idx==n){
            return 0;
        }

        if(memo[idx][cnt] != -1) return memo[idx][cnt];

        int cur = (Integer.parseInt(str.charAt(idx)+"") + cnt )%10;
        int tar = Integer.parseInt(target.charAt(idx)+"");

        int left = 0;
        int right = 0;

        if(cur > tar){ // 현재수가 더크면? 7   4 ->
            left = 10 - (cur-tar);
            right = cur-tar;
        }
        
        else if(cur < tar){ // 현재가 더 작으면 ? 3 5
            left = tar-cur;
            right = 10 - (tar-cur);
        }
        
        // 왼쪽돌리기 -> 다같이커짐
        int a = dfs(idx+1, cnt+left) + left;

        // 오른쪽 -> 나만바뀜
        int b = dfs(idx+1,cnt) + right;

        return memo[idx][cnt] = Math.min(a, b);
    }

    public static void main(String[] args) throws Exception{
        
        n = Integer.parseInt(br.readLine());
        str = br.readLine();
        target = br.readLine();

        memo = new int[n+1][11];
        for(int i = 0; i <=n;i++){
            Arrays.fill(memo[i], -1);
        }

        System.out.println(dfs(0,0));

    }
}

/*

문제가 그러니까
숫자 2개가 주어지는데

자물쇠 돌려서 맞추라는건데

왼쪽으로 돌린다 -> 숫자가 커진다
오른쪽으로 돌린다 -> 숫자가 작아진다

왼쪽으로 돌린다 -> 내 아래도 바뀐다 커진다
오른쪽으로 돌린다 -> 나만 작아진다

굳이 왼쪽 오른쪽 와리가리 칠 필요없는게
전체를 돌리고싶으면 그 칸 아래에서 왼쪽으로 돌리면되어서

그러면 한줄에는 한방향으로 하는게 중요하네? 
일단 와리가리 칠필요가없음 ㅇㅇ

그러면 왼쪽으로 돌려서 맞추냐 vs 오른쪽으로 돌려서 맞추냐 인데

이거는 재귀 돌리면 되지않을까

idx 는 계속 커질태고
지금을 왼쪽으로 돌릴때 vs 오른쪽으로 돌릴때

그리고 오른쪽으로 몇번 돌아갔는지도 체크 해야하지않나 ?
다음상태에서 비교해야하니까 근데 이제 숫자 0~9 까지니까 10개뿐이네 ?
그러면

[n][10] 으로 될거같은데 ?

상태정의가

min 가지고있으면되니까
ㄱㄱ

3 이 5가 되기 위해서 왼쪽 오른쪽 횟수
왼쪽 2번

오른쪽 10-(5-3) ? 8번?

4 가 7이 되기위해선?
3번
10 - ( 7-4 )? 7 인데
음
식이 저게 맞나
절대값으로 해도 되나

7 이 4가 되기 위해선?
오른쪽 3번
외ㅏㄴ쪽 7번이긴한데 음

지금 숫자랑 목표숫자랑 그거겠네 ? 

지금숫자가 더  작으면 오른쪽이 숫식이고
지금 숫자가 더 크면 왼쪽이 저 수식이네



*/