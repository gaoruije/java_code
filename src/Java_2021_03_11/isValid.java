package Java_2021_03_11;

import java.util.Stack;

public class isValid {
    // 题目要求：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //有效字符串需满足：左括号必须用相同类型的右括号闭合，左括号必须以正确的顺序闭合。
    // 基本思路：创建一个栈，遍历给定的所有的括号，要是见到左括号就放在栈的里边，要是见到右括号就和栈里边的栈顶元素
    // 进行比较。要是匹配就将栈顶元素出栈，继续遍历下一个元素，要是找到一个不配的就返回false，遍历完所有的括号后
    // 再对栈进行判定要是遍历完没有出现反例，并且栈是空的，就说明是括号匹配的
    public boolean isValid(String s) {
        // 1.首先手动创建一个栈，用来保存左右的左括号
        // 里边要填一个包装类，所以用到的是character包装类
        Stack<Character> stack = new Stack<>();
        // 2. 进行遍历字符串，要是见到左括号就入栈
        for (int i = 0; i < s.length(); i++) {// 字符串的长度操作是 .length操作
            char c = s.charAt(i);// 将字符串的每一个元素取出来，依次进行判定
            if (c == '(' || c == '[' || c == '{') {
                // 要是左括号就进行性入栈操作
                stack.push(c);
                // 出现做括号的时候要进行continue，进行下一轮的判定
                continue;
            }
            // 3.下边就表示是又括号了
            // 要是栈为空的话，就对应的是只要一个又括号的情况，直接返回false
            if (stack.isEmpty()) {
                return false;
            }
            // 4.取栈顶元素,并进行比较
            // 一定要注意：这里一定要进行出栈哦，不止止是取栈顶元素，要是只取不出栈里边的元素永远不会变化的
            char top = stack.pop();
            // 要是栈不是空的就进行匹配,每匹配一次就跳出,走下一次循环
            if (top == '(' && c == ')') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }
            if (top == '{' && c == '}') {
                continue;
            }
            // 要是上边的三种合法的情况都没有见到，则返回false
            return false;
        }
        // 5.等出了循环后，对栈进行判空，要是栈是空的就返回true，否则返回false
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
