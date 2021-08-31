import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.Supplier;

import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs.util.NamedComparator;
import edu.uwm.cs.util.NaturalComparator;
import edu.uwm.cs.util.ReverseComparator;
import edu.uwm.cs351.util.PriorityQueue;


public class TestPriorityQueue1 extends LockedTestCase {
	protected <T> void assertException(Class<?> excClass, Runnable f) {
		try {
			f.run();
			assertFalse("Should have thrown an exception, not returned",true);
		} catch (RuntimeException ex) {
			if (!excClass.isInstance(ex)) {
				ex.printStackTrace();
				assertFalse("Wrong kind of exception thrown: "+ ex.getClass().getSimpleName(),true);
			}
		}		
	}

	private PriorityQueue<String> pq;
	private Queue<TestUtil.Point> qp;
	
	private Iterator<String> it;
	private Iterator<TestUtil.Point> ip;
	
	private boolean sortIsStable = true;
	
	// These are all packed in "NamedComparator" to make sure
	// student code never tries to test the type of the comparator.
	private static final Comparator<String>
		cnat = new NamedComparator<>("",new NaturalComparator<>()),
		crev = new NamedComparator<>("",new ReverseComparator<>(cnat)),
		ccio = new NamedComparator<>("",String.CASE_INSENSITIVE_ORDER),
		crci = new NamedComparator<>("",new ReverseComparator<>(ccio)),
		cuns = new NamedComparator<>("",null);

	private TestUtil.Point p(int x, int y) { return TestUtil.p(x,y); }
	
	/**
	 * Convert the result into a string, or into the name of the exception thrown
	 * @param supp supplier of something, may return null
	 * @return string of result, or simple name of exception thrown
	 */
	protected <U> String toString(Supplier<U> supp) {
		try {
			return ""+supp.get();
		} catch (RuntimeException ex) {
			return ex.getClass().getSimpleName();
		}
	}

