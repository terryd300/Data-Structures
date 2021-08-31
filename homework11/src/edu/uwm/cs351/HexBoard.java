package edu.uwm.cs351;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

import edu.uwm.cs.util.AbstractEntry;
import edu.uwm.cs.util.Primes;
import junit.framework.TestCase;

/**
 * An implementation of the HexBoard ADT using 
 * a hash table implementation.
 * A hex board is a collection of hex tiles except that there can 
 * never be two tiles at the same location. 
 */
public class HexBoard extends AbstractSet<HexTile> {

	private static class Node 
	extends AbstractEntry<HexCoordinate,Terrain> 
	{		
		Node(boolean ignored) {} // don't change this constructor (but you can add a different one)
		
		HexTile tile;
		Node next;

		
		@Override
		public HexCoordinate getKey() {
			return tile.getLocation(); // TODO - done
		}
		
		@Override
		public Terrain getValue() {
			return tile.getTerrain(); // TODO - done
		}
		
		@Override
		public Terrain setValue(Terrain v) {
			if (v == null) throw new IllegalArgumentException("can't have a null terrain!");
			Terrain result = getValue();
			// TODO - done
			return result;
		}
	}
	
	// data structure
	private Node[] array;
	private int size;
	private int version;
	
	private static boolean doReport = true; 
	private static boolean report(String s) {
		if (doReport) System.err.println("Invariant error: " + s);
		else System.out.println("Detected invariant error: " + s);
		return false;
	}
	
	// TODO: helper methods
	
	private Node n(HexTile t, Node n1) 
	{
		Node result = new Node(false);
		result.tile = t;
		result.next = n1;
		return result;
	}
	
