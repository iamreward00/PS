import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int mod = 1000000007;
    static int[][][] memo;

    static int dfs(int idx, int prv, int check) {

        if (idx >= n - 1) {
            if (check == 0)
                return 0;
            else
                return 1;
        }

        if (memo[idx][prv][check] != -1)
            return memo[idx][prv][check];

        int a = 0;

        if (prv == 0) {
            a = (a % mod + dfs(idx + 1, 0, check) % mod) % mod;
            a = (a % mod + dfs(idx + 1, 1, check) % mod) % mod;
            a = (a % mod + dfs(idx + 1, 2, 1) % mod) % mod;
        }

        if (prv == 1) {
            a = (a % mod + dfs(idx + 1, 0, check) % mod) % mod;
            a = (a % mod + dfs(idx + 2, 0, check) % mod) % mod;
            a = (a % mod + dfs(idx + 2, 0, 1) % mod) % mod;
        }

        if (prv == 2) {
            a = (a % mod + dfs(idx + 1, 0, check) % mod) % mod;
            a = (a % mod + dfs(idx + 2, 0, check) % mod) % mod;
        }

        memo[idx][prv][check] = a;
        return memo[idx][prv][check];

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        memo = new int[n + 2][4][2];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        System.out.println(dfs(0, 0, 0));

    }
}

/*
 * 
 * 와 공룡 게 임 이 다
 * 맵의 길이는 N으로 주어진다.
 * 각 지점은 바닥이나 높이가 1 또는 2인 선인장(장애물)으로 이루어진다.
 * 시작 지점은 1이며, 공룡이 앞으로 갈수록 지점을 나타내는 수가 증가한다.
 * 
 * 2개의 인접한 선인장을 뛰어 넘을 수 있으며 인접한 두 선인장의 높이의 합이 4 이상이면 뛰어넘을 수 없다.
 * 
 * 아무것도 없는거
 * 높이 2인거
 * 높이 1인거
 * 
 * 나중에 높이 1인것 경우의수 세아려서 빼면 될듯 ?
 * 아니면 수 적으니까 3차원해도될듯
 * 
 * prv 가 있어야겠고 이전값
 * N은 1000 이니까
 * 메모리 시간 다 여유롭네요
 * 
 * 
 * 
 */