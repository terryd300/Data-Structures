package edu.uwm.cs351.util;

import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.uwm.cs.util.ReverseComparator;
import junit.framework.TestCase;

// This is a Homework Assignment for CS 351 at UWM

/**
 * A cyclic doubly-linked list implementation of the Java Queue interface,
 * implement priority queue semantics using a comparator. It does not accept null.
 * <p>
 * If the comparator is the indifferent comparator (always returns 0),
 * this implementation gives the behavior of a FIFO queue.
 * <p>
 * This implementation is not fully efficient;
 * it uses insertion sort when adding elements and thus will be efficient
 * if a series of elements already in order are added.  But if elements
 * are presented in reverse order, or in random order, each insertion
 * will take linear time.
 * <p>
 * On the other hand, this ADT provides two additional methods
 * which can be used to work around these deficiencies:
 * <dl>
 * <dt>remove</dt><dd>This reverses the sense of the comparator.
 * It takes constant time.  If it is known that a lot of elements are going
 * to be inserted in reverse order, the client can reverse the queue, 
 * add the elements and then reverse it back again.</dd>
 * <dt>setComparator</dt><dd>This sorts the entire queue using 
 * mergesort with the new comparator.  If the client will be adding a lot
 * of elements in random order, it can set the comparator to an indifferent
 * comparator, add all the elements, and then set the comparator 
 * back to the intended order. </dd>
 * </dl>
 * @param T element type
 */
public class PriorityQueue<T> extends AbstractQueue<T> {

	private static class Node<T> {
		T data;       // non-null
		Node<T> prev, next; // non-null
		Node() {
			next = this;
			prev = this;
		}
		Node(T d, Node<T> p, Node<T> n) {
			data = d;
			prev = p;
			next = n;
		}
		@Override // to help debugging
		public String toString() {
			return super.toString() + "(" + data + ")";
		}
	}
	
	private Node<T> dummy;
	private int size;
	private Comparator<T> comparator;
	private boolean reversed;
	private int version; // needed for fail-fast semantics
	
	private PriorityQueue(boolean ignored) {} // DO NOT CHANGE THIS
	
	private static boolean doReport = true;
	
	private boolean report(String s) {
		if (doReport) {
			System.err.println("Invariant error:" + s);
		} else {
			System.out.println("Caught invariant error: " + s);
		}
		return false;
	}
	
	// The invariant:
	private boolean wellFormed() {
		// TODO: check data structure.
		// Hint: "reversed" and "version" do not affect consistency.
		
		if (dummy == null)
			return report ("The dummy is null.");
		
		if (dummy.next == null || dummy.prev == null)
			return report ("The dummy's pointers are null.");
		
		if (dummy.data != null)
			return report ("The dummy's data is not null.");
		
		if (comparator == null)
			return report ("The comparator is null.");
		
		// Go through list, check size field, and cyclic.
		
		Node<T> testNode = dummy;
		int sizeCheck = 0;
		
		if (testNode.prev.next != dummy)
			return report ("The list is not cyclic.");
		
		while (testNode.next != dummy)
		{
			if (testNode.prev.next != testNode)
				return report ("The list is not cyclic.");
			
			if (testNode.next.prev != testNode)
				return report ("The list is not cyclic.");
			
			sizeCheck++;
			testNode = testNode.next;
		}
		
		if (sizeCheck != size)
			return report ("The size field does not have the correct value.");
		
		// Go through list, check comparator and null elements
		
		if (size == 1)
		{
			if (dummy.next.data == null)
				return report ("There is a null element in the list.");
		}
		
		else if (size > 1)
		{
			testNode = dummy.next;
			
			do
			{
				if (testNode.data == null)
					return report ("There is a null element in the list.");
				
				if (testNode.next.data != null)				
				{
					if (comparator.compare(testNode.data, testNode.next.data) > 0)
						return report ("There is an element out of order.");
				}
				
				testNode = testNode.next;
				
			}	while (testNode != dummy);
		}
		
		
		return true;
	}
	
	/**
	 * Set up an empty priority queue with an indifferent comparator.
	 */
	public PriorityQueue() {
		this((Comparator<T>) Comparator.naturalOrder());
		
	}
	
