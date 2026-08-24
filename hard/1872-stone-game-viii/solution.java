        // if(prefix[l-1]>prefix[l-2])
        //     return prefix[l-1];
        int max=prefix[0],in=0;
        for(int i=0;i<l;i++)
        {
            if(prefix[i]>max&&prefix[i]>1){
