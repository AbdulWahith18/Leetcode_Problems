        System.out.println();
        // Try every possible point where the game can be split
        for (int i = n - 2; i >= 1; i--) {
            System.out.println(ans+" "+(prefix[i]-ans));
            ans = Math.max(ans, prefix[i] - ans);
        int ans = prefix[n - 1];
        // Initially, consider taking all stones
            System.out.print(i+" ");
        for(int i:prefix)
        }
            prefix[i] = prefix[i - 1] + s[i];
