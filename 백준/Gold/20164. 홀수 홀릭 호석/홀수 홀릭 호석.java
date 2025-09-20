import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    /// 수의 각 자리 숫자 중에서 홀수의 개수를 종이에 적는다.
    /// 수가 한 자리이면 더 이상 아무것도 하지 못하고 종료한다.
    /// 수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
    /// 수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다.
    /// 이거 그러니까 숫자 1까지 가야하는거네
    /// 재귀하면서 쭉 더하면 될거같은데
    /// 언제 더해주냐 그게 문젠데
    /// 최대 최소가 있는거니까 결국
    /// 999999999 이게 최대 값 9자리인데
    /// 마지막에 다 더하는게 되나..? 돌아와야하는거 아닌가 리턴값있어야할거같은데 아닌가
    /// 아닌거같기도 하고 마지막 1일때 그냥 그거 이때까지 받아온거 출력해도되나
    /// 아 이게 돌아와야하나?
    /// 안돌아 와도 될듯
    /// 기저가서 list 에넣기만하면될듯 ㅇㅇ
    /// 3이상일때 이중포문  i j 해서 자르는 위치 표시해주면 될듯? 현재 인덱스도 넘겨야할거같고
    /// 아니면 숫자를 넘길까? 그래도 되고 숫자로 만드는 함수 하나 하면 되겠네
    /// 

    static boolean dbg = false;

    static int min = 1999999999;
    static int max = 0;
    static void dfs(int num, int cnt){
        String str = num+"";
        int size = str.length();
        for(int i = 0; i < size; i++){
            if((str.charAt(i)-'0')%2 == 1){
                cnt++;
            }
        }
        if(dbg) System.out.println(cnt);
        if(num < 10){ // 기저
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
            return;
        }

        if(num < 100){
            int a = num / 10;
            int b = num % 10;
            dfs(a+b , cnt);
        }

        else{
            for(int i = 1; i < size; i++){
                for(int j = i+1; j < size; j++){
                    int a = cut(num,0,i);
                    int b = cut(num,i,j);
                    int c = cut(num,j,size);
                    if(dbg) System.out.println(a + " " + b + " " + c);
                    dfs(a+b+c,cnt);
                }
            }
        }
    }
    /// 0 1 2 3 4 5 6
    
    static int cut(int num , int st, int ed){
        String res = "";
        String str = num+"";
        if(dbg) System.out.println(st + " " + ed);
        for(int i = st; i < ed; i++){
            res += str.charAt(i)+"";
        }
        
        return Integer.parseInt(res);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(N,0);
        System.out.println(min + " " + max);
    }
}