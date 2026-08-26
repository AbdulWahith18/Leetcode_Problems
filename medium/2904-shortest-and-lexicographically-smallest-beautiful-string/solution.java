class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();
        char[] str = s.toCharArray();

        int min = Integer.MAX_VALUE;
        int x = -1, y = -1;

        for (int l = 0; l < n; l++) {

            int count = 0, r = l;

            while (count < k && r < n)
            {
                if (str[r] == '1')
                    count++;
                r++;
            }

            if (count == k && (r - l) < min) 
            {
                min = r - l;
                x = l;
                y = r - 1;
            }
        }

        if (x == -1)
            return "";

        return s.substring(x, y + 1);
    }
}