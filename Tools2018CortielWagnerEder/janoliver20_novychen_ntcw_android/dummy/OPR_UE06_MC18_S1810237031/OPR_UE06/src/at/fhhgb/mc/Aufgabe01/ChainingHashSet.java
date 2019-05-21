package at.fhhgb.mc.Aufgabe01;

public class ChainingHashSet {
	/**
	 * Array which stores overflow lists that are indexed by the hash code of their
	 * elements.
	 */
	private RandomAccessDoubleLinkedList[] array;

	/** Initializes an empty hashtable with the given number of overflow lists. */
	public ChainingHashSet(int indexSize) {
		
		if (indexSize == 0) {
			indexSize = 1;
			System.out.print("Minimum Size needs to be one!");
		}

		array = new RandomAccessDoubleLinkedList[Math.abs(indexSize)];

	}

	/**
	 * Inserts a new element val into the hashtable (hashcode = val % array.length),
	 * if it did not exist in the table before. Returns true if a new element was
	 * inserted, false if it already existed.
	 */
	public boolean insert(int val) throws ValueException {

		if (val < 0) {
			throw new ValueException(val);
		}
		int hashcode = Math.abs(val % array.length);
		if (array[hashcode] == null) {
			array[hashcode] = new RandomAccessDoubleLinkedList();
		}

		if (array[hashcode].contains(val)) {
			return false;
		}

		array[hashcode].pushBack(val);
		return true;

	}

	/**
	 * Returns true if the given value is already stored in the hashtable, false
	 * otherwise.
	 */
	public boolean contains(int val) {
		int hashcode = Math.abs(val % array.length);
		if (array[hashcode] == null) {
			return false;
		} else {
			return array[hashcode].contains(val);
		}
	}

	/**
	 * Removes the given element from the hashtable if it exists. Returns true if an
	 * element was removed, false if no such element existed.
	 */
	public boolean remove(int val) {

		int hashcode = Math.abs(val % array.length);
		if (array[hashcode] == null) {
			return false;
		} else {
			if (!array[hashcode].contains(val)) {
				return false;
			}
			array[hashcode].removeAll(val);
			return true;
		}
	}

	/** Counts the amount of values, which are stored in the same overflow list */
	public int getOverflowCount(int hashVal) throws ValueException {

		int count = 0;

		// Invalid index:
		if (hashVal > array.length - 1 || hashVal < 0) {
			throw new ValueException(hashVal);
		}
		hashVal = Math.abs(hashVal);
		if (array[hashVal] == null) {
			return count;
		} else {
			DLNode n = array[hashVal].head;
			while (n != null) {
				if (n.isInitialized()) {
					count++;
				}
				n = n.next;
			}
			return count;
		}
	}

	/**
	 * Counts the amount of elements in the hashtable by adding the amount of
	 * elements in each overflow list.
	 * 
	 * @throws ValueException
	 */
	public int elements() throws ValueException {

		int count = 0;

		for (int i = 0; i < array.length; i++) {

			count = count + this.getOverflowCount(i);

		}
		return count;

	}

}
