import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    /*
     *
     * 🎶 DJ욱제는 비트에 몸을 맡기는 중이다. 🎶
     * 비트를 비틀어 제껴버리는 문제를 내 버렸다!
     * 와 ! bit 를 bitㄹ어 
     * 
     * n 이ㅏ 주어딘다
     * 연산이 일어나는 횟수를 구하라고?
     * 
     * K = K - ( K & ( ( ~ K  ) + 1 ) )
     * 엄
     * 10110
     * 
     * 일때 보자
     * 
     * 일단 저걸 
     * 이진수 -> 십진수 변환 있어야하고
     * 우측에 있는 K 를 전부다
     * a b c 로 바꿔서 해야겠네 그럼 편할듯
     * 
     * 0으로 만드는게 목표니까
     * 십진수 0도 똑같이 이진수 0이니까
     * 전부다 십진수로 할까
     * 
     * 왜냐면
     * 이진수 덧셈뺼셈 가능한지 의문
     * 난 불가능 하다 생각
     * 
     * 흠
     * 
     * N이 100만인데
     * 
     * 시간초과가 날수있을까?
     * 흐으으으음
     * 숫자로 하는게맞나
     * 문자열로하는게맞나
     * 흐으으으음
     * 
     * ~K + 1  한거를
     * K 랑 & 연산하고
     * K 에서 뺴는데
     * 수는 점점 줄어들긴할텐데
     * 흠
     * 10110
     * 
     * 22 인데
     * K = K - ( K & ( ( ~ K  ) + 1 ) )
     * 
     * 22  -   ( 22 &   ( ( ~ 22 ) + 1 ) )
     * 
     * 근데 자리수가 2^100만이면
     * 그거 쓰면안대나
     * biginteger
     * 여기에 이진수 계산도 있을텐데
     * 
     *  
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        BigInteger big = new BigInteger(str,2);
        int cnt = 0;
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        while(true){
            if(big.equals(zero)) break;
            BigInteger a = big.not();
            BigInteger b = a.add(one);
            BigInteger c = big.and(b);
            big = big.subtract(c);
            //System.out.println(big.toString(2));
            cnt++;
        }

        System.out.println(cnt);

    }
}