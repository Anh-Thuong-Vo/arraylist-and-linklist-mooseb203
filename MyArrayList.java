import java.lang.AssertionError;

public class MyArrayList<T> {

	// FIXME add member variables

	/**
	 * Construct an MyArrayList with a given initial length.
	 *
	 * @param initialLength The initial length of the array.
	 */
	public MyArrayList (int initialLength) { // we do not need to redeclare the <T> type in the constructor
		// FIXME
	}

	/**
	 * Return the number of elements in the MyArrayList.
	 *
	 * @return The number of elements in the MyArrayList.
	 */
	public int size() {
		return 0; // FIXME
	}


	/**
	 * Add an element to the end of the MyArrayList.
	 *
	 * @param element The element to add.
	 */
	public void add(T element) {
		// FIXME
	}

	/**
	 * Get the element at the specified index.
	 *
	 * This function assumes that the index argument is within range of the MyArrayList.
	 *
	 * @param index The index to get.
	 * @return The element at the specified index.
	 */
	public T get(int index) {
		return null; // FIXME
	}

	/**
	 * Remove the element at the specified index.
	 *
	 * This function assumes that the index argument is within range of the MyArrayList.
	 *
	 * @param index The index to remove.
	 */
	public void remove(int index) {
		// FIXME
	}

	/**
	 * Double the size of the internal array.
	 */
	private void resize() {
		//FIXME
	}

	/**
	 * Create a String representation of the MyArrayList.
	 *
	 * @return A String representation of the MyArrayList.
	 */
	public String toString() {
		String result = "{";
		if (this.size() > 0) {
			result += this.get(0);
		}
		for (int i = 1; i < this.size; i++) {
			result += ", " + this.get(i);
		}
		result += "}";
		return result;
	}

	/**
	 * Check that an MyArrayList contains the same elements as an int array.
	 *
	 * If the list and the array are not the same, throw an AssertionError.
	 *
	 * @param list The MyArrayList to check.
	 * @param answer The expected answer, in the form of an int array.
	 */
	public static void assertArraysEqual(MyArrayList list, int[] answer) {
		if (list.size() != answer.length) {
			throw new AssertionError("Expected list of length " + answer.length + " but got " + list.size());
		}
		for (int i = 0; i < answer.length; i++) {
			if ((Integer)list.get(i) != answer[i]) {
				throw new AssertionError("Expected " + answer[i] + " but got " + list.get(i) + " at index " + i);
			}
		}
	}

	/*
	 * Test that the empty arraylist has size 0.
	 */
	public static void test1() {
		MyArrayList <Integer> list = new MyArrayList(3);
		int[] answer = new int[0];
		assertArraysEqual(list, answer);
	}

	/*
	 * Test insertion into an arraylist (without resizing).
	 */
	public static void test2() {
		MyArrayList <Integer> list = new MyArrayList(3);
		for (int i = 0; i < 3; i++) {
			list.add(i * i);
		}
		int[] answer = {0, 1, 4};
		assertArraysEqual(list, answer);
	}

	/*
	 * Test deletion from an arraylist without emptying it.
	 */
	public static void test3() {
		MyArrayList <Integer> list = new MyArrayList(5);
		for (int i = 0; i < 5; i++) {
			list.add(i * i);
		}
		list.remove(1);
		list.remove(2);
		int[] answer = {0, 4, 16};
		MyArrayList.assertArraysEqual(list, answer);
	}

	/*
	 * Test deletion from an arraylist and emptying it.
	 */
	public static void test4() {
		MyArrayList <Integer> list = new MyArrayList(5);
		for (int i = 0; i < 5; i++) {
			list.add(i * i);
		}

		list.remove(1);
		list.remove(2);

		// delete the final remaining numbers
		list.remove(0);
		list.remove(0);
		list.remove(0);
		int[] answer1 = {};
		MyArrayList.assertArraysEqual(list, answer1);

		// check that there are no last-element issues
		for (int i = 0; i < 5; i++) {
			list.add(i * i);
		}
		list.remove(4);
		list.add(-1);
		int[] answer2 = {0, 1, 4, 9, -1};
		MyArrayList.assertArraysEqual(list, answer2);
	}

	/*
	 * Test insertion into an arraylist (with resizing).
	 */
	public static void test5() {
		MyArrayList <Integer> list = new MyArrayList(5);
		for (int i = 0; i < 12; i++) {
			list.add(i * i);
		}
		int[] answer = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121};
		MyArrayList.assertArraysEqual(list, answer);
	}

	/**
	 * Put the MyArrayList through some simple tests.
	 *
	 * @param args Ignored command line arguments.
	 */
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();

		System.out.println("pass");
	}

}
