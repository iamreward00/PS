import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    /*
     * 20:14 시작
     * 무슨문제일까요
     * 카드를섞는다네요
     * N개의 카드를섞는다네요
     * 
     * 3 2 5 6 1 4 
     * 
     * [A1, A2, A3, A4, A5, A6]면
     * A3, A2, A5, A6, A1, A4]
     * [A5, A2, A1, A4, A3, A6]
     * [A1, A2, A3, A6, A5, A4]
     * 
     * 
     * 이거 완탐이 되나?
     * 3 2 5 6 1 4 에서
     * 
     * 궤적은
     * 20억 이하래
     * 완탐안되네
     * 
     * 흠
     * 가는길이 하나긴한데
     * 희소배..열..?
     * 
     * 최소공배수인ㄴ가
     * 각인덱스가
     * 최악의경우
     * 2만번 해야하는데
     * 이게 2만개 있긴 하네요?
     * 각 인덱스마다
     * 사이클 구하고
     * 그거 최소공배수 하면 될듯
     * 
     * 예시보면
     * 1은 3
     * 2는 1
     * 3은 3
     * 4는 2
     * 5는 3
     * 6은 2 
     * 사이클이니까 이거 최소공배수  구나!
     * 
     * 
     * 근데 문제
     * 최소공배수 어떻게 구함..?
     * 
     * 최소공배수는!
     * x * y / gcd(x,y)
     * 하면댐
     * 두수의 곱을 두수의 최대 공약수로 나눈거임!
     * 
     * 그럼 최대 공약수 어떻게 구함???
     * 여기서 이제 유클리드 호제법
     * 
     * a>b   a,b 에서  a를 b로 나눈 나머지가 r 일때 
     * a와 b 의 최대공약수는 b를 r 의 최대공약수다!
     * 
     * 
     * 
     */
    

    static int n;
    static int[] arr;
    static int[] cic;
    static HashSet<Integer> set;

    static int find(int idx){
        int start = idx;
        int next = -1;
        int cnt = 0;
        while(start!=next){
            next = arr[idx];
            idx = next;
            cnt++;
        }
        //System.out.println(cnt);
        return cnt;
    }

    static long gcd(long a, long b ){
        long r = 0;
        if(a < b){
            long temp = b;
            b = a;
            a = temp;
        }
        while(b!=0){
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        cic = new int[n+1];
        set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            cic[i] = find(i);
            set.add(cic[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        long ans = 1;
        for(int i = 0; i < list.size(); i++){
            int a = list.get(i);
            ans = (ans*a) /gcd(ans, a);
        }
        System.out.println(ans);

    }
}