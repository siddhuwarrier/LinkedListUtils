package info.siddhuw

import info.siddhuw.ListUtils
import info.siddhuw.LinkedListUtils


description "This story is about testing the behaviour of the method written to\
find the ith element from the end of a list"

narrative "Find the ith element from the end of a list", {
	as_a "user of ListUtils"
	i_want "to be able to find the ith element from the end of a singly linked list"
	so_that "I can search the linked list in both directions in a single pass"
}

scenario "element with reverse index i searched for in a list of size n > i", {
	given "an empty list", {
		listUtils = new LinkedListUtils<Integer>()
	}
	when "10 elements are pushed into the list", {
		for (index in 1..10) {
			listUtils.getList().add(index)
		}
	}
	then "searching for the 5th value from the end should return the 5th value from the beginning", {
		retVal = listUtils.getNthElementFromEnd(5);
		retVal.shouldBe listUtils.getList().get(4)
	}
}

scenario "element with reverse index i searched for in a list of size n == i - 1", {
	given "an empty list", {
		listUtils = new LinkedListUtils<Integer>()
	}
	when "6 elements are pushed into the list", {
		for (index in 1..6) {
			listUtils.getList().add(index)
		}
	}
	then "searching for the 5th value from the end should return the 1st value from the beginning", {
		retVal = listUtils.getNthElementFromEnd(5);
		retVal.shouldBe listUtils.getList().get(0)
	}
}

scenario "element with reverse index i searched for in a list of size n <= i", {
	given "an empty list", {
		listUtils = new LinkedListUtils<Integer>()
	}
	when "5 elements are pushed into the list", {
		for (index in 1..5) {
			listUtils.getList().add(index)
		}
	}
	when "the 5th value from the end is searched for", {
		searchForNonExistentElement = {
			listUtils.getNthElementFromEnd(5)
		}
	}
	then "a NoSuchElementException should be thrown", {
		ensureThrows(NoSuchElementException) {
			searchForNonExistentElement()
		}
	}
}

scenario "searching for an element with any reverse index in an empty list", {
	given "an empty list", {
		listUtils = new LinkedListUtils<Integer>()
	}
	when "the 5th value from the end is searched for", {
		searchForNonExistentElement = {
			listUtils.getNthElementFromEnd(5)
		}
	}
	then "a NoSuchElementException should be thrown", {
		ensureThrows(NoSuchElementException) {
			searchForNonExistentElement()
		}
	}
}

