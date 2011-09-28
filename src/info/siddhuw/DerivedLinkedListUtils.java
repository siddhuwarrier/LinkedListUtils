package info.siddhuw;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class illustrates an alternative approach to performing 
 * the task of finding the nth element from the end of the list by
 * extending the LinkedList class.
 * 
 * The approach taken here is no different; except that instead of 
 * re-implementing methods already present in LinkedList.java, I merely use 
 * them.
 * 
 * It is important to note here that the methods in LinkedList.java use the
 * doubly-linked nature of the LinkedList to speed up some queries such as 
 * addAt, get, and remove (if the index to add, get or remove from is closer to
 * the end than the beginning, it uses prev.
 * 
 * This has been provided as an example
 * 
 * The LinkedList.java source code may be viewed here:
 * http://www.docjar.com/html/api/java/util/LinkedList.java.html
 * 
 * @author siddhu
 *
 */
public class DerivedLinkedListUtils<T> extends LinkedList<T> implements ListUtils
	<T> {
	
	private static final long serialVersionUID = 5558383482879030259L;

	public DerivedLinkedListUtils() {
		super();
	}
	
	@Override
	public T getNthElementFromEnd(int n) throws NoSuchElementException {
		try {
			return get(size() - n - 1);
		}
		catch(IndexOutOfBoundsException exception) {
			throw new NoSuchElementException();
		}
	}

	@Override
	@Deprecated
	public List<T> getList() {
		// TODO Auto-generated method stub
		return this;
	}

}
