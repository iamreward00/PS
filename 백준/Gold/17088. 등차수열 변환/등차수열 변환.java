import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int[] arr;


    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)arr[i] = Integer.parseInt(st.nextToken());

        if(n==1){
            System.out.println(0);
            return ;
        }

        int start = arr[1]-arr[0];
        
        int[] di = {-1,1,0};
        int[] dj = {-1,1,0};

        int min = 1999999999;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int a = arr[0] + di[i];
                int b = arr[1] + dj[j];
                int target = b - a;
                
                int cnt = 0;
                if (di[i] != 0) cnt++;
                if (dj[j] != 0) cnt++;
                
                boolean check = true;
                for(int k = 2; k < n; k++){
                    int num = a + (target*k);
                    int cha = Math.abs(arr[k] - num);
                    if(cha > 1){
                        check = false;
                        break;
                    }
                    else{
                        if(cha==1)cnt++;
                    }
                }

                if(check)min = Math.min(cnt, min);



            }
        }


        if(min == 1999999999) System.out.println(-1);
        else System.out.println(min);
        


    }
}

/*
등차수열 반환

이거 그 머냐
+1, -1 할수있다는데 
근데 결국 등차수열이려면

i 행 , i+1 행 차이가
i+1행 , i+2 행 차이랑 같아야하는데
이게 결국 
될수있는 범위가 적단말이죠

저연산을 숫자당 한번밖에 못해서

그러면 결국

등차가 몇개 안나올텐데 

a - b
a - b - 1
a - b + 1 

a - 1 - b - 1
a - 1 - b + 1

a + 1 - b - 1
a + 1 - b + 1

개나오는데 여기서 중복된거 지우면
a - b
a - b - 1
a - b + 1 
a - 1 - b - 1
a + 1 - b + 1
5 2 면 
3
2
4
1
5
가 나오겠네요?
이걸 가지고 이 등차로 되냐? 쭉 돌리면 될거같은데요

흠 '현재' 꺼를 바꿔야하나 
만약 a b 가 안된다면 a를바꿔야할까
만약 타겟등차랑 현재차이가 1 이라면 내가 작아지고 체크하고
차이가 0 이라면 그대로 가고 
차이가 2 라면 ? 내가 작아지고 상대가 커지고 
차이가 -2 라면 ? 내가 커지고 상대가 작아지고 
-1 이라면 ? 내가 커지거나 상대가 작아지거나 인데 흠 내가 커지는게 맞을까?
아니면 이게
다음 타겟 이 1 이면 상관없는데 
근데 지금 타겟이 차이가 2인데 다음도 2면 이제 아예안되는거잖아 ? 

지금타겟이 2고 다음 타겟이 음 

0 -1 1 2 -2 

가 나올수있는데 

5*10^5 만에 구할수있는데

만약 내가 타겟한 등차가 +- 0 이면
지금 차이를 구해 b - a  해서
근데 그게 만약 2야 ?
그러면 2였다는걸 기록해 
근데 다음 차이가 2야? 그럼 안되는거야
근데 다음차이가 1이야 ? 그럼됨

지금 차가 1이야

흠

걍 완탐 백트 하면 ?
흠
0 4 10

-1 4 10
0 5 10

0 4 9

-1 4 9

흠
처음꺼 기준인가 흠 
처음꺼 기준으로 i 랑 i+2 는 차이가 1차이여야 하나? 
ㅇㅇ 왜냐면 처음꺼를 -1 +1 0 해볼거거든
그러면
해당 타겟일때
3번돌겠네?

처음행을 기준으로
-1
+1
0
한거를
쭉죽가는거
i+1 이랑 차이가 1 이여야겠고 ? 
그러니까 i+1 - i  = 타겟 이랑 차이가 1 나야함 ㅇㅇ 


아 그러니까 이게 
처음 2개만 보면 되는거임
왜냐면 보셈
처음꺼 2개가
1 -1 0 
1 -1 0  
3 * 3 경우인데 
이거 뒤에 차이 2나오면 무조건 안됨
1이하면 무조건됨 이라고 하는거지 
왜? 2개가 고정되어버렸으니까

만약 차이가 2라면
앞에도 바뀌어야한다는거임
그러니까 안된다는거임


*/