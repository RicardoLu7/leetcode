import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T33 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序以便剪枝
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
    //0：搜索起始索引（从第0个元素开始）
    //new ArrayList<>()：当前组合（初始为空）
    private void backtrack(int[] candidates, int target, int start, List<Integer> current,
                           List<List<Integer>> result) {
        // 找到一组解
        //当剩余目标值为0时，说明当前组合的和等于目标值
        if (target == 0){
            //使用new ArrayList<>(current)创建副本，避免后续修改影响已保存的结果
            result.add(new ArrayList<>(current));
            return;
        }
        //start参数确保组合按非递减顺序生成，避免重复组合如[2,3]和[3,2]
        for (int i = start; i < candidates.length; i++) {
            // 剪枝：如果当前数已经大于剩余目标值，后面的数更大，直接退出
            if (candidates[i] > target){
                break;
            }
            // 选择当前数
            current.add(candidates[i]);
            // 递归搜索，注意可以重复使用当前数，所以起始索引还是 i
            backtrack(candidates,target - candidates[i],i,current,result);
            // 回溯：移除最后添加的数，尝试其他可能性
            current.remove(current.size() - 1);
        }
    }
}
