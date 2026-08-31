/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        List<Integer> l = new ArrayList<>();

        int i = 1;

        ListNode prev = head;
        ListNode temp = head.next;

        while(temp != null) {

            if(temp.next != null &&
               ((temp.val > prev.val && temp.val > temp.next.val) ||
                (temp.val < prev.val && temp.val < temp.next.val))) {

                l.add(i);
            }

            prev = temp;
            temp = temp.next;
            i++;
        }

        if(l.size() < 2)
            return new int[]{-1, -1};

        int max = l.get(l.size() - 1) - l.get(0);

        int min = Integer.MAX_VALUE;

        for(int j = 1; j < l.size(); j++) {

            int distance = l.get(j) - l.get(j - 1);

            min = Math.min(min, distance);
        }

        return new int[]{min, max};
    }
}