	protected void setUp() {
		try {
			assert pq.size() == 42;
			assertTrue("Assertions not enabled.  Add -ea to VM Args Pane in Arguments tab of Run Configuration",false);
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
		pq = new PriorityQueue<String>(String.CASE_INSENSITIVE_ORDER);
		qp = new PriorityQueue<TestUtil.Point>(TestUtil.pointLex);
	}

	
	/// locked tests
	
	public void test() {
		pq = new PriorityQueue<String>(String.CASE_INSENSITIVE_ORDER);
		pq.add("Babar");
		pq.add("Tintin");
		pq.add("asterix");
		assertEquals(Ts(266711480),toString(() -> pq.poll()));
		assertEquals(Ts(615516935),toString(() -> pq.peek())); // this is peek!
		assertEquals(Ts(452378790),toString(() -> pq.poll())); // now poll again
		assertEquals(Ts(1401642950),toString(() -> pq.poll()));
		assertEquals(Ts(2021641141),toString(() -> pq.poll())); // read homework!
		testMore(pq);
	}
	
	private void testMore(Object ignored) {
		pq = new PriorityQueue<>(null); // read homework!
		pq.add("Bread");
		pq.add("DONUTS!");
		pq.add("apples");
		assertEquals(Ts(1233559284),toString(() -> pq.poll()));
		assertEquals(Ts(2062818015),toString(() -> pq.poll()));
		assertEquals(Ts(1345666108),toString(() -> pq.poll()));
		assertEquals(Ts(908862969),toString(() -> pq.peek()));
		testReverse(pq);
	}
	
	private void testReverse(Object ignored) {
		pq = new PriorityQueue<String>(String.CASE_INSENSITIVE_ORDER);
		pq.add("polish");
		pq.add("Polish");
		pq.add("french");
		pq.reverse();
		assertEquals(Ts(255027957),toString(() -> pq.poll()));
		assertEquals(Ts(713812398),toString(() -> pq.poll()));
		testSort1(pq);
	}
	
	private void testSort1(Object ignored) {
		pq = new PriorityQueue<>(String.CASE_INSENSITIVE_ORDER);
		pq.add("cent");
		pq.add("Dollar");
		pq.setComparator(new NaturalComparator<>());
		// natural comparator uses String.compareTo
		// ASCII uppercase comes before lowercase
		assertEquals(Ts(449902312),toString(() -> pq.poll()));	
		testSort2(pq);
	}
	
	private void testSort2(Object ignored) {
		pq = new PriorityQueue<>(null);
		pq.add("abc");
		pq.add("xyzzy");
		pq.add("ABC");
		pq.setComparator(String.CASE_INSENSITIVE_ORDER);
		// sorting should be 'stable': leave relative order of equivalent things the same
		assertEquals(Ts(225953796),toString(() -> pq.poll()));			
	}
	
	
	/// testOnn: testing offer
	
	public void testO00() {
		assertTrue(pq.offer(""));
	}
	
	public void testO01() {
		pq.offer("apple");
		assertEquals(1,pq.size());
	}
	
	public void testO02() {
		pq.offer("bread");
		it = pq.iterator();
		assertTrue(it.hasNext());
	}
	
	public void testO03() {
		pq.offer("carrot");
		it = pq.iterator();
		assertEquals("carrot",it.next());
	}
	
	public void testO04() {
		pq.offer("daisy");
		it = pq.iterator();
		it.next();
		assertFalse(it.hasNext());
	}
	
	public void testO05() {
		assertTrue(pq.offer("donut"));
	}
	
	public void testO06() {
		assertTrue(qp.offer(p(0,6)));
		assertEquals(1,qp.size());
	}
	
	public void tstO07() {
		qp.offer(p(0,7));
		ip = qp.iterator();
		assertEquals(p(0,7),it.next());
	}
	
	public void testO10() {
		pq.offer("egg");
		pq.offer("flour");
		assertEquals(2,pq.size());
	}
	
	public void testO11() {
		pq.offer("grape");
		pq.offer("Hello");
		it = pq.iterator();
		assertEquals("grape",it.next());
		assertEquals("Hello",it.next());
	}
	
	public void testO12() {
		pq.offer("Jello");
		pq.offer("ice");
		it = pq.iterator();
		assertEquals("ice",it.next());
		assertEquals("Jello",it.next());
	}
	
	public void testO13() {
		pq.offer("kale");
		assertTrue(pq.offer("kale"));
	}
	
	public void testO14() {
		pq.offer("lettuce");
		pq.offer("lettuce");
		assertEquals(2,pq.size());
	}
	
	public void testO15() {
		pq.offer("orange");
		assertTrue(pq.offer("Orange"));
	}
	
	public void testO16() {
		pq.offer("pie");
		pq.offer("Pie");
		it = pq.iterator();
		assertEquals("pie",it.next());
		assertEquals("Pie",it.next());
	}
	
	public void testO17() {
		pq.offer("Quinoa");
		pq.offer("quinoa");
		it = pq.iterator();
		assertEquals("Quinoa",it.next());
		assertEquals("quinoa",it.next());
	}
	
	public void testO18() {
		pq.offer("Radish");
		pq.offer("rad");
		it = pq.iterator();
		assertEquals("rad",it.next());
		assertEquals("Radish",it.next());
	}
	
	public void testO19() {
		qp.offer(p(1,9));
		qp.offer(p(1,9));
		assertEquals(2,qp.size());
	}
	
	public void testO20() {
		pq.offer("straw");
		pq.offer("sun");
		pq.offer("Strawberry");
		assertEquals(3,pq.size());
	}
	
	public void testO21() {
		pq.offer("tea");
		pq.offer("tower");
		pq.offer("test");
		it = pq.iterator();
		assertEquals("tea",it.next());
		assertEquals("test",it.next());
		assertEquals("tower",it.next());
	}
	
	public void testO22() {
		pq.offer("uncle");
		pq.offer("Upside");
		pq.offer("umbrella");
		it = pq.iterator();
		assertEquals("umbrella",it.next());
		assertEquals("uncle",it.next());
		assertEquals("Upside",it.next());
	}
	
	public void testO23() {
		pq.offer("violet");
		pq.offer("violin");
		pq.offer("Violet");
		assertEquals(3,pq.size());
	}
	
	public void testO24() {
		pq.offer("web");
		pq.offer("Web");
		pq.offer("web");
		it = pq.iterator();
		assertEquals("web",it.next());
		assertEquals("Web",it.next());
		assertEquals("web",it.next());
	}
	
	public void testO25() {
		pq.offer("xxx");
		pq.offer("xx");
		pq.offer("x");
		it = pq.iterator();
		assertEquals("x",it.next());
		assertEquals("xx",it.next());
		assertEquals("xxx",it.next());
	}
	
	public void testO27() {
		qp.offer(p(2,7));
		qp.offer(p(7,2));
		qp.offer(p(3,3));
		ip = qp.iterator();
		assertEquals(p(2,7),ip.next());
		assertEquals(p(3,3),ip.next());
		assertEquals(p(7,2),ip.next());
	}
	
	public void testO28() {
		qp.offer(p(8,2));
		qp.offer(p(2,8));
		qp.offer(p(2,8));
		ip = qp.iterator();
		assertEquals(p(2,8),ip.next());
		assertEquals(p(2,8),ip.next());
		assertEquals(p(8,2),ip.next());
	}
	
	public void testO97() {
		assertException(NullPointerException.class, () -> pq.add(null));
	}
	
	public void testO98() {
		assertException(NullPointerException.class, () -> pq.offer(null));
	}
	
	public void testO99() {
		qp.offer(p(9,9));
		assertException(NullPointerException.class, () -> qp.offer(null));
	}
	
	
	/// testPnn: testing peek (nn < 40)
	
	public void testP00() {
		assertNull(pq.peek());
	}
	
	public void testP01() {
		assertNull(qp.peek());
	}
	
	public void testP10() {
		pq.add("ten");
		assertEquals("ten",pq.peek());
	}
	
	public void testP11() {
		pq.add("eleven");
		pq.peek();
		assertEquals(1,pq.size());
	}
	
	public void testP12() {
		pq.add("twelve");
		pq.peek();
		assertEquals("twelve",pq.peek());
	}
	
	public void testP13() {
		pq.add("macaroni");
		pq.peek();
		it = pq.iterator();
		assertEquals("macaroni",pq.peek());
	}
	
	public void testP15() {
		qp.add(p(1,4));
		assertEquals(p(1,4),qp.peek());
		assertEquals(1,qp.size());
	}
	
	public void testP20() {
		pq.add("Tea");
		pq.add("TeX");
		assertEquals("Tea",pq.peek());
	}
	
	public void testP21() {
		pq.add("TwentyOne");
		pq.add("21");
		assertEquals("21",pq.peek());
	}
	
	public void testP22() {
		pq.add("Twenty-Two");
		pq.add("twenty-two");
		assertEquals("Twenty-Two",pq.peek());
	}
	
	public void testP23() {
		pq.add("Win");
		pq.add("win");
		pq.add("wifi");
		assertEquals("wifi",pq.peek());
	}
	
	public void testP24() {
		pq.add("xxx");
		pq.add("Xray");
		pq.add("xray");
		assertEquals("Xray",pq.peek());
	}
	
	public void testP25() {
		pq.add("Yule");
		pq.add("year");
		pq.add("yule");
		assertEquals("year",pq.peek());
	}
	
	public void testP28() {
		qp.add(p(2,5));
		qp.add(p(2,5));
		assertEquals(p(2,5),qp.peek());
	}
	
	public void testP29() {
		qp.add(p(9,2));
		qp.add(p(2,9));
		ip = qp.iterator();
		qp.peek(); // does not cause anything to go stale
		assertTrue(ip.hasNext());
		assertEquals(p(2,9),ip.next());
	}
	
	public void testP30() {
		pq.add("a");
		pq.add("B");
		pq.add("c");
		assertEquals("a",pq.peek());
	}
	
	public void testP31() {
		pq.add("B");
		pq.add("a");
		pq.add("c");
		assertEquals("a",pq.peek());
	}
	
	public void testP32() {
		pq.add("c");
		pq.add("a");
		pq.add("B");
		assertEquals("a",pq.peek());
	}
	
	public void testP33() {
		pq.add("B");
		pq.add("c");
		pq.add("a");
		assertEquals("a",pq.peek());
	}
	
	public void testP34() {
		pq.add("a");
		pq.add("c");
		pq.add("B");
		assertEquals("a",pq.peek());
	}
	
	public void testP35() {
		pq.add("c");
		pq.add("B");
		pq.add("a");
		assertEquals("a",pq.peek());
	}
	
	public void testP39() {
		pq.add("dice");
		pq.add("DICE");
		pq.add("Dice");
		assertEquals("dice",pq.peek());
	}
	
	
	/// testPnn: testing poll (nn >= 40)
	
	public void testP40() {
		assertNull(pq.poll());
	}
	
	public void testP41() {
		assertNull(qp.poll());
	}
	
	public void testP42() {
		pq.poll();
		assertEquals(0,pq.size());
	}
	
	public void testP43() {
		pq.add("43");
		assertEquals("43",pq.poll());
	}
	
	public void testP44() {
		pq.add("44");
		pq.poll();
		assertEquals(0,pq.size());
	}
	
	public void testP45() {
		pq.add("48");
		pq.poll();
		assertNull(pq.poll());
	}
	
	public void testP46() {
		pq.add("46");
		pq.poll();
		it = pq.iterator();
		assertFalse(it.hasNext());
	}
	
	public void testP47() {
		pq.add("47");
		it = pq.iterator();
		pq.poll();
		assertException(ConcurrentModificationException.class,() -> it.hasNext());
	}
	
	public void testP48() {
		qp.add(p(4,8));
		assertEquals(p(4,8),qp.poll());
		assertEquals(0,qp.size());
		assertNull(qp.poll());
	}
	
	public void testP50() {
		pq.add("apple");
		pq.add("Orange");
		assertEquals("apple",pq.poll());
	}
	
	public void testP51() {
		pq.add("grapes");
		pq.add("cherries");
		assertEquals("cherries",pq.poll());
	}
	
	public void testP52() {
		pq.add("Carrot");
		pq.add("CARROT");
		assertEquals("Carrot",pq.poll());
	}
	
	public void testP53() {
		pq.add("dog");
		pq.add("cat");
		pq.poll();
		assertEquals(1,pq.size());
	}
	
	public void testP54() {
		pq.add("egg");
		pq.add("Easter");
		pq.poll();
		it = pq.iterator();
		assertEquals("egg",it.next());
	}
	
	public void testP55() {
		pq.add("five");
		pq.add("FIVE");
		pq.poll();
		assertEquals("FIVE",pq.poll());
	}
	
	public void testP56() {
		pq.add("56");
		pq.add("56");
		pq.poll();
		assertEquals(1,pq.size());
	}
	
	public void testP58() {
		qp.add(p(5,8));
		qp.add(p(8,5));
		assertEquals(p(5,8),qp.poll());
		assertEquals(1,qp.size());
		assertEquals(p(8,5),qp.poll());
		assertEquals(0,qp.size());
	}
	
	public void testP60() {
		pq.add("a");
		pq.add("B");
		pq.add("c");
		assertEquals("a",pq.poll());
	}
	
	public void testP61() {
		pq.add("B");
		pq.add("a");
		pq.add("c");
		assertEquals("a",pq.poll());
	}
	
	public void testP62() {
		pq.add("c");
		pq.add("a");
		pq.add("B");
		assertEquals("a",pq.poll());
	}
	
	public void testP63() {
		pq.add("B");
		pq.add("c");
		pq.add("a");
		assertEquals("a",pq.poll());
	}
	
	public void testP64() {
		pq.add("a");
		pq.add("c");
		pq.add("B");
		assertEquals("a",pq.poll());
	}
	
	public void testP65() {
		pq.add("c");
		pq.add("B");
		pq.add("a");
		assertEquals("a",pq.poll());
	}
	
	public void testP66() {
		pq.add("abc");
		pq.add("ABC");
		pq.add("Abc");
		pq.poll();
		assertEquals(2,pq.size());
	}
	
	public void testP67() {
		pq.add("B");
		pq.add("c");
		pq.add("a");
		pq.poll();
		assertEquals("B",pq.poll());
	}
	
	public void testP68() {
		pq.add("a");
		pq.add("c");
		pq.add("C");
		pq.poll();
		assertEquals("c",pq.poll());
	}
	
	public void testP69() {
		pq.add("c");
		pq.add("B");
		pq.add("a");
		pq.poll();
		pq.poll();
		assertEquals("c",pq.poll());
	}
	
	public void testP70() {
		pq.add("apple");
		pq.add("bread");
		pq.add("APPLE");
		pq.poll();
		it = pq.iterator();
		assertEquals("APPLE",it.next());
	}
	
	public void testP77() {
		pq.add("77");
		pq.add("77");
		pq.add("77");
		pq.poll();
		it = pq.iterator();
		pq.poll();
		assertException(ConcurrentModificationException.class, () -> it.next());
	}
	
	public void testP78() {
		qp.add(p(7,8));
		qp.add(p(8,7));
		qp.add(p(7,7));
		assertEquals(p(7,7),qp.poll());
		assertEquals(2,qp.size());
		assertEquals(p(7,8),qp.poll());
		assertEquals(1,qp.size());
		ip = qp.iterator();
		assertTrue(ip.hasNext());
		assertEquals(p(8,7),ip.next());
		assertEquals(1,qp.size());
		assertEquals(p(8,7),qp.poll());
		assertException(ConcurrentModificationException.class, () -> ip.remove());
		assertEquals(0,qp.size());
		assertNull(qp.poll());
	}
	
	public void testP80() {
		pq.add("apples");
		pq.add("dates");
		pq.add("bread");
		pq.poll();
		pq.add("cheese");
		assertEquals("bread",pq.poll());
	}
	
	public void testP81() {
		pq.add("Apples");
		pq.add("dates");
		pq.add("bread");
		pq.poll();
		pq.poll();
		pq.add("cheese");
		assertEquals("cheese",pq.poll());
	}
	

	/// testQnn: testing queue methods (offer,peek,poll) without iterator
	
	public void testP88() {
		assertTrue(qp.offer(p(3,1)));
		assertTrue(qp.offer(p(1,3)));
		
		assertEquals(2,qp.size());
		
		assertEquals(p(1,3),qp.poll());
		assertEquals(1,qp.size());
		
		assertTrue(qp.offer(p(2,2)));
		assertEquals(p(2,2),qp.peek());
		
		ip = qp.iterator();
		assertTrue(ip.hasNext());
		assertEquals(p(2,2),ip.next());
		assertTrue(ip.hasNext());
		assertEquals(p(3,1),ip.next());
		assertFalse(ip.hasNext());
		
		qp.clear();
		assertEquals(0,qp.size());
		assertNull(qp.poll());
	}

	public void testQ00() {
		assertNull(qp.peek());
		assertNull(qp.poll());
	}
	
	public void testQ01() {
		assertTrue(pq.offer("hello"));
	}
	
	public void testQ02() {
		pq.offer("bye");
		assertEquals("bye",pq.peek());
	}
	
	public void testQ03() {
		pq.offer("");
		assertEquals("",pq.poll());
	}
	
	public void testQ04() {
		pq.offer("WI");
		pq.peek();
		assertEquals("WI",pq.poll());
	}
	
	public void testQ05() {
		pq.offer("WI");
		pq.poll();
		assertNull(pq.peek());
	}
	
	public void testQ06() {
		pq.offer("WI");
		pq.peek();
		assertEquals(false,pq.isEmpty());
	}
	
	public void testQ07() {
		pq.offer("WI");
		pq.poll();
		assertEquals(true,pq.isEmpty());
	}
	
	public void testQ08() {
		assertTrue(qp.offer(p(3,2)));
		assertFalse(qp.isEmpty());
		assertEquals(p(3,2),qp.peek());		
		assertEquals(p(3,2),qp.poll());
		assertEquals(true,qp.isEmpty());
		assertNull(qp.poll());
	}
	
	public void testQ09() {
		assertException(NullPointerException.class,() -> pq.offer(null));
	}
	
	public void testQ10() {
		pq.offer("apples");
		assertTrue(pq.offer("apples"));
	}
	
	public void testQ11() {
		pq.offer("bananas");
		assertTrue(pq.offer("BANANAS"));
	}
	
	public void testQ12() {
		pq.offer("Cheese");
		assertTrue(pq.offer("dates"));
	}
	
	public void testQ13() {
		pq.offer("Fish");
		assertTrue(pq.offer("eggs"));
	}
	
	public void testQ14() {
		pq.offer("grapes");
		pq.offer("grapes");
		assertEquals("grapes",pq.peek());
	}
	
	public void testQ15() {
		pq.offer("horse");
		pq.offer("Horse");
		assertEquals("horse",pq.peek());
	}
	
	public void testQ16() {
		pq.offer("ice");
		pq.offer("Jam");
		assertEquals("ice",pq.peek());
	}
	
	public void testQ17() {
		pq.offer("melon");
		pq.offer("lemon");
		assertEquals("lemon",pq.peek());
	}
	
	public void testQ18() {
		pq.offer("Nuts!");
		pq.offer("nuts!");
		assertEquals("Nuts!",pq.poll());
	}
	
	public void testQ19() {
		pq.offer("Pear");
		pq.offer("orange");
		assertEquals("orange",pq.poll());
	}
	
	public void testQ20() {
		pq.offer("Quince");
		pq.offer("quince");
		pq.poll();
		assertEquals("quince",pq.peek());
	}
	
	public void testQ21() {
		pq.offer("Rootbeer");
		pq.offer("root");
		pq.poll();
		assertEquals("Rootbeer",pq.peek());
	}
	
	public void testQ22() {
		pq.offer("salad");
		pq.offer("tuna");
		pq.poll();
		assertEquals("tuna",pq.peek());
	}
	
	public void testQ23() {
		pq.offer("urn");
		pq.offer("vase");
		pq.poll();
		assertFalse(pq.isEmpty());
	}
	
	public void testQ24() {
		pq.offer("whale");
		pq.offer("WATER");
		pq.poll();
		pq.poll();
		assertTrue(pq.isEmpty());
	}
	
	public void testQ25() {
		pq.offer("xxx");
		pq.offer("XXX");
		pq.poll();
		pq.poll();
		assertNull(pq.peek());
	}
	
	public void testQ26() {
		pq.offer("zebra");
		pq.offer("yak");
		pq.poll();
		pq.poll();
		assertNull(pq.poll());
	}
	
	public void testQ28() {
		qp.offer(p(2,8));
		qp.offer(p(8,2));
		assertFalse(qp.isEmpty());
		assertEquals(p(2,8),qp.peek());
		assertEquals(p(2,8),qp.poll());
		assertEquals(p(8,2),qp.peek());
		assertFalse(qp.isEmpty());
		assertEquals(p(8,2),qp.poll());
		assertTrue(qp.isEmpty());
		assertNull(qp.poll());
		assertNull(qp.peek());
		assertTrue(qp.isEmpty());
	}
	
	public void testQ30() {
		pq.offer("airplane");
		pq.offer("BOAT");
		pq.poll();
		assertTrue(pq.offer("car"));
	}
	
	public void testQ31() {
		pq.offer("boat");
		pq.offer("AIRPLANE");
		pq.poll();
		pq.offer("car");
		assertEquals("boat",pq.peek());
	}
	
	public void testQ32() {
		pq.offer("CAR");
		pq.offer("airplace");
		pq.poll();
		pq.offer("boat");
		assertEquals("boat",pq.poll());
	}
	
	public void testQ48() {
		assertTrue(qp.offer(p(4,8)));
		assertTrue(qp.offer(p(8,8)));
		assertTrue(qp.offer(p(6,6)));
		assertEquals(p(4,8),qp.poll());
		assertEquals(p(6,6),qp.peek());
		assertTrue(qp.offer(p(4,4)));
		assertEquals(p(4,4),qp.poll());
		assertEquals(p(6,6),qp.peek());
		assertTrue(qp.offer(p(8,4)));
		assertEquals(p(6,6),qp.poll());
		assertEquals(p(8,4),qp.peek());
		assertFalse(qp.isEmpty());
		assertEquals(p(8,4),qp.poll());
		assertEquals(p(8,8),qp.peek());
		assertFalse(qp.isEmpty());
		assertEquals(p(8,8),qp.poll());
		assertTrue(qp.isEmpty());
		assertEquals(null,qp.poll());
		assertEquals(null,qp.peek());
	}

	
	/// testRnn: testing reverse
	
	public void testR00() {
		pq.reverse();
		assertTrue(pq.isEmpty());
	}
	
	public void testR01() {
		pq.reverse();
		assertNull(pq.peek());
	}
	
	public void testR02() {
		pq.reverse();
		assertNull(pq.poll());
	}
	
	public void testR03() {
		pq.reverse();
		assertEquals(0,pq.size());
	}
	
	public void testR04() {
		pq.reverse();
		assertEquals(true,pq.offer("Hello"));
	}
	
	public void testR10() {
		pq.add("red");
		pq.reverse();
		assertFalse(pq.isEmpty());
	}
	
	public void testR11() {
		pq.add("orange");
		pq.reverse();
		assertEquals("orange",pq.peek());
	}
	
	public void testR12() {
		pq.add("yellow");
		pq.reverse();
		assertEquals(1,pq.size());
	}
	
	public void testR13() {
		pq.add("green");
		pq.reverse();
		assertEquals("green",pq.poll());
	}
	
	public void testR14() {
		pq.reverse();
		assertTrue(pq.offer("blue"));
	}
	
	public void testR15() {
		pq.reverse();
		pq.offer("indigo");
		assertFalse(pq.isEmpty());
	}
	
	public void testR16() {
		pq.reverse();
		pq.offer("violet");
		assertEquals("violet",pq.peek());
	}
	
	public void testR17() {
		pq.reverse();
		pq.add("ultra");
		pq.reverse();
		assertEquals("ultra",pq.poll());
	}
	
	public void testR18() {
		qp.add(p(1,8));
		((PriorityQueue<?>)qp).reverse();
		assertEquals(1,qp.size());
		assertEquals(p(1,8),qp.peek());
		assertEquals(p(1,8),qp.poll());
		assertTrue(qp.isEmpty());
		qp.offer(p(8,1));
		assertEquals(1,qp.size());
		assertEquals(p(8,1),qp.peek());
		((PriorityQueue<?>)qp).reverse();
		assertEquals(1,qp.size());
		assertEquals(p(8,1),qp.peek());
		assertEquals(p(8,1),qp.poll());
		assertTrue(qp.isEmpty());		
	}
	
	public void testR20() {
		pq.add("Milwaukee");
		pq.add("Madison");
		pq.reverse();
		assertEquals(2,pq.size());
	}
	
	public void testR21() {
		pq.add("Milwaukee");
		pq.add("Madison");
		pq.reverse();
		assertEquals("Milwaukee",pq.peek());
	}
	
	public void testR22() {
		pq.add("Milwaukee");
		pq.add("Madison");
		pq.reverse();
		assertEquals("Milwaukee",pq.poll());
	}
	
	public void testR23() {
		pq.add("WI");
		pq.add("wi");
		pq.reverse();
		assertEquals("wi",pq.peek());
	}
	
	public void testR24() {
		pq.add("WI");
		pq.add("wi");
		pq.reverse();
		assertEquals("wi",pq.poll());
	}
	
	public void testR25() {
		pq.add("Milwaukee");
		pq.reverse();
		pq.offer("Madison");
		assertEquals("Milwaukee",pq.peek());
	}
	
	public void testR26() {
		pq.add("Madison");
		pq.reverse();
		pq.offer("Milwaukee");
		assertEquals("Milwaukee",pq.peek());
	}
	
	public void testR27() {
		pq.reverse();
		pq.offer("Milwaukee");
		pq.offer("Madison");
		assertEquals("Milwaukee",pq.peek());
	}
	
	public void testR28() {
		pq.reverse();
		pq.offer("Madison");
		pq.offer("Milwaukee");
		assertEquals("Milwaukee",pq.peek());
	}
	
	public void testR29() {
		pq.reverse();
		pq.offer("wi");
		pq.offer("WI");
		assertEquals("wi",pq.peek());
	}
	
	public void testR30() {
		pq.add("a");
		pq.reverse();
		pq.offer("B");
		pq.offer("c");
		assertEquals("c",pq.peek());
	}
	
	public void testR31() {
		pq.add("a");
		pq.reverse();
		pq.offer("c");
		pq.offer("B");
		assertEquals("c",pq.peek());
	}
	
	public void testR32() {
		pq.add("B");
		pq.reverse();
		pq.offer("a");
		pq.offer("c");
		assertEquals("c",pq.peek());
	}
	
	public void testR33() {
		pq.add("B");
		pq.reverse();
		pq.offer("c");
		pq.offer("a");
		assertEquals("c",pq.peek());
	}
	
	public void testR34() {
		pq.add("c");
		pq.reverse();
		pq.offer("a");
		pq.offer("B");
		assertEquals("c",pq.peek());
	}
	
	public void testR35() {
		pq.add("c");
		pq.reverse();
		pq.offer("B");
		pq.offer("a");
		assertEquals("c",pq.peek());
	}
	
	public void testR36() {
		pq.reverse();
		pq.add("a");
		pq.add("B");
		pq.add("c");
		assertEquals("c",pq.peek());
	}
	
	public void testR38() {
		qp.add(p(3,8));
		((PriorityQueue<?>)qp).reverse();
		assertTrue(qp.offer(p(2,8)));
		assertTrue(qp.offer(p(8,3)));
		assertEquals(3,qp.size());
		assertEquals(p(8,3),qp.peek());
		assertEquals(p(8,3),qp.poll());
		((PriorityQueue<?>)qp).reverse();
		assertEquals(2,qp.size());
		assertEquals(p(2,8),qp.peek());
	}
	
	public void testR40() {
		pq.reverse();
		it = pq.iterator();
		assertFalse(it.hasNext());
	}
	
	public void testR41() {
		pq.reverse();
		pq.offer("one");
		it = pq.iterator();
		assertTrue(it.hasNext());
	}
	
	public void testR42() {
		pq.offer("two");
		pq.reverse();
		it = pq.iterator();
		assertEquals("two",it.next());
	}
	
	public void testR43() {
		pq.reverse();
		pq.add("three");
		it = pq.iterator();
		it.next();
		assertFalse(it.hasNext());
	}
	
	public void testR44() {
		pq.add("four");
		pq.add("4");
		it = pq.iterator();
		assertEquals(true,it.hasNext());
	}
	
	public void testR45() {
		pq.reverse();
		pq.offer("five");
		pq.offer("FIVE");
		it = pq.iterator();
		assertEquals("five",it.next());
	}
	
	public void testR46() {
		pq.offer("six");
		pq.offer("SIX");
		pq.reverse();
		it = pq.iterator();
		assertEquals("SIX",it.next());
	}
	
	public void testR47() {
		pq.offer("seven");
		pq.reverse();
		pq.offer("SEVEN");
		it = pq.iterator();
		it.next();
		assertEquals("SEVEN",it.next());
	}
	
	public void testR48() {
		((PriorityQueue<?>)qp).reverse();
		qp.add(p(4,8));
		qp.add(p(8,4));
		ip = qp.iterator();
		assertTrue(ip.hasNext());
		assertEquals(p(8,4),ip.next());
		assertTrue(ip.hasNext());
		assertEquals(p(4,8),ip.next());
		assertFalse(ip.hasNext());
	}
	
	public void testR49() {
		pq.add("nine");
		it = pq.iterator();
		pq.reverse();
		assertException(ConcurrentModificationException.class,() -> it.hasNext());
	}
	
	public void testR50() {
		pq.add("ten");
		pq.reverse();
		pq.add("Ten");
		pq.reverse();
		pq.add("TEn");
		pq.reverse();
		pq.add("TEN");
		it = pq.iterator();
		assertEquals("TEn",it.next());
		assertEquals("ten",it.next());
		assertEquals("Ten",it.next());
		assertEquals("TEN",it.next());
	}
	
	
	/// testSnn: testing setComparator
	
	public void testR51() {
		pq.add("hello");
		pq.reverse();
		pq.add("WORLD");
		
		assertEquals("WORLD",pq.element());
		
		pq.add("bye");
		
		pq.reverse();
		assertEquals("bye",pq.element());
	}

	public void testS00() {
		pq.setComparator(cnat);
		assertTrue(pq.isEmpty());
	}
	
	public void testS01() {
		pq.setComparator(crev);
		assertTrue(pq.isEmpty());
	}
	
	public void testS02() {
		pq.setComparator(ccio);
		assertTrue(pq.isEmpty());
	}
	
	public void testS03() {
		pq.setComparator(crci);
		assertTrue(pq.isEmpty());
	}
	
	public void testS04() {
		pq.setComparator(cuns);
		assertTrue(pq.isEmpty());
	}
	
	public void testS05() {
		pq.add("apple");
		pq.setComparator(cnat);
		assertFalse(pq.isEmpty());
	}
	
	public void testS06() {
		pq.add("apple");
		pq.setComparator(crev);
		assertFalse(pq.isEmpty());
	}
	
	public void testS07() {
		pq.add("apple");
		pq.setComparator(ccio);
		assertFalse(pq.isEmpty());
	}
	
	public void testS08() {
		pq.add("apple");
		pq.setComparator(crci);
		assertFalse(pq.isEmpty());
	}
	
	public void testS09() {
		pq.add("apple");
		pq.setComparator(cuns);
		assertFalse(pq.isEmpty());
	}
	
	public void testS10() {
		pq.setComparator(cnat);
		pq.add("bread");
		assertEquals("bread",pq.peek());
	}
	
	public void testS11() {
		pq.setComparator(crev);
		pq.add("bread");
		assertEquals("bread",pq.peek());
	}
	
	public void testS12() {
		pq.setComparator(ccio);
		pq.add("bread");
		assertEquals("bread",pq.peek());
	}
	
	public void testS13() {
		pq.setComparator(crci);
		pq.add("bread");
		assertEquals("bread",pq.peek());
	}
	
	public void testS14() {
		pq.setComparator(cuns);
		pq.add("bread");
		assertEquals("bread",pq.peek());
	}
	
	public void testS15() {
		pq.add("BREAD");
		pq.setComparator(cnat);
		assertEquals("BREAD",pq.poll());
	}
	
	public void testS16() {
		pq.add("BREAD");
		pq.setComparator(crev);
		assertEquals("BREAD",pq.poll());
	}
	
	public void testS17() {
		pq.add("BREAD");
		pq.setComparator(ccio);
		assertEquals("BREAD",pq.poll());
	}
	
	public void testS18() {
		pq.add("BREAD");
		pq.setComparator(crci);
		assertEquals("BREAD",pq.poll());
	}
	
	public void testS19() {
		pq.add("BREAD");
		pq.setComparator(cuns);
		assertEquals("BREAD",pq.poll());
	}
	
	public void testS20() {
		pq.add("car");
		pq.add("Train");
		pq.setComparator(cnat);
		it = pq.iterator();
		assertEquals("Train",it.next());
		assertEquals("car",it.next());
	}
	
	public void testS21() {
		pq.add("car");
		pq.add("Train");
		pq.setComparator(crev);
		it = pq.iterator();
		assertEquals("car",it.next());
		assertEquals("Train",it.next());
	}
	
	public void testS22() {
		pq.add("car");
		pq.add("Train");
		pq.setComparator(ccio);
		it = pq.iterator();
		assertEquals("car",it.next());
		assertEquals("Train",it.next());
	}
	
	public void testS23() {
		pq.add("car");
		pq.add("Train");
		pq.setComparator(crci);
		it = pq.iterator();
		assertEquals("Train",it.next());
		assertEquals("car",it.next());
	}
	
	public void testS24() {
		pq.add("car");
		pq.add("Train");
		pq.setComparator(cuns);
		it = pq.iterator();
		assertEquals("car",it.next());
		assertEquals("Train",it.next());
	}
	
	public void testS25() {
		pq.add("plane");
		pq.add("BOAT");
		pq.setComparator(cnat);
		it = pq.iterator();
		assertEquals("BOAT",it.next());
		assertEquals("plane",it.next());
	}
	
	public void testS26() {
		pq.add("plane");
		pq.add("BOAT");
		pq.setComparator(crev);
		it = pq.iterator();
		assertEquals("plane",it.next());
		assertEquals("BOAT",it.next());
	}
	
	public void testS27() {
		pq.add("plane");
		pq.add("BOAT");
		pq.setComparator(ccio);
		it = pq.iterator();
		assertEquals("BOAT",it.next());
		assertEquals("plane",it.next());
	}
	
	public void testS28() {
		pq.add("plane");
		pq.add("BOAT");
		pq.setComparator(crci);
		it = pq.iterator();
		assertEquals("plane",it.next());
		assertEquals("BOAT",it.next());
	}
	
	public void testS29() {
		pq.add("plane");
		pq.add("BOAT");
		pq.setComparator(cuns);
		it = pq.iterator();
		assertEquals("BOAT",it.next());
		assertEquals("plane",it.next());
	}
	
	public void testS30() {
		pq.setComparator(null);
		assertTrue(pq.isEmpty());
	}
	
	public void testS31() {
		pq.offer("apples");
		pq.setComparator(null);
		assertFalse(pq.isEmpty());
	}
	
	public void testS32() {
		pq.setComparator(null);
		pq.offer("bread");
		assertFalse(pq.isEmpty());
	}
	
	public void testS33() {
		pq.offer("carrots");
		pq.setComparator(null);
		pq.offer("dates");
		assertEquals(2,pq.size());
	}
	
	public void testS34() {
		pq.offer("fish");
		pq.setComparator(null);
		pq.offer("eggs");
		assertEquals("fish",pq.peek());
	}
	
	public void testS35() {
		pq.setComparator(null);
		pq.add("B");
		pq.add("a");
		pq.add("C");
		pq.setComparator(cnat);
		assertEquals("B",pq.poll());
		assertEquals("C",pq.poll());
	}
	
	public void testS36() {
		pq.setComparator(null);
		pq.add("B");
		pq.add("a");
		pq.add("C");
		pq.setComparator(crev);
		assertEquals("a",pq.poll());
		assertEquals("C",pq.poll());
	}
	
	public void testS37() {
		pq.setComparator(null);
		pq.add("B");
		pq.add("a");
		pq.add("C");
		pq.setComparator(ccio);
		assertEquals("a",pq.poll());
		assertEquals("B",pq.poll());
	}
	
	public void testS38() {
		pq.setComparator(null);
		pq.add("B");
		pq.add("a");
		pq.add("C");
		pq.setComparator(crci);
		assertEquals("C",pq.poll());
		assertEquals("B",pq.poll());
	}
	
	public void testS39() {
		pq.setComparator(null);
		pq.add("B");
		pq.add("a");
		pq.add("c");
		pq.setComparator(cuns);
		assertEquals("B",pq.poll());
		assertEquals("a",pq.poll());
	}
		
	public void testS40() {
		pq.add("zero");
		pq.add("ZERO");
		pq.add("Zero");
		pq.setComparator(cnat);
		assertEquals("ZERO",pq.poll());
		assertEquals("Zero",pq.poll());
	}

	public void testS41() {
		pq.add("zero");
		pq.add("ZERO");
		pq.add("Zero");
		pq.setComparator(crev);
		assertEquals("zero",pq.poll());
		assertEquals("Zero",pq.poll());
	}
	
	public void testS42() {
		pq.add("zero");
		pq.add("ZERO");
		pq.add("Zero");
		pq.setComparator(ccio);
		assertEquals("zero",pq.poll());
		assertEquals("ZERO",pq.poll());
	}
	
	public void testS43() {
		pq.add("zero");
		pq.add("ZERO");
		pq.add("Zero");
		pq.setComparator(crci);
		assertEquals("zero",pq.poll());
		assertEquals("ZERO",pq.poll());
	}
	
	public void testS44() {
		pq.add("zero");
		pq.add("ZERO");
		pq.add("Zero");
		pq.setComparator(cuns);
		assertEquals("zero",pq.poll());
		assertEquals("ZERO",pq.poll());
	}
	
	// the following tests check the stability of your mergesort algorithm
	// To be stable, you should preferentially merge in things from the left
	// rather than the right (if they are judges equal by the comparator).
	
	public void testS45() {
		pq.setComparator(null);
		pq.add("a");
		pq.add("B");
		pq.add("A");
		pq.setComparator(ccio);
		if (sortIsStable) {
			assertEquals("a",pq.poll());
			assertEquals("A",pq.poll());
			assertEquals("B",pq.poll());
		}
	}
	
	public void testS46() {
		pq.setComparator(null);
		pq.add("A");
		pq.add("B");
		pq.add("b");
		pq.add("a");
		pq.setComparator(crci);
		if (sortIsStable) {
			assertEquals("B",pq.poll());
			assertEquals("b",pq.poll());
			assertEquals("A",pq.poll());
			assertEquals("a",pq.poll());
		}
	}
	
	public void testS47() {
		pq.setComparator(null);
		pq.add("ab");
		pq.add("aB");
		pq.add("AAA");
		pq.add("Ab");
		pq.add("AB");
		pq.setComparator(ccio);
		if (sortIsStable) {
			assertEquals("AAA",pq.poll());
			assertEquals("ab",pq.poll());
			assertEquals("aB",pq.poll());
			assertEquals("Ab",pq.poll());
			assertEquals("AB",pq.poll());
		}
	}
	
	public void testS49() {
		pq.add("nine");
		pq.add("NINE");
		pq.add("Nine");
		pq.add("NiNe");
		pq.add("NINe");
		pq.add("niNE");
		pq.add("ninE");
		pq.add("nINE");
		pq.add("9");
		assertEquals("9",pq.peek());
		pq.setComparator(crci);
		// Mergesort is stable as long as you
		// implement merge correctly (when equal, choose from left).
		if (sortIsStable) {
			assertEquals("nine",pq.poll());
			assertEquals("NINE",pq.poll());
			assertEquals("Nine",pq.poll());
			assertEquals("NiNe",pq.poll());
			assertEquals("NINe",pq.poll());
			assertEquals("niNE",pq.poll());
			assertEquals("ninE",pq.poll());
			assertEquals("nINE",pq.poll());
			assertEquals("9",pq.poll());
		}
	}
	
	public void testS50() {
		pq.add("violin");
		pq.add("viola");
		pq.add("violoncello");
		it = pq.iterator();
		pq.setComparator(cuns);
		// even though nothing happened, iterator should be marked stale:
		assertException(ConcurrentModificationException.class, () -> it.hasNext());
	}
	
	public void testS51() {
		pq.add("violin");
		pq.add("viola");
		pq.add("violoncello");
		pq.setComparator(cnat);
		it = pq.iterator();
		assertEquals("viola",it.next());
		assertEquals("violin",it.next());
	}
	
	public void testS58() {
		assertSame(String.CASE_INSENSITIVE_ORDER,pq.getComparator());
		pq.reverse();
		Comparator<String> rc = pq.getComparator();
		assertTrue(rc.compare("hello", "Bye") < 0);
		pq.reverse();
		assertSame(String.CASE_INSENSITIVE_ORDER,pq.getComparator());
		
		pq.setComparator(cnat);
		Comparator<String> dc = pq.getComparator();
		assertTrue(dc == cnat);
		pq.reverse();
		dc = pq.getComparator();
		assertTrue(dc.compare("Hello", "bye") > 0);
		
		pq.setComparator(cuns);
		Comparator<String> uc = pq.getComparator();
		assertTrue(uc.compare("Hello", "bye") == 0);
	}

	public void testS61() {				
		pq.add("hello");
		pq.setComparator(null);
		assertEquals("hello",pq.peek());
		
		pq.reverse();
		assertEquals("hello",pq.iterator().next());
		assertEquals(1,pq.size());
		
		assertEquals("hello",pq.poll());
		assertEquals(0,pq.size());
	}

	public void testS62() {
		assertTrue(pq.offer("hello"));
		assertTrue(pq.offer("WORLD"));
		
		assertEquals(2,pq.size());
		assertEquals("hello",pq.peek());
		
		pq.reverse();
		assertEquals("WORLD",pq.peek());
		assertEquals(2,pq.size());
		
		pq.setComparator(null);
		assertEquals("WORLD",pq.peek());
		
		pq.reverse();
		assertEquals("hello",pq.iterator().next());
		
		assertEquals("hello",pq.poll());
		assertEquals(1,pq.size());
		assertEquals("WORLD",pq.peek());
		
		assertEquals("WORLD",pq.poll());
		assertTrue(pq.isEmpty());
		assertNull(pq.peek());
		assertNull(pq.poll());
	}

	public void testS63() {
		pq.add("hello");
		pq.add("Bye");
		pq.add("WORLD");
		
		it = pq.iterator();
		assertEquals("Bye",it.next());
		assertEquals("hello",it.next());
		assertEquals("WORLD",it.next());
		
		pq.reverse();
		it = pq.iterator();
		assertEquals("WORLD",it.next());
		assertEquals("hello",it.next());
		assertEquals("Bye",it.next());
		
		pq.setComparator(cnat);
		it = pq.iterator();
		assertEquals("Bye",it.next());
		assertEquals("WORLD",it.next());
		assertEquals("hello",it.next());
	
		pq.reverse();
		it = pq.iterator();
		assertEquals("hello",it.next());
		assertEquals("WORLD",it.next());
		assertEquals("Bye",it.next());
	}

	public void testS64() {
		pq.add("Hello");
		pq.add("WORLD");
		pq.add("goodbye");
		pq.add("Cold");
		
		it = pq.iterator();
		assertEquals("Cold",it.next());
		assertEquals("goodbye",it.next());
		assertEquals("Hello",it.next());
		assertEquals("WORLD",it.next());
		
		pq.reverse();
		it = pq.iterator();
		assertEquals("WORLD",it.next());
		assertEquals("Hello",it.next());
		assertEquals("goodbye",it.next());	
		assertEquals("Cold",it.next());
		
		pq.setComparator(cnat);
		it = pq.iterator();
		assertEquals("Cold",it.next());
		assertEquals("Hello",it.next());
		assertEquals("WORLD",it.next());
		assertEquals("goodbye",it.next());	
	
		pq.reverse();
		it = pq.iterator();
		assertEquals("goodbye",it.next());	
		assertEquals("WORLD",it.next());
		assertEquals("Hello",it.next());
		assertEquals("Cold",it.next());
	}

	public void testS72() {
		pq.reverse();
		pq.add("Bar");
		pq.add("bar");
		// set comparator should sort starting from the existing LOGICAL order
		// which has Bar first and then bar
		pq.setComparator(ccio);
		// Since the elements are already in order for case insensitive order,
		// they should be left in the same LOGICAL order.
		assertEquals("Bar",pq.poll());
	}
	
	public void testS73() {
		pq.reverse();
		pq.add("ba");
		pq.add("bar");
		// set comparator should sort starting from the existing LOGICAL order
		// which has bar first and then ba
		pq.setComparator(cuns);
		// Then, since the elements are already in order, "bar" should still be first
		assertEquals("bar",pq.poll());
	}
	
	public void testS74() {
		pq.setComparator(null);
		pq.reverse();
		pq.add("ba");
		pq.add("BA");
		pq.setComparator(ccio);
		assertEquals("ba",pq.poll());
	}
	
	public void testS75() {
		pq.setComparator(cnat);
		pq.add("Apples");
		pq.add("bread");
		pq.add("Carrots");
		pq.reverse();
		pq.setComparator(cnat);
		assertEquals("Apples",pq.peek());
	}
}
