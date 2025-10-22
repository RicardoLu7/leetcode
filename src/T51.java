import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T51 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 创建HashSet来存储字典中的单词
        // HashSet提供O(1)时间复杂度的查找操作
        Set<String> wordSet = new HashSet<>(wordDict);

        // dp数组：dp[i] 表示字符串s的前i个字符能否被拆分成字典中的单词
        // 数组长度为s.length() + 1，因为要考虑空字符串的情况
        boolean[] dp = new boolean[s.length() + 1];

        // 基础情况：空字符串可以被认为是可以拆分的（前0个字符）
        // 这是动态规划的起点
        dp[0] = true;

        // 外层循环：i从1遍历到s.length()
        // i表示当前考虑的前i个字符（子串s[0:i)）
        for (int i = 1; i <= s.length(); i++) {
            // 内层循环：j从0遍历到i-1
            // j表示一个可能的分割点，将前i个字符分成两部分：
            // - 前j个字符：s[0:j)
            // - j到i的字符：s[j:i)
            for (int j = 0; j < i; j++) {
                // 关键判断：
                // 1. dp[j]为true：表示前j个字符可以被拆分
                // 2. s.substring(j, i)在字典中：表示从j到i的子串是一个单词
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    // 如果两个条件都满足，说明前i个字符可以被拆分
                    dp[i] = true;
                    // 一旦找到一种拆分方式，就可以跳出内层循环
                    // 因为只要有一种方式能拆分就足够了
                    break;
                }
            }
        }
        // 返回整个字符串s能否被拆分
        // dp[s.length()]表示前s.length()个字符（即整个字符串）能否被拆分
        return dp[s.length()];
    }
}
