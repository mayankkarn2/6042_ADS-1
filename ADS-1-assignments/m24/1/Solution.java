import java.util.Scanner;
import java.util.HashMap; 
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
/**
 * Class for solution.
 */
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
        HashMap<String, Student> hm = new HashMap<String, Student>();
        sc.nextLine();
        for(int i = 0; i < m; i++) {
            String[] inputs = sc.nextLine().split(",");
            hm.put(inputs[0], new Student(inputs[0],inputs[1],
                Double.valueOf(inputs[2])));
        }
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] inputs = sc.nextLine().split(" ");
            switch(inputs[2]) {
                case "1":
                Student s = (hm.get(inputs[1]));
                if (s == null) {
                    System.out.println("Student doesn't exists...");
                    break;
                }
                System.out.println(s.getName());
                break;
                case "2":
                Student st = hm.get(inputs[1]);
                if (st == null) {
                    System.out.println
                    ("Student doesn't exists...");
                    break;
                }
                System.out.println(st.getMarks());
                break;
                default:
                break;
            }
        }
    }
}