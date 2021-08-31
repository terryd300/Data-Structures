// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.cs351;

import junit.framework.TestCase;

/******************************************************************************
 * This class is a homework assignment;
 * A HexTileSeq is a collection of HexTiles.
 * The sequence can have a special "current element," which is specified and 
 * accessed through four methods that are not available in the sequence class 
 * (start, getCurrent, advance and isCurrent).
 * This implementation uses a singly-linked list implementation.
 ******************************************************************************/
public class HexTileSeq implements Cloneable
{
	// Implementation of the HexTileSeq class:
	//   1. The number of elements in the sequences is in the instance variable 
	//      manyItems.  The elements may be HexTile objects or nulls.
	//   2. For any sequence, the elements of the
	//      sequence are stored in a linked list starting at head.
	//   3. If there is a current element, then it is the element in the node
	//      pointed to by the cursor.  If there is no current element, then
	//      the cursor is null.
	//   4. The instance variable tail points to the last element in the linked list.
	//   5. The instance variable precursor points to the node before the
	//      one pointed to by the cursor.  If the cursor is the first node, the precursor
	//      is null.  If the cursor is null, the precursor points to the last node.

	// TODO: Declare the static node class (with a constructor taking a HexTile and a Node)
	
	private static class Node
	{
		HexTile data;
		Node next;
		
		public Node(HexTile data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	// TODO: Declare the five fields (see the textbook)
	
	private int manyNodes;	//Keeps track of number of nodes in the list
	private Node head;		//Refers to the head of the list
	private Node tail;		//Refers to the tail of the list
	private Node cursor;	//The currently selected node
	private Node precursor;	//The previously selected node or null if the first node is selected.

	private static boolean doReport = true; // changed only by invariant tester
	
	private boolean report(String error) {
		if (doReport) System.out.println("Invariant error: " + error);
		else System.out.println("Caught problem: " + error);
		return false;
	}

	private boolean wellFormed() {
		// Check the invariant.
		// 1. the linked list starting at head has no cycles.
		// This uses the "Tortoise and Hare" Algorithm attributed to Floyd.
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return report("cycle in list!");
		}
		
		// 2. manyItems is the length of the list.
		
		int count = 0;
		
		Node invariantcheck = head;
		
		while (invariantcheck != null)
		{
			count++;
			invariantcheck = invariantcheck.next;
		}
		
		if (count != this.manyNodes)
			return report("Many Items " + this.manyNodes + " does not match number of items in list." + count);
		
		// 3. tail is the last node in the list started by head.
		
		if (head != null && tail == null)
			return report ("The tail is null.");
		
		else if (this.manyNodes !=0 && tail.next != null)
			return report ("The tail is pointing to another node.");
		
		else
		{
			invariantcheck = head;

			while (invariantcheck != null)
			{
				if (invariantcheck == tail)
					break;
				invariantcheck = invariantcheck.next;
			}

			if (invariantcheck != tail)
				return report("The tail is not pointing to the last node.");
		}
		
		
		// 4. precursor is null or points to a node in the list which is started by head.
		
		invariantcheck = head;
		
		while (precursor != null && precursor != invariantcheck)
		{
			if (invariantcheck == null)
				return report ("The precursor is not pointed to a node in the list.");
			else
				invariantcheck = invariantcheck.next;
		}
		
		// 5. if precursor is null, then cursor points to the first node if any
		//    otherwise it points the node after the one precursor points to (if any).
		
		if (precursor == null && cursor != head)
			return report ("The precursor is null and the cursor is not pointing to the first node of the list.");
		
		else if (precursor != null && precursor.next != cursor)
			return report ("The cursor is not pointing to the node in front of the precursor.");
		
		else if (cursor == null && (precursor != null && precursor != tail))
			return report ("There is no currect cursor and the precursor is pointing to a node.");
		
		// TODO

		// If no problems discovered, return true
		return true;
	}

	// This is only for testing the invariant.  Do not change!
	private HexTileSeq(boolean testInvariant) { }
	
