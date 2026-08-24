        for(int i=l-2;i>=0;i--)
        {
            if(prefix[i]>1){
                in=i;
                max=prefix[i];
            }
        }
        if(in==l-1)
            return max;
