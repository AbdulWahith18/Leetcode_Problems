        int i=1;
        l.add(0);
        List<Integer> l=new ArrayList<>();
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode temp=head.next;
        while(temp!=null)
        {
            if(temp.next!=null&&temp.val>temp.next.val&&temp.val>prev.val)
                l.add(i);
            else if(temp.next!=null&&temp.val<temp.next.val&&temp.val<prev.val)
                l.add(i);
            i++;
        }
        if(l.size()==1)
            return new int[]{-1,-1};
        int min=l.get(1)-l.get(0),max=l.get(l.size()-1)-l.get(0);
        return new int[]{min,max};
        
    }
            temp=temp.next;
