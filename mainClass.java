import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class mainClass {

	static class ArrayListTree
	{
		public ArrayList<Integer> nodes = new ArrayList<>(Collections.nCopies(50, null));
		public Integer root = 0;
		public int numNodes = 0;
		
		
		public void Root(Integer value)
		{
			nodes.set(0, value);
			root = value;
			numNodes++;
		}
		
		public void setLeft(Integer value, Integer root)
		{
			int index = (2 * root) + 1;
			
			nodes.set(index, value);
			numNodes++;
		}
		
		public void setRight(Integer value, Integer root)
		{
			int index = (2 * root) + 2;
			
			nodes.set(index, value);
			numNodes++;
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		ArrayListTree tree = new ArrayListTree();
		Scanner scnr = new Scanner(System.in);
		createTree(scnr, tree);
		System.out.print("Pre-order: ");
		preorderTraversal((tree.nodes.indexOf(tree.root)), tree);
		System.out.println();
		System.out.print("Post-order: ");
		postorderTraversal((tree.nodes.indexOf(tree.root)), tree);
		

	}
	
	public static void createTree(Scanner scnr, ArrayListTree tree)
	{
		while(scnr.hasNextLine())
		{
			String line = scnr.nextLine();
			String values[] = line.split(" ");
		
			if (values.length == 3)
			{
				Integer parent = Integer.valueOf(values[0]);
				Integer leftChild = Integer.valueOf(values[1]);
				Integer rightChild = Integer.valueOf(values[2]);
				
				if (tree.root == 0)
				{
					tree.Root(parent);
					tree.setLeft(leftChild, 0);
					tree.setRight(rightChild, 0);
					
				}
				else
				{
					tree.setLeft(leftChild, tree.nodes.indexOf(parent));
					tree.setRight(rightChild, tree.nodes.indexOf(parent));
				}
			}
			
			else if (values.length == 2)
			{
				Integer parent = Integer.valueOf(values[0]);
				Integer leftChild = Integer.valueOf(values[1]);
				
				tree.setLeft(leftChild, tree.nodes.indexOf(parent));
			}
			else
			{
				return;
			}
		}
	}
	
	public static void preorderTraversal(int currentNodeIndex, ArrayListTree tree)
	{
		if (currentNodeIndex >= tree.nodes.size() || tree.nodes.get(currentNodeIndex) == null)
		{
			return;
		}
		
		//print current node
		
		System.out.print(tree.nodes.get(currentNodeIndex));
		
		if (currentNodeIndex != tree.numNodes)
		{
			System.out.print("-");
		}
		
		
		
		
		//Recursive call for the left child
		preorderTraversal((2 * currentNodeIndex) + 1, tree);
		
		//Recursive call for the right child
		preorderTraversal((2 * currentNodeIndex) + 2, tree);
	}
	
	public static void postorderTraversal(int currentNodeIndex, ArrayListTree tree)
	{
		if (currentNodeIndex >= tree.nodes.size() || tree.nodes.get(currentNodeIndex) == null)
		{
			return;
		}
		
		
		
		//recursive call for the left child
		postorderTraversal((2 * currentNodeIndex) + 1, tree);
		
		
		
		//recursive call for the right child
		postorderTraversal((2 * currentNodeIndex) + 2, tree);
		
		
		
		//visit the root
		System.out.print(tree.nodes.get(currentNodeIndex) + " ");
		
		
		
		
	}

}



