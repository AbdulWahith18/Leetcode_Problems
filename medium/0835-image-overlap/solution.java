
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        int x = i + dr;
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length, ans = 0;

        for (int dr = -n + 1; dr < n; dr++) {
            for (int dc = -n + 1; dc < n; dc++) {

                int count = 0;
