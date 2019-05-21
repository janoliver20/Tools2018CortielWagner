package at.fhhgb.mc.Aufgabe01;

public class DoubleLinkedList {
	/** Pointer to the first and last element of the list */
	protected DLNode head;
	protected DLNode tail;
	protected int elements;

	/** Constructor initializes list with a standard size. */
	public DoubleLinkedList() {
		head = null;
		tail = null;
		elements = 0;
	}

	/**
	 * Copy constructor initializes list with another list. This constructor must
	 * COPY all elements of the other list. The elements of the other list must NOT
	 * be changed!
	 */
	public DoubleLinkedList(DoubleLinkedList other) {

		DoubleLinkedList l = other.clone();
		DLNode n = l.head;

		while (n != null) {
			if (n.val != Integer.MIN_VALUE) {
				this.pushBack(n.val);
			} else {
				this.pushBackRecursive(n.list);
			}
			n = n.next;
		}
		l.elements = this.elements;

	}

	/**
	 * Deinitializes the object. The finalize method is used to close/clear
	 * everything currently related to the object (e.g.: Close file, Disconnect
	 * network connection, etc) In this case there is not really anything necessary,
	 * except for setting every value to it´s initial state / to null.
	 */
	protected void finalize() {

		head = tail = null;
		elements = 0;
	}

	/**
	 * Adds all elements from another list at the front of this linked list. e.g.
	 * list = [1,2,3] other = [10,[3,5,2],30] => list = [10,[3,5,3],30,1,2,3]
	 */
	public void pushFront(DoubleLinkedList other) {

		DoubleLinkedList l = other.clone();
		DLNode n = l.tail;

		for (int i = 0; i < l.nodeCounter(); i++) {

			if (n.val != Integer.MIN_VALUE) {
				this.pushFront(n.val);
			} else {
				this.pushFrontRecursive(n.list);
			}
			n = n.prev;
		}
	}

	/**
	 * Adds all elements from another list at the back of this linked list. e.g.
	 * list = [1,[2,11,56],3] other = [10,20,30] => list = [1,2,3,10,[2,11,56],30]
	 */
	public void pushBack(DoubleLinkedList other) {

		DoubleLinkedList l = other.clone();
		DLNode n = l.head;
		for (int i = 0; i < l.nodeCounter(); i++) {
			if (n.val != Integer.MIN_VALUE) {
				this.pushBack(n.val);
			} else {
				this.pushBackRecursive(n.list);
			}
			n = n.next;
		}
	}

	/** Clones this DoubleLinkedList instance and returns an exact COPY. */
	public DoubleLinkedList clone() {

		DoubleLinkedList l = new DoubleLinkedList();
		DLNode n = head;
		while (n != null) {
			if (n.val != Integer.MIN_VALUE) {
				l.pushBack(n.val);
			} else {
				l.pushBackRecursive(n.list.clone());
			}
			n = n.next;
		}
		l.elements = this.elements;

		return l;

	}

	/**
	 * Returns true if the other list is equal to this one, false otherwise. * The
	 * contents of the two lists must not be changed!
	 */
	public boolean equals(DoubleLinkedList other) {

		if (this.elements != other.elements) {
			return false;
		}
		DLNode n = head;
		DLNode o = other.head;

		int nc = nodeCounter();

		for (int i = 0; i < nc; i++) {

			if (n.val != o.val) {
				return false;
			}
			if (n.val == Integer.MIN_VALUE) {
				boolean check = n.list.equals(o.list);
				if (check) {
					return check;
				}

			}
			n = n.next;
			o = o.next;

		}

		return true;

	}

	/**
	 * Returns a string representation of the list. See the exercise [element1,
	 * element2] = list X = Uninitialized Node. Every Node is separated by a comma.
	 */
	public String toString() {

		if (head == null) {
			return "[empty list]";
		}
		DLNode n = head;
		StringBuilder s = new StringBuilder();
		s.append("[");

		for (int i = 0; i < nodeCounter(); i++) {

			if (i != 0) {
				s.append(", ");
			}

			if (n.val != Integer.MIN_VALUE) {
				s.append(n.val);
			} else if (n.list != null) {
				s.append(n.list.toString());
			} else {
				s.append("X");
			}
			n = n.next;

		}
		s.append("]");
		String s1 = s.toString();

		return s1;

	}

	/** Clears all elements from the linked list */
	public void clear() {

		head = null;
		tail = null;
		elements = 0;
	}

	/** Adds an element at the front of the linked list. */
	public void pushFront(int val) {

		DLNode a = new DLNode(val);
		if (head == null) {
			head = tail = a;
			elements++;
			return;
		}
		head.prev = a;
		a.next = head;
		head = a;
		elements++;

	}

	/** Adds an element at the back of the linked list. */
	public void pushBack(int val) {

		DLNode a;
		if (val == Integer.MIN_VALUE) {
			a = new DLNode();
		} else {
			a = new DLNode(val);
		}
		if (head == null) {
			head = tail = a;
			if (a.val == Integer.MIN_VALUE) {
				return;
			}
			elements++;
			return;
		}
		a.prev = tail;
		tail.next = a;
		tail = a;
		if (a.val == Integer.MIN_VALUE) {
			return;
		}
		elements++;

	}

