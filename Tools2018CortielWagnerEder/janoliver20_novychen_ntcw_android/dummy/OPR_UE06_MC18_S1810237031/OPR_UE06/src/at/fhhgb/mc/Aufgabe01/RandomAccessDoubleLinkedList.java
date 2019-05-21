package at.fhhgb.mc.Aufgabe01;

public class RandomAccessDoubleLinkedList extends DoubleLinkedList {

	/** Initializes an empty list. */
	public RandomAccessDoubleLinkedList() {

	}

	/**
	 * Copy constructor which initializes the list with another list. This
	 * constructor must COPY all elements of the other list.
	 */
	public RandomAccessDoubleLinkedList(RandomAccessDoubleLinkedList other) {
		super(other);
	}

	/**
	 * Inserts a new element with value val at the given index. If the index is
	 * larger than the current size, the list is padded with uninitialized DLNodes.
	 * If the node, which was at the given index before the insertion, is not
	 * initialized, then that Node must be reused. Should index be < 0, then do
	 * nothing.
	 */
	public void insertAt(int index, int val) throws InvalidAccessException {

		if (index < 0) {
			throw new InvalidAccessException("Invalid index. Index must be greater than 0.");
		}
		if (index == 0) {
			this.pushFront(val);
			return;
		}

		DLNode n = head;
		DLNode prev = head;

		for (int i = 0; i < index; i++) {

			if (head == null) {
				this.pushBack(Integer.MIN_VALUE);
				n = head;
			}

			if (n.next == null) {
				this.pushBack(Integer.MIN_VALUE);
			}
			prev = n;
			n = n.next;
		}
		if (n.list == null && n.val == Integer.MIN_VALUE) {
			n.val = val;
			elements++;
		} else {
			DLNode k = new DLNode(val);
			k.next = prev.next;
			k.next.prev = k;
			prev.next = k;
			k.prev = prev;
			elements++;

		}
	}

	/**
	 * Returns true if an element with the given value exists, false otherwise.
	 * However, true is returned upon the first occurrence of val.
	 */
	public boolean contains(int val) {

		DLNode n = head;
		while (n != null) {
			if (n.val == val) {
				return true;
			}
			n = n.next;
		}

		return false;

	}

	/**
	 * Removes the element at the given index. False if returned if index > list’s
	 * size.
	 */
	public boolean removeAt(int index) throws InvalidAccessException {

		if (index > this.nodeCounter() - 1 || index < 0 || head == null) {
			throw new InvalidAccessException(
					"Invalid index. Index must be greater than 0 and at most the current maximum index:"
							+ (this.nodeCounter() - 1));
		}

		DLNode n = head;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		if (!n.isInitialized()) {
			return true;
		}

		n.val = Integer.MIN_VALUE;
		elements--;
		return true;
	}

	/**
	 * Removes all elements with the given value. False if returned if val was not
	 * found.
	 */
	public boolean removeAll(int val) {
		DLNode n = head;
		boolean found = false;
		for (int i = 0; i < this.nodeCounter(); i++) {
			if (n.val == val) {
				n.val = Integer.MIN_VALUE;
				found = true;
				elements--;
			}
			n = n.next;

		}
		return found;
	}

	/**
	 * Returns the integer value at the given index. If index > list’s size,
	 * Integer.MIN_VALUE is returned.
	 */

	public int elementAt(int index) throws InvalidAccessException {

		if (index > this.nodeCounter() - 1 || index < 0) {
			throw new InvalidAccessException(
					"Invalid index. Index must be greater than 0 and at most the current maximum index:"
							+ (this.nodeCounter() - 1));
		}

		DLNode n = head;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		if (n.val != Integer.MIN_VALUE) {

			return n.val;
		} else {
			throw new InvalidAccessException("The node at this index does not currently hold a value.");
		}

	}

}
