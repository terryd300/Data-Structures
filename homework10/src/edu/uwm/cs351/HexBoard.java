package edu.uwm.cs351;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

import edu.uwm.cs351.util.AbstractEntry;

/**
 * An implementation of the HexBoard ADT using 
 * a binary search tree implementation.
 * A hex board is a collection of hex tiles except that there can 
 * never be two tiles at the same location. 
 */
public class HexBoard extends AbstractSet<HexTile> implements Cloneable {

	private static int compare(HexCoordinate h1, HexCoordinate h2) {
		if (h1.b() == h2.b()) {
			return h1.a() - h2.a();
		}
		return h1.b() - h2.b();
	}
	
	private static class Node extends AbstractEntry<HexCoordinate, Terrain> 
	{
		HexCoordinate loc;
		Terrain terrain;
		Node left, right;
		Node(HexCoordinate l, Terrain t) { loc = l; terrain = t; }
		
		@Override
		public HexCoordinate getKey() {
			// TODO Auto-generated method stub
			return loc;			
		}
		
		@Override
		public Terrain getValue() {
			// TODO Auto-generated method stub
			return terrain;
		}
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
		assert wellFormed() : "invariant broken before clear()";
		if (size > 0) {
			root = null;
			size = 0;
			++version;
		}
		assert wellFormed() : "invariant broken by clear()";
	}

	private Node doRemove(Node r, HexTile ht) {
		int c = compare(ht.getLocation(),r.loc);
		if (c == 0) {
			if (r.left == null) return r.right;
			if (r.right == null) return r.left;
			Node sub = r.left;
			while (sub.right != null) {
				sub = sub.right;
			}
			r.loc = sub.loc;
			r.terrain = sub.terrain;
			r.left = doRemove(r.left, new HexTile(r.terrain,r.loc));
		} else if (c < 0) {
			r.left = doRemove(r.left, ht);
		} else {
			r.right = doRemove(r.right, ht);
		}
		return r;
	}
	
	@Override // for efficiency and because the iterator uses this, for functionality
	public boolean remove(Object x) {
		assert wellFormed() : "invariant broken before remove()";
		if (!(x instanceof HexTile)) return false;
		HexTile ht = (HexTile)x;
		if (!contains(ht)) return false;
		root = doRemove(root,ht);
		--size;
		++version;
		assert wellFormed() : "invariant broken after remove";
		return true;
	}
	
	/**
	 * Return a set backed by this hex board that
	 * has all the tiles in the given row.
	 * The result is <i>backed</i> by this hex board;
	 * changes to either are reflected in the other.
	 * @param r row number.
	 * @return set of hextiles with the given row
	 */
	public Set<HexTile> row(int r) {
		return null; // TODO
	}
	
	/**
	 * Return a view of this hex board as a map from hex coordinates to terrain.
	 * It is as efficient as the hex board itself.
	 * @return
	 */
	public Map<HexCoordinate,Terrain> asMap() {
		return new MyMap(); // TODO
	}
	
	// TODO: add nested classes to implement map, Node set, and row.
	// The map and Node set classes must not have any fields!
	// The row class may only have a "final" field (for the row number).
	// Assuming you can use a separate constructor for MyIterator,
	// this class can be used for row iterators too.
	private class EntrySetIterator implements Iterator<Map.Entry<HexCoordinate, Terrain>> {
		// Separate this into two classes:
		// One an Node set iterator, and the other a wrapper
		// around it that returns hex tiles up to a particular row number.
		private Stack<Node> pending = new Stack<>();
		private HexTile current; // if can be removed
		private int myVersion = version;
		
