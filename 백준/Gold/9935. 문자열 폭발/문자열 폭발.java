import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException  {

  
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    String boom = "";
    String endstr ="";
    str = br.readLine();
    boom = br.readLine();
    int strlength = str.length();
    int boomlength = boom.length();
    Stack<Character> stack = new Stack<Character>();
    br.close();

    for( int i = 0; i < strlength ; i++ ){
      stack.add(str.charAt(i));

      boolean same = true;
      if(stack.size()>=boomlength){
        for( int j = 0; j < boomlength; j ++){
          char ch1 = stack.get(stack.size() - boomlength + j);
          char ch2 = boom.charAt(j);
          
          if( ch1 != ch2 ){
            same = false;
            break;
          }
        }
        if(same){
          for(int k = 0; k < boomlength; k++){
            stack.pop();
          }
        }
      }
    }
    if(stack.size()==0){
      System.out.println("FRULA");
    }
    else{
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < stack.size(); i++){
        sb.append(stack.get(i));
      }
      System.out.println(sb.toString());
    }



      
  }
  

}
