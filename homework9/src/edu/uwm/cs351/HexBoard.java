package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import junit.framework.TestCase;

/**
 * An implementation of the HexBoard ADT using 
 * a binary search tree implementation.
 * A hex board is a collection of hex tiles except that there can 
 * never be two tiles at the same location. 
 */
public class HexBoard extends AbstractCollection<HexTile> {

	private static int compare(HexCoordinate h1, HexCoordinate h2) {
		if (h1.b() == h2.b()) {
			return h1.a() - h2.a();
		}
		return h1.b() - h2.b();
	}
	
	private static class Node {
		HexCoordinate loc;
		Terrain terrain;
		Node left, right;
		Node(HexCoordinate l, Terrain t) { loc = l; terrain = t; }
	}
	
	private Node root;
	private int size;
	private int version;
	
	private static boolean doReport = true; 
	private static boolean report(String s) {
		if (doReport) System.err.println("Invariant error: " + s);
		else System.out.println("Detected invariant error: " + s);
		return false;
	}
	
	/**
	 * Return true if the nodes in this BST are properly
	 * ordered with respect to the {@link #compare(HexCoordinate, HexCoordinate)}
	 * method.  If a problem is found, it should be reported (once).
	 * @param r subtree to check (may be null)
	 * @param lo lower bound (if any)
	 * @param hi upper bound (if any)
	 * @return whether there are any problems in the tree.
	 */
	private static boolean isInProperOrder(Node r, HexCoordinate lo, HexCoordinate hi) {
		if (r == null) return true;
		if (r.loc == null) return report("null location in tree");
		if (r.terrain == null) return report("null terrain for " + r.loc);
		if (lo != null && compare(lo,r.loc) >= 0) return report("out of order " + r.loc + " <= " + lo);
		if (hi != null && compare(hi,r.loc) <= 0) return report("out of order " + r.loc + " >= " + hi);
		return isInProperOrder(r.left,lo,r.loc) && isInProperOrder(r.right,r.loc,hi);
	}
	
	/**
	 * Return the count of the nodes in this subtree.
	 * @param p subtree to count nodes for (may be null)
	 * @return number of nodes in the subtree.
	 */
	private static int countNodes(Node p) {
		if (p == null) return 0;
		return 1 + countNodes(p.left) + countNodes(p.right);
	}
	
	private boolean wellFormed() {
		if (!isInProperOrder(root,null,null)) return false;
		int count = countNodes(root);
		if (size != count) return report("size " + size + " wrong, should be " + count);
		return true;
	}
	
	/**
	 * Create an empty hex board.
	 */
	public HexBoard() {
		root = null;
		size = 0;
		assert wellFormed() : "in constructor";
	}
	
	/** Return the terrain at the given coordinate or null
	 * if nothing at this coordinate.
	 * @param c hex coordinate to look for (null OK but pointless)
	 * @return terrain at that coordinate, or null if nothing
	 */
	public Terrain terrainAt(HexCoordinate l) {
		assert wellFormed() : "in terrainAt";
		for (Node p = root; p != null; ) {
			int c = compare(l,p.loc);
			if (c == 0) return p.terrain;
			if (c < 0) p = p.left;
			else p = p.right;
		}
		return null;
	}

	@Override // required by Java
	public Iterator<HexTile> iterator() {
		assert wellFormed() : "in iterator";
		return new MyIterator();
	}

	@Override // required by Java
	public int size() {
		assert wellFormed() : "in size";
		return size;
	}
	
	@Override // required for efficiency
	public boolean contains(Object o) {
		assert wellFormed() : "in contains()";
		if (o instanceof HexTile) {
			HexTile h = (HexTile)o;
			return terrainAt(h.getLocation()) == h.getTerrain();
		}
		return false;
	}

	@Override // required for correctness
	public boolean add(HexTile e) {
		assert wellFormed() : "in add()";
		Node lag = null;
		Node p = root;
		int c = 0;
		while (p != null) {
			c = compare(e.getLocation(),p.loc);
			if (c == 0) break;
			lag = p;
			if (c < 0) p = p.left;
			else p = p.right;
		}
		if (p != null) { // found it!
			if (p.terrain == e.getTerrain()) return false;
			p.terrain = e.getTerrain();
			// size doesn't increase...
		} else {
			p = new Node(e.getLocation(),e.getTerrain());
			++size;
			if (lag == null) root = p;
			else if (c < 0) lag.left = p;
			else lag.right = p;
		}
		++version;
		assert wellFormed() : "after add()";
		return true;
	}

