import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

///https://www.acmicpc.net/problem/34558
public class Main {

    /*
     * 소수니까 에레토....의체 쓰고
     * 중앙값? 이건 어떻게 처리하지
     * 닫힌구간 a1,b1 이있으면
     * 이중에 소수의 개수가 짝수거나 소수가 존재하지 않으면 -1 출력
     * 아 소수끼리중에서 중앙값?
     * 이거 그러면
     * 누적합 만들어 두면 되는거 아닌가
     * 누적합만들어두고 이제 개수 파악한다음에
     * -1이 아닐때만 탐색 해볼까
     * 시간괜찮나
     * N 100,000
     * ai,bi 100,000
     * 100,000 안에 소수가 100,000개 가안될테니까
     * 이중포문 해도 괜찮긴하겠네
     * 
     * 그냥 수식으로도 나오나?
     * 2 5 의 경우
     * sum[5] - sum[1] 이니까
     * 5는 3이고 1 은ㅇ 0이니까
     * 근데 3 / 2 = 1 니까
     * 1 +1 해서 
     * 2번째 소수인 3을출력했나?
     * 그건 아닌거같은데
     * 아닌데 결국 이게 중앙 값 소수라는게
     * 홀수니까
     * 2번째 소수는 맞는데 이제 그게 2에서 시작한거구나
     * ㅇㅋ 탐색 절반으로 줄일수 있겠네
     * 
     * 아 100만이네
     * 일단 지금 -1 은 o(1) 이고
     * 나머지 저거는
     * 얼마나 짧지 시간초과 나겠는데
     * 몇번째 찾아야 하는지는 아는데 그게 
     * 선형이여서 안되겠네
     * 
     * 지금 느린게
     * else 저부분이란 말이지
     * 몇번째 소수 찾을진 정했어
     * 그거는 sum[a] 에서 mid 만큼 떨어진 놈이야
     * 근데 sum 배열은 111122223333444455556666777 이런꼴이야
     * 정렬된 배열 탐색 빠르게 하는거 뭐야? 이진탐색
     * 되나? 
     * sum[a] = 3 이고 mid = 4면
     * 우리가 찾는건 sum[i] = 7 인건데
     * 그 7이 가장 먼저 나오는 lowerbound 네
     * 될듯?
     * 2 5 
     * 2부터 시작하니까 sum[a-1] 로 해야겠네
     * 그러면 sum[a-1] = 0 mid = 2
     * sum[i] = 2 인데 그게 젤 처음 나오는곳 ㅇㅋ ㄱㄱ
     * 0 1 2 3 4 5
     * 0 0 1 2 2 3
     * 
     * 
     * 
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int size = 1000000;
        boolean[] arr = new boolean[size+200];

        for(int i = 2; i*i <= size; i++){
            if(!arr[i]){
                for(int j = i*i; j<= size ; j+=i){
                    arr[j] = true;
                }
            }
        }
        arr[0] = true;
        arr[1] = true;

        int[] sum = new int[size+200];

        
        int cnt = 0;
        
        for(int i = 0; i <= size; i++){
            if(!arr[i]){
                cnt++;
            }
            sum[i] = cnt;
        }
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if((sum[b] - sum[a-1])%2==0) {
                sb.append(-1 +"\n");
            }
            else{
                int target = (sum[b] - sum[a-1])/2 + 1 + sum[a-1]; /// 전체숫자에서 찾아야할거
                
                int left = 0;
                int right = 1000000;
                while(left <= right){
                    int mid = (left+right) / 2;
                    if(sum[mid] >= target ){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                sb.append(left +"\n");

            }

        }
        System.out.println(sb);
        


    }
    
}
