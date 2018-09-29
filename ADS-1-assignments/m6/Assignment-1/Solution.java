import java.util.Scanner;
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {
        //Nothing happens here.
    }
    /**
     * Converts numbers to Linked Lists.
     *
     * @param      number  The number
     *
     * @return     Linked Lists of numbers.
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList num = new LinkedList();
        for (int i = 0; i < number.length(); i++) {
            num.addAtHead(number.charAt(i));
        }
        return num;
    }
    /**
     * Converts digits to Number.
     *
     * @param      list  The list
     *
     * @return     String value of digits.
     */
    public static String digitsToNumber(final LinkedList list) {
        StringBuilder sb = new StringBuilder(list.returnNumber(list));
        return sb.reverse().toString();
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1 of numbers
     * @param      list2  The list 2 of numbers
     *
     * @return     Add value in a Linked list
     */
    public static LinkedList addLargeNumbers(final LinkedList list1,
        final LinkedList list2) {
        String first = digitsToNumber(list1);
        String second = digitsToNumber(list2);
        Stack one = new Stack();
        Stack two = new Stack();
        Stack carry = new Stack();
        int difference = first.length() - second.length();
        if (difference < 0) {
            difference = -1 * (difference);
        }
        if (first.length() - second.length() > 0) {
            for (int i = 0; i < first.length(); i++) {
                one.push(first.charAt(i));
            }
            for (int i = 0; i < difference; i++) {
                two.push('0');
            }
            for (int i = 0; i < second.length(); i++) {
                two.push(second.charAt(i));
            }
        } else if (first.length() - second.length() == 0) {
            for (int i = 0; i < first.length(); i++) {
                one.push(first.charAt(i));
                // System.out.println("hi");
            }
            for (int i = 0; i < second.length(); i++) {
                two.push(second.charAt(i));
            }
        } else {
            for (int i = 0; i < difference; i++) {
                one.push('0');
            }
            for (int i = 0; i < first.length(); i++) {
                one.push(first.charAt(i));
            }
            for (int i = 0; i < second.length(); i++) {
                two.push(second.charAt(i));
            }
        }
        // one.print();
        // two.print();
        carry.push('0');
        Stack res = new Stack();
        while (one.size() != 0) {
            int n1 = Integer.parseInt(String.valueOf(one.pop()));
            // System.out.println("n1:"+n1);
            int n2 = Integer.parseInt(String.valueOf(two.pop()));
            int sum = n1 + n2 + Integer.parseInt(String.valueOf(carry.pop()));
            // System.out.println("sum"+sum);
            // System.out.println("n2:"+n2);
            if (one.size() == 0) {
                String s = Integer.toString(sum);
                // System.out.println(s);
                for (int i = s.length() - 1; i >= 0; i--) {
                    res.push(s.charAt(i));
                }
            } else {
                final int ten = 10;
                res.push(Character.forDigit(sum % ten, ten));
                // System.out.println(Character.forDigit(sum % 10, 10));
                carry.push(Character.forDigit(sum / ten, ten));
                // System.out.println(Character.forDigit(sum / 10, 10));
                // System.out.println("--------------------------------------");
            }
        }
        // res.print();
        StringBuilder sbs = new StringBuilder(res.print());
        // System.out.println(res.print());
        String result = sbs.reverse().toString();
        LinkedList ret = AddLargeNumbers.numberToDigits(result);
        return ret;
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
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(
                    pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
            default:
                break;
        }
    }
}
