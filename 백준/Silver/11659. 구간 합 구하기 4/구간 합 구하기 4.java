import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/// 백준 11659 - 구간 합 구하기 4
public class Main {
    /// 입력으로 N 개의 숫자 M 개의 구해야할 구간이 들어옴 ㅇㅇ
    /// N,M 이 크지 않으면 이중 포문 돌려서 완탐 했을텐데 둘다 100,000 이 최대값이니 시간초과가 날것
    /// 그렇다면 누적합이라는 개념을 써야함
    /// arr[1] 이 뜻하는건 0 1 두개의 합  arr[4] 가 뜻하는건 0 1 2 3 4 의 합  N 보다 작은 것들의 모든 합임 // 인데스는 0부터 시작
    /// 그러면? arr[i] = arr[i-1] + i 가되는거지 이런개념이있고 누적합 유튜브에 좋은거 많으니 나중에 또 찾아보셈
    /// 문제도 자주풀고
    /// 구간 1 3 의 구간합을 구하고싶다면 저거는 1번째수 에서 3번쨰 수라는뜻 인덱스로는 0 1 2 -> 이거는 그냥 arr[2] 임 5 4 3 해서 12임
    /// 근데 만약 2 4 의 구간합을 구하고싶어 2번째 수부터 4번째 수 이거는 인덱스로 1 2 3 이고 이거는 4 3 2 여서 답은 9임 근데 어떻게 거 arr배열꼴로 구하냐면
    /// arr[3] 의 모양은 0 1 2 3    근데 여기서 구간 바로 전까지를 다 뺴버리면?? 시작이 1번쨰 인덱스니까 1번쨰 이전인걸 다 가진놈
    /// arr[0] 을 빼버리면 1 2 3 인덱스가 나온다
    /// 문제풀기 ㄱㄱㄱㄱ
    /// N,M , 구간합 배열 1개 ㄱㄱㄱㄱㄱ
    /// 이렇게하면 배열 만드는데 N 번 그리고 인덱스로 두개 뽑아서 빼면되는거라 구간합 구하는거 자체는 O(1) 인듯? 맞나 맞을듯 ㅇㅇㅇ
    /// 아 그리고 숫자 하나는 1000 보다 작은수인데 이거 만약에 1000 이 10만개면 인트 터지나? 100만 1000만 1억 10억 가도 안터지니까 int 해도 될듯
    static int N,M;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N]; 
        st = new StringTokenizer(br.readLine()); // 숫자 N 개 입력받고
        arr[0] = Integer.parseInt(st.nextToken());// 하나 미리 뺴고
        for(int i = 1; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1]; // 이전꺼 합도 더하면서 넣기
        }
        for(int i = 0; i < M; i++){//// M 개의 정답을 출력해야함~
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 1 ~ 3 이 들어오면 인덱스는 0 ~ 2 까지니까 arr[2] 임
            int b = Integer.parseInt(st.nextToken()); // 2~ 4 라고 들어오면 인덱스는 1~ 3 이니까 arr[3] 에서 arr[시작인덱스-1] 하면댐
            a--;
            b--;
            if(a > 0){
                System.out.println(arr[b] - arr[a-1]);
            }
            else{ // 근데 0 일때 -1 할수없고 어짜피 처음부터니 뺼것도없어서 그냥 출력 ㄱㄱ
                System.out.println(arr[b]);
            }
        }
    }
}