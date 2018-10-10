class Solution {
	static class Node {
		int data;
		Node next;
	}
	static Node head, tail;

	public static void insertAtHead(int value) {
		Node node = new Node();
		node.data = value;
		node.next = head;
		if(head == null) {
			node.next = head;
		}
		head = node;
	}

	// public void insertAt(int index, int value) {
	// 	// int iterations = 0;
	// 	Node node = new Node();
	// 	node.data = value;
	// 	if(index == iterations) {

	// 	}
	// }

	public static void print() {
		Node thead = head;
		while(thead == null) {
			System.out.println(thead.data);
			thead = thead.next;
		}
	}

	public static void main(String[] args) {
		insertAtHead(5);
		insertAtHead(6);
		insertAtHead(10);
		print();
	}
}