	/*
	 * Adds another list at the beginning of this linked list. If the first element
	 * is an int-node, a new node is prepended. * If the first element is a
	 * list-node, the _list is inserted recursively into that list.
	 */
	public void pushFrontRecursive(DoubleLinkedList _list) {

		DoubleLinkedList l = _list.clone();
		DLNode n = new DLNode(l);
		if (head == null) {
			head = tail = n;
			this.elements = elements + l.elements;
			return;
		}

		if (head.list == null && head.val != Integer.MIN_VALUE) {
			n.next = head;
			head.prev = n;
			head = n;
			this.elements = elements + l.elements;
			return;
		}
		head.list.pushFrontRecursive(l);

	}

	/*
	 * Adds another list at the end of this linked list. If the last element is an
	 * int-node, a new node is appended. * If the last element is a list-node, the
	 * _list is inserted * recursively into that list.
	 */
	public void pushBackRecursive(DoubleLinkedList _list) {

		DoubleLinkedList l = _list.clone();
		DLNode n = new DLNode(l);
		if (head == null) {
			head = tail = n;
			this.elements = l.elements;
			return;
		}

		if (tail.list == null && tail.val != Integer.MIN_VALUE) {
			DLNode i = new DLNode(l);
			tail.next = i;
			i.prev = tail;
			tail = i;
			this.elements = elements + l.elements;
			return;
		}
		tail.list.pushBackRecursive(l);

	}

	/**
	 * Removes and returns the front element of the linked list, or if * the first
	 * element is another list, returns that list’s first element. Returns
	 * Integer.MIN_VALUE if empty
	 */
	public int popFront() throws InvalidAccessException {

		if (head == null) {
			throw new InvalidAccessException("The List is empty.");
		}

		if (head.list == null && head.val != Integer.MIN_VALUE) {
			int r = head.val;
			head = head.next;
			elements--;
			return r;
		}
		return (head.list.popFront());

	}

	/**
	 * Returns the front element of the list without removing it. If the * first
	 * element is another list, returns that list’s first element * Returns
	 * Integer.MIN_VALUE if empty
	 */
	public int peekFront() {

		if (head == null) {
			return Integer.MIN_VALUE;
		}

		if (head.list == null && head.val != Integer.MIN_VALUE) {
			return head.val;
		}
		return (head.list.peekFront());

	}

	/**
	 * Removes and returns the element from the back of the linked list, * or if the
	 * last element is another list, returns that list’s last * element Returns
	 * Integer.MIN_VALUE if empty
	 */
	public int popBack() throws InvalidAccessException {

		if (head == null) {
			throw new InvalidAccessException("The List is empty.");
		}
		if (tail.list == null && tail.val != Integer.MIN_VALUE) {
			int r = tail.val;
			tail = tail.prev;
			tail.next = null;
			elements--;
			return r;
		}

		return tail.list.popBack();

	}

	/**
	 * Returns the element at the back of the list without removing it. * If the
	 * last element is another list, returns that list’s last element Returns
	 * Integer.MIN_VALUE if empty
	 */
	public int peekBack() {

		if (head == null) {
			return Integer.MIN_VALUE;
		}
		if (tail.list == null && tail.val != Integer.MIN_VALUE) {
			return tail.val;
		}

		return tail.list.peekBack();

	}

	/**
	 * IMPORTANT: Returns the number of elements (Element = a node which includes an
	 * actual int value, not a node which includes a list) in the double linked list
	 * and of all its sub-lists e.g. List: [2, [4,5] 3, 4] => elements = 5 (not 6)
	 */
	public int elements() {
		return elements;

	}

	/**
	 * Returns true if the element val exists in the list or in any of its
	 * sub-lists, false otherwise.
	 */
	public boolean search(int val) {

		DLNode n = head;
		if (n == null) {
			return false;
		}

		int nc = nodeCounter();

		for (int i = 0; i < nc; i++) {

			if (n.val == val) {
				return true;
			}
			if (n.val == Integer.MIN_VALUE) {
				boolean check = n.list.search(val);
				if (check) {
					return check;
				}
			}
			n = n.next;
		}
		return false;

	}

	/**
	 * Reverse the order of all elements. Does NOT change the order of * sub-lists!
	 */
	public void reverse() {

		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		int nodes = nodeCounter();
		DLNode t = tail.prev;
		head = tail;
		for (int i = 0; i < nodes - 1; i++) {

			if (t.list == null && t.val != Integer.MIN_VALUE) {
				this.reverseHelperVal(t.val);
				t = t.prev;
			} else {
				this.reverseHelperList(t.list);
				t = t.prev;
			}
		}
		tail.next = null;
		head.prev = null;

	}

	/**
	 * Adds an list Node at the end of the current list in order to reverse it.
	 * (only used in reverse method)
	 */
	public void reverseHelperList(DoubleLinkedList _list) {
		DLNode n = tail;
		DLNode k = new DLNode(_list);
		n.next = k;
		k.prev = n;
		tail = k;

	}

	/**
	 * Adds an var Node at the end of the current list in order to reverse it. (only
	 * used in reverse method)
	 */
	public void reverseHelperVal(int val) {

		DLNode a = new DLNode(val);
		DLNode t = tail;
		t.next = a;
		a.prev = t;
		tail = a;

	}

	/**
	 * Returns the number of Nodes of the main list (Not the number of elements)
	 * WITHOUT the nodes of the sublist.
	 */
	public int nodeCounter() {

		DLNode n = head;
		int nodeCounter = 0;
		while (n != null) {
			n = n.next;
			nodeCounter++;
		}
		return nodeCounter;
	}
}
