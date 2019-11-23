/**
 * Implements a stack using a Linked List data structure. 
 * @author Brian LeProwse
 *
 */
public class Stack {
	private Node head;			// The first Node in the list.
	private Node temp;			// Temporary Node to add/traverse the list.	
	private char data;			// Data within the Nodes (char).
	/**
	 * Add entry to the top of the stack. 
	 * @param data
	 */
	public void push(char data) {
		// Add to empty list.
		if(isEmpty()) {
			head = new Node(data);

		}  else {
			temp = new Node(data);  		// Temp Node holds next input.
			temp.next = head;			// Temp's next --> head Node.	
			head = temp;					// Head Node --> temp Node.
		}
	}
	/**
	 * Remove the top entry in the Linked List.
	 * @return the character in top entry.
	 */
	public char pop() {
		// Error message if Linked List contains no entries. 
		if(isEmpty()) {
			System.err.println("Cannot pop top entry from an empty stack!");
		
		} else {
			data = head.data;		// First character contained in head Node.
			
			// Connect links in chain after removing the head Node.
			//pop = new Node(' ');	
			temp = head.next;
			head = temp;
		}
		return data;					// Character in old head Node.
	}
	/**
	 * View the top entry in the Linked List.
	 * @return character in top entry.
	 */
	public char peek() {
			
		// Error if Linked List has no Nodes.
		if(isEmpty()) {
			System.err.println("Cannot view top entry in an empty stack!");
		} else {
			data = head.data;		// First character contained in head Node.
		}
		return data;				
	}
	/**
	 * Check if the Linked List is empty.
	 * @return if list is empty
	 */
	public boolean isEmpty() {
		return head == null;
	}
	/**
	 * Clear the current linked list. Resetting head node to null
	 * will break all other, if any, links within the list. Size 
	 * of the list also returned to zero.
	 */
	public void clear() {

		head = null;			// Head to null to break list.
	}
	private class Node {
		private char data;
		private Node next;

		/**
		 * Node's constructor creates a new Node with the parameter data and
		 * sets the next field to null. 
		 * @param entry
		 */
		private Node(char entry) {
			data = entry;
			next = null;
		}
		private char getData() {		
			return data;
		}
		private Node getNext() {	
			return next;
		}
		private void setData(char entry) {	
			data = entry;
		}
		private void setNext(Node next) {	
			this.next = next;
		}	
	}
}

