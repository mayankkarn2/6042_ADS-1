import java.util.Scanner;

class Book implements Comparable<Book> {

    private String name;
 
    private String author;

    private double price;

    Book(final String bookName, final String authorName,
         final double cost) {
        this.name = bookName;
        this.author = authorName;
        this.price = cost;
    }

    public String getName() {
        return this.name;
    }

    public int compareTo(final Book obj) {
        return this.getName().compareTo(obj.getName());
    }
    public String toString() {
        return this.name + ", " + this.author + ", "
               + this.price;
    }
}

class BinarySearchT<Key extends Comparable<Key>, Values> {

    private Node root;

    class Node {

        private Key key;

        private Values value;

        private Node right;

        private Node left;

        private int size;

        Node(final Key key1, final Values val, final int size1) {
            this.key = key1;
            this.value = val;
            this.size = size1;
        }

    }

    public void put(final Key key, final Values value) {
        if (key == null) {
            return;
        }
        root = put(root, key, value);
    }

    public Node put(final Node node, final Key key,
                    final Values value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp < 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.size = 1 + size(node.left) - size(node.right);
        return node;
    }

    public Values get(final Key key) {
        return get(root, key);
    }

    private Values get(final Node node, final Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp < 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(final Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.right);
        }
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(final Node node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    public Key floor(final Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node floor(final Node node, final Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp <  0) {
            return floor(node.left, key);
        }
        Node t = floor(node.right, key);
        if (t != null) {
            return t;
        } else {
            return node;
        }
    }

    public Key ceiling(final Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node ceiling(final Node node, final Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            Node t = ceiling(node.left, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        }
        return ceiling(node.right, key);
    }

    public Key select(final int k) {
        Node node = select(root, k);
        return node.key;
    }

    public int size() {
        return size(root);
    }

    private int size(final Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    private Node select(final Node node, final int k) {
        if (node == null) {
            return null;
        }
        int t = size(node.left);
        if      (t > k) {
            return select(node.left,  k);
        } else if (t < k) {
            return select(node.right, k - t - 1);
        } else {
            return node;
        }
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(final Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(final Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(final Key key) {
        root = delete(root, key);
    }

    private Node delete(final Node node, final Key key) {
        Node temp = node;
        if (temp == null) {
            return null;
        }

        int cmp = key.compareTo(temp.key);
        if      (cmp < 0) {
            temp.left  = delete(temp.left,  key);
        } else if (cmp > 0) {
            temp.right = delete(temp.right, key);
        } else {
            if (temp.right == null) {
                return temp.left;
            }
            if (temp.left  == null) {
                return temp.right;
            }
            Node tempNode = temp;
            temp = min(tempNode.right);
            temp.right = deleteMin(tempNode.right);
            temp.left = tempNode.left;
        }
        temp.size = size(temp.left) + size(temp.right) + 1;
        return temp;
    }

}

final class Solution {

    private Solution() {

    }

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchT<Book, Integer> obj = new BinarySearchT<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                obj.put(new Book(tokens[1], tokens[2], Double.parseDouble(
                                     tokens[2 + 1])),
                        Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                System.out.println(obj.get(new Book(
                                               tokens[1], tokens[2],
                                               Double.parseDouble(
                                                   tokens[2 + 1]))));
                break;
            case "max":
                System.out.println(obj.max());
                break;
            case "min":
                System.out.println(obj.min());
                break;
            case "floor":
                System.out.println(obj.floor(
                                       new Book(tokens[1], tokens[2],
                                                Double.parseDouble(
                                                    tokens[2 + 1]))));
                break;
            case "ceiling":
                System.out.println(obj.ceiling(
                                       new Book(tokens[1], tokens[2],
                                                Double.parseDouble(
                                                    tokens[2 + 1]))));
                break;
            case "select":
                System.out.println(obj.select(Integer.parseInt(tokens[1])));
                break;
            case "delete":
                obj.delete(new Book(tokens[1], tokens[2], Double.parseDouble(
                                        tokens[2 + 1])));
                break;
            case "deleteMax":
                obj.deleteMax();
                break;
            case "deleteMin":
                obj.deleteMin();
                break;
            default:
                break;
            }
        }
    }
}