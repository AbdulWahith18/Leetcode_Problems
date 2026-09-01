import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] id = new int[m][n];

        for (int[] row : id)
            Arrays.fill(row, -1);

        // Find S and give every L an ID
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

        int fullMask = (1 << litterCount) - 1;

        Queue<int[]> q = new ArrayDeque<>();

        // row, col, mask, energy, moves
        q.offer(new int[]{sr, sc, 0, energy, 0});

        boolean[][][][] visited =
            new boolean[m][n][1 << litterCount][energy + 1];

        visited[sr][sc][0][energy] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int e = cur[3];
            int moves = cur[4];

            if (mask == fullMask)
                return moves;

            if (e == 0)
                continue;

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n)
                    continue;

                if (classroom[nr].charAt(nc) == 'X')
                    continue;

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

                if (!visited[nr][nc][nmask][ne]) {

                    visited[nr][nc][nmask][ne] = true;

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