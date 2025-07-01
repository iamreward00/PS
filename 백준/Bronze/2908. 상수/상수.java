import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num1;
		int num2;
		Scanner scan = new Scanner(System.in);
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		scan.close();
		
		num1 = num1/100%10 + (num1/10%10)*10 + (num1%10)*100;
		num2 = num2/100%10 + (num2/10%10)*10 + (num2%10)*100;
		if(num1 > num2) System.out.println(num1);
		else System.out.println(num2);
	}

}
