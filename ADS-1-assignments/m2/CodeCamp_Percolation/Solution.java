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
		id = new int[n*n + 2];
		int count = 1;
		for(int i = 0; i < size * size + 2; i++) {
			id[i] = count++;
		}
	}
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		if(isOpen(q)) {
			for(int i = 0; i < size * size; i++) {
				if(id[i] == qid) {
					id[i] = pid;
				}
			}
		}
	}
	public Boolean connected(int i, int j) {
		return(id[i] == id[j]);
	}

	public Boolean isOpen(int index) {
		// System.out.println(index);
		// System.out.println(sites[index] == 1);
		return sites[index] == 1;
	}

	public void  open(int row, int col) {
		int index = ((row-1) * size + col) - 1;
		sites[index] = 1;
		sites[size*size+1]=1;
		sites[size*size]=1;
		//For first row
		if(index > 0 && index < size-1) {
			union(index, index - 1);
			union(index, index+1);
			union(index, index+size);
		}
		//For first column
		else if((index % size == 0) &&(index>0)&& (index < size*size -size)) {
			// System.out.println("Hello");

			union(index, index+1);
			union(index, index + size);
			union(index, index-size);
		}
		//For Last column
		else if(index % size == size - 1 && (index>size)&& (index < size*size - 1) ) {
			union(index, index -1);
			union(index, index + size);
			union(index, index - size);	
		}
		//For Last row
		else if(index > (size * size - size)  && index < (size * size) - 1) {
			union(index, index - size);
			union(index, index - 1);
			union(index, index + 1);
		}
		//For UpperLeft corner
		else if(index == 0) {
			// System.out.println("Here");
			union(index, index + 1);
			union(index, index + size);
		}
		//For UpperRight corner
		else if(index == size - 1) {
			union(index, index - 1);
			union(index, index + size);
		}
		//For BottomLeft Corner
		else if(index == (size * (size - 1))) {
			// System.out.println("Hi");
			union(index, index + 1);
			union(index, index - size);
		}
		//For BottomRight Corner
		else if(index == (size*size)-1) {
			union(index, index-1);
			union(index, index-size);
		}
		else {
			union(index, index - 1);
			union(index, index + 1);
			union(index, index - size);

			union(index, index + size);
		}
		count++;
		// System.out.println(Arrays.toString(id));
		// System.out.println(Arrays.toString(sites));
	}

	public Boolean percolates() {
		// System.out.println(Arrays.toString(id));
		int c = 0;
		// for(int i = 0; i < size * size; i++) {
		// 	if(c % size == size - 1) {
		// 		c = 0;
		// 		System.out.println(id[i]);
		// 		System.out.println();
		// 	}
		// 	System.out.print(id[i] + " ");
		// 	c++;
		// }
		if(size == 1) {
			if(sites[size] == 1) {
				return true;
			}
			return false;
		}
		else {
			for(int i = 0; i < size; i++) {
				union(size * size, i);
				// System.out.println(Arrays.toString(id));
				for(int j = ((size*size) - size) - 1; j < size*size; j++) {
					if(isOpen(j) && id[j] == id[i]) {
						return true;
					}
				}
			}
		}
		return false;
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
		System.out.println(p.percolates());
	}
}