	@Override // more efficient
	public void clear() {
		if (size > 0) {
			root = null;
			size = 0;
			++version;
		}
	}
	
	private class MyIterator implements Iterator<HexTile> {
		// new data structure for iterator:
		private Stack<Node> pending = new Stack<>();
		private HexTile current; // if can be removed
		private int myVersion = version;
		private Node cursor = root;
		
		private boolean wellFormed() {
			// TODO:
			// 1. Check the outer invariant (see new syntax in homework description)
			
			if (!HexBoard.this.wellFormed())
				return false;
			
			// 2. If we are stale, don't check anything else, pretend no problems
			
			if (myVersion != version)
				return true;
			
			// 3. If current isn't null, there should be a node for it in the tree.
			
			if (current != null)
			{
				if (!contains(current))

				{
					return report ("The current element is not in the tree.");
				}
			}
			// 4. If current isn't null, the next node after it should be top of the stack
			
			if (current != null)
			{
				
			}
			
			// 5. If the stack isn't empty, then it should have all GT ancestors of top of stack and nothing else.
			
			if (!pending.empty())
			{
				Stack<Node> stackTest = new Stack<>();	//Test stack
				Stack<Node> stackTestTwo = new Stack<>();	//Second Test Stack
				Node nodeTestone = root;
				Node nodeTesttwo = root;
				Node testNode;
				
				testNode = pending.peek();
				
				if (testNode.loc.equals(root.loc))
				{	
					return true;
				}
				
				cursor = root;
				
				while (cursor.left != null)		//Go to starting point in tree
				{
					stackTest.push(cursor);
					cursor = cursor.left;
				}
								
				while (!stackTest.empty())
				{
					if (testNode.loc.equals(cursor.loc))
					{
//						stackTest.push(cursor);
						break;
					}
					
					if (cursor.right != null)
					{
						stackTest.pop();
						cursor = cursor.right;
											
						while (cursor.left != null)
						{
							stackTest.push(cursor);
							cursor = cursor.left;
						}
						
//						cursor = stackTest.pop();
					}
					
					else
					{
						cursor = stackTest.pop();
						
						if (cursor.right != null)
						{
							cursor = cursor.right;
							stackTest.push(cursor);
							
							while (cursor.left != null)
							{
								stackTest.push(cursor);
								cursor = cursor.left;
							}
						}	
					}
					
				}
				
				//return pending.equals(stackTest);	
				
				if (!pending.empty())
				{
					stackTestTwo.push(pending.pop());
				}
				
				while (!pending.empty())
				{
//					nodeTestone = pending.pop();
//					stackTestTwo.push(nodeTestone);
					
					if (stackTest.empty())
					{
						while (!stackTestTwo.empty())
						{
							nodeTestone = stackTestTwo.pop();
							pending.push(nodeTestone);
						}
						
						return false;
					}
					else
						nodeTesttwo = stackTest.pop();
					
					if (nodeTestone.loc != nodeTesttwo.loc)
					{	
						while (!stackTestTwo.empty())
						{
							nodeTestone = stackTestTwo.pop();
							pending.push(nodeTestone);
						}
						
						return false;
					}
				}
				
				if (stackTest.empty() && !pending.empty())
				{
					while (!stackTestTwo.empty())
					{
						nodeTestone = stackTestTwo.pop();
						pending.push(nodeTestone);
					}
					
					return false;
				}
				
				if (!stackTest.empty() && pending.empty())
				{
					while (!stackTestTwo.empty())
					{
						nodeTestone = stackTestTwo.pop();
						pending.push(nodeTestone);
					}
					
					return false;
				}

				while (!stackTestTwo.empty())
				{
					nodeTestone = stackTestTwo.pop();
					pending.push(nodeTestone);
				}
				
//				while (!stackTest.empty())
//				{
//					nodeTestone = pending.pop();
//					nodeTesttwo = stackTest.pop();
//					
//					if (nodeTestone.equals(nodeTesttwo))
//					{
//						//Do Nothing
//					}
//					else
//					{
//						
//						while (!stackTest.empty())		//Returns pending stack to original order
//						{
//							nodeTestone = stackTest.pop();
//							pending.push(nodeTestone);
//						}
//						
//						return report("WellFormed failed on GT test.");
//					}
//				}
//				
//				
//				while (!pending.empty())
//				{
//					nodeTestone = pending.pop();
//					
//					if (pending.empty())
//						nodeTesttwo = null;
//					else
//						nodeTesttwo = pending.peek();
//									
//					if (nodeTesttwo != null && compare(nodeTestone.loc, nodeTesttwo.loc) < 0)
//						return report ("WellFormed failed on GT ancestor check.");
//					else
//					{
//						stackTest.push(nodeTestone);
//					}
//				}
//				
//				while (!stackTest.empty())		//Returns pending stack to original order
//				{
//					nodeTestone = stackTest.pop();
//					pending.push(nodeTestone);
//				}
			}
			
			return true;
		}
		
