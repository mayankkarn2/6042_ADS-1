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
			int j = 0, f = 0;
			st.top = -1;
			for(j = 0; j < inputs.length(); j++) {
				f = st.push(inputs.charAt(j));
				if(f == 0) {
					System.out.println("NO");
					break;
				}
			}
			if(f!=0) {
				if(j == inputs.length() && st.top == -1) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");	
				}
			}
			i++;
		}
	}
}