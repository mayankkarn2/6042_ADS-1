class Storage {
	private Student[] students;
	private int size;
	private int[] totals;

	Storage() {
		students = new Student[50];
		size = 0;
		totals = new int[50];
	}

	public void addStudent(Student s) {
		students[size] = s;
		totals[size] = s.getTotal();
		size++;
	}

	public Student[] meritOrder() {
		//Sort by Total
		for(int i = 0; i < size; i++) {
			for(int j = i+1; j < size; j++) {
				if(students[j].getTotal() > students[i].getTotal()) {
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
		//Sort by Subject 3
		int i = 0;
		while(i < size-1) {
			int j = i+1;
			while(students[i].getTotal() == students[j].getTotal()) {
				j++;
			}
			for(int k = i; k < j; k++) {
				for(int l = i+1; l < j; l++) {
					if(students[l].getSub3() > students[k].getSub3()) {
						Student temp = students[k];
						students[k] = students[l];
						students[l] = temp;
					}
				}
			}
			i++;
		}
		// //Sort by subject 2
		// i = 0;
		// while(i < size-1) {
		// 	int j = i+1;
		// 	while(students[i].getTotal() == students[j].getTotal()) {
		// 		j++;
		// 	}
		// 	for(int k = i; k < j; k++) {
		// 		for(int l = i+1; l < j; l++) {
		// 			if(students[l].getSub2() > students[k].getSub2()) {
		// 				Student temp = students[k];
		// 				students[k] = students[l];
		// 				students[l] = temp;
		// 			}
		// 		}
		// 	}
		// 	i++;
		// }
		return students;
		//Sort by DOB
		// i = 0;
		// while(i < size-1) {
		// 	j = i+1;
		// 	while(students[i].getTotal() == students[j].getTotal()) {
		// 		j++;
		// 	}
		// 	for(int k = i; k < j; k++) {
		// 		for(int l = i+1; l < j; l++) {
		// 			if(students[l].getSub2() > students[k].getSub2()) {
		// 				Student temp = students[k];
		// 				students[k] = students[l];
		// 				students[l] = temp;
		// 			}
		// 		}
		// 	}
		// 	i++;
		// }
	}

	public void printStudents() {
		for(int i = 0; i < size; i++) {
			System.out.print(students[i].getName()+",");
			System.out.print(students[i].getTotal()+",");
			System.out.println(students[i].getCat());
		}
		System.out.println();
	}
}