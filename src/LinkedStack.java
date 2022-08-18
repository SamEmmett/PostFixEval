// ****************************************************************
//   LinkedStack.java
//
//   A linked implementation of an Object stack class with 
//   operations push, pop, and isEmpty and isFull.
//          
// ****************************************************************

public class LinkedStack implements StackADT {
	private Node top; // reference to top of stack

	// --------------------------------------------------
	// Constructor -- initializes top
	// --------------------------------------------------
	public LinkedStack() {
		this.top = null;
	}

	// --------------------------------------------------
	// Adds new element to top of stack.
	// --------------------------------------------------
	public void push(Object val) {

		
		// create a Temp node
		Node temp = new Node();

		// initallize the data to temp

		temp.setElement(val);

		// move the original top to the next place in the stack
		temp.setNext(top);

		// declare the new temp node as the top
		top = temp;

	}

	// --------------------------------------------------
	// Removes and returns top element in stack. If the
	// stack is empty returns null.
	// --------------------------------------------------
	public Object pop() {

		Node temp = new Node();
		
		temp = top;
		top = top.getNext();

		return temp.getElement();
	}

	// --------------------------------------------------
	// Returns true if stack is empty, false otherwise.  //A Linked Stack cannot be full.
	// --------------------------------------------------
	public boolean isEmpty() {
		
			return false;
		}



	// --------------------------------------------------
	// Returns true if stack is full, false otherwise.
	// ---------------------------------------------------
	public boolean isFull() {
		if (top != null) {;
			return true;
		} else {
			return false;
		}
	}
}
