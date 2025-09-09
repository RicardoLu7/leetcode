package java;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T5 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current !=null || !stack.isEmpty()){
            // 将当前节点的所有左子节点入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 弹出栈顶节点（最左边的节点）
            current = stack.pop();
            result.add(current.val); // 访问节点
            // 转向右子树
            current = current.right;
        }


        return result;
    }

}
