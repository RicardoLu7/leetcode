public class T54 {
    public ListNode sortList(ListNode head) {
        // 递归终止条件：如果链表为空或只有一个节点，直接返回
        if(head == null || head.next == null) return head;

        // 使用快慢指针法找到链表中点
        // slow 每次走一步，fast 每次走两步
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;          // slow 前进一步
            fast = fast.next.next;     // fast 前进两步
        }

        // 分割链表为两部分
        ListNode mid = slow.next;  // mid 指向后半部分的头节点
        slow.next = null;          // 切断前后两部分的连接

        // 递归排序前后两部分，然后合并
        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        // 创建虚拟头节点，简化边界处理
        ListNode dummy = new ListNode(0), curr = dummy;

        // 比较两个链表的节点值，选择较小的接入结果链表
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;  // l1 值较小，接入 l1
                l1 = l1.next;    // l1 指针前进
            }else {
                curr.next = l2;  // l2 值较小，接入 l2
                l2 = l2.next;    // l2 指针前进
            }
            curr = curr.next;    // 结果链表指针前进
        }

        // 将剩余的非空链表直接接在末尾
        curr.next = l1 != null ? l1 : l2;

        // 返回虚拟头节点的下一个节点（真正的头节点）
        return dummy.next;
    }

}
