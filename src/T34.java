import java.util.ArrayList;
import java.util.List;

public class T34 {
    public List<List<Integer>> permute(int[] nums) {
        //List<List<Integer>> - 列表的列表，每个内层列表代表一个排列
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        //当start等于数组长度时，说明已经处理完所有位置
        if (start == nums.length){
            // 将当前数组转换为列表
            //创建新的列表来存储当前排列
            List<Integer> permutation = new ArrayList<>();
            //遍历数组，将每个数字添加到排列列表中
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }
        //i从start开始，确保每个位置尝试所有可能的数字
        for (int i = start; i < nums.length; i++) {
            // 交换当前位置与i位置
            swap(nums,start,i);
            // 递归处理下一个位置
            backtrack(nums,start + 1,result);
            // 回溯，交换回来
            swap(nums,start,i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
