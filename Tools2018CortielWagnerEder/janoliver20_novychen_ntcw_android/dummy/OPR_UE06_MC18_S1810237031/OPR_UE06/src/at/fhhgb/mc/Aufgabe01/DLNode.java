package at.fhhgb.mc.Aufgabe01;

public class DLNode {
	/** Ref to the next elem in the list, or null if it is the last */
	public DLNode next;
	/** Ref to the prev elem in the list, or null if it is the first */
	public DLNode prev;
	/** Holds the actual data */
	public int val;
	/** Holds another list. Must be null if val != Integer.MIN_VALUE */
	public DoubleLinkedList list;

	// Default Constructor
	public DLNode() {

		val = Integer.MIN_VALUE;
		list = null;

	}

	// New Element
	public DLNode(int val) {
		this.val = val;
		this.list = null;

	}

	// New List
	public DLNode(DoubleLinkedList list) {
		this.list = list;
		this.val = Integer.MIN_VALUE;

	}

	// Checks if Node has been initializedÏ
	public boolean isInitialized() {
		return list != null || val != Integer.MIN_VALUE;
	}
}
