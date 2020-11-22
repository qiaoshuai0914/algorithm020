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
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode l2c = l2;
        ListNode l1c =l1;
        ListNode  p1 =null;
        while(l1c!=null && l2c!=null){
            if(l1c.val>l2c.val){
                ListNode w =l2c.next;
                l2c.next =l1c;
                if(p1!=null){
                    p1.next=l2c;
                }
                p1=l2c;
                l2c= w;
            }else{
                p1=l1c;
                l1c =l1c.next;
            }

        }
        if(l2c!=null&&p1!=null){
            p1.next = l2c;
        }
        if(l1.val>l2.val){
            return l2;
        }
        return  l1;
    }
}