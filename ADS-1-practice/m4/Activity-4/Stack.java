import java.util.Scanner;
class Stack {
	
	String[] data = new String[20];
	int top = -1;
	public void push(String input) {
		top++;
		data[top] = input;
	}

	public void pop() {
		System.out.println(data[top]);
		top--;
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		String str = "it was - the best - of times - - - it was - the - -";
		String[] inputs = str.split(" ");
		for(String input : inputs) {
			if(input.equals("-")) {
				s.pop();
			}
			else {
				s.push(input);
			}
		}
	}
}