class Stack {
    
    char[] data = new char[500];
    int top = -1;
    public void push(char input) {
        top++;
        data[top] = input;
    }

    public char pop() {
        char r = data[top];
        top--;
        return r;
    }
    public int size() {
        return top+1;
    }
    public String print() {
        String s = "";
        for(int i = 0; i <= top; i++) {
            s = s + (data[i]);
        }
        return s;
    }
}