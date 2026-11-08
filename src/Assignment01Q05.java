public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (m.length == 0) {
            return -1;
        }

        int n = m.length;

        if (i < 0 || i >= n || j < 0 || j >= n) {
            return -1;
        }

        if (i == j) {
            return 0;
        }

        int[] queue = new int[n];
        int head = 0;
        int tail = 0;

        int[] distances = new int[n]; // also used to track visited nodes
        for (int k = 0; k < n; k++) {
            distances[k] = -1;
        }

        queue[tail++] = i; // first assigns then incrementing tail
        distances[i] = 0;

        while (head < tail) {
            int current = queue[head++];

            if (current == j) {
                return distances[current];
            }

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (m[current][neighbor] == 1 && distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 1;
                    queue[tail++] = neighbor;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }
}