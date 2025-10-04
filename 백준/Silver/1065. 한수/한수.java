import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    int n;
    int num = 0;
    int sum = 0;
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    scanner.close();

    for(int i = 1; i <= n; i++){
      int check = 0;

      ArrayList<Integer> array = new ArrayList<>();
      num = i;
      while(num > 0){
        array.add(num%10);
        num = num/10;
      }
      for (int j = 0; j < array.size() - 2 ; j++) {
        if (array.get(j)-array.get(j+1) != array.get(j+1)-array.get(j+2)) {
          check++; 
        }
      }
      if (check == 0) {
        sum++;
      }
    }
    System.out.println(sum
    );

  }
}