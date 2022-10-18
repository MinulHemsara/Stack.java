class stack {
    int top;
    char[] data;

    public stack() {
        top = -1;
        data = new char[6];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == (data.length) - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(char value) {
        if (isFull() == false) {
            data[++top] = value;
        } else {
            System.out.println("Stack is Full");
        }
    }

    public char peek() {
        return data[top];
    }

    public char pop() {
        if (isEmpty() == false) {
            return data[top--];
        } else {
            return 'g';
        }
    }

}
public class Main {
    public static void main(String[] args) {
            String expression = "{()}[]";
            stack st = new stack();
            for (int i = 0; i < expression.length();i++){
                if (expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '('){
                    st.push(expression.charAt(i));
                } else if (!st.isEmpty()&& (
                        (expression.charAt(i) == ']' && st.peek() == '[')||
                                (expression.charAt(i) == '}' && st.peek() == '{') ||
                                (expression.charAt(i) == ')' && st.peek() == '('))){
                    st.pop();
                }else {
                    st.push(expression.charAt(i));
                }
                }
            if (st.isEmpty()){
                System.out.println("Balanced");
            }else {
                System.out.println("Not Balanced");
            }
            }
}
