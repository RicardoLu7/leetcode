import javax.swing.tree.TreeNode;

public class T47 {
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode root) {
        if (root == null) return true;
        //遍历左子树
        if (!inorderTraversal(root.left)){
            return false;
        }
        // 检查当前节点：中序遍历中前一个节点应该小于当前节点
        if (prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        //遍历右子树
        return inorderTraversal(root.right);
    }

}
