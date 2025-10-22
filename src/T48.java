import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T48 {
    //返回值含义：外层List包含每一层，内层List包含该层所有节点的值
    public List<List<Integer>> levelOrder(TreeNode root) {
        //result 将存储最终的层序遍历结果，结构如：[[第一层], [第二层], [第三层], ...]
        List<List<Integer>> result = new ArrayList<>();
        //如果根节点为null，直接返回空列表，避免后续空指针异常
        if (root == null) return result;
        //使用 Queue 接口，LinkedList 实现
        //队列遵循FIFO（先进先出）原则，适合层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // 添加这一行，将根节点加入队列
        //开始层序遍历循环
        while (!queue.isEmpty()) {
            //在开始处理当前层之前，先记录这一层有多少个节点
            //确保内层循环只处理当前层的节点，不会处理到下一层
            int levelSize = queue.size();
            //用于存储当前层所有节点的值
            List<Integer> currentLevel = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                //从队列头部取出节点
                //poll() 方法移除并返回队列头部的元素
                //这是当前正在处理的节点
                TreeNode node = queue.poll();
                //将当前节点的值加入当前层列表
                currentLevel.add(node.val);

                // 将下一层的节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //完成一层的遍历后，将该层列表添加到结果中
            result.add(currentLevel);
        }
        return result;
    }
}
