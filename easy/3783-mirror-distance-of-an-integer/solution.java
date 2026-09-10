class Solution {
    public int mirrorDistance(int num) {
        int reverse = 0,x=num;

        while (num != 0)
        {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }
        return Math.abs(x-reverse);
    }
}