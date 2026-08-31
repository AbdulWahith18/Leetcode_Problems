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
