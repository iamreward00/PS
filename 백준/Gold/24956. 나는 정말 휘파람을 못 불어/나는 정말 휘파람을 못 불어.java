import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
boj.ma/24956
나는 정말 휘파람을 못 불어
*/
public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int ecnt = 0;
        int wcnt = 0;
        String str =br.readLine();
        for(int i = 0; i < n; i++){
            if(str.charAt(i)=='E') ecnt++;
        }


        long[] powarr = new long[222222];
        powarr[0] = 1;
        int mod = 1000000007;
        
        for(int i = 1; i < 222222; i++){
            powarr[i] = (powarr[i-1]*2) %mod;
        }


        long sum = 0;
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if(c=='W') wcnt++;
            if(c=='E') ecnt--;
            if(c=='H'){
                long temp = (powarr[ecnt]%mod - (ecnt + 1) + mod)%mod ;
                sum += (temp%mod * wcnt%mod)%mod;
            }
        }

        System.out.println(sum%mod);

    }
}

/*
휘 파람 ummmm 휘파람파람파람
블랙핑크 컴백해주세요

문자열 S 에서 유사휘파람 소리를 구해야해요
WHEE 는 유사 휘파람 이래요
유사휘파람 문자열 뒤에 E 붙인것도 유사 휘파람 이래요
유사 휘파람 문자열은 S 상에서 연속하지 않아도 된다는데요 ?
유사 휘파람 문자열인 부분 수열의 개수를 구하래요 

8
WAHEWHEE


W_HE__E_
W_HE___E
W_H___EE
W_HE__EE
W____HEE
____WHEE

흠
WHEE 일때
이게
음
다 따로 나올수있구나 
흠

W 가 처음 나왔을때
그 다음 H 위치 랑
그다음 E E 가 흠
그다음 E 개수가 만약 3개 라면 ? 
나오는 경우의 수가 
3c2 + 3c3 인가 ?
4개라면 ?
4c2 + 4c3 + 4c4 인데 
이거 빨리 못하나 
그러니까 지금 내 W 위치에서 뒤에있는 H 의 위치에서 뒤에있는 E 들의 개수 


E 개수가 2개면 1
3개면 4
W_HE__E_
W_HE___E
W_H___EE
W_HE__EE

4개면 
8임 ?

아 그런가
선택하고안하고인가
근데이제 1개만 선택되는 경우 n 을 빼고 하나도 선택 안하는 경우 1 도 빼면 될거같은데 ?
그러니까 e 가 3개면 

일단 4 뺴고 
2^3 하면 
4 나오네 ?
빨리할수있네

2^n - n - 1 

4면
16 - 4 - 1
9 ?
인지 확인해볼까

W_HE__E_
W_HE___E
W_H___EE
W_HE__EE
W_HE____E
W_HE__E_E
W_HE___EE
W_H___EEE
W_HE__EEE

맞네

그러면 그냥 H 기준으로 잡아도 되는거아님 ?
이제 내앞에 W 개수 * 내뒤에 E 저거 해서
기준이 H 네 

양옆을 보는거니까 
내앞에 W가 몇개인지
내뒤에 E가몇개인지

누적합도 쓸필요 없는거같은데

전체 E 개수 미리파악하고  e 나올떄마다 지우고 
w는 그냥 나올떄마다 추가하고 

기준은 H 다
H 기준으로 양옆본다

이런 문제 앳코더에서 많이 본거같은데 그죵?


아 근데
ecnt가 커지면
이제
long 도 벗어나는구나 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
따로 배열 만들어야겠네

아
mod 쪽에 뺄셈들어가니까 이게 위험하네
항상
모듈려 연산에 뺼셈이 들어가면
모듈려값을 더해줄것!

*/