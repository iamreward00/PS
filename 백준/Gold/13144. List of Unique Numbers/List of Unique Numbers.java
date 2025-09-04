import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    

    /// 5
    /// 1 2 3 1 2
    /// ----------------------------------
    /// 1
    /// 1 2
    /// 1 2 3
    /// 1 2 3 1 (땡)
    /// 2
    /// 2 3
    /// 2 3 1
    /// 2 3 1 2 (땡)
    /// 3
    /// 3 1
    /// 3 1 2
    /// 1
    /// 1 2
    /// 2
    /// ------------------------------------
    /// ㅇ저거 2 , 2 3 이부분 중복인데 이거 어떻게 어떻게 못하나? 3, 3 1,  이부분도 중복이고 마지막에 1, 1 2, 2 이것도 다 그냥 
    /// 어떻게 못하나???????
    /// 1
    /// 1 2
    /// 2   이것도  2가 중복인거잖아
    /// 
    /// 1
    /// 1 2   여기서 2가 들어오면서 새로 추가된수열이 1,2  랑 2  총 2개가 추가됨
    /// 1 2 3  여기서 3이 들어오면서 새로 추가된 수열이 1,2,3  / 2,3 / 3 총 3개가 추가됨 N 개만큼 추가되네?
    /// 2 3 1 이면 1이 사라지고 1이 들어오면서 새로 추가된 수열이 2,3,1 / 3,1 / 1 또 N 개네?
    /// 그러면 그러면 그냥 중복된거 나오면 뒤로 한칸 미뤄버리고 하면 되겠네?
    /// 밑에  while문 수정 ㄱㄱ
    /// 
    ///  (1 ≤ N ≤ 100,000) 수는 모두 1 이상 100,000 이하이다. 아 이거 ㅊ문제 처음봤을때 long 쓰자고했는데 까먹었네...
    

    static int N;
    static int[] arr;
    static int[] check;

    static int dfs(int idx){ /// 1차 시도 
        check = new int[100010];
        int cnt = 0;
        for(int i = idx ; i < N; i++){
            if(check[arr[i]] != 0) break;
            cnt ++;
            check[arr[i]] = 1;
        }
        return cnt;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new int[100010];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = 0;
        
        long sum = 0;
        while(right < N){ /// 3차시도 위에 주석 작성 후 시도된 코드입니다
            ///  매번 현재 길이만큼 더해주는거니까 r - l + 1 왜냐면 인덱스 0부터 시작해서...
            while (check[arr[right]] == 1){ /// 아 1 2 3 2 3  같은경우가있네 if문 한번이면안됨 왜 냐하면 한번만하면 1 2 3 2 에서 2 3 2 가되어버린다 
                /// 그래서 2 3 2 에서 3 2 로 여기서 앞에 2를없에면서 check[2] = 0 으로만들어줘야 아래가 돌아간다
                /// 2 3 2 에서 맨오른쪽 2가 0인지 보기위해서 맨왼쪽들지워서 0으로만드는거지 while 조건문이 left 면 다 삭제함
                check[arr[left]] = 0;
                left++;
            }
            if(check[arr[right]] == 0){
                check[arr[right]] = 1;
                sum += right-left+1;
                right++;
            }
            // if(right >= N){ // right 가 맨오른쪽에 닿았으면 끝인거같은데? 3 1 2 해서 마지막에 2 닿으면 끝이니까 이때 이미 3이 더해지니까 1 2 / 2 를 볼필요도없는거지
            //     left++;
            //     right--;
            // }
        }

        while(left < N && left < 0){ /// 2차시도 사실 위에 dfs 랑 기능 같음 메모리 초과 나길래 main 함수에 넣어봤습니다 혹시나 해서
            /// left < 0 은 돌아가지 말라고 넣어두었습니다
            
            if(check[arr[right]] == 0){
                check[arr[right]] = 1;
                sum++;
                right++;
            }
            else if (check[arr[right]] == 1){
                check = new int[100010];
                left ++;
                right = left;
            }
            if(right >= N){
                check = new int[100010];
                left++;
                right = left;
            }
        }

        System.out.println(sum);
    }
}