	/**
	 * Initialize an empty sequence.
	 * @param - none
	 * @postcondition
	 *   This sequence is empty.
	 **/   
	public HexTileSeq( )
	{
		// TODO: Implement this code.
		
		this.manyNodes = 0;
		this.head = null;
		this.tail = null;
		this.cursor = null;
		this.precursor = null;
		
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
		// size() should not modify anything, so we omit testing the invariant here
		
		return this.manyNodes;
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
	public void addBefore(HexTile element)
	{
		assert wellFormed() : "invariant failed at start of addBefore";
		// TODO: Implement this code.
		
		if (cursor == null && this.manyNodes == 0)	//List is currently empty
		{
			head = new Node(element, null);
			tail = head;
			cursor = head;
			precursor = null;
			this.manyNodes = 1;
		}
		
		else if (cursor == null && precursor != null)	//List is not empty and cursor is at end of list
		{
			precursor = null;
			cursor = head;	//Moves cursor to front of current list to be used as a pointer for the new node
			head = new Node(element, cursor);
			cursor = head;	//Moves cursor to new head element to be marked as the current element.
			this.manyNodes++;
		}
		
		else if (precursor == null && cursor == head)	//List is not empty and cursor is at front of list
		{
			head = new Node(element, cursor);
			cursor = head;
			this.manyNodes++;
		}
		
		else	//Cursor is in the middle of the list
		{
			cursor = new Node(element, precursor.next);
			precursor.next = cursor;
			this.manyNodes++;
		}
		
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
	public void addAfter(HexTile element)
	{
		assert wellFormed() : "invariant failed at start of addAfter";
		// TODO: Implement this code.
		
		if (cursor == null && this.manyNodes == 0)	//List is currently empty
		{
			head = new Node(element, null);
			tail = head;
			cursor = head;
			precursor = null;
			this.manyNodes = 1;
		}
		
		else if (cursor == null && precursor != null)	//List is not empty and cursor is at end of list
		{
			cursor = new Node(element, null);
			tail = cursor;
			precursor.next = cursor;
			this.manyNodes++;
		}
		
		else if (cursor == tail)	//Cursor is at last element in list
		{
			precursor = cursor;
			cursor = new Node(element, null);
			tail = cursor;
			precursor.next = cursor;
			this.manyNodes++;
		}
		
		else	//Cursor is in the middle of the list
		{
			precursor = cursor;
			cursor = new Node(element, cursor.next);
			precursor.next = cursor;
			this.manyNodes++;
		}
		
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
		
		cursor = head;
		precursor = null;
		
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
		
		if (cursor != null)
			return true;
		
		else
			return false;
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
	public HexTile getCurrent( )
	{
		assert wellFormed() : "invariant failed at start of getCurrent";
		// TODO: Implement this code.
		
		return cursor.data;
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
		
		if (precursor == null)
			precursor = head;
		else
			precursor = precursor.next;
		
		if (cursor == tail)
			cursor = null;
		else
			cursor = cursor.next;
		
		
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
		
		if (!isCurrent())
		{
			throw new IllegalStateException("There is no current element to be removed.");
		}
		
		else if (cursor == tail && this.manyNodes >= 2)	//Current element is at the end of the list and list has more than two elements. 
		{
			cursor = null;
			precursor.next = null;
			tail = precursor;
			this.manyNodes--;
		}
		
		else if (cursor == tail && this.manyNodes == 1)	//Current element is at the end of the list and list has one element.
		{
			cursor = null;
			precursor = null;
			tail = null;
			head = null;
			this.manyNodes--;
			
		}
		
		else if (cursor == head)	//Current element is at the front of the list
		{
			cursor = head.next;
			head = cursor;
			this.manyNodes--;
		}
		
		else	//Current element is in the middle of the list
		{
			cursor = cursor.next;
			precursor.next = cursor;
			this.manyNodes--;
		}
		
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
	public void addAll(HexTileSeq addend)
	{
		assert wellFormed() : "invariant failed at start of addAll";
		// TODO: Implement this code.
		
		if (addend == null)
			throw new NullPointerException("The addend is null.");
			
		//Temporary variables to hold current cursor positions from current sequence
		Node tempcursor = cursor;
		Node tempprecursor = precursor;
		
		//Temporary variables to hold current cursor positions from addend
		Node tempaddcursor = addend.cursor;
		Node tempaddprecursor = addend.precursor;
		
		addend.start();
		this.cursor = head;
		this.precursor = null;
		
		while (cursor != tail)
			advance();
		
		while (addend.cursor != null)
		{
			this.addAfter(addend.getCurrent());
			addend.advance();
		}
		
		//Returning cursor positions to original locations
		if (tempcursor == null)	//If there originally was not a current item, move current item to front of list.
		{
			cursor = head;
			precursor = null;
		}
		else
		{
			cursor = tempcursor;
			precursor = tempprecursor;
		}
		addend.cursor = tempaddcursor;
		addend.precursor = tempaddprecursor;
		
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
	public HexTileSeq clone( )
	{  // Clone a HexTileSeq object.
		assert wellFormed() : "invariant failed at start of clone";
		HexTileSeq answer;

		try
		{
			answer = (HexTileSeq) super.clone( );
		}
		catch (CloneNotSupportedException e)
		{  // This exception should not occur. But if it does, it would probably
			// indicate a programming error that made super.clone unavailable.
			// The most common error would be forgetting the "Implements Cloneable"
			// clause at the start of this class.
			throw new RuntimeException
			("This class does not implement Cloneable");
		}
		
		// TODO: clone the whole list and give it four new pointers
		
		//Make temporary holders for current cursor location
		Node tempcursor = cursor;
		Node tempprecursor = precursor;
		
		//Copies of current head and tail pointers
		answer.head = head;
		answer.tail = tail;
					
		start();
		
		while (cursor.next != null)
		{
			answer.addAfter(getCurrent());
			this.advance();
		}
		
		cursor = tempcursor;
		answer.cursor = tempcursor;
		
		precursor = tempprecursor;
		answer.precursor = tempprecursor;
		
		assert wellFormed() : "invariant failed at end of clone";
		assert answer.wellFormed() : "invariant failed for clone";
		
		return answer;
	}

	
	public static class TestInvariant extends TestCase {
		private HexTileSeq self;
		
		private Node n() {
			return new HexTileSeq.Node(null,null);
		}
		
		@Override
		public void setUp() {
			self = new HexTileSeq(false);
			doReport = false;
		}
			
		public void testA() {
			doReport = true;
			assertTrue(self.wellFormed());
		}
		
		public void testB() {
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
			self.manyNodes = -1;
			assertFalse(self.wellFormed());
		}
		
		public void testC() {
			self.precursor = n();
			assertFalse(self.wellFormed());
			self.precursor = null;
			self.cursor = n();
			assertFalse(self.wellFormed());
		}
		
		public void testD() {
			self.tail = n();
			assertFalse(self.wellFormed());
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
		}
		
		public void testE() {
			self.head = n();
			self.manyNodes = 1;
			self.precursor = self.head;
			assertFalse(self.wellFormed());
			self.precursor = null;
			self.cursor = self.head;
			assertFalse(self.wellFormed());
		}
		
		public void testF() {
			self.head = n();
			self.tail = n();
			self.manyNodes = 1;
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
			self.precursor = null;
			self.cursor = self.head;
			assertFalse(self.wellFormed());
		}
		
		public void testG() {
			self.head = n();
			self.tail = self.head;
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
		}
		
		public void testH() {
			self.head = n();
			self.tail = self.head;
			self.manyNodes = 1;
			doReport = true;
			self.cursor = self.head;
			assertTrue(self.wellFormed());
			self.precursor = self.head;
			self.cursor = null;
			assertTrue(self.wellFormed());
		}
		
		public void testI() {
			System.out.println("Test I");
			self.head = n();
			self.tail = self.head;
			self.head.next = self.head;
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
			self.tail = n();
			assertFalse(self.wellFormed());
			self.tail.next = self.tail;
			assertFalse(self.wellFormed());
			self.tail = null;
			assertFalse(self.wellFormed());
		}
		
		public void testJ() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.manyNodes = 2;

			doReport = true;
			self.cursor = self.head;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.tail;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = null;
			assertTrue(self.wellFormed());
		}
		
		public void testK() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.cursor = self.head;
			assertFalse(self.wellFormed());
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
			self.manyNodes = 3;
			assertFalse(self.wellFormed());
		}
		
		public void testL() {
			self.head = n();
			self.head.next = n();
			self.cursor = self.head;
			self.manyNodes = 2;
			assertFalse(self.wellFormed());
			self.tail = self.head;
			assertFalse(self.wellFormed());
			self.tail = n();
			assertFalse(self.wellFormed());
		}
		
		public void testM() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.manyNodes = 2;
			self.cursor = self.head;
			self.tail.next = self.head;
			assertFalse(self.wellFormed());
			self.tail.next = self.tail;
			assertFalse(self.wellFormed());
		}
		
		public void testN() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.manyNodes = 2;
			assertFalse(self.wellFormed());
			self.precursor = self.head;
			assertFalse(self.wellFormed());
			self.cursor = self.head;
			assertFalse(self.wellFormed());
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
			self.cursor = self.tail;
			assertFalse(self.wellFormed());
			self.precursor = null;
			assertFalse(self.wellFormed());
		}
		
		public void testO() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.manyNodes = 2;
			self.precursor = n();
			assertFalse(self.wellFormed());
			self.cursor = self.tail;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
			self.cursor = self.head;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
		}
		
		public void testP() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = self.tail = n();
			self.manyNodes = 3;
			self.cursor = self.head;
			
			doReport = true;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());			
		}
		
