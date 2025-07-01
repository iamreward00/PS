import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        String str;
        int anw[] = new int[26];
        str = scanner.nextLine();
        scanner.close();

        a = str.length();
        for (int i = 0; i < 26; i++) {
            anw[i] = -1;
        }

        for (int i = 0; i < a; i++) {
            for (int j = 97; j <= 122; j++) {

                if ((int) str.charAt(i) == j) {
                    if (anw[j - 97] != -1) {
                        break;
                    }
                    anw[j - 97] = i;
                }

            }

        }
        for (int i = 0; i < 26; i++) {
            System.out.print(anw[i]);
            System.out.print(" ");
        }

    }
}