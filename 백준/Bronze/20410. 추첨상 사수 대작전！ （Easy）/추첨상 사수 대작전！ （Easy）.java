import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int seed = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        for(int a = 0; a < 100; a ++){
            for(int c = 0 ; c < 100 ; c++){
                int xone = (a*seed+c) % m;
                int xtwo = (a*xone+c) % m;
                
                if(x1==xone && x2 == xtwo){
                    System.out.println(a + " " + c);
                    return;
                }
            }
        }

    }
}

/*

*/