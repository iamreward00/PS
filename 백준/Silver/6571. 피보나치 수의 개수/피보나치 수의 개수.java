import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            String aStr = st.nextToken();
            String bStr = st.nextToken();
            if (aStr.equals("0") && bStr.equals("0")) {
                break;
            }
            BigInteger a = new BigInteger(aStr);
            BigInteger b = new BigInteger(bStr);


            int count = 0;
            BigInteger f1 = new BigInteger("1");
            BigInteger f2 = new BigInteger("2");

            while (f1.compareTo(b) <= 0) {
                if (f1.compareTo(a) >= 0) {
                    count++; 
                }
                BigInteger temp = f1.add(f2);
                f1 = f2;
                f2 = temp;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);

    }
    
}