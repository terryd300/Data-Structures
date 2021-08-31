package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import junit.framework.TestCase;


/**
 * An immutable class that represents a path on a hex board.
 */
public class HexPath {
	/*
	 * We represent paths in a way that permit efficient "growing"
	 * of paths at the end; each path is either an initial path,
	 * ending at the same place it starts, or is an extension of a shorter path.
	 * This class is <i>immutable</i> which means that once created,
	 * none of the fields can change.  As a result, we don't need to check
	 * the invariant after checking it in the constructor.
	 */
	private final HexPath previous;
	private final HexCoordinate last;
	private final int size;
	
	private static boolean doReport = true;
	
	private boolean report(String s) {
		if (doReport) System.err.println("Invariant error: " + s);
		else System.out.println("Caught invariant error: " + s);
		return false;
	}
	
	// since the class is immutable, we only need to check the invariant
	// at the end of the constructor.
	private boolean wellFormed() {
		// 1. The last location is never null.
		
		if (last == null)
			return report ("The last location is null.");
		
		// 2. If the previous path is null, then size is 0.
		
		if (previous == null && size != 0)
			return report ("The previous path is null and the size is not zero.");
		
		// 3. If the previous path is not null, then:
		//    (a) the previous path must be well formed
		
		if (previous != null)
		{
			if (!previous.wellFormed())
		
			return report ("The previous path is not well formed.");
		
		//    (b) this size is one more than that of the previous path
		
		if (this.size - previous.size != 1)
			return report ("The size is not correct.");
		
		//    (c) the last coordinate of the previous path is next to the this last coordinate.
		
		if (this.last.distance(previous.last()) != 1)
			return report ("The last corrdinate of this path is not adjacent to the last coordinate of this path.");
		
		}
		
		return true;
	}
	
	/// Testing the invariant: do not change this code:
	private HexPath(HexPath p, HexCoordinate l, int s) {
		previous = p;
		last = l;
		size = s;
		// don't check here (see TestInvariant)
	}
	
	
	
	/** Create an initial path, starting and stopping at one location (size = 0)
	 * @param initial the initial location, must not be null
	 */
	public HexPath(HexCoordinate initial) {
		// NB: The following constructor calls the other constructor.
		// Therefore we don't need to check the invariant.
		this(null,initial);
	}
	
	/**
	 * Create a path that extends an existing path with another location.
	 * The new location must be next to the last location of the previous path
	 * (if any).
	 * @param p previous path, may be null
	 * @param next, next location, must not be null, and must be adjacent to
	 * last location of previous path.
	 */
	public HexPath(HexPath p, HexCoordinate next) {
		
		if (next == null)
			throw new IllegalArgumentException ("Unable to add a null node to the path.");
		
		if (p == null)
		{
			this.size = 0;
			this.previous = null;
		}
		
		else
		{
			this.size = p.size + 1;
			this.previous = p;
		}
		
		this.last = next;
		
		assert wellFormed() : "invariant failed after constructor";
	}
	
	public int size() { return size; }
	public HexCoordinate last() { return last; }
	
	/**
	 * Return a string of the form XX -> XX -> XX where each XX is a hex coordinate.
	 * A size=1 path consists just of a single location.
	 * @return string representing path
	 */
	@Override
	public String toString() {
		// TODO: COmplete this method
		
		String result;
		HexCoordinate loc = this.last();
		
		result = "<" + loc.a() + "," + loc.b() + "," + loc.c() + ">";
		
		if (previous != null)
			result = previous.toString() + " -> " + result;
		
		return result;
		
	}

	/**
	 * Draw a path on a hex board (already rendered).
	 * The path is drawn as a series of line segments between
	 * the centers of hexagons on the path.  A size=0 path
	 * doesn't show up. 
	 * @param g
	 */
	public void draw(Graphics g) {
		// TODO: Draw path.
		// (Do not render locations, just the path!)
	}
	
	public HexCoordinate[] toArray() {
		HexCoordinate[] result = new HexCoordinate[size+1];
		// TODO: Complete this method (our solution uses a recursive helper method)
		
		HexPath path = previous;
		int l = result.length;
		
		result [l-1] = this.last;
		
		if (result.length != 1)
		{
			for (int i = 2; i <= result.length; i++)

			{
				result[l-i] = path.last;
				path = path.previous;
			}
		}
		return result;
	}
	
	public static class TestInvariant extends TestCase {
		HexPath self;
		
		HexPath previous;
		HexCoordinate last;
		int size;

		protected void assertInvariant(boolean good) {
			self = new HexPath(previous, last, size);
			doReport = good;
			assertEquals("Expected invariant detected " + (good ? "good" :"bad"),good,self.wellFormed());
		}

		public void testA() {
			last = new HexCoordinate(1,1,0);
			previous = null;
			size = 0;
			assertInvariant(true);
		}

		public void testB() {
			last = new HexCoordinate(1,1,0);
			previous = null;
			size = 1;
			assertInvariant(false);
		}

		public void testC() {
			last = null;
			previous = null;
			size = 0;
			assertInvariant(false);
		}
		
		public void testD() {
			last = new HexCoordinate(1,1);
			previous = new HexPath(null,new HexCoordinate(2,2),0);
			size = 1;
			assertInvariant(true);
		}
		
		public void testE() {
			last = null;
			previous = new HexPath(null,new HexCoordinate(2,2),0);
			size = 1;
			assertInvariant(false);			
		}
		
		public void testF() {
			last = new HexCoordinate(2,2);
			previous = new HexPath(null,new HexCoordinate(3,1),0);
			size = 1;
			assertInvariant(false);
		}
		
		public void testG() {
			last = new HexCoordinate(2,2);
			previous = new HexPath(null,new HexCoordinate(1,3),0);
			size = 1;
			assertInvariant(false);
		}
		
		public void testH() {
			last = new HexCoordinate(1,1);
			previous = new HexPath(null,new HexCoordinate(2,2),1);
			size = 2;
			assertInvariant(false);
		}
		
		public void testI() {
			last = new HexCoordinate(1,1);
			previous = new HexPath(null,new HexCoordinate(2,2),1);
			size = 1;
			assertInvariant(false);
		}
		
		public void testJ() {
			last = new HexCoordinate(1,1);
			previous = new HexPath(null,new HexCoordinate(2,2),0);
			size = 2;
			assertInvariant(false);
		}
		
		public void testK() {
			last = new HexCoordinate(2,2);
			previous = new HexPath(null,new HexCoordinate(2,2),0);
			size = 1;
			assertInvariant(false);
		}
		
		public void testL() {
			last = new HexCoordinate(3,2);
			HexPath first = new HexPath(null,new HexCoordinate(3,2),0);
			previous = new HexPath(first,new HexCoordinate(2,1),1);
			size = 2;
			assertInvariant(true);
		}
		
		public void testM() {
			last = new HexCoordinate(1,1);
			HexPath first = new HexPath(null,new HexCoordinate(3,2),0);
			previous = new HexPath(first,new HexCoordinate(2,1),1);
			size = 2;
			assertInvariant(true);
		}
		
		public void testN() {
			last = new HexCoordinate(1,1);
			HexPath first = new HexPath(null,new HexCoordinate(4,2),0);
			previous = new HexPath(first,new HexCoordinate(2,1),1);
			size = 2;
			assertInvariant(false);
		}
	}
}
