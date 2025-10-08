import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    
    /*
     * AB와 DC를 조합하면 AC가 되고 표현형은 C다.
        DC와 AB를 조합하면 DB가 되고 표현형은 D다.
        같은 방법으로 6개의 모든 조합을 만들었을 때 가능한 표현형은 C D P X다.
     * 
     * N 이 100,000
     * 이중포문 하면 시간초과남
     * 조합했을때 나보다 작은게 있으면 내가 출력될수있다 잖아
     * 그러니까 min 값을 구해 놔야하나
     * 
     * AC DB XP
     * 
     * A
     * C P
     * 
     * B
     * D X 
     * 
     * 맞네 그러면 될듯?
     * 
     * 왼쪽 에서 min 구하고  오른쪽 비교
     * 오른쪽에서 min 구하고 왼쪽 비교
     * 
     * 
     * 누적개념으로 가야할거같은데
     * 
     * AC DB XP
     * 이거일때
     * 왼쪽 min A 고
     * 오른쪽 min B 인데
     * 답안나옴
     * 아니면 ldx, rdx 인거만 돌려주면 또 될듯?
     * 
     * 
     */


    static boolean dbg = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = st.nextToken();
        }

        boolean[] chk = new boolean[30];
        char left = arr[0].charAt(0);
        char right = arr[0].charAt(1);
        
        for(int i = 1; i < N ; i++){
            char a = arr[i].charAt(0);
            char b = arr[i].charAt(1);
            if(left <= b){
                chk[b-'A'] = true;
            }
            if(right <= a){
                chk[a-'A'] = true;
            }
            if(left > a){
                left = a;
            }
            if(right > b){
                right = b;
            }
        }

        left = arr[N-1].charAt(0);
        right = arr[N-1].charAt(1);

        for(int i = N-2; i >= 0 ; i--){
            char a = arr[i].charAt(0);
            char b = arr[i].charAt(1);
            if(left <= b){
                chk[b-'A'] = true;
            }
            if(right <= a){
                chk[a-'A'] = true;
            }
            if(left > a){
                left = a;
            }
            if(right > b){
                right = b;
            }
        }




        int cnt = 0;
        
        for(int i = 0; i < 30; i++){
            if(chk[i]){
                cnt++;
                
                sb.append((char)(i+'A') +" ");
            } 
        }

        System.out.println(cnt);
        System.out.println(sb);

    }
}
