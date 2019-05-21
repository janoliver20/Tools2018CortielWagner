package at.fhhgb.mc.Aufgabe02;

public class BinarySearchTree {

	/** Inner class for the binary tree node. **/
	protected class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		Comparable data;

		public BinaryTreeNode(Comparable data) {
			left = null;
			right = null;
			this.data = data;
		}
	}

	/** Root node of the tree. **/
	protected BinaryTreeNode root;

	/** Number of elements stored in the tree. */
	protected int size;

	/** Help variable for the Array methods. */
	private int count = 0;

	public BinarySearchTree() {

		this.root = null;
		this.size = 0;

	}

	/**
	 * Inserts the given element. Duplicate elements are not allowed. Returns true
	 * if insertion was successful, false otherwise.
	 */
	public boolean insert(Comparable elem) throws ValueException {

		try {

			if (root == null) {
				root = new BinaryTreeNode(elem);
				size++;
				return true;
			}

			if (elem == null) {
				throw new ValueException(elem);
			}

			return insertRec(root, elem);

		} catch (ClassCastException e1) {
			throw new ValueException(elem);
		}
	}

	private boolean insertRec(BinaryTreeNode cur, Comparable elem) {

		BinaryTreeNode n = new BinaryTreeNode(elem);

		if (elem.compareTo(cur.data) > 0) {
			if (cur.right == null) {
				cur.right = n;
				size++;
				return true;
			} else {
				return insertRec(cur.right, elem);
			}
		}

		if (elem.compareTo(cur.data) < 0) {
			if (cur.left == null) {
				cur.left = n;
				size++;
				return true;
			} else {
				return insertRec(cur.left, elem);
			}
		}

		return false;

	}

	/**
	 * Searches for the (first) element with the given key. Returns true if it could
	 * be found, false otherwise.
	 * 
	 * @throws ValueException
	 * @throws InvalidAccessException
	 */
	public boolean find(Comparable key) throws ValueException, InvalidAccessException {

		try {

			if (key == null) {
				throw new ValueException(key);
			}
			if (root == null) {
				throw new InvalidAccessException("Tree is empty! Access not possible");
			}

			return findRec(root, key);
		} catch (ClassCastException e1) {
			throw new ValueException(key);
		}
	}

	private boolean findRec(BinaryTreeNode cur, Comparable key) {

		if (cur == null) {
			return false;
		}
		if (cur.data.compareTo(key) == 0) {
			return true;
		}
		if (cur.data.compareTo(key) < 0) {
			return findRec(cur.right, key);
		}
		return findRec(cur.left, key);
	}

	/**
	 * Removes the element with the given key. Returns true if the key could be
	 * found (and removed), false otherwise.
	 * 
	 * @throws InvalidAccessException
	 */
	public boolean remove(Comparable key) throws ValueException, InvalidAccessException {

		try {
			if (key == null) {
				throw new ValueException(key);
			}
			if (root == null) {
				throw new InvalidAccessException("Tree is empty! Access not possible");
			}

			return removeRec(root, key, null);
		} catch (ClassCastException e1) {
			throw new ValueException(key);
		}

	}

	private boolean removeRec(BinaryTreeNode cur, Comparable key, BinaryTreeNode parent) {

		if (cur == null) {
			return false;
		}
		if (cur.data.compareTo(key) == 0) {

			BinaryTreeNode n = cur;
			BinaryTreeNode succ;

			if (n.right == null) {
				// no right son
				cur = n.left;
			} else if (n.right.left == null) {
				// right son has no left son
				cur = n.right;
				cur.left = n.left;
			} else {
				// right son has left son
				succ = n.right;

				while (succ.left.left != null)
					succ = succ.left;
				cur = succ.left;
				succ.left = cur.right;
				cur.left = n.left;
				cur.right = n.right;
			}
			if (parent == null)
				root = cur;
			else if (key.compareTo(parent.data) < 0) {
				parent.left = cur;
			} else {
				parent.right = cur;
			}
			size--;
			return true;

		}
		parent = cur;
		if (cur.data.compareTo(key) < 0) {
			return removeRec(cur.right, key, parent);
		}
		return removeRec(cur.left, key, parent);
	}

	/** Returns the number of elements stored in the tree. */
	public int size() {
		return size;

	}

	/**
	 * Returns the parent element of the given key. Integer.MIN_VALUE if no parent
	 * can be found.
	 */
	public Comparable getParent(Comparable key) {
		return getParentRec(root, key, null);

	}

	private Comparable getParentRec(BinaryTreeNode cur, Comparable key, BinaryTreeNode parent) {

		if (cur == null) {
			return Integer.MIN_VALUE;
		}
		if (cur.data.compareTo(key) == 0) {
			if (parent != null) {
				return parent.data;
			}
			return Integer.MIN_VALUE;
		}
		parent = cur;
		if (cur.data.compareTo(key) < 0) {
			return getParentRec(cur.right, key, parent);
		}
		return getParentRec(cur.left, key, parent);
	}

	/**
	 * Returns the elements of the tree in ascending (inorder traversal) or
	 * descending (reverse inorder traversal) order.
	 */
	public Comparable[] toArray(boolean ascending) {

		if (root == null) {
			return null;
		}

		Comparable[] tree = new Comparable[size];

		if (ascending) {
			tree = toArrayAsc(root, tree);
			count = 0;
			return tree;
		} else {
			count = size - 1;
			tree = toArrayRev(root, tree);
			count = 0;
			return tree;
		}
	}

	private Comparable[] toArrayAsc(BinaryTreeNode cur, Comparable[] tree) {
		if (cur != null) {
			toArrayAsc(cur.left, tree);
			tree[count] = cur.data;
			count++;
			toArrayAsc(cur.right, tree);
		}
		return tree;
	}

	private Comparable[] toArrayRev(BinaryTreeNode cur, Comparable[] tree) {

		if (cur != null) {
			toArrayRev(cur.left, tree);
			tree[count] = cur.data;
			count--;
			toArrayRev(cur.right, tree);
		}
		return tree;
	}

	/** Returns the elements of the tree (postorder traversal). */
	public Comparable[] toArrayPostOrder() {

		if (root == null) {
			return null;
		}
		Comparable[] tree = new Comparable[size];
		tree = toArrayPostOrderRec(root, tree);
		count = 0;
		return tree;

	}

	private Comparable[] toArrayPostOrderRec(BinaryTreeNode cur, Comparable[] tree) {

		if (cur != null) {
			toArrayPostOrderRec(cur.left, tree);
			toArrayPostOrderRec(cur.right, tree);
			tree[count] = cur.data;
			count++;
		}
		return tree;

	}

	/** Returns the elements of the tree (preorder traversal). */
	public Comparable[] toArrayPreOrder() {

		if (root == null) {
			return null;
		}

		Comparable[] tree = new Comparable[size];
		tree = toArrayPreOrderRec(root, tree);
		count = 0;
		return tree;

	}

	private Comparable[] toArrayPreOrderRec(BinaryTreeNode cur, Comparable[] tree) {

		if (cur != null) {
			tree[count] = cur.data;
			count++;
			toArrayPreOrderRec(cur.left, tree);
			toArrayPreOrderRec(cur.right, tree);
		}
		return tree;
	}

	/**
	 * Returns largest number stored in the tree. Integer.MIN_VALUE if no largest
	 * element can be found
	 */
	public Comparable max() {

		if (root == null) {
			return Integer.MIN_VALUE;
		}
		Comparable[] getMax = this.toArray(false);
		return getMax[0];
	}

	/**
	 * Returns smallest number stored in the tree. Integer.MIN_VALUE if no smallest
	 * element can be found
	 */
	public Comparable min() {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		Comparable[] getMax = this.toArray(true);
		return getMax[0];

	}

	/** Represents the tree in a human readable form. */
	public String toString() {

		if (root == null) {
			return null;
		}

		Comparable[][] tree = new Comparable[this.maxDepth(root)][this.size];

		int n = 0;
		for (int i = 0; i < this.maxDepth(root); i++) {
			for (int k = 0; k < this.size; k++) {
				if (root.data instanceof String) {
					tree[n][k] = "Integer.MIN_VALUE";
				} else {
					tree[n][k] = Integer.MIN_VALUE; // = Integer.MIN_VALUE
				}
			}
			n++;
		}

		Comparable[] elements = this.toArray(true);

		for (int i = 0; i < this.size(); i++) {
			tree[getLevel(root, elements[i], 0)][i] = elements[i];
		}

		StringBuilder s = new StringBuilder();

		int a = 0;
		for (int i = 0; i < this.maxDepth(root); i++) {

			s.append("\n");

			for (int k = 0; k < this.size; k++) {

				if (root.data instanceof String) {
					if (tree[a][k].compareTo("Integer.MIN_VALUE") != 0) { // != Integer.MIN_VALUE;
						s.append(tree[a][k]);
					} else {
						s.append("  ");
					}

				} else {
					if (tree[a][k].compareTo(Integer.MIN_VALUE) != 0) { // != Integer.MIN_VALUE;
						s.append(tree[a][k]);

					} else {
						s.append("  ");
					}
				}
			}
			a++;
			s.append("\n");
		}

		return s.toString();

	}

	/**
	 * Returns the level on which a specific Node is located.
	 */
	private int getLevel(BinaryTreeNode cur, Comparable element, int level) {

		if (cur == null) {
			return Integer.MIN_VALUE;
		}
		if (cur.data == element) {
			return level;
		}
		if (cur.data.compareTo(element) < 0) {
			return getLevel(cur.right, element, ++level);
		}
		return getLevel(cur.left, element, ++level);
	}

	/**
	 * Returns the max Depth of a tree.
	 */
	private int maxDepth(BinaryTreeNode cur) {

		if (cur == null) {
			return 0;
		}
		int leftDepth = maxDepth(cur.left);
		int rightDepth = maxDepth(cur.right);

		int depth = Math.max(leftDepth, rightDepth);

		return depth + 1;

	}
}
