import java.util.Stack;

public class T56 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    //构造函数，初始化两个空栈
    //stack 用于正常存储数据
    //minStack 用于维护最小值信息
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        //将新值 val 压入主栈 stack
        stack.push(val);
        //minStack.isEmpty()：如果最小值栈为空（第一次push）
        //val <= getMin()：或者新值 ≤ 当前最小值
        if (minStack.isEmpty() || val <= getMin()){
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        //从主栈弹出栈顶元素并保存到变量 poped
        int poped = stack.pop();
        // 如果弹出的是最小值，minStack才弹出
        if (poped == getMin()){
            minStack.pop();
        }
    }

    public int top() {
        //返回主栈的栈顶元素（不弹出）
        return stack.peek();
    }

    public int getMin() {
        //返回最小值栈的栈顶元素，即当前栈中的最小值
        return minStack.peek();
    }
}
