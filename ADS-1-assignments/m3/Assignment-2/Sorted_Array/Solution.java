import java.util.*;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size1 = s.nextInt();
		int size2 = s.nextInt();
		int main = size1 + size2;
		s.nextLine();
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		String str1 = s.nextLine();
		String[] sarr1 = str1.split(",");
		String str2 = s.nextLine();
		String[] sarr2 = str2.split(",");
		for(int i = 0; i < size1; i++) {
			arr1[i] = Integer.parseInt(sarr1[i]);
		}
		for(int i = 0; i < size2; i++) {
			arr2[i] = Integer.parseInt(sarr2[i]);
		}
		int[] last = new int[size1 + size2];
		for(int i = 0; i < size1; i++) {
			last[i] = arr1[i];
		}
		int j = 0;
		int i = size1;
		for(j = 0, i = size1; j < size2; i++, j++) {
			last[i] = arr2[j];
		}
		Arrays.sort(last);
		System.out.println(Arrays.toString(last).replace("[","").replace("]","").replace(" ",""));
	}
}