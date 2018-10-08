import java.util.Scanner;
/**
 * Class for minimum heap.
 *
 * @param      <E>   Generics Variables.
 */
class MinHeap<E> {
    /**
     * Comparable array.
     */
    private Comparable[] data;
    /**
     * Size of array.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      values  The values
     */
    MinHeap(final Comparable[] values) {
        data = values;
        size = 0;
    }
    /**
     * Determines if heap.
     *
     * @return     True if heap, False otherwise.
     */
    public Boolean isHeap() {
        for (int i = 0; i < (data.length - 1) / 2
            && (2 * i + 2 <= data.length - 1); i++) {
            if (data[i].compareTo(data[2 * i + 1]) > 0
                || data[i].compareTo(data[2 * i + 2]) > 0) {
                return false;
            }
        }
        return true;
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
        String datatype = sc.nextLine();
        int lines = sc.nextInt();
        int i = 0;
        sc.nextLine();
        switch (datatype) {
            case "Double":
                while (i < lines) {
                    // if(sc.next().equals(""))
                    int j = 0;
                    String data = sc.nextLine();
                    if (data.equals("")) {
                        System.out.println("false");
                        break;
                    }
                    String[] datas = data.split(",");
                    Double[] d = new Double[datas.length];
                    for (String st : datas) {
                        d[j] = Double.parseDouble(st);
                        j++;
                    }
                    MinHeap<Double> mh = new MinHeap(d);
                    System.out.println(mh.isHeap());
                    i++;
                }
            case "Integer":
                while (i < lines) {
                    int j = 0;
                    String data = sc.nextLine();
                    String[] datas = data.split(",");
                    Integer[] d = new Integer[datas.length];
                    for (String st : datas) {
                        d[j] = Integer.parseInt(st);
                        j++;
                    }
                    MinHeap<Integer> mh = new MinHeap(d);
                    System.out.println(mh.isHeap());
                    i++;
                }
            case "Float":
                while (i < lines) {
                    int j = 0;
                    String data = sc.nextLine();
                    if (data.equals("")) {
                        System.out.println("false");
                        break;
                    }
                    String[] datas = data.split(",");
                    Float[] d = new Float[datas.length];
                    for (String st : datas) {
                        d[j] = Float.parseFloat(st);
                        j++;
                    }
                    MinHeap<Float> mh = new MinHeap(d);
                    System.out.println(mh.isHeap());
                    i++;
                    // System.out.println(":"+sc.hasNext());
                    if (!sc.hasNext()) {
                        // System.out.println("false");
                        break;
                    }
                }
            case "String":
                while (i < lines) {
                    int j = 0;
                    String data = sc.nextLine();
                    if (data.equals("")) {
                        System.out.println("false");
                        break;
                    }
                    String[] datas = data.split(",");
                    MinHeap<String> mh = new MinHeap(datas);
                    System.out.println(mh.isHeap());
                    i++;
                }
            default:
            break;
        }
    }
}