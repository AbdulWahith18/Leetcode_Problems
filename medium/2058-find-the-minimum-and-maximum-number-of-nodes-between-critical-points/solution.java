        ListNode temp=head.next;
        while(temp!=null)
        {
            if(temp.next!=null&&temp.val>temp.next.val&&temp.val>prev.val)
                l.add(i);
            else if(temp.next!=null&&temp.val<temp.next.val&&temp.val<prev.val)