		private MyIterator(boolean ignored) {} // do not change, and do not use in your code
		
		// TODO: any helper method(s) (see homework description)
		
		public Node doRemove(Node r, HexTile h)
		{
			if (r == null)
				return null;
			
			int c = compare(r.loc, h.getLocation());
			
			if (c == 0)
			{
				if (r.left == null && r.right == null)
					return null;
				
				if (r.right == null)
					return r.left;
				
				if (r.left == null)
					return r.right;
				
				Node t = r.right;
				
				while (t.left != null)
					t = t.left;
				
				r.loc = t.loc;
				r.terrain = t.terrain;
				
				r.right = doRemove(r.right, new HexTile(t.terrain, t.loc));
			}
			
			if (c < 0)
				r.right = doRemove(r, h);
			
			if (c > 0)
				r.left = doRemove(r, h);
			
			return null;
		}

		
		private MyIterator() {
			// TODO
			
			myVersion = version;
			
			cursor = root;
			
			while (cursor != null)
			{
				pending.push(cursor);
				cursor = cursor.left;
			}
			
			assert wellFormed();
		}
		
		@Override // required by Java
		public boolean hasNext() {
			
			if (pending != null)
				return true;
			else
				return false; // TODO
		}

		@Override // required by Java
		public HexTile next() {
			
//			if (current == null)
//			{	
//
//			
//			}
			
			if (hasNext())
			{
				if (cursor.right != null)
				{
					cursor = cursor.right;
										
					while (cursor.left != null)
					{
						pending.push(cursor);
						cursor = cursor.left;
					}
					
					cursor = pending.pop();
				}
				
				else
				{
					cursor = pending.pop();
					
//					if (cursor.right != null)
//					{
//						cursor = cursor.right;
//						pending.push(cursor);
//						
//						while (cursor.left != null)
//						{
//							pending.push(cursor);
//							cursor = cursor.left;
//						}
//					}	
				}
			}
						
			return new HexTile(cursor.terrain, cursor.loc); // TODO: find next entry and generate hex tile on demand
		}

		@Override // required for functionality
		public void remove() {
			
			doRemove(root, current);
			
			// TODO
		}
	}

	// Do not change anything in this test class:
	public static class TestInternals extends TestCase {
		private HexBoard self;
		private MyIterator it;
		
		private void assertIteratorWellFormed(boolean val) {
			doReport = val;
			assertEquals(val,it.wellFormed());
		}
		
		private HexCoordinate h(int a, int b) {
			return new HexCoordinate(a,b);
		}
		
		private HexTile ht(Terrain t, HexCoordinate h) {
			return new HexTile(t,h);
		}
		
		/**
		 * Return a terrain different than the argument.
		 * @param t terrain, must not be null
		 * @return different terrain (never null)
		 */
		private Terrain not(Terrain t) {
			int i = t.ordinal();
			++i;
			Terrain[] terrains = Terrain.values();
			return terrains[i % terrains.length];
		}
		
		private HexCoordinate h1 = h(3,0), h1x = h(4,0);
		private HexCoordinate h2 = h(2,1);
		private HexCoordinate h3 = h(3,1);
		private HexCoordinate h4 = h(2,2);
		private HexCoordinate h5 = h(3,2);
		private HexCoordinate h6 = h(4,2);
		private HexCoordinate h7 = h(7,4), h7x = h(8,4);
		
		private Node n(HexCoordinate h,Terrain t,Node n1, Node n2) {
			Node result = new Node(h,t);
			result.left = n1;
			result.right = n2;
			return result;
		}
		
		private Node clone(Node n) {
			return n(n.loc,n.terrain,n.left,n.right);
		}
		
		@Override
		protected void setUp() {
			self = new HexBoard();
			self.size = 0;
			self.root = null;
			self.version = 0;
			assertTrue("Main class invariant broken?",self.wellFormed());
			it = self.new MyIterator(false); // special syntax
		}
		
