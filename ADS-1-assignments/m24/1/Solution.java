import java.util.Scanner;
import java.util.HashMap; 
import java.util.Map;
class Student {
	private String rollNo;
	private String name;
	private String marks;
	Student(String rollNo, String name, String marks) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}
	public String getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public String getMarks() {
		return marks;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		HashMap<String,Student> hm = new HashMap<String,Student>();
		sc.nextLine();
		for(int i = 0; i < m; i++) {
			String[] inputs = sc.nextLine().split(",");
			hm.put(inputs[0], new Student(inputs[0],inputs[1],inputs[2]));
		}
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			String inputs[] = sc.nextLine().split(" ");
			switch(inputs[2]) {
				case "1":
				Student s = (hm.get(inputs[1]));
				System.out.println(s.getName());
				break;
				case "2":
				Student st = hm.get(inputs[1]);
				System.out.println(st.getMarks());
			}
		}
	}
}