import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st1 = br.readLine();
        String st2 = br.readLine();
        String st3 = br.readLine();
        int num = 0;
        if (st1.charAt(st1.length()-1) != 'z') {
            num = Integer.parseInt(st1) + 3;
        }
        if (st2.charAt(st2.length()-1) != 'z') {
            num = Integer.parseInt(st2) + 2;
        }
        if (st3.charAt(st3.length()-1) != 'z') {
            num = Integer.parseInt(st3) + 1;
        }
        
        
        if(num%15 == 0){
                System.out.println("FizzBuzz");
            }
        else if(num%3==0 && num%5 != 0){
                System.out.println("Fizz");
            }
        else if(num%3 != 0 && num%5 ==0){
                System.out.println("Buzz");
            }
        else{
                System.out.println(num+"");
            }


        br.close();
    }
}