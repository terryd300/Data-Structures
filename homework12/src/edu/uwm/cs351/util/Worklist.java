package edu.uwm.cs351.util;

import java.util.Iterator;

/**
 * A sequence of values that can be added to while iteration continue.
 * The {@link #remove()} method is unnecessary and unsupported.
 */
public interface Worklist<E> extends Iterator<E> {
	/**
	 * Add a new element to the sequence.
	 * It will be returned some time later in response to {@link #next()}.
	 * @param element element to add, not null
	 */
	public void add(E element);

	@Override
	default boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default E next() {
		// TODO Auto-generated method stub
		return null;
	}
}

