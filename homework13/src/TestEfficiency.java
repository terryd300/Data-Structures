import java.util.Comparator;

import edu.uwm.cs.util.NamedComparator;
import edu.uwm.cs.util.NaturalComparator;
import edu.uwm.cs351.util.PriorityQueue;
import junit.framework.TestCase;


public class TestEfficiency extends TestCase {
	private PriorityQueue<Integer> b;

	private static final int POWER = 20; // about 1 million entries
	private static final int TESTS = 100000;

	protected void setUp() throws Exception {
		super.setUp();
		try {
			assert b.size() == TESTS : "cannot run test with assertions enabled";
		} catch (NullPointerException ex) {
			System.err.println("You should disable assertions to run this test.");
			System.err.println("If this test takes a long time); stop it by pressing the red button on the Console.");
			System.err.println("Then press the double gray X to make sure you don't have any old tests running in the background.");
			System.err.println("Go to Run > Run Configurations. Select the 'Arguments' tab");
			System.err.println("Then remove '-ea' from the VM Arguments box.");
		}
		b = new PriorityQueue<Integer>(null);
		int max = (1 << (POWER)); // 2^(POWER) =~ 1 million
		for (int power = POWER; power > 0; --power) {
			int incr = 1 << power;
			for (int i=1 << (power-1); i < max; i += incr) {
				b.add(i);
			}
		}
	}

	@Override
	protected void tearDown() {
		b = null;
	}

	public void testSize() {
		for (int i=0; i < TESTS; ++i) {
			assertEquals((1<<POWER)-1,b.size());
		}
	}

	public void testPoll() {
		int max = (1 << (POWER));
		assertEquals(max/2,b.element().intValue());
		assertEquals(max/2,b.peek().intValue());
		for (int power = POWER; power > 0; --power) {
			int incr = 1 << (power);
			for (int i=1 << (power-1); i < max; i += incr) {
				assertEquals(i,b.poll().intValue());
			}
		}
		assertTrue(b.isEmpty());
	}

	public void testReverse() {
		int max = (1 << (POWER)); // 2^(POWER) =~ 1 million
		for (int i=0; i < max; ++i) {
			b.reverse(); // should be fast!
		}
		b.reverse(); // one more time
		for (int power = 1; power <= POWER; ++power) {
			int incr = 1 << power;
			for (int i= max-(1 << (power-1)); i > 0; i -= incr) {
				assertEquals(i,b.poll().intValue());
			}
		}    	
	}

	public void testSort() {
		b.setComparator(new NamedComparator<>("",new NaturalComparator<>()));
		int max = (1 << (POWER));
		for (int i=1; i < max; ++i) {
			assertEquals(i,b.remove().intValue());
		}
		assertTrue(b.isEmpty());
	}

	public void testSortNOP() {
		b.setComparator(new NamedComparator<>("",new NaturalComparator<>()));
		for (int i=0; i < POWER; ++i) {
			b.setComparator(null);
			b.setComparator(new NamedComparator<>("",new NaturalComparator<>()));
		}
	}
	
	public void testSortUnchanged() {
		Comparator<Integer> c = TestUtil.<Integer>defaultComparator();
		for (int i=0; i < TESTS; ++i) {
			b.setComparator(c);
		}
	}
	
	public void testDestructiveReverse() {
		Comparator<Integer> cnat = ((a,b) -> a-b);
		Comparator<Integer> crev = ((a,b) -> b-a);
		Comparator<Integer> cuns = ((a,b) -> 0);
		b.setComparator(cnat);
		for (int i=0; i < POWER/2; ++i) {
			b.reverse();
			// See testS72(): this call has to reverse the list:
			b.setComparator(cuns);
			b.setComparator(crev); // this should be a NOP sort
			b.reverse();
			b.setComparator(cnat); // destructive reverse again
		}
		
	}
}
