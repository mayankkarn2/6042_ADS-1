import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
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
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = s.nextInt();
        }
        Arrays.sort(numbers);
        // System.out.println(Arrays.toString(numbers));
        int count = 0;
        int j;
        int k;
        for (int i = 0; i < size - 2; i++) {
            j = i + 1;
            k = size - 1;
            while (j < k) {
                // System.out.println("here");
                if (numbers[i] + numbers[j] + numbers[k] == 0) {
                    // System.out.println("count lo");
                    count++;
                    j++;
                    k--;
                } else if (numbers[i] + numbers[j] + numbers[k] <    0) {
                    // System.out.println("In j");
                    j++;
                } else {
                    // System.out.println("In k");
                    k--;
                }
            }
        }
        System.out.println(count);
    }
}