package edu.uwm.cs351.util;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * A generic stack class with push/pop methods.
 * When an instance is created, one may optionally pass in a
 * class descriptor.  This makes the implementation more robust.
 * @param T element type of stack
 */
public class Stack<T> implements Cloneable {

	private final Class<T> clazz; // initialize to null if necessary
	
	// Hint: You are permitted to copy in code from lecture repos.
	// TODO: Declare fields (for dynamic array data structure)
	
	private T[] contents;
	private int used;
	
	// TODO: declare report/wellFormed - Copied from ArrayCollection.java in lecture6 repo
	
	private boolean report(String s) 
	{
		System.err.println("invariant error: " + s);
		return false;
	}
	
	private boolean wellFormed() {
		if (contents == null) return report("contents is null");
		if (used < 0) return report("Used is negative! " + used);
		if (used > contents.length) return report("more in collection that its capacity? " + used + " > " + contents.length);
		return true;
	}
	
	// a helper method which you will find useful.
	@SuppressWarnings("unchecked")
	private T[] makeArray(int size) {
		if (clazz == null)
			return (T[])new Object[size]; // lying...
		else
			return (T[])Array.newInstance(clazz, size);
	}
	
	private static final int DEFAULT_CAPACITY = 1;

	// TODO: rest of class
	// You need two constructors: one taking a class value (used by makeArray)
	// and one without such a value.  In the former case, makeArray
	// won't need to lie in its array creation.
	// Make sure to assert the invariant at end of each constructor
	// and at start (and end, if they mutate anything) of public methods.
	
	public Stack()
	{
		clazz = null;
		contents = makeArray(DEFAULT_CAPACITY);
		
		assert wellFormed() : "Invarient failed at end of constructor";
	}
	
	public Stack(Class<T> c)
	{
		clazz = c;
		contents = makeArray(DEFAULT_CAPACITY);
		
		assert wellFormed() : "Invarient failed at end of constructor";
	}
	
	public T pop()
	{
		if (isEmpty())
			throw new EmptyStackException();
		else
			return contents[--used];
	}
	
	public boolean isEmpty()
	{
		if (this.used == 0)
			return true;
		else
			return false;
	}
	
	public void push(T item)
	{
		if (used == contents.length)
			ensureCapacity(used + 1);
		
		contents[used] = item;
		used++;
	}
	
	public T peek()
	{
		if (isEmpty())
			throw new EmptyStackException();
		else
			return contents[used - 1];
	}
	
	public void clear()
	{
		used = 0;
		return;
	}
	
	private void ensureCapacity(int minimumCapacity)
	{
		
		if (minimumCapacity <= this.contents.length)
			return;
		
		int newSize = this.contents.length * 2;
		
		if (newSize < minimumCapacity)
			newSize = minimumCapacity;
		
		T[] newArray = makeArray(newSize);
		
		for (int i = 0; i < contents.length; i++)
			newArray[i] = this.contents[i];
		
		this.contents = newArray;
	}
	
	public Stack<T> clone( )
	{  // Clone a HexTileSeq object.
		assert wellFormed() : "invariant failed at start of clone";
		Stack<T> answer;

		try
		{
			answer = (Stack<T>)super.clone( );
		}
		catch (CloneNotSupportedException e)
		{  // This exception should not occur. But if it does, it would probably
			// indicate a programming error that made super.clone unavailable.
			// The most common error would be forgetting the "Implements Cloneable"
			// clause at the start of this class.
			throw new RuntimeException
			("This class does not implement Cloneable");
		}
		
		answer.contents = contents.clone();

		assert wellFormed() : "invariant failed at end of clone";
		assert answer.wellFormed() : "invariant failed for clone";
		
		return (Stack<T>) answer;
	}
	
}
