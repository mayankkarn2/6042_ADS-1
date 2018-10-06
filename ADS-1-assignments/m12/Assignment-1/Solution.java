import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int lines = s.nextInt();
		int vacancies = s.nextInt();
		int unreserved = s.nextInt();
		int bcVac = s.nextInt();
		int scVac = s.nextInt();
		int stVac = s.nextInt();
		int i = 0;
		s.nextLine();
		Storage store = new Storage();
		while(i < lines) {
			String data = s.nextLine();
			String[] datas = data.split(",");
			store.addStudent(new Student(datas[0],datas[1],Integer.parseInt(datas[2]),Integer.parseInt(datas[3]),Integer.parseInt(datas[4]), datas[6]));
			i++;
		}
		Student[] merit = store.meritOrder();
		Student[] result = new Student[vacancies];
		store.printStudents();
		int k = 0;
		for(i = 0; i < unreserved; i++) {
			result[k] = merit[i];
			merit[i].setInc("INC");
			k++;
		}
		int count = 0;
		for(i = 0; i < merit.length; i++) {
			if(count == bcVac) break;
			if(merit[i].getCat().equals("BC") && merit[i].getInc().equals("n")) {
				result[k] = merit[i];
				count++;
				k++;
			}
		}
		count = 0;
		for(i = 0; i < merit.length; i++) {
			if(count == scVac) break;
			if(merit[i].getCat().equals("SC") && merit[i].getInc().equals("n")) {
				result[k] = merit[i];
				count++;
				k++;
			}
		}
		count = 0;
		for(i = 0; i < merit.length; i++) {
			if(count == stVac) break;
			if(merit[i].getCat().equals("ST") && merit[i].getInc().equals("n")) {
				result[k] = merit[i];
				count++;
				k++;
			}
		}
		System.out.println(k);
		for(i = 0; i < k; i++) {
			for(int j = i+1; j < k; j++) {
				if(result[j].getTotal() > result[i].getTotal()) {
					Student temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		for(i = 0; i < k; i++) {
			System.out.print(result[i].getName()+",");
			System.out.print(result[i].getTotal()+",");
			System.out.println(result[i].getCat());
		}
	}
}