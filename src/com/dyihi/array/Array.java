package com.dyihi.array;

public class Array {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** the default size of the DyiArray */
	private static int ARRAY_SIZE =10;
	/** the DyiArray. */
	private int[] arr;
	/** the size of the DyiArray */
	private int size;
	/** the end index of the DyiArray */
	private int endIndex;
	
	/**
	 * Constructor.
	 */
	public Array() {
		arr = new int[ARRAY_SIZE];
		size = ARRAY_SIZE;
		endIndex = 0;
	}
	
	/**
	 * Constructor. it creates an DyiArray with given size.
	 * 
	 * @param size the size of the DyiArray.
	 */
	public Array(int arraySize) {
		arr = new int[arraySize];
		size = arraySize;
		endIndex = 0;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Insert the number into the DyiArray.
	 * 
	 * @param number the number to be inserted to the DyiArray.
	 * @return true if inserts successfully; false otherwise.
	 */
	public boolean insertElement(int number) {
		boolean success = false;
		
		if (endIndex < size) {
			arr[endIndex] = number;
			endIndex++;
			success = true;
		}
		
		return success;
	}
	
	/**
	 * Search if the given number exists in the DyiArray.
	 * 
	 * @param number the number to search.
	 * @return the index of the number in the DyiArray. it return -1 if number 
	 * 		   not found in the DyiArray.
	 */
	public int searchElement(int number) {
			
		int i, index = -1;
		for (i = 0; i < endIndex; i++) {
			if (arr[i] == number) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * Remove the given number from the DyiArray.
	 * 
	 * @param number the number to be removed.
	 * @return true if remove successfully; false otherwise.
	 */
	public boolean removeElement(int number) {
		boolean success = false;
		
		if (this.searchElement(number) != -1) {
			int i;
			for( i = searchElement(number); i < endIndex - 1; i++) {
				arr[i] = arr[i+1];//[i] = arr[i+1];
			}
			arr[i] = 0;
			endIndex--;
			
			success = true;
		}
		
		return success;
	}
	
	
	public int getElement(int index) {
			return arr[index];	
	}
	
	/**
	 * Clear the array.
	 */
	public void clear() {
		for(int i = 0; i < getSize(); i++) {
			arr[i] = 0;
		}
	}
	
	public void print() {
		for(int i = 0; i < getSize(); i++) {
			System.out.println(getElement(i));
		}
	}
}
