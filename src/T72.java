import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T72 {
    public int[] topKFrequent(int[] nums, int k) {
        // 第1行：创建频率统计的HashMap
        // key: 数字, value: 该数字出现的次数
        Map<Integer, Integer> freq = new HashMap<>();

        // 第2行：遍历数组，统计每个数字的出现频率
        // 使用getOrDefault方法，如果数字不存在则返回0，存在则返回当前值
        for (int num : nums) {
            freq.put(num,freq.getOrDefault(num,0) + 1);
        }
        // 第3行：创建桶数组，索引代表频率，值是该频率对应的所有数字列表
        // 桶数组长度为 nums.length + 1，因为频率范围是[1, nums.length]
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        // 第4-7行：将数字放入对应的频率桶中
        for (Integer num : freq.keySet()) {
            int count = freq.get(num);// 获取该数字的频率
            if (buckets[count] == null) buckets[count] = new ArrayList<>();// 如果该频率桶为空，则初始化
            buckets[count].add(num);// 将数字添加到对应频率的桶中
        }
        // 第8行：创建结果数组，长度为k
        int[] res = new int[k];

        // 第9-13行：从高频率到低频率遍历桶，收集前k个高频元素
        // i从最高频率(buckets.length-1)向最低频率(0)遍历
        // idx记录结果数组的当前位置
        for (int i = buckets.length - 1, idx = 0; i >= 0 && idx < k; i--){
            if (buckets[i] != null){// 如果该频率桶不为空
                for (Integer num : buckets[i]) {// 遍历该桶中的所有数字
                    if (idx < k){
                        res[idx++] = num;// 如果还没收集够k个，就添加到结果中
                    }

                }
            }
        }
        return res;
    }
}
