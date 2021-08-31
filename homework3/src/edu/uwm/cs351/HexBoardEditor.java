package edu.uwm.cs351;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import edu.uwm.cs351.util.ArrayCollection;

public class HexBoardEditor extends JFrame {
	/**
	 * Eclipse wants this
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		final Collection<HexTile> seq = new ArrayCollection<HexTile>();
		try {
			for (String arg : args) {
				readSeq(seq,new BufferedReader(new FileReader(arg)));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final HexBoardEditor x = new HexBoardEditor(seq);
				x.setSize(800, 500);
				x.setVisible(true);
				// indicate that we don't want automatic close:
				x.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				// if someone closes the window, then we print out all the hex tiles and then
				// dispose the window
				x.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosing(WindowEvent e) {
						// TODO: print out all tiles in the picture to standard output
						
						Iterator<HexTile> it = seq.iterator();
						
						while (it.hasNext())
						{
							HexTile next = it.next();
							System.out.println(next);
						}
						
						x.setVisible(false);
						x.dispose();
					}
					
				});
			}
		});
	}
	
	private static void readSeq(Collection<HexTile> seq, BufferedReader r) throws IOException {
		String input;
		while ((input = r.readLine()) != null) {
			try {
				// TODO: add new tile to sequence
				HexTile newtile;
				newtile = HexTile.fromString(input.toString());
				seq.add(newtile);
				
			} catch (FormatException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private final Collection<HexTile> board;
	private HexCoordinate selected  = new HexCoordinate(0,0,0);
	private HexTile tile = null;
	private HexTile clicked = null;
	private Terrain currentTerrain = Terrain.INACCESSIBLE;
	private JComboBox<Integer> sizeSelector = new JComboBox<>(new Integer[]{10,15,20,30,50,75,100,150,200,500});
	private JLabel terrainIndicator = new TerrainIndicator();
	boolean vacant;
	
	/**
	 * Return the currently selected hexagon width
	 * @return current hexagon width
	 */
	protected int getHexWidth() {
		return ((Integer)sizeSelector.getSelectedItem()).intValue();
	}

