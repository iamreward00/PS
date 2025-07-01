import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    static class Star {
        double x, y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Edge {
        int to;
        double cost;

        public Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static double dist(Star a, Star b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Star> stars = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            double x = Double.parseDouble(input[0]);
            double y = Double.parseDouble(input[1]);
            stars.add(new Star(x, y));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.cost, o2.cost);
            }
        });
        queue.offer(new Edge(0, 0));
        double result = 0;

        while (!queue.isEmpty()) {
            Edge node = queue.poll();
            int current = node.to;

            if (!visited[current]) {
                visited[current] = true;
                result += node.cost;

                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        queue.offer(new Edge(i, dist(stars.get(current), stars.get(i))));
                    }
                }
            }
        }

        System.out.println(result);
    }
}
