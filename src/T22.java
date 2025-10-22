public class T22 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个虚拟头节点，值为0，用于简化链表操作
        // 这样可以避免处理头节点的特殊情况
        ListNode dummyHead = new ListNode(0);

        // 使用指针p和q分别指向两个输入链表的当前节点
        // curr指针指向结果链表的当前节点，初始指向虚拟头节点
        ListNode p = l1, q = l2, curr = dummyHead;

        // carry表示进位值，初始为0
        int carry = 0;

        // 循环条件：只要p或q中至少有一个不为null（即至少还有一个链表有节点）
        while (p != null || q != null) {
            // 使用三元运算符获取p当前节点的值，如果p为null则取0
            int x = (p != null) ? p.val : 0;

            // 使用三元运算符获取q当前节点的值，如果q为null则取0
            int y = (q != null) ? q.val : 0;

            // 计算当前位的总和：进位 + p的值 + q的值
            int sum = carry + x + y;

            // 计算新的进位：总和除以10的整数部分
            // 例如：sum=15 → carry=1, sum=8 → carry=0
            carry = sum / 10;

            // 创建新节点，值为总和除以10的余数（当前位的数字）
            // 并将新节点连接到当前节点的next
            curr.next = new ListNode(sum % 10);

            // 将curr指针移动到新创建的节点
            curr = curr.next;

            // 如果p不为null，将p指针移动到下一个节点
            if (p != null) p = p.next;

            // 如果q不为null，将q指针移动到下一个节点
            if (q != null) q = q.next;
        }

        // 循环结束后，检查是否还有进位需要处理
        if (carry > 0) {
            // 如果还有进位，创建一个新节点存储进位值
            curr.next = new ListNode(carry);
        }

        // 返回虚拟头节点的下一个节点，即真正的结果链表的头节点
        return dummyHead.next;

    }
}
