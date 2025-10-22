import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t36 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 统计每个字符的出现次数
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                //c - 'a'：字符算术运算，将字符转换为0-25的索引
                //'a' - 'a' = 0，'b' - 'a' = 1，...，'z' - 'a' = 25
                //count[index]++：对应字母的计数加1
                count[c - 'a']++;
            }
            // 构建计数键：例如 "aab" -> "2#1#0#0...#0"
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append('#');
                keyBuilder.append(count[i]);
            }
            String key  = keyBuilder.toString();
            // 使用计数键分组
            //检查当前键是否已存在于HashMap中
            //如果不存在，创建新的空列表并放入HashMap
            //将当前字符串添加到对应的列表中
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        //map.values()：返回HashMap中所有值的集合（Collection<List<String>>）
        //new ArrayList<>(...)：转换为List<List<String>>类型返回
        //保证返回格式：即使输入为空，也返回空列表而不是null
        return new ArrayList<>(map.values());
    }
}
