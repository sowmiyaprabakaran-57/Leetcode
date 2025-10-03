class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m <= 2 || n <= 2) return 0; // No space to trap water

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // Add all border cells into the min-heap
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = visited[m - 1][j] = true;
        }

        // Directions for neighbors (up, down, left, right)
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int water = 0;

        // Process cells
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    // If neighbor is lower, water trapped
                    water += Math.max(0, h - heightMap[nx][ny]);
                    // Push the effective height into the heap
                    pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
                }
            }
        }

        return water;
    }
}