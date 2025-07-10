
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while (true){
      String st = br.readLine();
      Boolean check = true;
      if( st.length() < 1 ) {
    	  check = false;
    	  break;
      }
      if( st.equals(".") ){
        break;
      }
      Stack<Character> stack = new Stack<Character>();
      
      for(int i = 0; i < st.length(); i++){
        if(st.charAt(i) == '(' || st.charAt(i) == '['){
          stack.push(st.charAt(i));
        }
        else if(st.charAt(i) == ')'){
          if(stack.isEmpty()){
            check = false;
            break;
          }
          char c = stack.pop();
          if(c != '('){
            check = false;
            break;
          }
        }
        else if(st.charAt(i) == ']'){
          if(stack.isEmpty()){
            check = false;
            break;
          }
          char c2 = stack.pop();
          if(c2 != '['){
            check = false;
            break;
          }
        }
          
    }
      
      if(check == false){
        System.out.println("no");
        
      }
      else if(check == true){
        if(stack.isEmpty()){
          System.out.println("yes");
        }
        else{
          System.out.println("no");
        }
      }
      
    }

   
    br.close();
    
  }

}