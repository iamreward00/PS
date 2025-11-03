import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /* 
     * 20:44 시작
     * 흠
     * 
     * 가장 큰 정사각형을 찾으라는 문제네요?
     * 
     * N이 30만
     * 높이는 10^9 10억
     * 
     * 정사각형 한변의 길이를 출력
     * 
     * 구간?의 최소값 인거같은데요
     * 30만이면 음
     * 흠
     * 길이 2의 구간에서 최소값 2 이상인곳이 있냐? 그러면 2는 가능한데
     * 
     * 이게 좌표점 2개 잡고 하면
     * n^2 인데
     * 
     * 이게 근데 5가 나온다는건
     * 4,3,2,1 전부다 나온다는건데
     * oooooxxxx 인가?
     * 정사각형 크기가 6이 최대라면 7은 불가능한거니까
     * 이진탐색? 으로 되나
     * 근데 그게 결국
     * 흠
     * 이게 10억이면
     * 2^20 이 10만이니까
     * 30? 이겠네
     * log 로 한다면 30 인데 이거에 
     * 그 숫자만큼 연속된게있냐? 찾으면 될까?
     * 그 찾는건 오래 걸리냐?
     * o(N) 하면 될거같은데
     * 왜냐면 오른쪽으로 쭉가가면서 연속되면 cnt++ 하면서 아니면 cnt = 0 하고 하면 될듯
     * 이진탐색이 진짜 되냐?
     * 진짜 저
     * ooooooxxxxxxxxx꼴이냐?
     * 맞지
     * ㅇㅋ 가자
     * 
     * 
     * 
     */


    static int n;
    static int[] arr;

    static boolean check(int num,int len){
        int cnt = 0;
        int max = 0;
        
        for(int i = 0; i < len; i++){
            if(arr[i] >= num){
                cnt++;
            }
            else{
                cnt = 0;
            }
            
            max = Math.max(max, cnt);
        }

        if(max >= num){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)arr[i] = Integer.parseInt(st.nextToken());
        int left = 1;
        int right = 1000000000;


        int len = n;
        while(left <= right){
            int mid = ( left + right )/ 2;
            
            if(check(mid,n)){ // true 면 되는거니까 오른쪽으로 가야하니까 left를 올려야게네
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(left-1);

    }
}