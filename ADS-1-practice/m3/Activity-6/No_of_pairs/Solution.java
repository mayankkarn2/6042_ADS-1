import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = s.nextInt();
		}
		Arrays.sort(array);
		int count = 0;
		System.out.println("-----------------------");
		int i = 0;
		while(i < size - 2) {
			System.out.println("i:"+i);
			int j = i;
			int innerCount = 1;
			if(array[i] == array[i + 1] && array[i] == array[i + 2]) {
				innerCount += 2;
				j = j + 2;
				i = j;
			}
			else if(array[i] == array[i + 1]) {
				innerCount += 1;
				j = j + 1;
				i = j;
			}
			else {
				i = j;
				if(innerCount > 1) {
					count += ((innerCount * (innerCount - 1))/2);
				}
			}
			// System.out.println(count);
		}
		System.out.println(count);
	}
}