	/**
	 * Set up an empty priority queue with the given comparator.
	 * @param c comparator to use, or the indifferent comparator (if null)
	 */
	public PriorityQueue(Comparator<T> c) {
		// TODO: set up the data structure
		comparator = c;
		
		dummy = new Node<T>(null, null, null);

		dummy.next = dummy;
		dummy.prev = dummy;
		reversed = false;
		size = 0;
		version = 1;
				
		assert wellFormed() : "invariant broken at constructor";
	}
	
	@Override // required by Java
	public boolean offer(T x) {
		assert wellFormed() : "invariant broken at start of offer()";
		// TODO
		
		if (x == null)
			throw new NullPointerException("Unable to add a null node.");
		
		Node<T> newNode = new Node<T>();
		Node<T> testNode = dummy.next;
		
//		newNode.data = x;
		
		if (size == 0)
		{
			dummy.next = newNode;
			dummy.prev = newNode;
			newNode.next = dummy;
			newNode.prev = dummy;
			newNode.data = x;
		}
		
		else if (size == 1)
		{
			if (comparator.compare(x, testNode.data) < 0)
			{
				newNode.next = dummy.next;
				dummy.next = newNode;
				newNode.prev = dummy;
				newNode.next.prev = newNode;
				newNode.data = x;
			}
			
			else
			{
				newNode.prev = dummy.prev;
				newNode.next = dummy;
				dummy.prev.next = newNode;
				dummy.prev = newNode;
				newNode.data = x;
			}
			
		}
		
		else
		{
			while (comparator.compare(x, testNode.data) >= 0)
			{
				if (testNode.next == dummy)
				{	
					newNode.prev = dummy.prev;
					newNode.next = dummy;
					newNode.prev.next = newNode;
					dummy.prev = newNode;
					newNode.data = x;

					size++;
					version++;
					
					assert wellFormed() : "invariant broken at end of offer()";
					return true;
				}
				else
					testNode = testNode.next;
			}
		
			newNode.next = testNode;
			testNode.prev.next = newNode;
			newNode.prev = testNode.prev;
			testNode.prev = newNode;
			newNode.data = x;

		}
		
		size++;
		version++;
		
		assert wellFormed() : "invariant broken at end of offer()";
		return true;
	}

	@Override // required by Java
	public T peek() {
		assert wellFormed() : "invariant broken at start of peek()";
		
		if (reversed)
			return dummy.prev.data;
		else
			return dummy.next.data; // TODO
	}
	
	@Override // required by Java
	public T poll() {
		assert wellFormed() : "invariant broken at start of poll()";
		// TODO: set up return value
		
		T value;
		
		value = peek();
		
		if (reversed)
		{
			dummy.prev = dummy.prev.prev;
			dummy.prev.next = dummy;
		}
		
		else
		{
			dummy.next = dummy.next.next;
			dummy.next.prev = dummy;
		}
		
		if (size != 0)
		{	
			size--;
			version++;
		}
		
		
		assert wellFormed() : "invariant broken at end of poll()";
		return value; // TODO: return result
	}
	
	@Override // required by Java
	public int size() {
		assert wellFormed() : "invariant broken at start of size()";
		return size;
	}

	@Override // required by Java
	public Iterator<T> iterator() {
		assert wellFormed() : "invariant broken at start of iterator()";
		return new MyIterator();
	}
	
	// Do we need any efficiency overrides?
	
	/**
	 * Get the comparator for the elements.
	 * the element returned by "poll" will be the minimum
	 * element according to the comparator.
	 * @return
	 */
	public Comparator<T> getComparator() {
		assert wellFormed() : "invariant broken at start of getComparator()";
		// We do NOT use ReverseComparator internally;
		// it's used just to handle clients.
		if (reversed) return new ReverseComparator<T>(comparator);
		return comparator;
	}
	
	/**
	 * Reverse the sense of the comparator (and logically the order
	 * of all elements entered into the queue.)
	 * This is a constant-time operation.
	 */
	public void reverse() {
		assert wellFormed() : "invariant broken at start of reverse()";
		// TODO: constant time (no loops!)
		
		if (reversed)
			reversed = false;
		else
			reversed = true;
		
		assert wellFormed() : "invariant broken at end of reverse()";
	}
	
