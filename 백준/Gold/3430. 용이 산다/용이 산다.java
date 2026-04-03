import java.io.InputStreamReader;

public class Main {
    static int n, m;

    // 1. 객체 생성을 막기 위한 전역 배열 세팅
    static int[] arr = new int[1000005];
    static int[] first = new int[1000005];
    static int[] next = new int[1000005];
    static boolean[] rain = new boolean[1000005];
    static int[] list = new int[1000005];

    // 2. PriorityQueue를 대체할 '원시타입(int) 최소 힙'
    static int[] heap = new int[1000005];
    static int heapSize = 0;

    static void push(int val) {
        heap[++heapSize] = val;
        int i = heapSize;
        while (i > 1 && heap[i] < heap[i / 2]) {
            int t = heap[i]; heap[i] = heap[i / 2]; heap[i / 2] = t;
            i /= 2;
        }
    }

    static int poll() {
        int res = heap[1];
        heap[1] = heap[heapSize--];
        int i = 1;
        while (i * 2 <= heapSize) {
            int child = i * 2;
            if (child + 1 <= heapSize && heap[child + 1] < heap[child]) child++;
            if (heap[i] <= heap[child]) break;
            int t = heap[i]; heap[i] = heap[child]; heap[child] = t;
            i = child;
        }
        return res;
    }

    // 3. StringBuilder를 대체할 '커스텀 출력 버퍼'
    static byte[] outBuf = new byte[65536]; 
    static int outIdx = 0;

    static void flush() throws Exception {
        System.out.write(outBuf, 0, outIdx);
        outIdx = 0;
    }

    static void printString(String s) throws Exception {
        for (int i = 0; i < s.length(); i++) {
            if (outIdx == outBuf.length) flush();
            outBuf[outIdx++] = (byte) s.charAt(i);
        }
    }

    static void printInt(int num) throws Exception {
        if (num == 0) {
            if (outIdx == outBuf.length) flush();
            outBuf[outIdx++] = '0';
            return;
        }
        int temp = num;
        int len = 0;
        while (temp > 0) { len++; temp /= 10; }
        
        if (outIdx + len >= outBuf.length) flush();
        
        int idx = outIdx + len - 1;
        while (num > 0) {
            outBuf[idx--] = (byte) ((num % 10) + '0'); 
            num /= 10;
        }
        outIdx += len;
    }

    static void printChar(char c) throws Exception {
        if (outIdx == outBuf.length) flush();
        outBuf[outIdx++] = (byte) c;
    }

    public static void main(String[] args) throws Exception {
        int t = readInt();

        while (t-- > 0) {
            n = readInt();
            m = readInt();

            heapSize = 0; // 힙 초기화

            // 이번 테케에서 쓸 만큼만 초기화
            for (int i = 1; i <= n; i++) {
                first[i] = -1;
                rain[i] = true;
            }
            for (int i = 0; i < m; i++) {
                next[i] = -1;
            }

            for (int i = 0; i < m; i++) {
                arr[i] = readInt();
            }

            for (int i = m - 1; i >= 0; i--) {
                if (arr[i] > 0) {
                    next[i] = first[arr[i]];
                    first[arr[i]] = i;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (first[i] != -1) {
                    push(first[i]); 
                }
            }

            int ldx = 0;
            boolean check = true;

            for (int i = 0; i < m; i++) {
                int cur = arr[i];
                if (cur == 0) {
                    if (heapSize == 0) {
                        list[ldx++] = 0;
                    } else {
                        int a = poll(); 
                        int lake = arr[a];
                        list[ldx++] = lake;
                        rain[lake] = false;
                    }
                } else {
                    if (rain[cur]) {
                        check = false;
                        break;
                    } else {
                        rain[cur] = true;
                        if (next[i] != -1) {
                            push(next[i]); 
                        }
                    }
                }
            }

            if (check) {
                printString("YES\n");
                for (int i = 0; i < ldx; i++) {
                    printInt(list[i]);
                    printChar(i == ldx - 1 ? '\n' : ' ');
                }
            } else {
                printString("NO\n");
            }
        }
        
        flush(); 
    }

    // 4. StringTokenizer를 대체할 '커스텀 입력기'
    static int readInt() throws Exception {
        int c, n = 0;
        while ((c = System.in.read()) <= 32) {
            if (c == -1) return -1;
        }
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return n;
    }
}