		public void testQ() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = self.tail = n();
			self.manyNodes = 3;
			self.cursor = self.head;
			self.tail.next = self.head;
			assertFalse(self.wellFormed());
			self.tail.next = self.head.next;
			assertFalse(self.wellFormed());
			self.tail.next = self.tail;
			assertFalse(self.wellFormed());
		}
		
		public void testR() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = self.tail = n();
			self.manyNodes = 3;
			self.cursor = self.head;
			
			self.head.next.next = self.head.next;
			assertFalse(self.wellFormed());
			self.head.next.next = self.head;
			assertFalse(self.wellFormed());
		}
		
		public void testS() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = self.tail = n();
			self.cursor = self.head;
			assertFalse(self.wellFormed());
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
			self.manyNodes = 2;
			assertFalse(self.wellFormed());
			self.manyNodes = 4;
			assertFalse(self.wellFormed());
			self.manyNodes = -3;
			assertFalse(self.wellFormed());
		}
		
		public void testT() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.cursor = self.head;
			self.manyNodes = 3;
			assertFalse(self.wellFormed());
			self.tail = self.head;
			assertFalse(self.wellFormed());
			self.tail = self.head.next;
			assertFalse(self.wellFormed());
			self.tail = n();
			assertFalse(self.wellFormed());
		}
		
		public void testU() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.manyNodes = 3;
			self.tail = self.head.next.next;

			assertFalse(self.wellFormed());
			self.precursor = self.head.next;
			assertFalse(self.wellFormed());
			self.precursor = self.head;
			assertFalse(self.wellFormed());
			self.cursor = self.head;
			assertFalse(self.wellFormed());
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
			self.precursor = self.head.next;
			assertFalse(self.wellFormed());
			self.cursor = self.head.next;
			assertFalse(self.wellFormed());
			self.precursor = null;
			assertFalse(self.wellFormed());
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
			self.cursor = self.tail;
			assertFalse(self.wellFormed());
			self.precursor = null;
			assertFalse(self.wellFormed());
			self.precursor = self.head;
			assertFalse(self.wellFormed());
		}
		
		public void testV() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.manyNodes = 3;
			self.tail = self.head.next.next;

			self.precursor = n();
			assertFalse(self.wellFormed());
			self.cursor = self.head;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
			self.cursor = self.head.next;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
			self.cursor = self.head.next.next;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
		}
		
		public void testW() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.head.next.next.next = self.tail = n();
			self.manyNodes = 4;
			self.cursor = self.head;
			
			doReport = true;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());			
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());			
		}
		
		public void testX() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.head.next.next.next = self.tail = n();
			self.manyNodes = 4;
			self.cursor = self.head;

			self.tail.next = self.head;
			assertFalse(self.wellFormed());
			self.tail.next = self.head.next;
			assertFalse(self.wellFormed());
			self.tail.next = self.head.next.next;
			assertFalse(self.wellFormed());
			self.tail.next = self.head.next.next.next;
			assertFalse(self.wellFormed());
		}
		
		public void testY() {
			Node n;
			self.head = n();
			self.head.next = n();
			self.head.next.next = n = n();
			self.head.next.next.next = self.tail = n();
			self.manyNodes = 4;
			self.cursor = self.head;

			n.next = self.head;
			assertFalse(self.wellFormed());
			n.next = self.head.next;
			assertFalse(self.wellFormed());
			n.next = self.head.next.next;
			assertFalse(self.wellFormed());
		}
	}
}

