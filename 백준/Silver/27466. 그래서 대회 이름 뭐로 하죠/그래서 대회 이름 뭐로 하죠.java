import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        int cnt = 0;
        String ans = "";
        char last = '.';
        boolean check = false;
        for(int i = n-1; i >= 0; i--){
            char cur = arr[i];
            if(cur != 'A'&& cur != 'E' &&  cur != 'I' && cur != 'O' && cur != 'U' && last =='.'){
                if(cnt>=2) continue;
                last = arr[i];
            }
            if(cnt>=2){
                ans = arr[i] + ans;
            }
            if(arr[i] == 'A') cnt ++ ;
            if(ans.length() >= m-3){
                check = true;
                break;
            }
        }
        ans = ans + "AA" + last;
        if(last=='.') check = false;
        if(check){
            System.out.println("YES");
            System.out.println(ans);
        }
        else{
            System.out.println("NO");
        }
        


    }
}

/*
음
AA 를 찾고 
자음인거 찾고
앞에서 쭉 연결하면 될거같은데

이게 그러면 음
혹시모르니까
맨뒤의 AA 를 쓰는게 좋은가 ? 

m 개의 길이를 만드는거니까 
이중포문은 일단 안되고 

그냥 AA 나오면
그뒤에 있는 자음하나
나머지 앞에서 쭉 채우면 되냐 ? 
근데 글자수 가 안된다면 ? 
근데 그건
3 이상이여햐 하는데 
그럼 역순으로 한다면 ?
뒤에서부터 찾아도 되는거잖아 

뒤에서부터 자음 하나 찾고 
그다음 A A 찾고
그다음 글자 채우면 될듯 ? 




*/