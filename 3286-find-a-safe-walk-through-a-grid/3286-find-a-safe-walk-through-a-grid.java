class Solution {

    class Pair {
        int dist, r, c;

        Pair(int dist, int r, int c) {
            this.dist = dist;
            this.r = r;
            this.c = c;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, (int) 1e9);

        int[][] dirs = {{1, 0},{-1, 0},{0, 1}, {0, -1}};

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[0][0] = grid.get(0).get(0);
        pq.offer(new Pair(dist[0][0], 0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            for (int[] dir : dirs) {
                int nr = cur.r + dir[0];
                int nc = cur.c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int newDist = cur.dist + grid.get(nr).get(nc);

                if (newDist < dist[nr][nc]) {
                    dist[nr][nc] = newDist;
                    pq.offer(new Pair(newDist, nr, nc));
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}