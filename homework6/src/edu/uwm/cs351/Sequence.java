// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.cs351;

import java.util.Comparator;

import junit.framework.TestCase;

/******************************************************************************
 * This class is a homework assignment;
 * We generalize the Sequence class from previous homework assignments.
 * The sequence can have a special "current element," which is specified and 
 * accessed through four methods that are not available in the sequence class 
 * (start, getCurrent, advance and isCurrent).
 * This implementation uses a singly-linked list with a dummy node implementation.
 ******************************************************************************/
public class Sequence<E> implements Cloneable
{
	// Implementation of the Sequence class:
	//   0. The dummy node is never null
	//   1. The number of elements in the sequences is in the instance variable 
	//      manyItems.  The elements may be any kind of objects or nulls.
	//   2. For any sequence, the elements of the
	//      sequence are stored in a linked list starting at the node after dummy.
	//   3. The "cursor" is a "model field" (not a real field).
	//      It is always the node (if any) after the precursor node.
	//   4. If there is a current element, then it is the element in the node
	//      pointed to by the "cursor".  If there is no current element, then
	//      the "cursor" is null.
	//   5. The instance variable precursor points to some node in the list
	//      or the dummy node.
	// Your code should not have any unchecked cast or raw type warnings
	// and may not suppress warnings except in one place where we placed it in clone().

	private static class Node<T> {
		// TODO: finish this class.  Keep "T" as the generic parameter
		// (It's sloppy and confusing to use the same name as for Sequence)
		
		T data;
		Node<T> next;
		Node(T d, Node<T> n) {
			data = d;
			next = n;
		}
		@Override
		public String toString() {
			return super.toString() + "[" + data + "]";
		}
	}
	
	// TODO: Declare the *three* fields (see the homework handout)
	
	private Node<E> dummy, precursor;
	private int manyItems;

	private static boolean doReport = true; // changed only by invariant tester
	
	private boolean report(String error) {
		if (doReport) System.out.println("Invariant error: " + error);
		else System.out.println("Caught problem: " + error);
		return false;
	}

	private boolean wellFormed() {
		// Check the invariant.
		// 0. The dummy isn't null
		
		if (dummy == null)
			return report ("The dummy is null.");
		
		// 1. the linked list starting at dummy has no cycles.
		//    Use the "Tortoise and Hare" Algorithm attributed to Floyd.
		//    (See Homework #4)
		
		Node<E> slow = dummy;
		Node<E> fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return report("cycle in list!");
		}
		
		// 2. manyItems is the length of the list (excluding dummy!).
		
		int count = 0;
		Node<E> countTest = dummy;
		
		while (countTest.next != null)
		{
			count++;
			countTest = countTest.next;
		}
		
		
		if (count != manyItems)
			return report ("ManyItems does not accurately report the count of items in the list.");
		
		// 3. precursor is points to a node (it is not null) and 
		//    that node is in the list which is started by dummy.
		// TODO
		
		if (precursor == null)
			return report ("The precursor is null.");
		
		Node<E> precursorTest = dummy;
		
		while (precursorTest != precursor)
		{
			if (precursorTest.next == null)
				return report ("The precursor is not pointing to an item in the list started by dummy.");
			precursorTest = precursorTest.next;
		}

