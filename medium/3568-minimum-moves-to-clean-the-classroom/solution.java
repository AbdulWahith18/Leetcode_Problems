class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        // Give each litter cell an ID
        int[][] id = new int[m][n];

        for (int[] row : id)
            Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    id[i][j] = litterCount++;
                }
            }
        }

        // All litter collected
        int fullMask = (1 << litterCount) - 1;

        // r, c, mask, energy, moves
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc, 0, energy, 0});

        Set<String> visited = new HashSet<>();

        visited.add(sr + "," + sc + ",0," + energy);

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int e = cur[3];
            int moves = cur[4];

            // All litter collected
            if (mask == fullMask)
                return moves;

            // No energy → cannot move
            if (e == 0)
                continue;

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X')
                    continue;

                // Moving costs 1 energy
                int ne = e - 1;

                int nmask = mask;

                char ch = classroom[nr].charAt(nc);

                // Collect litter
                if (ch == 'L') {
                    nmask |= (1 << id[nr][nc]);
                }

                // Reset energy
                if (ch == 'R') {
                    ne = energy;
                }

                String key = nr + "," + nc + "," + nmask + "," + ne;

                if (!visited.contains(key)) {

                    visited.add(key);

                    q.offer(new int[]{
                        nr,
                        nc,
                        nmask,
                        ne,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}