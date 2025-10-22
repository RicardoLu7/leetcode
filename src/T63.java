import javax.swing.tree.TreeNode;

public class T63 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 基准情况1: 如果当前节点为空，返回null
        // 基准情况2: 如果当前节点就是p或q，直接返回当前节点
        // (因为一个节点可以是它自己的祖先)
        //这个条件也处理了"一个节点是另一个节点祖先"的情况
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归在左子树中查找p和q
        // 返回值可能是：p、q、它们的LCA，或者null(都没找到)
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 递归在右子树中查找p和q
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况1: 如果p和q分别位于当前节点的左右子树中
        // 那么当前节点就是它们的最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 情况2: 如果p和q都在左子树，返回左子树的结果
        // 情况3: 如果p和q都在右子树，返回右子树的结果
        // 情况4: 如果左右子树都没找到，返回null
        //如果都没找到，返回null（但这种情况不会发生，因为题目保证p和q存在
        return left != null ? left : right;
    }
}
