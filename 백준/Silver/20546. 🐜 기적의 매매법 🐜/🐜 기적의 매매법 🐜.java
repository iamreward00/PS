import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[20];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 14; i++) arr[i] = Integer.parseInt(st.nextToken());

        int jm = n;
        int sm = n;

        int jc = 0;
        int sc = 0;

        for(int i = 1; i <= 14; i++){
            int cur = arr[i];
            if(jm >= cur){
                jc += jm/cur;
                jm %= cur;
            }
        }

        int upcnt = 0;
        int downcnt = 0;
        int prv = arr[1];

        for(int i = 2; i <= 14; i++){
            int cur = arr[i];

            if(cur > prv){ // 오늘이 어제보다 크네 
                upcnt ++;
                downcnt = 0;
            }
            else if(cur < prv){ // 오늘이 어제보다 작네
                downcnt++;
                upcnt = 0;
            }
            else{ // 같을때니까 다 초기화
                upcnt = 0;
                downcnt = 0;
            }

            if(downcnt>=3){ // 매수
                if(sm >= cur){
                sc += sm/cur;
                sm %= cur;
                
            }
            }
            else if(upcnt >=3){ // 매도
                sm += sc * cur;
                sc = 0;
            }
            prv = cur;
            
        }

        int jall = jm + (jc*arr[14]);
        int sall = sm + (sc*arr[14]);
        if(jall>sall){
            System.out.println("BNP");
        }
        else if(sall > jall){
            System.out.println("TIMING");
        }
        else{
            System.out.println("SAMESAME");
        }



    }
}

/*

준현이는 주식을 살 수 있다면 무조건 최대한 많이 산다

모든 거래는 전량 매수와 전량 매도로 이루어진다.
현금이 100원이고 주가가 11원이라면 99원어치의 주식을 매수하는 것이다.
단, 현금이 100원 있고 주가가 101원이라면 주식을 살 수 없다.
성민이는 빚을 내서 주식을 하지는 않는다.

3일 연속 가격이 전일 대비 상승하는 주식은 다음날 무조건 가격이 하락한다고 가정한다.
따라서 현재 소유한 주식의 가격이 3일째 상승한다면, 전량 매도한다. 
전일과 오늘의 주가가 동일하다면 가격이 상승한 것이 아니다.


3일 연속 가격이 전일 대비 하락하는 주식은 다음날 무조건 가격이 상승한다고 가정한다.
따라서 이러한 경향이 나타나면 즉시 주식을 전량 매수한다. 
전일과 오늘의 주가가 동일하다면 가격이 하락한 것이 아니다.


15
20 20 33 98 15 6 4 1 1 1 2 3 6 14
준현이는 1월 5일에 1주를 매수한다. 따라서 14일의 자산은 14원이다.
성민이는 1월 7일 3주를, 1월 8일 3주를 매수한다.
그리고 1월 13일에 전량 매도한다. 따라서 14일 자산은 36원이다.

14일 밖에없은니까
구현하면 될거같은데  ?
준현이꺼 따로
성민이꺼 따로해도 시간넉넉해


long 이여야하나?
모든 입력은 1000 이하의 양의 정수이다.
만약 내가 1000원이있고
1 원이였다가 1000원에 팔면
1000 * 1000 이니까
long 안써도 되겠네


*/