		private boolean wellFormed() {
			if (!HexBoard.this.wellFormed()) return false;
			if (version == myVersion) {
				@SuppressWarnings("unchecked")
				Stack<Node> clone = (Stack<Node>) pending.clone();
				Node p = null;
				if (current != null) {
					boolean found = false;
					for (Node r=root; r != null; ) {
						if (compare(current.getLocation(),r.loc) < 0) {
							p = r; // remember GT ancestor
							r = r.left;
						} else {
							if (r.loc.equals(current.getLocation()) && current.getTerrain() == r.terrain) found = true;
							r = r.right;
						}
					}
					if (!found) return report("didn't find current in tree.");
					if (p == null) {
						if (!clone.isEmpty()) return report("stack isn't empty, but hextile is last");
					} else {
						if (clone.isEmpty()) return report("stack is empty, but hextile is not last");
						if (clone.peek() != p) return report("top of stack is not next Node from current");
					}
				}
				p = null;
				while (!clone.isEmpty()) {
					Node q = clone.pop();
					if (q == null) return report("Found null on stack");
					Node r = q.left;
					while (r != p && r != null) {
						r = r.right;
					}
					if (r != p) return report("Found bad Node " + q + " on stack");
					p = q;
				}				
				if (p != null) {
					Node r = root;
					while (r != p && r != null) {
						r = r.right;
					}
					if (r != p) return report("Bottom Node on stack not a right descendant of root: " + p);
				}
			}
			return true;
		}
		
		private void pushNodes(Node p) {
			while (p != null) {
				pending.push(p);
				p = p.left;
			}
		}
			
		private void checkVersion() {
			if (version != myVersion) throw new ConcurrentModificationException("stale");
		}

		private EntrySetIterator() {
			pushNodes(root);
			assert wellFormed();
		}
		
		@Override // required by Java
		public boolean hasNext() {
			checkVersion();
			return !pending.isEmpty();
		}

		@Override // required by Java
		public Node next() {
			if (!hasNext()) throw new NoSuchElementException("no more");
			Node p = pending.pop();
			pushNodes(p.right);
			current = new HexTile(p.terrain,p.loc);
			assert wellFormed() : "invariant broken at end of next()";
			return new Node(current.getLocation(), current.getTerrain());
		}

		@Override // required for functionality
		public void remove() {
			assert wellFormed() : "invariant broken at start of remove()";
			checkVersion();
			if (current == null) throw new IllegalStateException("nothing to remove");
			HexBoard.this.remove(current);
			myVersion = version;
			current = null;
			assert wellFormed() : "invariant broken at end of remove()";
		}
	}
	
	private class MyIterator implements Iterator<HexTile> {

		EntrySetIterator it = new EntrySetIterator();
		HexTile currentTile = null;
		
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public HexTile next() {
			if (!hasNext())
				throw new NoSuchElementException("You have reached the end, my friend!");
			Node currentNode = it.next();
			currentTile = new HexTile(currentNode.terrain, currentNode.loc);
			return currentTile;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			HexBoard.this.remove(currentTile);
		}
		
	}
	
	private class EntrySet extends AbstractSet<Map.Entry<HexCoordinate, Terrain>>
	{

		// Required by Java
		@Override
		public Iterator<Entry<HexCoordinate, Terrain>> iterator() {
			return new EntrySetIterator();
		}

		// Required by Java
		@Override
		public int size() {
			return HexBoard.this.size;
		}
		
	}
	
	private class MyMap extends AbstractMap<HexCoordinate, Terrain>
	{

		// Added for functionality
		@Override
		public Terrain put(HexCoordinate key, Terrain value) {
			Terrain t = value;
			t = HexBoard.this.terrainAt(key);
			HexBoard.this.add(new HexTile(value,key));
			return t;
		}

		// Required by Java
		@Override
		public Set<Entry<HexCoordinate, Terrain>> entrySet() {
			return new EntrySet();
		}

		// Added for functionality
		@Override
		public Terrain remove(Object key) {
			HexTile ht = null;		
			if ((key instanceof HexTile))
			{
				ht = (HexTile)key;
			}
			else
				return null;
			if (!contains(ht)) return null;
			root = doRemove(root,ht);
			--size;
			++version;
			return ht.getTerrain();
		}
		
	}
}
