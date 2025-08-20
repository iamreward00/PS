import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/// 백준 2143 두 배열의 합
/// https://www.acmicpc.net/problem/2143
public class Main {

    /// 흠 뭐지
    /// 누적합인가
    /// 부 배열 -> 이건 누적합이맞음
    /// 구간합 + 구간합 = T 면 cnt ++;
    /// 근데이게 만약 B배열에서 누적합이 5 나왔고
    /// 구해야하는게 7이고 A 에서 만약 2의 누적합을가지는경우가 많을수있으니까
    /// 그경우만큼 다 cnt++해줘야하니까
    /// 해쉬맵쓴다음에
    /// key : 누적합 value = 나온횟수
    /// 해서
    /// 하면될거같은데?
    /// 


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long T = Long.parseLong(br.readLine());

        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 B 입력
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Long, Long> mapA = new HashMap<>(); /// 모든 A의 누적합들
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0L) + 1);
            }
        }

        long cnt = 0;

        for (int i = 0; i < M; i++) { /// 근데 이제 B는 위와 동일한데 그 숫자가나왔을떄 T -sum 해서나오는게있으면 있는거니까 cnt += 하는거지
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                long target = T - sum;

                if (mapA.containsKey(target)) {
                    cnt += mapA.get(target);
                }
            }
        }

        System.out.println(cnt);
    }
}