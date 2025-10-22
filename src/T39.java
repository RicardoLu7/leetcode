import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T39 {
    public int[][] merge(int[][] intervals) {
        // 边界条件：如果区间数量<=1，无需合并
        if (intervals.length <= 1) return intervals;

        // 使用lambda表达式按起始位置排序
        // (a, b) -> Integer.compare(a[0], b[0]) 比较两个区间的起始位置
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 创建结果列表
        List<int[]> result = new ArrayList<>();

        // 创建指向当前合并区间的引用
        int[] newInterval = intervals[0];

        // 将第一个区间添加到结果中
        result.add(newInterval);

        // 使用增强for循环遍历所有区间
        for (int[] interval : intervals) {
            // 检查当前区间是否与正在合并的区间重叠
            if (interval[0] <= newInterval[1]) {
                // 重叠：更新合并区间的结束位置
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // 不重叠：开始处理新的区间
                newInterval = interval;      // 将引用指向新的区间
                result.add(newInterval);     // 将新区间添加到结果中
            }
        }

        // 转换并返回结果
        return result.toArray(new int[result.size()][]);
    }
}
