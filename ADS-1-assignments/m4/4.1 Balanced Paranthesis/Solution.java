import java.util.Scanner;
class Stack {
	
	String[] data = new String[2000];
	int top = -1;
	public int push(char input) {
		String val = Character.toString(input);
		if(top == -1) {
			if(val.equals("(") || val.equals("[") || val.equals("{")) {
				top++;
				data[top] = val;
				return 1;
			} 
			else {
				return 0;
			}
		} 
		switch(val) {
			case "(":
			if(data[top].equals("(") || data[top].equals("[") || data[top].equals("{") ) {
				top++;
				data[top] = val;
				return 1;
			}
			return 0;
			case ")":
			if(data[top].equals("(")) {
				pop();
				return 1;
			}
			return 0;
			case "[":
			if(data[top].equals("(") || data[top].equals("[") || data[top].equals("{")) {
				top++;
				data[top] = val;
				return 1;
			}
			return 0;
			case "]":
			if(data[top].equals("[")) {
				pop();
				return 1;
			}
			return 0;
			case "{":
			if(data[top].equals("(") || data[top].equals("[") || data[top].equals("{")) {
				top++;
				data[top] = val;
				return 1;
			}
			return 0;
			case "}":
			if(data[top].equals("{")) {
				pop();
				return 1;
			}
			return 0;
		}
		return 0;
	}

	public void pop() {
		top--;
	}
}
public class Solution {
	public static void main(String[] args) {
		Stack st = new Stack();
		Scanner s = new Scanner(System.in);
		int lines = s.nextInt();
		s.nextLine();
		int i = 0;
		while(i < lines) {
			String inputs = "";
			inputs = s.nextLine();
			for(int j = 0; j < inputs.length(); j++) {
				int f = st.push(inputs.charAt(j));
				if(f == 0) {
					System.out.println("NO");
					break;
				}
				if(j == inputs.length()-1) {
					if(st.top == -1) {
						System.out.println("YES");
						break;
					}
					else {
						System.out.println("NO");
						break;
					}
				}
			}
			i++;
		}
	}
}