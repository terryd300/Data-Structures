package edu.uwm.cs351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * An abstraction of a hexagonal game board.
 */
public class HexBoard extends AbstractCollection<HexTile> {
	// the only field is an ADT, no redundancy, no need for an invariant
	private Map<HexCoordinate,Terrain> contents = new HashMap<>();

	/** Return the terrain at the given coordinate or null
	 * if nothing at this coordinate.
	 * @param c hex coordinate to look for (null OK but pointless)
	 * @return terrain at that coordinate, or null if nothing
	 */
	public Terrain terrainAt(HexCoordinate c) {
		return contents.get(c);
		//return null; // TODO (very easy)
	}

	@Override // required by Java
	public Iterator<HexTile> iterator() {
		return new MyIterator();
	}

	@Override // required by Java
	public int size() {
		return contents.size();
		//return 0; // TODO
	}

	// TODO: What else?
	// Document with "//" the reason for every override
	// and add a "//" comment for other Collection methods when you don't need to.
	// (Except for the list in the homework.)
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#add(java.lang.Object)
	 */
	@Override
	public boolean add(HexTile e) {
		
		/*If the key and value are the same, return false
		 * If the key exists, but different value, replace value and return true
		 * If neither exists, add the key and value
		 * If e is null, throw new NullPointerException
		 */
		
		if (e == null)
			throw new NullPointerException("Unable to add a null element.");
		
		else if (!contents.containsKey(e.getLocation()))		//Neither
		{
			contents.put(e.getLocation(), e.getTerrain());
			return true;
		}
		
		else if (contents.containsKey(e.getLocation()))
		{
			if (contents.get(e.getLocation()).equals(e.getTerrain()))
				return false;
			else
			{
				contents.replace(e.getLocation(), e.getTerrain());
				return true;
			}
		}
		
		return false;
			
	}
	
	/**
	 * Read a hex board from a reader
	 * @param br read t read from, must not be null
	 * @throws FormatException if there is a format error in the final
	 * @throws IOException if an error reading
	 */
	public void read(BufferedReader br) throws FormatException, IOException {
		String line;
		while ((line = br.readLine()) != null) {
			add(HexTile.fromString(line));
		}
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#clear()
	 */
	@Override	// Override to use HashMap clear method instead of iterator's clear method.
	public void clear() {
		contents.clear();
	}

	/**
	 * Write a hex board out.
	 * @param p print writer to use.
	 */
	public void write(PrintWriter p) {
		for (HexTile h : this) {
			p.println(h.toString());
		}
		p.flush();
	}
	
	private class MyIterator implements Iterator<HexTile> {
		private Iterator<Map.Entry<HexCoordinate,Terrain>> base = contents.entrySet().iterator();
		
		@Override // required by Java
		public boolean hasNext() {
			return contents.entrySet().iterator().hasNext();
			//return false; // TODO: very easy, delegate to the "base" iterator
		}

		@Override // required by Java
		public HexTile next() {
			HexCoordinate answerCoord;
			Terrain answerTerr;
			
			answerCoord = contents.entrySet().iterator().next().getKey();
			answerTerr = contents.get(answerCoord);
			
			return new HexTile(answerTerr, answerCoord);
			
			//return null; // TODO: use base iterator and generate hex tile on demand
		}

		// TODO: what else?
	}
}
