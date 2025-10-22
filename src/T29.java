import java.util.ArrayList;
import java.util.List;

public class T29 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), n, n, result);
        return result;
    }

    private void backtrack(StringBuilder current, int left, int right, List<String> result) {
        if (left == 0 && right == 0){
            result.add(current.toString());
            return;
        }
        if (left > 0){
            //添加一个左括号到当前字符串
            current.append('(');
            //递归调用，左括号数量减1，继续构建
            backtrack(current, left - 1, right, result);
            //删除最后添加的字符，恢复到添加前的状态，以便尝试其他可能性
            current.deleteCharAt(current.length() - 1);
        }
        //只有当右括号剩余数量大于左括号剩余数量时才能添加右括号
        //这确保了任何时候右括号都不会超过左括号的数量
        if (right > left){
            current.append(')');
            backtrack(current, left, right - 1, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