	/**
	 * Change the ordering of the elements to follow the given comparator.
	 * If the comparator was most recently set to the identical comparator 
	 * (without any intervening calls to {@link #reverse()}), this is
	 * a constant-time operation.  If the elements are already in sorted order, then
	 * this is a linear-time operation.  Otherwise it takes time O(n lg n).
	 * The sorting of elements uses a 'stable' sort.
	 * @param newComp new comparator (if null, use the indifferent comparator).
	 */
	public void setComparator(Comparator<T> newComp) {
		assert wellFormed() : "invariant broken at start of setComparator()";
		// TODO: First check if reverse, because then we must first destructively
		// TODO: reverse the list so that we treat things in the same order.
		// TODO: Next, check if already in order (linear time).
		// TODO: Otherwise, do a destructive merge sort of the entries.
		// TODO: "Destructive" means that you should re-use nodes, not allocate any more. 
		assert wellFormed() : "invariant broken at end of setComparator()";
	}
	
	// The solution has a few helper methods here.
	
	private class MyIterator implements Iterator<T> {
		// TODO: define the data structure for the iterator
		// Optional: define a data structure invariant
		
		Node<T> cursor = dummy.next;
		int currentVersion = version;
		
		public boolean hasNext() {
			assert wellFormed() : "invariant fails at start of hasNext()";
			
			if (currentVersion != version)
				throw new ConcurrentModificationException("The interator is stale.");
			
			if (cursor.data != null)
				return true;
			
			else			
				return false; // TODO
		}

		public T next() {
			assert wellFormed() : "invariant fails at start of next()";
			// TODO set up return value
			
			T value = null;
			
			if (!hasNext())
				throw new NoSuchElementException("You have reached the end of the list.");
			
			else
			{
				value = cursor.data;
				cursor = cursor.next;
			}
						
			assert wellFormed() : "invariant fails at end of next()";
			return value; // TODO: return result
		}

		public void remove() {
			assert wellFormed() : "invariant fails at start of remove()";
			// TODO: code for remove
			
			if (currentVersion != version)
				throw new ConcurrentModificationException("The interator is stale.");
			
			cursor.prev.next = cursor.next;
			cursor.next.prev = cursor.prev;
			cursor = cursor.next;
			size++;
			version++;
			
			assert wellFormed() : "invariant fails at end of remove()";
		}
	}
	
	// Do not change this code:
	public static class TestInvariant extends TestCase {
		protected PriorityQueue<String> self;
		protected Node<String> dummy;
		protected Node<String> n1, n2, n3;
		
		private void assertWellFormed(boolean val) {
			doReport = val;
			assertEquals(val,self.wellFormed());
		}

		@Override
		protected void setUp() {
			self = new PriorityQueue<String>(false);
			self.comparator = String.CASE_INSENSITIVE_ORDER;
			dummy = new Node<String>(null,null,null);
			dummy.next = dummy;
			dummy.prev = dummy;
			self.dummy = dummy;
			n1 = new Node<String>("bye",null,null);
			n2 = new Node<String>("Hello",null,null);
			n3 = new Node<String>("world",null,null);
		}
		
		public void testA() {
			assertWellFormed(true);
		}
		
		public void testB() {
			self.dummy = null;
			assertWellFormed(false);
		}
		
		public void testC() {
			self.comparator = null;
			assertWellFormed(false);
		}
		
		public void testD() {
			dummy.prev = null;
			assertWellFormed(false);
		}
		
		public void testE() {
			dummy.next = null;
			assertWellFormed(false);
		}
		
		public void testF() {
			dummy.data = "";
			assertWellFormed(false);
		}
		
		public void testG() {
			self.size = 1;
			assertWellFormed(false);
		}
		
		public void testH() {
			self.size = 1;
			dummy.next = n1;
			n1.next = dummy;
			dummy.prev = n1;
			n1.prev = dummy;
			assertWellFormed(true);
		}
		
		public void testI() {
			self.size = 1;
			dummy.next = n1;
			assertWellFormed(false);
		}
		
		public void testJ() {
			self.size = 1;
			dummy.next = n1;
			n1.next = dummy;
			assertWellFormed(false);
		}		
		
		public void testK() {
			self.size = 1;
			dummy.next = n1;
			n1.next = dummy;
			dummy.prev = n1;
			assertWellFormed(false);
		}
		
		public void testL() {
			dummy.next = n1;
			n1.next = dummy;
			dummy.prev = n1;
			n1.prev = dummy;
			assertWellFormed(false);
		}
		
		public void testM() {
			self.size = 1;
			dummy.next = n1;
			n1.next = dummy;
			dummy.prev = n1;
			n1.prev = dummy;
			n1.data = null;
			assertWellFormed(false);
		}
		
