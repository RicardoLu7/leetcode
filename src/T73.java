import java.util.Stack;

public class T73 {
    public String decodeString(String s) {
        // 数字栈：存储遇到的重复次数，如 "3[a]" 中的 3
        Stack<Integer> countStack = new Stack<>();
        // 字符串栈：存储遇到左括号时已经解码的部分
        Stack<StringBuilder> stringStack = new Stack<>();

        // current: 当前正在构建的字符串
        // 比如处理 "a2[c]" 时，current 会从 "a" 变成 "c" 再变成 "acc"
        StringBuilder current = new StringBuilder();

        // num: 当前正在解析的数字，用于处理多位数
        // 比如 "12[ab]" 需要把 1 和 2 组合成 12
        int num = 0;

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                // 如果是数字字符，构建完整数字
                // 比如遇到 "123"：
                // 第一次：0*10 + 1 = 1
                // 第二次：1*10 + 2 = 12
                // 第三次：12*10 + 3 = 123
                num = num * 10 + (c - '0');

            }else if(c == '['){
                // 遇到左括号，表示要开始处理嵌套内容
                // 保存当前状态到栈中，以便后续恢复
                countStack.push(num);// 保存重复次数
                stringStack.push(current);// 保存已解码部分

                // 重置状态，准备处理括号内的新内容
                num = 0; // 重置数字
                current = new StringBuilder(); // 重置当前字符串
            }else if (c == ']'){
                // 遇到右括号，进行解码操作
                int repeat = countStack.pop();    // 弹出重复次数
                StringBuilder temp = stringStack.pop(); // 弹出之前的字符串

                // 将当前字符串重复指定次数
                // 比如 repeat=3, current="a" → "aaa"
                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }
                // 更新当前字符串为解码后的结果
                current = temp;

            }else {
                // 普通字母字符（非数字、非括号）
                // 直接添加到当前正在构建的字符串中
                current.append(c);
            }
        }
        // 最终 current 中就是完全解码后的字符串
        return current.toString();
    }
}
