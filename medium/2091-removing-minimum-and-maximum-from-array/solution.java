        // Both from front
        int front = right + 1;

        // Both from back
        int back = l - left;

        // One from front, one from back
        int mixed = (left + 1) + (l - right);

        return Math.min(front, Math.min(back, mixed));
    }
}