		public void testN() {
			self.size = 2;
			dummy.next = n1;
			n1.next = n2;
			n2.next = dummy;
			dummy.prev = n2;
			n2.prev = n1;
			n1.prev = dummy;
			assertWellFormed(true);
		}
		
		public void testO() {
			self.size = 2;
			dummy.next = n1;
			n1.next = n2;
			n2.next = dummy;
			dummy.prev = n1;
			n1.prev = n2;
			n2.prev = dummy;
			assertWellFormed(false);
		}
		
		public void testP() {
			self.size = 1;
			dummy.next = n1;
			n1.next = n2;
			n2.next = dummy;
			dummy.prev = n2;
			n2.prev = n1;
			n1.prev = dummy;
			assertWellFormed(false);
		}
		
		public void testQ() {
			self.size = 2;
			dummy.next = n1;
			n1.next = n2;
			n2.next = n1;
			dummy.prev = n2;
			n2.prev = n1;
			n1.prev = dummy;
			assertWellFormed(false);
		}

		public void testR() {
			Node<String> n1c = new Node<String>(n1.data,null,null);
			self.size = 2;
			dummy.next = n1;
			n1.next = n2;
			n1c.next = n2;
			n2.next = dummy;
			dummy.prev = n2;
			n2.prev = n1c;
			n1.prev = dummy;
			n1c.prev = dummy;
			assertWellFormed(false);
		}
		
		public void testS() {
			Node<String> dummyc = new Node<String>(null,null,null);
			self.size = 2;
			dummy.next = n1;
			dummyc.next = n1;
			n1.next = n2;
			n2.next = dummyc;
			dummy.prev = n2;
			dummyc.prev = n2;
			n2.prev = n1;
			n1.prev = dummy;
			assertWellFormed(false);
		}
		
		public void testT() {
			Node<String> dummyc = new Node<String>(null,null,null);
			self.size = 2;
			dummy.next = n1;
			dummyc.next = n1;
			n1.next = n2;
			n2.next = dummy;
			dummy.prev = n2;
			dummy.prev = n2;
			n2.prev = n1;
			n1.prev = dummyc;
			assertWellFormed(false);
		}
		
		public void testU() {
			self.size = 2;
			dummy.next = n1;
			n1.next = n2;
			n2.next = dummy;
			dummy.prev = n2;
			n2.prev = n1;
			n1.prev = dummy;
			n2.data = null;
			assertWellFormed(false);
		}
				
		public void testV() {
			self.size = 2;
			dummy.next = n2;
			n2.next = n1;
			n2.next = dummy;
			dummy.prev = n1;
			n1.prev = n2;
			n2.prev = dummy;
			assertWellFormed(false);
		}

		public void testW() {
			self.size = 3;
			dummy.next = n1;
			n1.next = n2;
			n2.next = n3;
			n3.next = dummy;
			dummy.prev = n3;
			n3.prev = n2;
			n2.prev = n1;
			n1.prev = dummy;
			assertWellFormed(true);
			self.reversed = true;
			assertWellFormed(true);
			n3.next = n3;
			assertWellFormed(false);
			n3.next = n2;
			assertWellFormed(false);
			n3.next = n1;
			assertWellFormed(false);
		}
		
		public void testX() {
			Node<String> n2c = new Node<>(n2.data,null,null);
			self.size = 3;
			dummy.next = n1;
			n1.next = n2;
			n2.next = n3;
			n2c.next = n3;
			n3.next = dummy;
			dummy.prev = n3;
			n3.prev = n2c;
			n2.prev = n1;
			n2c.prev = n1;
			n1.prev = dummy;
			assertWellFormed(false);			
		}

		public void testY() {
			self.size = 3;
			dummy.next = n1;
			n1.next = n3;
			n3.next = n2;
			n2.next = dummy;
			dummy.prev = n2;
			n2.prev = n3;
			n3.prev = n1;
			n1.prev = dummy;
			assertWellFormed(false);
			n3.data = n2.data;
			assertWellFormed(true);
		}
		
		public void testZ() {
			self.size = 3;
			dummy.next = n1;
			n1.next = n2;
			n2.next = n3;
			n3.next = dummy;
			dummy.prev = n3;
			n3.prev = n2;
			n2.prev = n1;
			n1.prev = null;
			assertWellFormed(false);
			n1.prev = dummy;
			n3.next = null;
			assertWellFormed(false);
		}
	}
}
