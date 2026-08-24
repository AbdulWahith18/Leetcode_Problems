
        // Try every possible point where the game can be split
        for (int i = n - 2; i >= 1; i--) {
            System.out.println(ans+" "+(prefix[i]-ans));
            ans = Math.max(ans, prefix[i] - ans);
        }

        return ans;
    }
}
