import java.util.ArrayList;
import java.util.List;

public class T44 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // 每次进入函数时，current都是一个有效的子集
        result.add(new ArrayList<>(current));
        // 从start开始，避免重复
        for (int i = start; i < nums.length; i++) {
            // 选择当前元素
            current.add(nums[i]);
            // 递归处理后续元素
            backtrack(nums,i+1,current,result);
            // 回溯，撤销选择
            current.remove(current.size() - 1);
        }
    }
}
