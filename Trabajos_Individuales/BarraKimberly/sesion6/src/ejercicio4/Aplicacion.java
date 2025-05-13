package ejercicio4;

import ejercicio1.StackLink;

public class Aplicacion  {

    public static boolean symbolBalancing(String s) {
        StackLink<Character> stack = new StackLink<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                try {
                    char top = stack.pop();
                    if (!isMatchingPair(top, c)) {
                        return false;
                    }
                } catch (ExceptionIsEmpty e) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
