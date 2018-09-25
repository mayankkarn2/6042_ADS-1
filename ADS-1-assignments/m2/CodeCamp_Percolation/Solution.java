// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem

import java.util.*;

class Percolation {

	int size;
	int[] sites;
	int[] id;
	int count = 0;
	Percolation(){

	}
	Percolation(int n) {
		size = n;
		sites = new int[n*n + 2];
		// System.out.println(Arrays.toString(sites));
		id = new int[n*n + 2];
		int count = 1;
		for(int i = 0; i < size * size + 2; i++) {
			id[i] = count++;
		}
		// System.out.println(Arrays.toString(id));
		// for(int i = 0; i < n-1; i++) {
		// 	union(i, id[(n*n)-1]);
		// }
		// for(int i = (n*n - size) - 1; i < n * n; j++) {
		// 	union(i, id[n*n]);
		// }
	}
	public void union(int p, int q) {
		// System.out.println(p + ":" +q);
		if(isOpen(q)) {
			id[p] = id[q];
		}
	}

	public int find(int i) {
		int key = id[i];
		// System.out.println("my key "+key);
		// System.out.println("my eye "+i);
		// System.out.println("my id[i] "+id[i]);
		while(id[i] == key) {
			i = key;
		}
		return i;
	}

	public Boolean isOpen(int index) {
		// System.out.println(index);
		return id[index] == 1;
	}

	public void  open(int row, int col) {
		int index = ((row-1) * size + col) - 1;
		// System.out.println("index:"+index);
		//For first row
		sites[index] = 1;
		sites[size*size+1]=1;
		sites[size*size]=1;
		// System.out.println(Arrays.toString(sites));
		if(index > 0 && index < size-1) {
			// System.out.println("row one");
			union(index, index - 1);
			union(index, index+1);
			union(index, index+size);
		}
		//For first column
		else if((index % size == 0) &&(index>0)&& (index < size*size -size)) {
			// System.out.println("first coll");
			union(index, index+1);
			union(index, index + size);
			union(index, index-size);
		}
		//For Last column
		else if(index % size == size - 1 && (index>size)&& (index < size*size - 1) ) {
			union(index, index -1);
			// System.out.println("laaastttttttt col");
			union(index, index + size);
			union(index, index - size);	
		}
		//For Last row
		// System.out.printlnSystem.out.println("one");
		// ("one");
		else if(index > (size * size - size)  && index < (size * size) - 1) {
			// System.out.println("last row");
			union(index, index - size);
			union(index, index - 1);
			union(index, index + 1);
		}
		//For UpperLeft corner
		else if(index == 0) {
			// System.out.println("UpperLeft");
			union(index, index + 1);
			union(index, index + size);
		}
		//For UpperRight corner
		else if(index == size - 1) {
			// System.out.println("UpperRight");
			union(index, index - 1);
			union(index, index + size);
		}
		//For BottomLeft Corner
		else if(index == (size * (size - 1))) {
			union(index, index + 1);
// System.out.println("BottomLeft");
			union(index, index - size);
		}
		//For BottomRight Corner
		else if(index == (size*size)-1) {
// System.out.println("BottomRight");
			union(index, index-1);
			union(index, index-size);
		}
		else {
			union(index, index - 1);
			union(index, index + 1);
			union(index, index - size);
			// System.out.println("others");

			union(index, index + size);
		}
		count++;
		// System.out.println(Arrays.toString(id));
	}

	public Boolean percolates() {
		// System.out.println("nenu ochesa");
		// System.out.println("my size ==="+size);
		for(int i = 0; i < size; i++) {
			// System.out.println("\ni robo = "+ i);

			union(id[(size*size)],i);
			// System.out.println("\nevry loop "+Arrays.toString(id));
		// System.out.println("every sites"+Arrays.toString(sites));

		}
		// System.out.println("\npercilste "+Arrays.toString(id));
		// System.out.println("percilste sites"+Arrays.toString(sites));
		for(int i = (size*size - size); i < size * size; i++) {
			// System.out.println("my bobo = " + i);
			union(id[size*size],i);
		}
		// System.out.println("wewr "+Arrays.toString(id));
		// System.out.println("my s *s "+size*size);
		// System.out.println("percilste sites"+Arrays.toString(sites));
		// System.out.println("sites size sites"+sites.length);
		return find(size*size) != find(size*size+1);
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String grid = s.nextLine();
		Percolation p = new Percolation(Integer.parseInt(grid));
		while(s.hasNext()) {
			String input = s.nextLine();
			String[] val = input.split(" ");
			p.open(Integer.parseInt(val[0]), Integer.parseInt(val[1]));
		}
		Percolation pp = new Percolation();
		// System.out.println("Hi");
		System.out.println(p.percolates());
		// System.out.println("nenu ranu");
	}
}
