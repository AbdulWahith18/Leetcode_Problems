        List<Integer> l=new ArrayList<>();
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        l.add(0);
        int i=1;
        ListNode prev=head;
        ListNode temp=head.next;
        while(temp!=null)
        {
            if(temp.next!=null&&temp.val>temp.next.val&&temp.val>prev.val)
                l.add(i);
            else if(temp.next!=null&&temp.val<temp.next.val&&temp.val<prev.val)
                l.add(i);
            prev=temp;
            temp=temp.next;
            i++;
        }
        for(Integer j:l)
            System.out.println(j);
        if(l.size()==1)
            return new int[]{-1,-1};
        int min=l.get(2)-l.get(1),max=l.get(l.size()-1)-l.get(0);
        return new int[]{min,max};
        
    }
}
