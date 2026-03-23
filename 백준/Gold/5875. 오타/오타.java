import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;


    public static void main(String[] args) throws Exception{
        String str = br.readLine();
        n = str.length();
        int[] sumarr = new int[n + 1];
        int sum = 0;
        for(int i = 1; i <= n; i++){
            char c = str.charAt(i-1);
            
            if(c=='('){
                sum++;
            }
            else{
                sum--;
            }
            sumarr[i] = sum;
            
        }
        if(sum != -2 && sum != 2){
            System.out.println(0);
            return;
        }
        int ans = 0;

        if(sum==2){
            for (int i = n; i >= 1; i--) {
                if (sumarr[i] <= 1) break; 
                if (str.charAt(i - 1) == '(') ans++;
            }
        }
        else if(sum==-2){
            for (int i = 1; i <= n; i++) {
                if (str.charAt(i - 1) == ')') ans++;
                if (sumarr[i] < 0) break;
            }
        }


        System.out.println(ans);




    }
}

/*
아 괄호다

첫째 줄에 하나의 문자만 고쳐서 올바른 괄호쌍이 될 수 있는 경우의 수를 출력한다.

이게 음

그러니까 하나만 틀리다면 
(  1 이고
) -1 이면

2 또는 -2가 나옴

2라면 음
뒤에서 부터 쭉 탐색하다가 
이제 그 앞이 쫙 ㄱㅊ으면 그 뒤까지니까
뒤에서부터 찾는데 
0 미만이면

반대로 이제 
-2라면
0 초과면 멈추면 되겠네
근데 이건 앞에서 해야함





*/