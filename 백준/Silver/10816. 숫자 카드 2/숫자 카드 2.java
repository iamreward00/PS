import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



/// 백준 10816 - 숫자 카드 2(LowerBound, UpperBound) 활용
/// https://www.acmicpc.net/problem/10816
public class Main {


    /// lowerbound upperbound 를 활용하기위해선
    /// 이진탐색을 해야하고
    /// 이진탐색을 위해선
    /// 정렬을 해야한다
    /// ㅇㅋ 일단 정렬하고
    /// 흠 1을 찾는다고치면
    /// 1이 가장 마지막에 나온위치 - 1이 가장처음나온 위치 하면 1의 개수가 나온다
    /// 이걸이용해서 풀어보자 이번엔 ㄱㄱㄱ
    /// N 이랑 n 배열 M 이랑 m 배열 해서 
    
    static int N,M;
    static int[] narr;
    static int[] marr;
    static StringBuilder sb = new StringBuilder();

    static int check(int target){
        int ans = 0;

        int left = 0;
        int right = N-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(narr[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

        }
        int upper = left - 1 ;

        left = 0;
        right = N-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(narr[mid] >= target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }
        int lower = left - 1;

        //System.out.println(upper);



        return upper - lower ;


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        narr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            narr[i] = Integer.parseInt(st.nextToken());
        }


        M = Integer.parseInt(br.readLine());
        marr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            marr[i] = Integer.parseInt(st.nextToken());
        }
        /// 입력다받고 이제 정렬부터 시작 ㄱㄱㄱ
        
        Arrays.sort(narr);
        ///System.out.println(Arrays.toString(narr));
        /// 이제 총 M 번돌면서 upper lower 찾아서 - 해서 출력하기 ㄱㄱㄱㄱ 함수로 따로 빼면 편할듯
        for(int i = 0; i < M; i++){
            sb.append(check(marr[i]) + " ");
        }

        System.out.println(sb);


    }
}

/// sb.append 대신 바로 print 했더니 시간초과났다 역시 입출력 최적화는 차이가 좀 있는거같다ㅇㅇ
/// 시간초과나면 한번 생각해봐야지하지말고 첨부터 그냥 입출력은 최적화 해라 ㅇㅇ