	private void ensureCapacity(int minimumCapacity)
	{
		int newSize = Primes.nextPrime(minimumCapacity);
		
		Node[] newArray = new Node[newSize];
		Node oldElement = null;
		Node newElement = null;
		
		int newIndex;
		
		for (int i = 0; i < array.length; i++)
		{
			oldElement = array[i];
			
			while (oldElement != null)
			{
				newIndex = oldElement.getKey().hashCode() % newArray.length;
				
				newElement = newArray[newIndex];
				
				while (newElement.next != null)
				{
					newElement = newElement.next;
				}
				
				newElement.next = oldElement;
				
				oldElement = oldElement.next;
			}
		}
	}
	

	
	private boolean wellFormed() {
		// TODO check data structure - done
		
		// 1.  The array is not null
		
		if (array == null)
			return report ("The array is null!");
		
		// 2.  The number of entries is correctly summed in the "size" field.
		
		int sizecheck = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] != null)
			{
				Node test = array[i];

				do
				{
					sizecheck++;
					test = test.next;
					if (sizecheck > size)
						return report ("The size field is incorrect.");
					
				}	while (test != null);
			}
		}
		
		if (sizecheck != size)
			return report("The size field is incorrect");
		
		// 3.  The length of the array is a prime number.
		
		if (!Primes.isPrime(array.length))
			return report ("The length of the array is not a prime number!");
		
		// 4.  The array is neither too full nor too empty.
		
		if (array.length != 7 && size == 0)
			return report ("The array is too large");
		
		if (((double)size / array.length) > 0.75)
			return report ("The array is too small)");
		
		
		// 5.  Each entry is in the correct chain.
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] != null)
			{
				Node test = array[i];
				
				do
				{
					if (test.tile == null)
						return report ("There is a null tile in a chain.");
					
					if (test.getKey().hashCode() % array.length != i)
						return report ("There is an entry in the incorrect chain.");

					test = test.next;
				}	while (test != null);
			}		
		}
		
		// 6.  The chains contain no duplicates.
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] != null)
			{

				Node base = array[i];
				Node test = base.next;

				do
				{
					while (test != null)
					{
						if (base.getKey().equals(test.getKey()))
							return report ("There is a chain with a duplicate.");
						else
							test = test.next;
					}

					base = base.next;

					if (base != null) 
						test = base.next;

				}	while (base != null);
			}		
		}
		
		return true;
	}
	
	// Override for functionality
	
	@Override
	public boolean add(HexTile e) {
		// TODO Auto-generated method stub
		
		if (e == null)
			throw new NullPointerException("Unable to add a null tile.");
		
		int index;
		
		Node test = null;
		Node newNode = n(e, null);
		
		if ((double)(size + 1) / array.length > 0.75)
			ensureCapacity(size + 1);
		
		index = e.getLocation().hashCode() % array.length;
		
		if (array[index] == null)
		{	
			array[index] = newNode;	
			size++;
			return true;
		}
		
		test = array[index];
		
		while (test != null)
		{
			
			if (test.getKey().equals(e.getLocation()))
			{
				if (test.getValue().equals(e.getTerrain()))
					return report("Unable to add a duplicate tile.");
				else
				{
					test.setValue(e.getTerrain());
					return true;
				}
			}
			
			test = test.next;
		}
		
		test = newNode;
		size++;
		
		return true;
	}

	private HexBoard(boolean ignored) {} // do not change this constructor!
	
	/**
	 * Create an empty hex board.
	 */
	public HexBoard() {
		// TODO - done
		array = new Node[7];
		size = 0;
		version = 1;
		assert wellFormed() : "in constructor";
	}
	
	/** Return the terrain at the given coordinate or null
	 * if nothing at this coordinate.
	 * @param c hex coordinate to look for (null OK but pointless)
	 * @return terrain at that coordinate, or null if nothing
	 */
	public Terrain terrainAt(HexCoordinate l) {
		assert wellFormed() : "in terrainAt";
		// TODO - done
		Terrain t = null;
		
		int c = l.hashCode();
		int index = c % array.length;
		
		Node test = array[index];
		
		do
		{
			if (test == null)
				break;
			
			if (test.getKey().equals(l))
			{
				t = test.getValue();
				break;
			}
			
			test = test.next;
			
		}	while (test != null);
		
		return t;
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
	
		
	/**
	 * Return a view of this hex board as a map from hex coordinates to terrain.
	 * It is as efficient as the hex board itself.
	 * @return
	 */
	public Map<HexCoordinate,Terrain> asMap() {
		return new MyMap();
	}
	
	private class MyMap extends AbstractMap<HexCoordinate,Terrain> {
		@Override // required by Java
		public Set<Entry<HexCoordinate, Terrain>> entrySet() {
			return new EntrySet();
		}

		@Override // needed for functionality
		public Terrain put(HexCoordinate key, Terrain value) {
			Terrain t = terrainAt(key);
			add(new HexTile(value,key));
			return t;
		}

		@Override // needed for efficiency
		public Terrain get(Object key) {
			if (!(key instanceof HexCoordinate)) return null;
			return terrainAt((HexCoordinate)key);
		}

		@Override // needed for efficiency
		public boolean containsKey(Object key) {
			if (!(key instanceof HexCoordinate)) return false;
			return terrainAt((HexCoordinate)key) != null;
		}

		@Override // needed for efficiency
		public Terrain remove(Object key) {
			if (!(key instanceof HexCoordinate)) return null;
			HexCoordinate h = (HexCoordinate)key;
			Terrain t = terrainAt(h);
			if (t != null) HexBoard.this.remove(new HexTile(t,h));
			return t;
		}		
	}
	
	private class EntrySet extends AbstractSet<Entry<HexCoordinate,Terrain>> {

		@Override // required by Java
		public Iterator<Entry<HexCoordinate, Terrain>> iterator() {
			return new EntrySetIterator();
		}

		@Override // required by Java
		public int size() {
			return HexBoard.this.size();
		}

		@Override // required for efficiency
		public boolean contains(Object o) {
			if (!(o instanceof Entry<?,?>)) return false;
			Entry<?,?> entry = (Entry<?,?>)o;
			if (!(entry.getKey() instanceof HexCoordinate)) return false;
			HexCoordinate h = (HexCoordinate)entry.getKey();
			if (!(entry.getValue() instanceof Terrain)) return false;
			Terrain t = (Terrain)entry.getValue();
			return terrainAt(h) == t;
		}

		@Override // required for efficiency
		public boolean remove(Object o) {
			if (!(o instanceof Entry<?,?>)) return false;
			Entry<?,?> entry = (Entry<?,?>)o;
			if (!(entry.getKey() instanceof HexCoordinate)) return false;
			HexCoordinate h = (HexCoordinate)entry.getKey();
			if (!(entry.getValue() instanceof Terrain)) return false;
			Terrain t = (Terrain)entry.getValue();
			return HexBoard.this.remove(new HexTile(t,h));
		}		
	}
		
	private class MyIterator implements Iterator<HexTile> {
		// TODO: choose easy implementation - done
		
		private EntrySetIterator iterator;
		
		MyIterator() {
			// TODO - done
			iterator = new EntrySetIterator();
		}
		
		@Override
		public boolean hasNext() {
			if (iterator.hasNext())
				return true;
			else
				return false; // TODO - done
		}
		
		public HexTile next() {
			if (hasNext())
				return new HexTile(iterator.next().getValue(), iterator.next().getKey()); // TODO - done
			else
				throw new NoSuchElementException("You are at the end of the list.");
		}
		
		public void remove() {
			// TODO - done
			iterator.remove();
			return;
		}
	}
	
	private class EntrySetIterator implements Iterator<Entry<HexCoordinate,Terrain>> {
		
		private boolean wellFormed() {
			if (!HexBoard.this.wellFormed()) return false;
			// OPTIONAL: define an invariant on the iterator
			// (Only check if the iterator is not stale!)
			return true;
		}

		int counter = 0;
		
		private EntrySetIterator() {
			// TODO - done
			counter = -1;
			assert wellFormed();
		}
		
		@Override // required by Java
		public boolean hasNext() {
			if (counter <= array.length)
				return true;
			else
				return false; // TODO - done
		}

		@Override // required by Java
		public Entry<HexCoordinate,Terrain> next() {
			if (!hasNext())
				throw new NoSuchElementException("You are at the end of the line.");
			
			
			
			
			
			
			counter++;
			HexCoordinate c = array[counter].getKey();
			Terrain t = terrainAt(c);
			return (Entry<HexCoordinate, Terrain>) new HexTile(t, c); 
			// TODO - done
		}

		@Override // required for functionality
		public void remove() {
			// TODO
		}
	}
	
	public static class TestInternals extends TestCase {
		private HexBoard self;
		
		private void assertWellFormed(boolean val) {
			doReport = val;
			assertEquals(val,self.wellFormed());
		}
		
		private HexCoordinate h(int a, int b) {
			return new HexCoordinate(a,b);
		}
		
		private HexTile ht(Terrain t, HexCoordinate h) {
			return new HexTile(t,h);
		}
		
		private HexCoordinate h1 = h(3,0), h1x = h(10,0);
		private HexCoordinate h2 = h(2,1);
		private HexCoordinate h3 = h(3,1);
		private HexCoordinate h4 = h(2,2);
		private HexCoordinate h5 = h(3,2);
		private HexCoordinate h6 = h(4,2);
		private HexCoordinate h7 = h(7,4), h7x = h(8,4);
		
		private Node n(HexCoordinate h,Terrain t,Node n1) {
			Node result = new Node(false);
			result.tile = ht(t,h);
			result.next = n1;
			return result;
		}
		
		private Node clone(Node n) {
			return n(n.tile.getLocation(),n.tile.getTerrain(),n.next);
		}
		
		private static int unique = 0;
		
		@Override
		protected void setUp() {
			self = new HexBoard(false);
			self.size = 0;
			self.array = new Node[7];
			self.version = ++unique;
			assertWellFormed(true);
		}

		public void test() {
			System.out.println("h1.hashCode() = " + h1.hashCode());
			System.out.println("h2.hashCode() = " + h2.hashCode());
			System.out.println("h3.hashCode() = " + h3.hashCode());
			System.out.println("h4.hashCode() = " + h4.hashCode());
			System.out.println("h5.hashCode() = " + h5.hashCode());
			System.out.println("h6.hashCode() = " + h6.hashCode());
			System.out.println("h7.hashCode() = " + h7.hashCode());
			System.out.println("h1x.hashCode() = " + h1x.hashCode());
			System.out.println("h7x.hashCode() = " + h7x.hashCode());
		}
		public void testA() {
			self.array = null;
			assertWellFormed(false);
		}
		
		public void testB() {
			self.array = new Node[6];
			assertWellFormed(false);
			self.array = new Node[5];
			assertWellFormed(false);
			self.array = new Node[9];
			assertWellFormed(false);
		}
		
		public void testC() {
			self.array = new Node[11];
			assertWellFormed(false);
			self.array = new Node[17];
			assertWellFormed(false);			
		}
		
		public void testD() {
			Node n1 = n(h1,Terrain.CITY,null);
			self.size = 1;
			assertWellFormed(false);
			self.array[3] = n1;
			assertWellFormed(true);
			self.size = 0;
			assertWellFormed(false);
			self.size = 2;
			assertWellFormed(false);
		}
		
		public void testE() {
			Node n1 = n(h1,Terrain.CITY,null);
			self.size = 1;
			self.array[1] = n1;
			assertWellFormed(false);
			self.array[3] = n1;
			self.size = 2;
			assertWellFormed(false);
			self.array[1] = null;
			self.array[6] = n1;
			assertWellFormed(false);
		}
		
		public void testF() {
			Node n2 = n(h2,Terrain.WATER,null);
			self.size = 1;
			self.array[6] = n2;
			assertWellFormed(true);
			self.array = new Node[11];
			assertWellFormed(false);
			self.array[6] = n2;
			assertWellFormed(false);
			self.array[6] = null;
			self.array[5] = n2;
			assertWellFormed(true);
		}
		
		public void testG() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,null);
			self.array[3] = n1;
			self.array[6] = n2;
			assertWellFormed(false);
			self.size = 1;
			assertWellFormed(false);
			self.size = 3;
			assertWellFormed(false);
			self.size = 2;
			assertWellFormed(true);
		}
		
		public void testH() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,null);
			self.array[6] = n1;
			self.array[3] = n2;
			self.size = 2;
			assertWellFormed(false);
		}
		
		public void testI() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,n1);
			self.size = 2;
			self.array[3] = n2;
			assertWellFormed(false);
			self.array = new Node[17];
			self.array[3] = n2;
			assertWellFormed(true);
			self.array = new Node[7];
			self.array[6] = n2;
			assertWellFormed(false);
			self.array[3] = n1;
			assertWellFormed(false);
		}
		
		public void testJ() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,n1);
			self.size = 2;
			self.array = new Node[17];
			self.array[3] = n2;
			n1.next = clone(n2);
			n1.next.next = null;
			assertWellFormed(false);
			self.size = 3;
			assertWellFormed(false);
			n1.next.tile = ht(Terrain.FOREST,h1);
			assertWellFormed(false);
		}
		
		public void testK() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,n1);
			self.size = 2;
			self.array = new Node[17];
			self.array[3] = n2;
			n1.next = clone(n2);
			assertWellFormed(false);
			self.size = 3;
			assertWellFormed(false);
			n1.next.tile = ht(Terrain.FOREST,h1);
			assertWellFormed(false);
		}
		
		public void testL() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,n1);
			self.size = 2;
			self.array = new Node[17];
			self.array[3] = n2;
			n1.next = n2;
			assertWellFormed(false);
			n1.next = clone(n2);
			assertWellFormed(false);
			n1.next.next = n2;
			assertWellFormed(false);
			n1.next.next = n1;
			assertWellFormed(false);
		}
		
		public void testM() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,null);
			Node n3 = n(h3,Terrain.LAND,null);
			Node n4 = n(h4,Terrain.MOUNTAIN,null);
			Node n5 = n(h5,Terrain.DESERT,null);
			Node n6 = n(h6,Terrain.FOREST,null);
			Node n7 = n(h7,Terrain.INACCESSIBLE,null);
			self.array[3] = n1;
			self.array[6] = n2;
			self.array[0] = n3;
			self.size = 3;
			assertWellFormed(true);
			n1.next = n4;
			assertWellFormed(false);
			self.size = 4;
			assertWellFormed(true);
			self.array[4] = n5;
			self.size = 5;
			assertWellFormed(true);
			self.array[5] = n6; 
			self.size = 6;
			assertWellFormed(false);
			self.array[3] = null;
			self.size = 4;
			assertWellFormed(true);
			self.array[2] = n7;
			self.size = 5;
			assertWellFormed(true);
		}
		
		public void testN() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,null);
			Node n3 = n(h3,Terrain.LAND,null);
			Node n4 = n(h4,Terrain.MOUNTAIN,null);
			self.array[3] = n1;
			self.array[6] = n2;
			self.array[0] = n3;
			n1.next = n4;
			self.size = 4;
			assertWellFormed(true);
			n1.tile = null;
			assertWellFormed(false);
			n1.tile = ht(Terrain.FOREST,h1);
			assertWellFormed(true);
			n4.tile = null;
			assertWellFormed(false);
		}
		
		public void testO() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n1x = n(h1x,Terrain.WATER,n1);
			Node n4 = n(h4,Terrain.MOUNTAIN,n1x);
			Node n7x = n(h7x,Terrain.LAND,n4);
			self.array[3] = n7x;
			self.size = 4;
			assertWellFormed(true);
			n1.next = n1;
			assertWellFormed(false);
			n1.next = n1x;
			assertWellFormed(false);
			n1.next = n4;
			assertWellFormed(false);
			n1.next = n7x;
			assertWellFormed(false);
		}
	}
}
