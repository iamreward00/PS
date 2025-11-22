import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
    N 개의 수중에서
    어떤수가 다른 수 두개의 합으로 나타낼수있으면
    그 수를 좋다 라고 한다

    N 개의 수가 주어지면 몇개인지 찾아라
    N 2000

    각 항 10억 까지

    흠

    i 번째 수가 좋은 수가 되려면
    n-i 개수중에서 2개 뽑는거니까 이거 2중포믄
    근데 i 번쨰수니까 3중포문
    그래서
    8000000000
    80억
    안됨
    
    포문이 3개니까
    일단 젤위에 포문을 줄일수있냐? i번째수 고르는거
    없다
    무조건해야할꺼같아
    그러면 내부에

    그수가 좋은수인지 판단하기위한 이중포문을 줄여볼까?
    두 수를
    a b 라고하는데
    이거 이중포문이잖아 선택하는게
    근데 
    a 를 정하기 o(n)
    b 를 정하기 o(n)
    
    인데
    a를 정하면 b는 무조건 고정인데 
    그러니까
    a에 따라서 b가 종속임 
    b 가 o(n) 이나 걸릴건없을거같은데
    정렬하고
    그거하면 될거같은데
    이분탐색
    왜냐면 a + b  = arr[i]  인걸 찾는거잖아
    한번이라도 true 면 ok 인데 아무튼
    b를 선형탐색하는것보다 이제 이진탐색하면 한번의 탐색이
    log n 이되네?

    그러면 a 하는거 해서 n 거기에 log n 
    그리고 i 번째

    nlogn * n 
    2000 * log2000 * 2000
    근데 log 2000  해봤자 뭐 
    11언저리네
    그러면
    44000000
    만에 가능하다
    ㅇㅋ ㄱㄱ
    첨에 정렬 해봤짜 뭐 얼마나 걸린다고 시간 안터지네


    */

    static int n;
    static int[] arr;
    static int cnt = 0;

    static boolean find(int idx){

        for(int i = 0; i < n; i++){
            if( i== idx) continue;
            if(b2find(idx, i)) return true;
        }
        return false;
    }

    static boolean b2find(int idx, int i ){
        int target = arr[idx];
        int nownum = arr[i];

        int left = i;
        int right = n-1;
        
        while(left <= right){
            int mid = (left+right)/2;
            int cur = arr[mid] + nownum;
            if( cur ==target){
                if(mid != idx && mid != i) return true;
                
                int temp = mid - 1;
                while (temp >= 0 && arr[temp] == target) {
                    if (temp != idx && temp != i) return true;
                    temp--;
                }
                temp = mid + 1;
                while (temp < n && arr[temp] == target) {
                    if (temp != idx && temp != i) return true;
                    temp++;
                }
                return false;
            } 

            if(cur > target) {
                right = mid - 1;

            }
            else{
                left = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        for(int i = 0; i < n; i++){

            
            if(find(i)) cnt++;;

        }
        System.out.println(cnt);
    }
}