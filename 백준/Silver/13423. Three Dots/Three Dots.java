import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 개수 입력
        String line = br.readLine();
        if(line == null) return;
        int T = Integer.parseInt(line);
        
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 1. 이진 탐색을 하려면 '정렬'이 필수입니다.
            Arrays.sort(arr);

            int cnt = 0;
            
            // 2. a와 b를 고정 (O(N^2))
            for(int i = 0; i < n; i++) {         // a (왼쪽 점)
                for(int j = i + 1; j < n; j++) { // b (가운데 점)
                    int a = arr[i];
                    int b = arr[j];
                    
                    // 등차수열 공식: c - b = b - a  =>  c = 2*b - a
                    int c = b * 2 - a;
                    
                    // 3. c가 존재하는지 이진 탐색으로 확인 (O(log N))
                    // Arrays.binarySearch는 값을 찾으면 0 이상의 인덱스를, 못 찾으면 음수를 반환합니다.
                    if (Arrays.binarySearch(arr, c) >= 0) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}