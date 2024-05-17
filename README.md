To use both of these programs:

First, make sure that you have java installed on your machine.

After cloning the repository, open a terminal shell and navigate to the project directory.

Type 'javac binaryTree.java mainClass.java' to compile both programs.

To run binaryTree.java, type 'java binaryTree'. No user input is required.
The program will output the resultingtraversals from the binary tree of minimal height that 
was created from the array [1, 2, 3, 4, 5, 6, 7, 8, 9]. The traversals that will be printed 
are preorder, postorder, in-order, and breadth first search, respectively.

To run mainClass.java, type 'java mainClass.java'. Because this program builds a binary tree,
user input should be in the following format:
"root node left child right child"
For instance, a valid user input would be
1 2 3
2 9 15
3 11 30
9 21 15
15 32 44
11 21 8

Where 1 is the root of the tree and 2 and 3 are the left and right children.
Left child 2 has 9 and 15 as left and right children.
Right child 3 has 11 and 30 as left and right children.
Left child 9 has 21 and 15 as left and right children.
Right child 15 has 32 and 44 as left and right children.
Left child 11 has 21 and 8 as left and right children.

The program output will be the preorder and postorder traversals of the resulting tree, respectively.


