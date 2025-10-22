import java.util.ArrayList;
import java.util.List;

public class T27 {
/*    作用：数字到字母的映射关系，数组索引对应数字
    特点：
    使用static final声明为常量，提高性能和内存效率
    数组索引直接对应数字（0-9）
    数字0和1对应空字符串（因为不表示任何字母）*/
    private static final String[] MAPPING = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
/*    输入验证：检查输入是否为null或空字符串
    初始化：创建结果列表和StringBuilder
    启动回溯：从第一个数字(index=0)开始回溯过程
    返回结果：回溯完成后返回所有组合*/
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
/*        作用：递归的终止条件
        逻辑：当index等于输入数字字符串的长度时，说明已经处理完所有数字
        操作：将当前构建的路径字符串添加到结果列表中，然后返回（结束当前递归分支）*/
        if (index == digits.length()){
            result.add(path.toString());
            return;
        }

/*        作用：获取当前位置的数字字符
        示例：如果digits = "23"且index = 0，则digit = '2'*/
        char digit = digits.charAt(index);

/*        作用：将数字字符转换为对应的字母字符串
        转换逻辑：digit - '0'将字符数字转换为整数值
        例如：'2' - '0' = 2
        查找映射：从MAPPING数组中获取对应的字母字符串
        例如：MAPPING[2] = "abc"*/
        String letters = MAPPING[digit - '0'];

/*        作用：遍历当前数字对应的所有字母
        转换：letters.toCharArray()将字符串转换为字符数组
        循环：对每个字母进行尝试
        例如：对于"abc"，会依次处理'a'、'b'、'c'*/
        for (char letter : letters.toCharArray()) {
/*            作用：将当前字母添加到路径中
            效果：构建当前组合的一部分
            示例：如果path = ""且letter = 'a'，则path = "a"*/
            path.append(letter);

/*            作用：递归调用自身，处理下一个数字
            参数变化：index + 1表示处理下一个位置
            递归深度：继续深入构建组合，直到满足终止条件*/
            backtrack(digits, index + 1, path, result);

/*            作用：撤销上一步的选择，为尝试下一个字母做准备
            操作：删除StringBuilder的最后一个字符
            重要性：这是回溯算法的核心，确保所有可能性都被探索
            示例：如果path = "a"，执行后path = ""*/
            path.deleteCharAt(path.length() - 1);
        }
    }
}
