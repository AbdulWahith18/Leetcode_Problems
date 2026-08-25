        {
        while(i<x&&j<y)
            if(i<x)
                h1.add(nums1[i++]);
            if(j<y)
                h2.add(nums2[j++]);
        }
        List<Integer> l=new ArrayList<>();
        for(int k=0;k<x;k++)
        {
            if(h1.contains(nums1[k])&&h2.contains(nums1[k])&&!l.contains(nums1
                l.add(nums1[k]);
        }
        int res[] = new int[l.size()];
        for(int k=0;k<l.size();k++)
            res[k]=l.get(k);
        return res;
    }
            [k]))
}
