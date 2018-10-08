import java.util.Scanner;
import java.util.Arrays;
class MinHeap<E> {
	Comparable[] data;
	int size;
	MinHeap(Comparable[] values) {
		data = values;
		size = 0;
		// System.out.println(Arrays.toString(data));
	}
	public Boolean isHeap() {
		// System.out.println(data.length);
		for(int i = 0; i < (data.length-1)/2 && (2*i+2 <= data.length-1); i++) {
			// System.out.println("---------");
			// System.out.println(data[i]);
			// System.out.println(data[2*i+1]);
			// System.out.println(data[2*i+2]);
			// System.out.println(data[i].compareTo(data[2*i+2]));
			if(data[i].compareTo(data[2*i+1]) > 0 || data[i].compareTo(data[2*i+2]) > 0) {
				return false;
			}
		}
		return true;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String datatype = sc.nextLine();
		int lines = sc.nextInt();
		int i = 0;
		sc.nextLine();
		switch (datatype) {
			case "Double":
				while(i < lines) {
					int j = 0;
					String data = sc.nextLine();
					String[] datas = data.split(",");
					Double[] d = new Double[datas.length];
					for(String st : datas) {
						d[j] = Double.parseDouble(st);
						j++;
					}
					MinHeap<Double> mh = new MinHeap(d);
					System.out.println(mh.isHeap());
					i++;
				}
			case "Integer":
				while(i < lines) {
					int j = 0;
					String data = sc.nextLine();
					String[] datas = data.split(",");
					Integer[] d = new Integer[datas.length];
					for(String st : datas) {
						d[j] = Integer.parseInt(st);
						j++;
					}
					MinHeap<Integer> mh = new MinHeap(d);
					System.out.println(mh.isHeap());					
					i++;
				}
			case "Float":
				while(i < lines) {
					int j = 0;
					String data = sc.nextLine();
					String[] datas = data.split(",");
					Float[] d = new Float[datas.length];
					for(String st : datas) {
						d[j] = Float.parseFloat(st);
						j++;
					}
					MinHeap<Float> mh = new MinHeap(d);
					System.out.println(mh.isHeap());
					i++;
				}
			case "String":
				while(i < lines) {
					int j = 0;
					String data = sc.nextLine();
					String[] datas = data.split(",");
					MinHeap<String> mh = new MinHeap(datas);
					System.out.println(mh.isHeap());
					i++;
				}
		}
	}
}