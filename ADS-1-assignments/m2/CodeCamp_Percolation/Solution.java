// public class Percolation {
//    public Percolation(int n)
//    public    void open(int row, int col)
//    public boolean isOpen(int row, int col)
//    public boolean isFull(int row, int col)
//    public     int numberOfOpenSites()
//    public boolean percolates()
// }


// You can implement the above API to solve the problem

import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * size of grid.
     */
    private int size;
    /**
     * sites to store open values.
     */
    private int[] sites;
    /**
     * Names of the sites.
     */
    private int[] id;
    /**
     * count of the open sites.
     */
    // private int count = 0;
    /**
     * Constructs the object.
     *
     * @param      n     size of the grid
     */
    Percolation(final int n) {
        size = n;
        sites = new int[n * n + 2];
        id = new int[n * n + 2];
        int count = 1;
        for (int i = 0; i < size * size + 2; i++) {
            id[i] = count++;
        }
    }
    /**
     * Unions the two sites if q is open.
     *
     * @param      p     First site
     * @param      q     Second site
     */
    public void union(final int p, final int q) {
        int pid = id[p];
        int qid = id[q];
        if (isOpen(q)) {
            for (int i = 0; i < size * size; i++) {
                if (id[i] == qid) {
                    id[i] = pid;
                }
            }
        }
    }
    /**
     * Returns true if their if path between sites.
     *
     * @param      i     First site
     * @param      j     Second site
     *
     * @return     Returns True or False
     */
    public Boolean connected(final int i, final int j) {
        return (id[i] == id[j]);
    }
    /**
     * Determines if open.
     *
     * @param      index  The index
     *
     * @return     True if open, False otherwise.
     */
    public Boolean isOpen(final int index) {
        // System.out.println(index);
        // System.out.println(sites[index] == 1);
        return sites[index] == 1;
    }
    /**
     * Opens the site and unions its adjacent sites if open.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void  open(final int row, final int col) {
        int index = ((row - 1) * size + col) - 1;
        sites[index] = 1;
        sites[size * size + 1] = 1;
        sites[size * size] = 1;
        //For first row
        if (index > 0 && index < size - 1) {
            union(index, index - 1);
            union(index, index + 1);
            union(index, index + size);
        } else if ((index % size == 0) &&(index>0) && (index < size * size - size)) {
            // System.out.println("Hello");
            //For first column
            union(index, index + 1);
            union(index, index + size);
            union(index, index-size);
        } else if(index % size == size - 1 && (index > size)&& (index < size * size - 1) ) {
            //For Last column
            union(index, index - 1);
            union(index, index + size);
            union(index, index - size); 
        } else if(index > (size * size - size)  && index < (size * size) - 1) {
            //For Last row
            union(index, index - size);
            union(index, index - 1);
            union(index, index + 1);
        } else if(index == 0) {
            //For UpperLeft corner
            // System.out.println("Here");
            union(index, index + 1);
            union(index, index + size);
        } else if(index == size - 1) {
            //For UpperRight corner
            union(index, index - 1);
            union(index, index + size);
        } else if(index == (size * (size - 1))) {
            //For BottomLeft Corner
            // System.out.println("Hi");
            union(index, index + 1);
            union(index, index - size);
        } else if(index == (size * size) - 1) {
            //For BottomRight Corner
            union(index, index - 1);
            union(index, index - size);
        } else {
            union(index, index - 1);
            union(index, index + 1);
            union(index, index - size);

            union(index, index + size);
        }
        // count++;
        // System.out.println(Arrays.toString(id));
        // System.out.println(Arrays.toString(sites));
    }
    /**
     * Returns True if percolation occurs, else False
     *
     * @return     Boolean, True or False
     */
    public Boolean percolates() {
        // System.out.println(Arrays.toString(id));
        int c = 0;
        // for(int i = 0; i < size * size; i++) {
        //  if(c % size == size - 1) {
        //      c = 0;
        //      System.out.println(id[i]);
        //      System.out.println();
        //  }
        //  System.out.print(id[i] + " ");
        //  c++;
        // }
        if(size == 1) {
            if(sites[size] == 1) {
                return true;
            }
            return false;
        }
        else {
            for (int i = 0; i < size; i++) {
                union(size * size, i);
                // System.out.println(Arrays.toString(id));
                for( int j = ((size*size) - size) - 1; j < size*size; j++) {
                    if (isOpen(j) && id[j] == id[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * The main function
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
