class Solution {
    public int minimumPushes(String word) {
        int res=word.length();
        if(res<=8)
            return res;
        else if(res<16)
            return (8+(res%8)*2);
        else if(res==16)
            return 24;
        else if(res<24)
            return (24+(res%8)*3);
        else if(res==24)
            return 48;
        else
            return (48+(res%8)*4);
        
    }
}