package info.siddhuw;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * An implementation of the ListUtils interface that allows the user to 
 * retrieve the nth element from the end of the list.
 *  
 * @author siddhu.warrier
 *
 * @param <T> The type of the linked list.
 */
public class LinkedListUtils<T> implements ListUtils<T> {

	private List<T> linkedList;

	/**
	 * Default constructor: Initialises the linked list with no arguments
	 */
	public LinkedListUtils() {
		linkedList = new LinkedList<T>();
	}
	
	/**
	 * Gets the nth element from the end of the list. 
	 * @param n: the reverse index (i.e. index counted from the end). Numbering
	 * starts at 0
	 * @return The nth element from the end of the list
	 * @throws NoSuchElementException If the nth element from the end of the list
	 * could not be found. 
	 */
	@Override
	public T getNthElementFromEnd(int n) throws NoSuchElementException {		
		Iterator<T> iterator = linkedList.iterator(); //get the head of the linked list
		T value = iterator.next();
		
		int counter = 0;
		
		//note: list.size() is O(1) because the size is updated during inserts 
		//and stored in a member variable.
		for (int index = 1; index < linkedList.size(); index ++) {
			counter ++;
			
			if (counter > n) {
				value = iterator.next();
				counter = n; //assignment atomic; increment not.
			}
		}
		
		if (counter < n) {
			throw new NoSuchElementException();
		}
		
		return value;
	}

	/**
	 * Utility method to retrieve a reference to the list.
	 * 
	 * @return the Linked list traversed in this class. 
	 */
	@Override
	public List<T> getList() {
		return linkedList;
	}
}