		// If no problems discovered, return true
		return true;
	}

	// This is only for testing the invariant.  Do not change!
	private Sequence(boolean testInvariant) { }
	
	// TODO copy code from the Homework #4 HexTileSeq.java (provided)
	// and convert to use the adjusted and simpler data structure.

	
	// #)
	// TODO: Declare the static node class (with a constructor taking a HexTile and a Node)
	// TODO: Declare the five fields (see the textbook)

	public Sequence( )
	{
		// TODO: Implement this code.
		//#(
		// Nothing to do: default values of fields are correct.
		//#)
		
		// Create dummy to start list
		this.dummy = new Node<E>(null, null);
		this.precursor = this.dummy;
		this.manyItems = 0;
		
		assert wellFormed() : "Invariant false at end of constructor";
	}

	/**
	 * Determine the number of elements in this sequence.
	 * @param - none
	 * @return
	 *   the number of elements in this sequence
	 **/ 
	public int size( )
	{
		assert wellFormed() : "invariant failed at start of size";
		// TODO: Implement this code.
		// #(
		return manyItems;
		// #)
		// size() should not modify anything, so we omit testing the invariant here
	}

	/**
	 * Add a new element to this sequence, before the current element. 
	 * @param element
	 *   the new element that is being added, it is allowed to be null
	 * @postcondition
	 *   A new copy of the element has been added to this sequence. If there was
	 *   a current element, then the new element is placed before the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the start of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 **/
	public void addBefore(E element)
	{
		assert wellFormed() : "invariant failed at start of addBefore";
		// TODO: Implement this code.
		// #(
		// handle the special case:
		if (!isCurrent())
			{
				dummy.next = new Node<E>(element,dummy.next);
				precursor = dummy;
			}
		else
			precursor.next = new Node<E>(element,precursor.next);
		++manyItems;
		// #)
		assert wellFormed() : "invariant failed at end of addBefore";
	}

	/**
	 * Add a new element to this sequence, after the current element. 
	 * @param element
	 *   the new element that is being added, may be null
	 * @postcondition
	 *   A new copy of the element has been added to this sequence. If there was
	 *   a current element, then the new element is placed after the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the end of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 **/
	public void addAfter(E element)
	{
		assert wellFormed() : "invariant failed at start of addAfter";
		// TODO: Implement this code.
		// #(
		// special case:
		if (!this.isCurrent())
			precursor.next = new Node<E>(element, null);
		else
		{	
			this.advance();
			precursor.next = new Node<E>(element,precursor.next);
		}

		++manyItems;
		// #)
		assert wellFormed() : "invariant failed at end of addAfter";
	}

	/// Cursor methods

	/**
	 * The first element (if any) of this sequence is now current.
	 * @param - none
	 * @postcondition
	 *   The front element of this sequence (if any) is now the current element (but 
	 *   if this sequence has no elements at all, then there is no current 
	 *   element).
	 **/ 
	public void start( )
	{
		assert wellFormed() : "invariant failed at start of start";
		// TODO: Implement this code.
		// #(
		precursor = dummy;
		// #)
		assert wellFormed() : "invariant failed at end of start";
	}

	/**
	 * Accessor method to determine whether this sequence has a specified 
	 * current element (a HexTile or null) that can be retrieved with the 
	 * getCurrent method. This depends on the status of the cursor.
	 * @param - none
	 * @return
	 *   true (there is a current element) or false (there is no current element at the moment)
	 **/
	public boolean isCurrent( )
	{
		assert wellFormed() : "invariant failed at start of isCurrent";
		// TODO: Implement this code.
		// #(
		return precursor.next != null;
		// #)
	}

	/**
	 * Accessor method to get the current element of this sequence. 
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @return
	 *   the current element of this sequence, possibly null
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   getCurrent may not be called.
	 **/
	public E getCurrent( )
	{
		assert wellFormed() : "invariant failed at start of getCurrent";
		// TODO: Implement this code.
		// #(
		if (!isCurrent()) throw new IllegalStateException("no current");
		return (E) precursor.next.data;
		// #)
	}

	/**
	 * Move forward, so that the next element is now the current element in
	 * this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true. 
	 * @postcondition
	 *   If the current element was already the end element of this sequence 
	 *   (with nothing after it), then there is no longer any current element. 
	 *   Otherwise, the new current element is the element immediately after the 
	 *   original current element.
	 * @exception IllegalStateException
	 *   If there was no current element, so 
	 *   advance may not be called (the precondition was false).
	 **/
	public void advance( )
	{
		assert wellFormed() : "invariant failed at start of advance";
		// TODO: Implement this code.
		// #(
		if (!isCurrent()) throw new IllegalStateException("no current");
		precursor = precursor.next;
		// #)
		assert wellFormed() : "invariant failed at end of advance";
	}

	/**
	 * Remove the current element from this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @postcondition
	 *   The current element has been removed from this sequence, and the 
	 *   following element (if there is one) is now the new current element. 
	 *   If there was no following element, then there is now no current 
	 *   element.
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   removeCurrent may not be called. 
	 **/
	public void removeCurrent( )
	{
		assert wellFormed() : "invariant failed at start of removeCurrent";
		// TODO: Implement this code.
		// #(
		if (!isCurrent()) throw new IllegalStateException("no current to remove");
		--manyItems;
		if (precursor == null) {
			dummy.next = precursor.next.next;
		} else {
			precursor.next = precursor.next.next;
		}
//		if (tail == precursor.next) tail = precursor;
		// #)
		assert wellFormed() : "invariant failed at end of removeCurrent";
	}

	/**
	 * Place the contents of another sequence at the end of this sequence.
	 * @param addend
	 *   a sequence whose contents will be placed at the end of this sequence
	 * @precondition
	 *   The parameter, addend, is not null. 
	 * @postcondition
	 *   The elements from addend have been placed at the end of 
	 *   this sequence. The current element of this sequence if any,
	 *   remains unchanged.   The addend is unchanged.
	 * @exception NullPointerException
	 *   Indicates that addend is null. 
	 **/
	public void addAll(Sequence<E> addend)
	{
		assert wellFormed() : "invariant failed at start of addAll";
		// TODO: Implement this code.
		// #(
		if (addend.manyItems == 0) return;
		
		if (this.manyItems == 0)	// If the current list is empty, point dummy to addend list.
		{
			this.dummy = addend.dummy;
			this.manyItems = addend.manyItems;
			this.precursor = addend.precursor;
			
			while (this.precursor.next != null)
				this.precursor = this.precursor.next;
			
			return;
		}
		
		boolean current = this.isCurrent();
		Node<E> currentPrecursor = this.precursor;
		
		while (this.isCurrent())	//Find the end of the list.
			this.advance();
		
		Sequence<E> addendCopy = addend.clone();
		precursor.next = addendCopy.dummy.next;
		manyItems += addend.manyItems;
		
		if (current)
		{
			this.precursor = currentPrecursor;
		}
		
		else
		{
			while (this.isCurrent())
				this.advance();
		}

		

		// #)
		assert wellFormed() : "invariant failed at end of addAll";
	}   


	/**
	 * Generate a copy of this sequence.
	 * @param - none
	 * @return
	 *   The return value is a copy of this sequence. Subsequent changes to the
	 *   copy will not affect the original, nor vice versa.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for creating the clone.
	 **/ 
	public Sequence<E> clone( )
	{  // Clone a HexTileSeq object.
		assert wellFormed() : "invariant failed at start of clone";
		Sequence<E> answer;

		try
		{
			answer = (Sequence<E>) super.clone( );
		}
		catch (CloneNotSupportedException e)
		{  // This exception should not occur. But if it does, it would probably
			// indicate a programming error that made super.clone unavailable.
			// The most common error would be forgetting the "Implements Cloneable"
			// clause at the start of this class.
			throw new RuntimeException
			("This class does not implement Cloneable");
		}

		// #(
		Node<E> answerDummy = new Node<E>(null, null);
		Node<E> answerNext = answerDummy;
		answer.precursor = answerNext;
		for (Node<E> p = this.dummy.next; p != null; p = p.next) {
			Node<E> c = new Node<E>(p.data,null);
			answerNext = answerNext.next = c;
			if (p == precursor) answer.precursor = answerNext;
			if (p == precursor.next) answer.precursor.next = answerNext; 
			
		}
		
		answer.dummy = answerDummy;
		// #)
		// TODO: clone the whole list and give it four new pointers

		assert wellFormed() : "invariant failed at end of clone";
		assert answer.wellFormed() : "invariant failed for clone";

		return answer;
	}

	//#(
	public String toString() {
		// for debugging
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		boolean first = true;
		for (Node<E> p = dummy.next; p != null; p=p.next) {
			if (first) first = false;
			else sb.append(", ");
			if (p == precursor.next) sb.append("*");
			sb.append(p.data);
		}
		sb.append("}");
		return sb.toString();

	}
	//#)

	// TODO:
	// Add the "sort" method with documentation comment (AKA "javadoc").
	
	/**
	 * Sorts the sequence in ascending order.
	 * Uses the comparator to determine the correct order.
	 * 
	 * @param comp
	 */
	public void sort(Comparator<E> comp)
	{
		if (this.manyItems < 2)	// If the list is either empty or has one element, no need to sort.
			return;
		
		Node<E> sortCursor = dummy.next;
		Node<E> unSortCursor = sortCursor.next;
				
		while (unSortCursor != null)
		{
			while (comp.compare(sortCursor.data, unSortCursor.data) > 0 && sortCursor != null)
				sortCursor = sortCursor.next;
			
			if (sortCursor != null)
			{
				unSortCursor.next = sortCursor.next;
				sortCursor.next = unSortCursor;
			}
				
		
//			unSortCursor.next = sortCursor.next;
//			sortCursor.next = unSortCursor;
			sortCursor = unSortCursor;
			unSortCursor = unSortCursor.next;
			sortCursor = sortCursor.next;
			
		}
		
		
	}
	
	
	// Please don't change the following tests:
	public static class TestInvariant extends TestCase {
		private Sequence<String> self;
		
		private Node<String> n() {
			return new Sequence.Node<String>(null,null);
		}
		
		@Override
		public void setUp() {
			self = new Sequence<String>(false);
			doReport = false;
		}
			
		public void testA() {
			assertFalse(self.wellFormed());
		}
		
		public void testB() {
			self.dummy = n();
			assertFalse(self.wellFormed());
		}
		
		public void testC() {
			self.precursor = n();
			assertFalse(self.wellFormed());
		}
		
		public void testD() {
			self.dummy = n();
			self.precursor = n();
			assertFalse(self.wellFormed());
		}
		
		public void testE() {
			self.dummy = n();
			self.precursor = self.dummy;
			
			doReport = true;
			assertTrue(self.wellFormed());
		}
		
		public void testF() {
			self.dummy = self.precursor = n();
			self.manyItems = 1;
			assertFalse(self.wellFormed());
			self.manyItems = -1;
			assertFalse(self.wellFormed());
		}
				
		public void testG() {
			self.dummy = n();
			self.dummy.next = n();
			self.manyItems = 1;
			assertFalse(self.wellFormed());
			self.precursor = n();
			assertFalse(self.wellFormed());
		}
		
		public void testH() {
			self.dummy = n();
			self.dummy.next = n();
			self.manyItems = 1;
			
			doReport = true;
			self.precursor = self.dummy;
			assertTrue(self.wellFormed());
			self.precursor = self.dummy.next;
			assertTrue(self.wellFormed());
		}
		
		public void testI() {
			self.dummy = self.precursor = n();
			self.dummy.next = n();
			assertFalse(self.wellFormed());
			self.manyItems = 2;
			assertFalse(self.wellFormed());
		}
		
		public void testJ() {
			self.manyItems = 1;
			self.dummy = self.precursor = n();
			self.dummy.next = self.dummy;
			assertFalse(self.wellFormed());
		}
				
		public void testK() {
			self.dummy = n();
			self.dummy.next = n();
			self.dummy.next.next = n();
			self.manyItems = 2;
			
			self.precursor = null;
			assertFalse(self.wellFormed());
			self.precursor = n();
			assertFalse(self.wellFormed());
			self.precursor.next = self.dummy.next;
			assertFalse(self.wellFormed());

			doReport = true;
			self.precursor = self.dummy;
			assertTrue(self.wellFormed());
			self.precursor = self.dummy.next;
			assertTrue(self.wellFormed());
			self.precursor = self.dummy.next.next;
			assertTrue(self.wellFormed());
		}
		
		public void testL() {
			self.manyItems = 3;
			self.dummy = self.precursor = n();
			self.dummy.next = n();
			
			self.dummy.next.next = self.dummy;
			assertFalse(self.wellFormed());
			
			self.dummy.next.next = self.dummy.next;
			assertFalse(self.wellFormed());
			
			self.dummy.next.next = n();
			self.dummy.next.next.next = self.dummy.next;
			assertFalse(self.wellFormed());
			
			self.dummy.next.next.next = self.dummy.next.next;
			assertFalse(self.wellFormed());
		}
	}
}