		/**
		 * Set up a tree of the following form
		 * <pre>
		 *       h4
		 *      /  \
		 *    h2    h5
		 *   /  \     \
		 * h1    h3    h7
		 *            /
		 *          h6
		 * </pre>
		 * @param t terrain to start creating nodes with
		 */
		protected void makeMedium(Terrain t) {
			Node a = new Node(h1,t); t = not(t);
			Node c = new Node(h3,t); t = not(t);
			Node b = n(h2,t,a,c); t = not(t);
			Node f = new Node(h6,t); t = not(t);
			Node g = n(h7,t,f,null); t = not(t);
			Node e = n(h5,t,null,g); t = not(t);
			Node d = n(h4,t,b,e);
			self.root = d;
			self.version  = t.hashCode();
			self.size = 7;
			assertTrue("Main class invariant broken?",self.wellFormed());
		}
		
		public void testA() {
			assertIteratorWellFormed(true);
			
			self.size = 8;
			assertIteratorWellFormed(false);
			
			makeMedium(Terrain.CITY);
			it.myVersion = self.version;
			assertIteratorWellFormed(true);
			
			self.size = 8;
			assertIteratorWellFormed(false);
		}
		
		public void testB() {
			++self.version;
			assertIteratorWellFormed(true);
			
			self.size = 8;
			assertIteratorWellFormed(false);
			
			makeMedium(Terrain.LAND);
			it.myVersion = self.version-1;
			assertIteratorWellFormed(true);
			
			self.size = 8;
			assertIteratorWellFormed(false);
		}
		
		public void testC() {
			it.current = ht(Terrain.CITY,h3);
			assertIteratorWellFormed(false);
			
			makeMedium(Terrain.WATER);
			it.myVersion = self.version;
			it.current = null;
			assertIteratorWellFormed(true);
			
			it.current = ht(Terrain.DESERT,h1x);
			assertIteratorWellFormed(false);
			it.current = ht(Terrain.LAND,h7x);
			assertIteratorWellFormed(false);
			it.current = ht(not(self.root.right.right.terrain),self.root.right.right.loc);
			assertIteratorWellFormed(false);
			
			it.current = ht(self.root.right.right.terrain,self.root.right.right.loc);
			assertIteratorWellFormed(true);
		}
		
		public void testD() {
			// Read the Homework assignment on the iterator's well formed
			it.current = ht(Terrain.MOUNTAIN,h4);
			++self.version;
			assertIteratorWellFormed(true);
			
			makeMedium(Terrain.DESERT);
			it.myVersion = self.version-2;
			assertIteratorWellFormed(true);
		}
		
		public void testE() {
			makeMedium(Terrain.INACCESSIBLE);
			it.myVersion = self.version;
			
			it.pending.push(self.root);
			assertIteratorWellFormed(true);
			it.pending.pop();
			
			it.pending.push(self.root.left);
			assertIteratorWellFormed(false);
			it.pending.pop();
			
			it.pending.push(self.root.left.right);
			assertIteratorWellFormed(false);
			it.pending.pop();
			
			it.pending.push(self.root.right);
			assertIteratorWellFormed(true);
			it.pending.pop();
			
			it.pending.push(self.root.right.right);
			assertIteratorWellFormed(true);
			it.pending.pop();
			
			it.pending.push(null);
			assertIteratorWellFormed(false);
			it.pending.pop();
			
			it.pending.push(self.root.right.right.left);
			assertIteratorWellFormed(false);
			it.pending.pop();
		}
		
		public void testF() {
			makeMedium(Terrain.LAND);			
			it.myVersion = self.version;
			
			it.pending.push(self.root);
			assertIteratorWellFormed(true);
			it.current = ht(self.root.left.right.terrain,self.root.left.right.loc);
			assertIteratorWellFormed(true);
			it.current = ht(not(self.root.left.right.terrain),self.root.left.right.loc);
			assertIteratorWellFormed(false);
			it.current = ht(self.root.left.terrain,self.root.left.loc);
			assertIteratorWellFormed(false);
			it.current = ht(self.root.terrain,self.root.loc);
			it.pending.pop();
			
			assertIteratorWellFormed(false);
			
			it.pending.push(self.root.right);
			// it.current still set (see above)
			assertIteratorWellFormed(true);
			it.current = ht(not(self.root.terrain),self.root.loc);
			assertIteratorWellFormed(false);
			it.current = ht(self.root.left.right.terrain,self.root.left.right.loc);
			assertIteratorWellFormed(false);
			it.current = ht(self.root.right.right.terrain,self.root.right.right.loc);
			assertIteratorWellFormed(false);
			it.current = ht(self.root.right.right.left.terrain,self.root.right.right.left.loc);
			assertIteratorWellFormed(false);
			it.pending.pop();
			
			assertIteratorWellFormed(false);
			
			it.pending.push(self.root.right.right);
			// it.current still set (see above)
			assertIteratorWellFormed(true);
			it.current = ht(not(self.root.right.right.left.terrain),self.root.right.right.left.loc);
			assertIteratorWellFormed(false);
			it.current = ht(self.root.right.terrain,self.root.right.loc);
			assertIteratorWellFormed(false);
			it.current = null;
			assertIteratorWellFormed(true);
			it.current = ht(self.root.right.right.terrain,self.root.right.right.loc);
			assertIteratorWellFormed(false);
			it.pending.pop();
			
			assertIteratorWellFormed(true);
		}
		
