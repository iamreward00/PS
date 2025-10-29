import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int n, m, s;
    static String id;
    static LinkedList<int[]>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        list = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                list[c - 'a'].add(new int[]{i, j});
            }
        }
        id = br.readLine();

        // === 입력 처리 끝 ===

        // 변경점 1: String 대신 StringBuilder 사용
        StringBuilder pathBuilder = new StringBuilder(); 
        StringBuilder tempPathBuilder = new StringBuilder();

        // 변경점 2: 변수명을 더 명확하게 변경 (idx -> Y, jdx -> X)
        int currentY = 0;
        int currentX = 0;
        int idIdx = 0;
        int levelCnt = 0;
        
        // ID를 완성한 후의 최종 위치를 저장할 변수
        int finalY = 0;
        int finalX = 0;

        while (true) {
            int charIdx = id.charAt(idIdx) - 'a';
            if (list[charIdx].isEmpty()) {
                // 더 이상 필요한 아이템이 없으면 루프 종료
                break;
            }
            
            int[] nextPos = list[charIdx].poll();
            int nextY = nextPos[0];
            int nextX = nextPos[1];

            // 변경점 3: += 대신 append 메서드 사용
            if (nextY > currentY) { // Down
                for (int i = 0; i < nextY - currentY; i++) tempPathBuilder.append("D");
            } else { // Up
                for (int i = 0; i < currentY - nextY; i++) tempPathBuilder.append("U");
            }

            if (nextX > currentX) { // Right
                for (int i = 0; i < nextX - currentX; i++) tempPathBuilder.append("R");
            } else { // Left
                for (int i = 0; i < currentX - nextX; i++) tempPathBuilder.append("L");
            }
            
            tempPathBuilder.append("P");

            currentY = nextY;
            currentX = nextX;
            idIdx = (idIdx + 1) % s;

            if (idIdx == 0) { // ID 한 세트를 완성했을 때
                levelCnt++;
                pathBuilder.append(tempPathBuilder); // 완성된 경로를 최종 경로에 추가
                
                // 변경점 4: StringBuilder 초기화 (새로운 객체 생성 없이 길이만 0으로)
                tempPathBuilder.setLength(0); 

                // 최종 위치 갱신
                finalY = currentY;
                finalX = currentX;
            }
        }

        // 마지막 아이템을 주운 위치에서 던전 출구 (n-1, m-1)까지 이동
        int exitY = n - 1;
        int exitX = m - 1;

        if (exitY > finalY) { // Down
            for (int i = 0; i < exitY - finalY; i++) pathBuilder.append("D");
        } else { // Up
            for (int i = 0; i < finalY - exitY; i++) pathBuilder.append("U");
        }

        if (exitX > finalX) { // Right
            for (int i = 0; i < exitX - finalX; i++) pathBuilder.append("R");
        } else { // Left
            for (int i = 0; i < finalX - exitX; i++) pathBuilder.append("L");
        }

        // 변경점 5: 최종 출력 시 .length()와 .toString() 메서드 사용
        System.out.println(levelCnt + " " + pathBuilder.length());
        System.out.println(pathBuilder.toString());
    }
}