class Solution { 
    public String lexPalindromicPermutation(String s, String target) { 

        int[] counts = new int[26]; 

        for (char c : s.toCharArray()) { 
            counts[c - 'a']++; 
        } 

        int oddCount = 0; 
        char oddChar = 0; 

        for (int i = 0; i < 26; i++)
        { 
            if (counts[i] % 2 != 0)
            { 
                oddCount++; 
                oddChar = (char) (i + 'a'); 
            } 
        }

        if (oddCount > 1)
            return "";

        char[] st = new char[s.length()];

        int k = 0;
        int j = s.length() - 1;

        for (int i = 25; i >= 0; i--)
        {

            if (counts[i] > 1)
            {
                int c = counts[i] / 2;

                while (c > 0)
                {
                    st[k++] = (char) (i + 'a');
                    st[j--] = (char) (i + 'a');
                    c--;
                }
            }
        }

        if (k == j && oddCount == 1)
            st[k] = oddChar;

        String rev = new String(st);

        int com = rev.compareTo(target);

        System.out.println("str " + rev);
        System.out.println("COM " + com);

        if (com > 0)
            return rev;

        return "";
    } 
}