public class T3 {
    public <ListNode> ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return  l2;
        if (l2 == null) return  l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists(res.next,l1.val >= l2.val ? l1 : l2);
        return res;
    }
}
