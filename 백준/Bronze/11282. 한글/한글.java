import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // '가'의 유니코드 10진수 값은 44032
        // N번째 글자이므로 N-1을 더해준 뒤 문자로 변환
        char hangul = (char) (44032 + n - 1);
        
        System.out.println(hangul);
    }
}