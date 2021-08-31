package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.lang.annotation.Target;

/**
 * A hexagonal game tail with a particular coordinate and terrain.
 */
public class HexTile {

	public static final int WIDTH = 50; // subject to change
	
	private final Terrain terrain;
	private final HexCoordinate location;
	
	/**
	 * Create a hexagonal tile for the given terrain and location in hex coordinates.
	 * @param t terrain, must not be null
	 * @param loc location, must not be null
	 * @exception IllegalArgumentException if either argument is null
	 */
	public HexTile(Terrain t, HexCoordinate loc) {
		if (t == null || loc == null) throw new IllegalArgumentException("neither terrain nor location may be null");
		terrain = t;
		location = loc;
	}
	
	@Override
	public String toString() {
		return terrain.toString() + location.toString();
	}
	
	/**
	 * Return terrain of this tile.
	 * @return terrain of this tile
	 */
	public Terrain getTerrain() { return terrain; }
	
	/**
	 * Return location of this tile.
	 * @return location of this tile
	 */
	public HexCoordinate getLocation() { return location; }
	
	/**
	 * Render the tile in a graphics context.
	 * We fill the hexagon with the terrain suggested color and then
	 * outline the tile in black.
	 * @param g context to use, must not be null
	 */
	public void draw(Graphics g) {
		draw(g, WIDTH);
	}

	/**
	 * Render the tile in a graphics context.
	 * We fill the hexagon with the terrain suggested color and then
	 * outline the tile in black.
	 * @param g context to use, must not be null
	 * @param width width of hexagon
	 */
	public void draw(Graphics g, int width) {
		Polygon hexagon = location.toPolygon(width);
		g.setColor(terrain.getColor());
		g.fillPolygon(hexagon);
		g.setColor(Color.BLACK);
		g.drawPolygon(hexagon);
	}
	
	// TODO: define static method fromString.  Make sure to document it!
	
	/** 
	 * Reads in a string and returns a corresponding HexTile coordinates and tile terrain
	 * 
	 * @param tile String of terrain and coordinates
	 * @return HexTile location and terrain type
	 * @exception FormatException if string is not in format of terrain<a, b, c>
	 */
	
	public static HexTile fromString(String tile)
	{
		if (tile.isEmpty())
			throw new FormatException ("The Tile is Empty.");
		
		int a, b, c;
		String terrain;
		Terrain ground;
		int commacount = 0;
		int lastcomma = -1;
		int commaone = -1; 
		int commatwo = -1;
		int bracketone = -1;
		
		bracketone = tile.indexOf("<");
		
		if (bracketone == -1)
			throw new FormatException ("There were no coordinates found in the string.");
		
		// Find all the commas in the string.  If 3 more more commas exist, then the string is invalid and no longer need to loop			
		while (tile.indexOf(",", lastcomma + 1) != -1 && commacount < 3)
		{
			lastcomma = tile.indexOf(",", lastcomma + 1);
			commacount++;

			//Places index of comma into correct location depending on which comma it is.
			switch (commacount)
			{
			case 1:	commaone = lastcomma; break;
			case 2: commatwo = lastcomma; break;
			}
		}
		
		if (commacount != 2)
			throw new FormatException ("There are an incorrect number of commas in the string.");
		
		terrain = tile.substring(0, bracketone);
		
		try
		{
			a = Integer.parseInt(tile.substring(bracketone + 1, commaone));	// Start at bracketone + 1 due to terrain at beginning.
			b = Integer.parseInt(tile.substring(commaone + 1, commatwo));  // Add one to skip over leading comma
			c = Integer.parseInt(tile.substring(commatwo + 1, tile.length() - 1)); // Subtract one to remove ending bracket.
		}

		catch (NumberFormatException e)
		{
			throw new FormatException ("There are extra non-integer characters in the string");
		}

		if (c != a - b)
			throw new IllegalArgumentException ("The Hex Coordinate is invalid.");
		
		try
		{
			ground = Terrain.valueOf(terrain);
		}
		
		catch (IllegalArgumentException e)
		{
			throw new IllegalArgumentException ("Incorrect Terrain Type");
		}
		
		return new HexTile(ground, new HexCoordinate(a,b));
		
	}

}
