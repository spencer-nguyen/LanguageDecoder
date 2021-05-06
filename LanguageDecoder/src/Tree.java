/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: LanguageDecoder
  Assignment Number: Project 3
  Course: COP5416

This class is the tree object for use with Strings only. It accepts a 
key and inserts the key and words into a tree. It will also traverse
the tree and print the corresponding word.
************************************************************************/
public class Tree{

	private Node root;
	
	Tree(){
		this.root = new Node("");// initialize root as empty 
	}
	
	private class Node{
		
		private String data;
		Node left;
		Node right;
		
		Node(String data){
			this.data = data;
			left = null;
			right = null;
		}
		
		public String getData() {
			return this.data;
		}
	}
	
	/**
	 * This method accepts data and the designator "key". It
	 * begins the iterative insert with root and passed data.
	 * @param data
	 * @param designator
	 */
	public void insert(String data, String designator) {
		insertIterative(this.root, data, designator);
	}
	
	/**
	 * This method accepts the encoded message and will traverse the
	 * tree as an iterative search. It begins the search at root.
	 * @param encoded
	 */
	public void search(String encoded) {
		searchIterative(this.root, encoded);
	}
	
	/**
	 * This method inserts iteratively. It accepts the node, data, and designator "key".
	 * In this method, '+' inserts left and '-' inserts right.
	 * @param current
	 * @param data
	 * @param designator
	 */
	private void insertIterative(Node current, String data, String designator) {
		
		for(int i = 0; i < designator.length(); i++) {
			if(designator.charAt(i) == '+') {
				if(current.left == null) {
					current.left = new Node(data);
				}
				else {
					current = current.left;
				}
			}
			else if(designator.charAt(i) == '-') {
				if(current.right == null) {
					current.right = new Node(data);
				}
				else {
					current = current.right;
				}
			}
		}
	}
	
	/**
	 * This method traverses the tree iteratively. It accepts the encoded
	 * message and will traverse the tree based on the symbols in the message.
	 * @param current
	 * @param encoded
	 */
	private void searchIterative(Node current , String encoded) {
		
		for(int i = 0; i < encoded.length(); i++) {
			if(encoded.charAt(i) == '+') {
				current = current.left;
				/* If last node is reached. */
				if(i == encoded.length() - 1) {
					System.out.print(current.getData() + " ");
				}
			}
			else if(encoded.charAt(i) == '-') {
				current = current.right;
				/* If last node is reached. */
				if(i == encoded.length() - 1) {
					System.out.print(current.getData() + " ");
				}
			}
		}
	}
}
