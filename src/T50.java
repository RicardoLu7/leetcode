import javax.swing.tree.TreeNode;

public class T50 {
    public void flatten(TreeNode root) {
        // 从根节点开始遍历
        TreeNode curr = root;
        // 遍历整个树，直到当前节点为null
        while (curr != null){
            // 如果当前节点有左子树，需要处理展开
            if (curr.left != null){
                // 找到左子树的最右节点
                TreeNode predecessor = curr.left;
                while (predecessor.right != null){
                    predecessor = predecessor.right;
                }
                // 将当前节点的右子树接到前驱节点的右边
                // 这样左子树的最右节点就指向了原来的右子树
                predecessor.right = curr.right;
                // 将左子树移到右边，完成"提升"操作
                curr.right = curr.left;
                // 将左指针设为null，满足单链表要求
                curr.left = null;
            }
            // 移动到链表中的下一个节点（可能是原来的左子节点或右子节点）
            curr = curr.right;
        }
    }

}
