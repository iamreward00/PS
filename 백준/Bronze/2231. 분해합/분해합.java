import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Main {
        public static int check(int temp_num) {
            
            int sum = temp_num;

            String temp_st = temp_num + "";
            for(int i = 0; i< temp_st.length(); i++){
                String s = temp_st.charAt(i) + "";
                sum += Integer.parseInt(s);
            }
            
            return sum;
            
        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int num =  Integer.parseInt(br.readLine());
            Boolean bool = false;
            for(int i = 0; i < num ; i++){
                if(check(i)== num){
                    bw.write(String.valueOf(i));
                    bool = true;
                    break;
                }
            }

            if(!bool){
                bw.write("0");
            }

            bw.close();
            br.close();

    }
}