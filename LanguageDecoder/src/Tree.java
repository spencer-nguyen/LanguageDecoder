
public class Tree{

	private Node root;
	
	Tree(){
		this.root = new Node("");
	}
	
	
	private class Node{
		
		private String data;
		Node left, right;
		
		Node(String data){
			this.data = data;
			left = null;
			right = null;
		}
		
		public String getData() {
			return this.data;
		}
	}
	
	public void insert(String data, String designator) {
		insertIterative(this.root, data, designator);
	}
	
	public void insertIterative(Node current, String data, String designator) {
		
		
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
	
	public void search(String encoded) {
		searchIterative(this.root, encoded);
	}
	
	public void searchIterative(Node current , String encoded) {
		
		for(int i = 0; i < encoded.length(); i++) {
			

			if(encoded.charAt(i) == '+') {
				current = current.left;
				if(i == encoded.length() - 1) {
					System.out.print(current.getData() + " ");
				}
			}
			else if(encoded.charAt(i) == '-') {
				current = current.right;
				if(i == encoded.length() - 1) {
					System.out.print(current.getData() + " ");
				}

			}
		}
	}
}
