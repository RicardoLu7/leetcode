import javax.swing.tree.TreeNode;

public class T71 {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);

    }

    private int[] dfs(TreeNode node) {
        if (node == null){
            return new int[]{0,0};
        }

        // 后序遍历：先处理左右子树
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // 不偷当前节点：可以偷子节点（选择偷或不偷子节点的较大值）
        int notRob = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        // 偷当前节点：不能偷直接子节点，只能偷孙子节点
        int rob = node.val + left[0] + right[0];

        return new int[]{notRob, rob};

    }

}
