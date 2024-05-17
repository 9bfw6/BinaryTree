import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;







public class binaryTree {

	public static void main(String[] args) {
		Node<Integer> root = null;

		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		root = buildTree(array);

		preOrder(root);

		System.out.println();

		postOrder(root);

		System.out.println();

		inOrder(root);

		System.out.println();

		bfs(root);



	}
	//method that builds a binary tree with minimum height from array
	public static Node<Integer> buildTree(int[] array) {
		int length = array.length;

		if (length == 0) {
			return null;
		}


		int mid = length / 2;

		Node<Integer> root = new Node<>(array[mid]);

		int[] array1 = Arrays.copyOfRange(array, 0, mid);
		int[] array2 = Arrays.copyOfRange(array, mid + 1, length);

		root.left = buildTree(array1);
		root.right = buildTree(array2);

		return root;

	}
	//preOrder traversal method
	public static void preOrder(Node<Integer> root) {

		if (root == null) {
			return;
		}

		System.out.println(root.data);

		preOrder(root.left);
		preOrder(root.right);

	}
	//postOrder traversal method
	public static void postOrder(Node<Integer> root) {

		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);

		System.out.println(root.data);


	}
	//inOrder traversal method
	public static void inOrder(Node<Integer> root) {
		if (root.left != null) {
			inOrder(root.left);
		}

		System.out.println(root.data);

		if (root.right != null) {
			inOrder(root.right);
		}

	}

	// Visits nodes according to current depth
	static <E> void bfs(Node<E> node) {
		ArrayList<E> finalOrder = new ArrayList<>();
		Queue<Node<E>> queue = new LinkedList<>();

		if (node == null) {
			return;
		}

		// Add root to queue
		queue.add(node);

		// Loop while queue is not empty
		while (!queue.isEmpty()) {
			// For each element of queue
			int levelSize = queue.size(); // Number of nodes at the current level
			for (int i = 0; i < levelSize; i++) {
				// Create temp node of head of queue
				Node<E> temp = queue.poll();

				// If child of temp is not null, add to queue
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
				finalOrder.add(temp.data); //add node to finalOrder list
			}
		}

		// Print finalOrder arraylist
		for (E data : finalOrder) {
			System.out.println(data);
		}
	} // end of bfs



	//Node class
	static class Node<E> {
		public E data;
		public Node<E> left;
		public Node<E> right;
		public Node<E> parent;

		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public Node<E> getParent() {
			return this.parent;
		}

		public E getData() {
			return this.data;
		}

		public void setData(E data) {
			this.data = data;
		}
	}



} //end of binaryTree class


