import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class T49 {
    //目的：记录当前在前序遍历数组中的位置
    private int preIndex = 0;
    //目的：创建中序遍历值到索引的映射
    //作用：快速查找某个值在中序遍历数组中的位置
    private Map<Integer,Integer> inorderMap = new HashMap<>();
    //方法签名：公共方法，接收前序和中序遍历数组，返回构建的二叉树根节点
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建中序遍历的值到索引的映射，便于快速查找
        //执行过程：遍历中序数组，将每个值与其索引存入HashMap
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        //目的：开始递归构建二叉树
        //参数说明：
        //preorder：前序遍历数组
        //0：当前子树在中序遍历中的起始索引
        //inorder.length - 1：当前子树在中序遍历中的结束索引
        return buildTree(preorder,0,inorder.length - 1);

    }
    //preorder：前序遍历数组
    //inStart：当前子树在中序遍历中的起始位置
    //inEnd：当前子树在中序遍历中的结束位置
    private TreeNode buildTree(int[] preorder, int inStart, int inEnd) {
        // 递归终止条件
        if (inStart > inEnd){
            return null;
        }

        // 前序遍历的第一个元素是根节点
        //从 preorder 中取出当前根节点的值
        //preIndex++：移动到下一个位置，为后续递归做准备
        //创建新的树节点
        int rootValue =  preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // 在中序遍历中找到根节点的位置
        //目的：确定根节点在中序遍历中的位置
        //作用：这个位置将中序数组分为左子树和右子树
        //示例：如果根节点值是3，inorderMap.get(3) 返回1
        int rootIndex = inorderMap.get(rootValue);

        // 递归构建左子树和右子树
        // 注意：先构建左子树，因为前序遍历的顺序是根->左->右
        //inStart：左子树在中序遍历中的起始位置（不变）
        //rootIndex - 1：左子树在中序遍历中的结束位置（根节点前一个位置）
        root.left = buildTree(preorder,inStart,rootIndex - 1);
        //rootIndex + 1：右子树在中序遍历中的起始位置（根节点后一个位置）
        //inEnd：右子树在中序遍历中的结束位置（不变）
        root.right = buildTree(preorder,rootIndex + 1,inEnd);
        return root;
    }
}
