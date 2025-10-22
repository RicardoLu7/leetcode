public class t52 {
    public ListNode detectCycle(ListNode head) {
        //如果链表为空（head == null），肯定无环
        //如果链表只有一个节点且next为null（head.next == null），也肯定无环
        if (head == null || head.next == null){
            return null;
        }
        //slow：慢指针，每次前进1步
        //fast：快指针，每次前进2步
        //都从链表头开始
        ListNode slow = head;
        ListNode fast = head;

        //因为快指针每次走2步，所以要检查fast和fast.next都不为null
        //如果fast或fast.next为null，说明到达链表尾部，无环
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            //如果快慢指针指向同一个节点，说明链表有环
            if (slow == fast){
                // 第二步：找到环的入口
                ListNode ptr = head;           // 新指针从头开始
                while (ptr != slow){           // 当ptr和slow未相遇时循环
                    ptr = ptr.next;            // ptr每次走1步
                    slow = slow.next;          // slow每次走1步
                }
                return ptr;
            }
        }
        return null;
    }
}
