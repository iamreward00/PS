import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // lis_start[i]: arr[i]에서 '시작'하는 가장 긴 증가 부분 수열
        int[] lis_start = new int[N];
        
        // lds_start[i]: arr[i]에서 '시작'하는 가장 긴 감소 부분 수열
        int[] lds_start = new int[N];

        // ★ 핵심: 배열의 뒤에서부터 앞으로 계산해야 '시작점'을 기준으로 DP를 채울 수 있음
        for (int i = N - 1; i >= 0; i--) {
            lis_start[i] = 1; // 자기 자신으로 시작
            lds_start[i] = 1; // 자기 자신으로 시작

            for (int j = i + 1; j < N; j++) {
                // i 뒤에 있는 j에 대해
                
                // arr[i] 뒤에 arr[j]를 붙여 LIS를 만들 수 있는 경우
                if (arr[i] < arr[j]) {
                    lis_start[i] = Math.max(lis_start[i], lis_start[j] + 1);
                }

                // arr[i] 뒤에 arr[j]를 붙여 LDS를 만들 수 있는 경우
                if (arr[i] > arr[j]) {
                    lds_start[i] = Math.max(lds_start[i], lds_start[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            int currentLen = lis_start[i] + lds_start[i] - 1;
            if (maxLen < currentLen) {
                maxLen = currentLen;
            }
        }
        
        // N이 1 이상일 때 최소 길이는 1
        if (N > 0 && maxLen == 0) {
            maxLen = 1;
        }

        System.out.println(maxLen);
    }
}