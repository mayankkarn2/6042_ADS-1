import java.util.Scanner;
class Stack {
	
	String[] data = new String[2000];
	int top = -1;
	public int push(char input) {
		// System.out.println("i:"+input);
		String val = Character.toString(input);
		if(top == -1) {
			if(val.equals("(") || val.equals("[") || val.equals("{")) {
				top++;
				data[top] = val;
				return 1;
			} 
			else {
				// System.out.println("hi");
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
			// System.out.println("here");
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
		// System.out.println("h"+data[top]);
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
			int flag = 1;
			st.top = -1;
			inputs = s.nextLine();
			// System.out.println(inputs);
			for(int j = 0; j < inputs.length(); j++) {
				int f = st.push(inputs.charAt(j));
				if(f == 0) {
					System.out.println("NO");
					break;
				}
				if(j == inputs.length()-1 && st.top == -1) {
					System.out.println("YES");
					break;
				}
				// else {
				// 	System.out.println("NO");
				// }
			}
			i++;
		}
		i = 0;
	}
}