	public HexBoardEditor(final Collection<HexTile> seq) {
		board = seq;
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		final HexPanel hexPanel = new HexPanel();
		contentPane.add(hexPanel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		// TODO: Add buttons (use JButton) to the buttonPanel for each kind of terrain's name,
		// setting background color and making opaque, and then activate them
		// by adding an action listener to set the current terrain and make
		// sure the indicator repaints.
		
		JButton inaccessible = new JButton("INACCESSIBLE");
		inaccessible.setBackground(Terrain.INACCESSIBLE.getColor());
		inaccessible.setForeground(Color.WHITE);
		buttonPanel.add(inaccessible);
		inaccessible.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				terrainIndicator.setBackground(Terrain.INACCESSIBLE.getColor());
				terrainIndicator.setForeground(Color.WHITE);
				terrainIndicator.setText("INACCESSIBLE");
			}
		});
		
		
		JButton water = new JButton("WATER");
		water.setBackground(Terrain.WATER.getColor());
		water.setForeground(Color.BLACK);
		buttonPanel.add(water);
		water.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				terrainIndicator.setBackground(Terrain.WATER.getColor());
				terrainIndicator.setForeground(Color.BLACK);
				terrainIndicator.setText("WATER");
			}
		});
		
		JButton land = new JButton("LAND");
		land.setBackground(Terrain.LAND.getColor());
		land.setForeground(Color.BLACK);
		buttonPanel.add(land);
		land.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				terrainIndicator.setBackground(Terrain.LAND.getColor());
				terrainIndicator.setForeground(Color.BLACK);
				terrainIndicator.setText("LAND");
			}
		});
		
		JButton forest = new JButton("FOREST");
		forest.setBackground(Terrain.FOREST.getColor());
		forest.setForeground(Color.BLACK);
		buttonPanel.add(forest);
		forest.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				terrainIndicator.setBackground(Terrain.FOREST.getColor());
				terrainIndicator.setForeground(Color.BLACK);
				terrainIndicator.setText("FOREST");
			}
		});
		
		JButton mountain = new JButton("MOUNTAIN");
		mountain.setBackground(Terrain.MOUNTAIN.getColor());
		mountain.setForeground(Color.BLACK);
		buttonPanel.add(mountain);
		mountain.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				terrainIndicator.setBackground(Terrain.MOUNTAIN.getColor());
				terrainIndicator.setForeground(Color.BLACK);
				terrainIndicator.setText("MOUNTAIN");
			}
		});
		
		JButton city = new JButton("CITY");
		city.setBackground(Terrain.CITY.getColor());
		city.setForeground(Color.BLACK);
		buttonPanel.add(city);
		city.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				terrainIndicator.setBackground(Terrain.CITY.getColor());
				terrainIndicator.setForeground(Color.BLACK);
				terrainIndicator.setText("CITY");
			}
		});
		
		JButton desert = new JButton("DESERT");
		desert.setBackground(Terrain.DESERT.getColor());
		desert.setForeground(Color.BLACK);
		buttonPanel.add(desert);
		desert.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				terrainIndicator.setBackground(Terrain.DESERT.getColor());
				terrainIndicator.setForeground(Color.BLACK);
				terrainIndicator.setText("DESERT");
			}
		});
		
		JPanel indicatorPanel = new JPanel();
		sizeSelector.setSelectedItem(HexTile.WIDTH);
		sizeSelector.addActionListener((ae) -> { hexPanel.repaint(); }); // lambda syntax is SHORT!
		indicatorPanel.add(new JLabel("Current Terrain:"));
		indicatorPanel.add(terrainIndicator);
		indicatorPanel.add(new JLabel("  Hexagon Width:"));
		indicatorPanel.add(sizeSelector);
		contentPane.add(indicatorPanel,BorderLayout.NORTH);
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
		this.setContentPane(contentPane);
		// TODO: if the hex panel is single clicked, 
		// select the location (so it gets highlighted).
		// Use HexTile.WIDTH as the width of hex tiles.
		//
		// If a double click, then if there is no tile there already, 
		// a new tile of the currently selected terrain should be created there.
		// If the current terrain is INACCESSIBLE then delete any existing tile.
		// Otherwise, replace any existing tile with a new tile of the current terrain.
		//
		// Thus INACCESSIBLE is normally an eraser; 
		// but if you double click in an empty area, 
		// then it WILL create an INACCESSIBLE tile.  
		//
		// Afterwards, in any case, tell the hex panel that
		// it needs to be repainted.
		
		hexPanel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Point p = e.getPoint();
				HexCoordinate h = HexCoordinate.fromPoint(p, getHexWidth());
				Terrain t = Terrain.valueOf(terrainIndicator.getText());
				tile = new HexTile(t, h);
				switch(e.getClickCount())
				{
				case 1:
				{
					vacant = true;
					clicked = new HexTile(currentTerrain, h);
					Iterator<HexTile> it = seq.iterator();
					
					while (it.hasNext())
					{
						HexTile next = it.next();
						
						if (next.getLocation().equals(clicked.getLocation()))
						{
							clicked = new HexTile(next.getTerrain(), h);
							vacant = false;
						}
						
	
					}
					break;
				}
				case 2:
				{
					
					Iterator<HexTile> it = seq.iterator();
					boolean removed = false;
					
					while (it.hasNext() && removed == false && tile.getTerrain().equals(Terrain.INACCESSIBLE))
					{
						HexTile next = it.next();
						
						if (next.getLocation().equals(tile.getLocation()) && tile.getTerrain().equals(Terrain.INACCESSIBLE))
						{
							it.remove();
							removed = true;
						}
					}
					
					if (removed == false)
						seq.add(tile);
					break;
				}
				}
				hexPanel.repaint();

			}
		});
	}
		
	private final class HexPanel extends JPanel {
		/**
		 * Keep Eclipse happy
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // render background
			int width = getHexWidth();
			// TODO: render all tiles and outline selected area with magenta.
			// Use "width" as the width of the hex tiles.
//			if (tile != null)
//				tile.draw(g, width);
			
			if (board != null)
			{
				Iterator<HexTile> it = board.iterator();
				
				while(it.hasNext())
				{
					tile = it.next();
					tile.draw(g, width);
				}
			}
			
			if (clicked != null)
			{
				//clicked.draw(g, width);
				Polygon hexagon = clicked.getLocation().toPolygon(width);
				
				if (vacant = false)
				{
					g.setColor(clicked.getTerrain().getColor());
					g.fillPolygon(hexagon);
				}
				
				g.setColor(Color.MAGENTA);
				g.drawPolygon(hexagon);
				
			}
			
			
	
		}
	}
	
	private class TerrainIndicator extends JLabel {
		/**
		 * Keep Eclipse happy
		 */
		private static final long serialVersionUID = 1L;

		public TerrainIndicator() {
			super("INACCESSIBLE");
			this.setOpaque(true); // need this on some systems to activate color
			this.setBackground(Terrain.INACCESSIBLE.getColor());
			this.setForeground(Color.WHITE);
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		@Override
		public void repaint() {
			// TODO: set text and background color
			super.repaint();
		}
	}
}
