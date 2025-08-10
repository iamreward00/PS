import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        
        // 집합의 원소 1~20을 표현할 int 변수 (32비트)
        // 0번째 비트는 숫자 1, 1번째 비트는 숫자 2, ..., 19번째 비트는 숫자 20을 의미
        int set = 0;

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            
            // "all"과 "empty"를 제외한 명령어는 숫자 x를 입력받음
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    // x에 해당하는 비트를 1로 변경 (OR 연산)
                    // 1 << (x-1) : x에 해당하는 비트만 1이고 나머지는 0인 마스크 생성
                    set |= (1 << (x - 1));
                    break;

                case "remove":
                    // x에 해당하는 비트를 0으로 변경 (AND 연산 + NOT 연산)
                    // ~(1 << (x-1)) : x에 해당하는 비트만 0이고 나머지는 1인 마스크 생성
                    set &= ~(1 << (x - 1));
                    break;

                case "check":
                    // x에 해당하는 비트가 1인지 확인 (AND 연산)
                    // 연산 결과가 0이 아니면 원소가 존재
                    if ((set & (1 << (x - 1))) != 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "toggle":
                    // x에 해당하는 비트를 반전 (XOR 연산)
                    // 0이면 1로, 1이면 0으로 변경
                    set ^= (1 << (x - 1));
                    break;

                case "all":
                    // 모든 비트를 1로 변경
                    // (1 << 20)은 21번째 비트만 1인 수. 여기서 1을 빼면 하위 20개 비트가 모두 1이 됨
                    set = (1 << 20) - 1;
                    break;

                case "empty":
                    // 모든 비트를 0으로 변경
                    set = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}