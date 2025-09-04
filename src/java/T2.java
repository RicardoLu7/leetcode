package java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T2 {
    public static void main(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false; // 提前判断奇数长度

        char[] stack = new char[n];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[++top] = ')';
            } else if (c == '{') {
                stack[++top] = '}';
            } else if (c == '[') {
                stack[++top] = ']';
            } else {
                if (top == -1 || c != stack[top--]) {
                    return false;
                }
            }
        }

        return top == -1;
    }
}
