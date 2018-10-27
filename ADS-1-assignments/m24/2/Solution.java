import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * Roll No.
     */
    private String rollNo;
    /**
     * Name.
     */
    private String name;
    /**
     * Marks.
     */
    private Double marks;
    /**
     * Constructs the object.
     *
     * @param      r     { parameter_description }
     * @param      n     { parameter_description }
     * @param      m     { parameter_description }
     */
    Student(final String r, final String n, final Double m) {
        this.rollNo = r;
        this.name = n;
        this.marks = m;
    }
    /**
     * Gets the roll no.
     *
     * @return     The roll no.
     */
    public String getRollNo() {
        return rollNo;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public Double getMarks() {
        return marks;
    }
}
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Nothing happens here.
    }
    /**
     * The main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        BinarySearchST<Double, Student> bs = new BinarySearchST<Double, Student>();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] inputs = sc.nextLine().split(",");
            bs.put(Double.valueOf(inputs[2]), new Student(inputs[0], inputs[1],
                Double.valueOf(inputs[2])));
        }
        int n = sc.nextInt();
    	sc.nextLine();
    	for(int i = 0; i < n; i++) {
    		String[] inputs = sc.nextLine().split(" ");
    		switch(inputs[0]) {
    			case "BE":
    			Iterable<Double> q = bs.keys(Double.valueOf(inputs[1]),Double.valueOf(inputs[1]));
    			for(Double d : q) {
    				System.out.println(bs.get(d).getName());
    			}
    		}
    	}
    }
}