		public void testG() {
			makeMedium(Terrain.FOREST);
			it.myVersion = self.version;
			
			Node fakeRoot = clone(self.root);
			it.pending.push(fakeRoot);
			assertIteratorWellFormed(false);
			it.pending.push(fakeRoot.left);
			assertIteratorWellFormed(false);
			
			it.pending.clear();
			it.pending.push(self.root);
			assertIteratorWellFormed(true);
			it.pending.push(clone(self.root.left));
			assertIteratorWellFormed(false);
			it.current = ht(self.root.left.left.terrain,self.root.left.left.loc);
			assertIteratorWellFormed(false);
			
			it.pending.pop();
			it.pending.push(self.root.left);
			assertIteratorWellFormed(true);
			it.current = null;
			assertIteratorWellFormed(true);
		}
		
		public void testH() {
			makeMedium(Terrain.WATER);
			it.myVersion = self.version;
			
			it.pending.push(self.root);
			assertIteratorWellFormed(true);
			
			it.pending.push(self.root);
			assertIteratorWellFormed(false);
			it.pending.pop();
			
			it.pending.push(self.root.right);
			assertIteratorWellFormed(false);
			it.pending.pop();
			
			it.pending.push(self.root.left);
			assertIteratorWellFormed(true);
			it.pending.pop();
		}
		
		public void testI() {
			makeMedium(Terrain.CITY);
			it.myVersion = self.version;
			
			it.pending.push(self.root.left);
			assertIteratorWellFormed(false);
			
			it.pending.push(self.root.left.left);
			assertIteratorWellFormed(false);
			
			it.current = ht(self.root.left.left.terrain,self.root.left.left.loc);
			assertIteratorWellFormed(false);
			
			it.pending.clear();
			it.pending.push(self.root);
			it.pending.push(self.root.left);
			assertIteratorWellFormed(true);
		}
		
		public void testJ() {
			makeMedium(Terrain.MOUNTAIN);
			it.myVersion = self.version;
			
			it.pending.push(self.root);
			
			it.pending.push(self.root.left.left);
			assertIteratorWellFormed(false);
			it.pending.pop();
			
			it.pending.push(self.root.left.right);
			assertIteratorWellFormed(true);
			it.current = ht(self.root.left.left.terrain,self.root.left.left.loc);
			assertIteratorWellFormed(false);
			it.current = ht(self.root.left.terrain,self.root.left.loc);
			assertIteratorWellFormed(true);
			it.pending.pop();
			assertIteratorWellFormed(false);
			
			it.pending.pop();
			assertIteratorWellFormed(false);
		}
		
		public void testK() {
			makeMedium(Terrain.DESERT);
			it.myVersion = self.version;
			
			it.pending.push(self.root);
			it.pending.push(self.root.right);
			assertIteratorWellFormed(false);
			it.current = ht(self.root.terrain,self.root.loc);
			assertIteratorWellFormed(false);
			
			it.pending.clear();
			it.pending.push(self.root.right);
			assertIteratorWellFormed(true);
			it.current = null;
			assertIteratorWellFormed(true);
			
			it.pending.push(self.root.right.right);
			assertIteratorWellFormed(false);
			
			it.pending.clear();
			it.pending.push(self.root.right.right);
			assertIteratorWellFormed(true);
			it.current = ht(self.root.right.terrain,self.root.right.loc);
			assertIteratorWellFormed(false);
			it.pending.push(self.root.right.right.left);
			assertIteratorWellFormed(true);
		}
	}
}
