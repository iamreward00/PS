import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
     * 문제 신기하네요
     * 이게 새로 길이가 5여가지고
     * 입력에서 /5 해서 그게
     * 가로길이네요
     * 그렇게 해서 만들면 되겠는데요
     * 
     * 일단 모양을 다 만들어둘까요
     * 0부터 9까지
     * 
     * 그리고 /5 한거로이제
     * 짤라서
     * 전체 맵을만들고!
     * 맨윗줄에서 # 만나고 그거 끝날때까지 길이제고
     * 해서 하면 될거같은데요!
     * 
     * 
     */

    static String[] numbers = {"####.##.##.####" , "#####", "###..#####..###" ,"###..####..####", 
                                "#.##.####..#..#","####..###..####","####..####.####",
                                "###..#..#..#..#","####.#####.####","####.####..####"};

    
    static int n,len;
    static char[][] map;

    static boolean checkone(int jdx){
        for(int i = 0; i < 5; i++){
            if(map[i][jdx] != '#') return false;
            if(jdx+1 < len && map[i][jdx+1] == '#') return false;
            
        }
        return true;
    }

    static int check(int jdx){
        int size = 3;
        int start =jdx;
        int end = jdx+size;
        String temp = "";
        int res = -1;
        for(int i = 0; i < 5; i++){
            for(int j = start; j < end; j++){
                temp += map[i][j];
            }
        }
        for(int i = 0; i < 10; i++){
            if(i==1) continue;
            if(temp.equals(numbers[i])){
                res = i;
            }
        }

        return res;

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        len = n/5;
        String str = br.readLine();
        map = new char[5][len];
        int idx = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < len; j++){
                map[i][j] = str.charAt(idx++);
            }
        }
        // for(int i = 0; i < 5; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }


        for(int j = 0; j < len; j++){
            if(map[0][j]=='#'){
                if(checkone(j)){
                    sb.append(1);
                    j++;
                }
                else{
                    sb.append(check(j));
                    j+=3;
                }
                

            }
        }
        System.out.println(sb);


    }
}