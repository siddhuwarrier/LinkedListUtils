package info.siddhuw;

import java.util.List;

/**
 * An interface that outlines what utilities a list as outlined
 * in the specification should provide.
 * 
 * @author siddhu.warrier
 *
 * @param <T> The type of the list.
 */
public interface ListUtils<T> {
	T getNthElementFromEnd(int n);
	
	List<T> getList();
}
