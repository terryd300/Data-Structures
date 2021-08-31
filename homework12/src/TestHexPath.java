import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexPath;
import junit.framework.TestCase;


public class TestHexPath extends TestCase {

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

	HexCoordinate c000 = new HexCoordinate(0,0,0);
	HexCoordinate c011 = new HexCoordinate(0,-1,1);
	HexCoordinate c110 = new HexCoordinate(1,1,0);
	HexCoordinate c220 = new HexCoordinate(2,2,0);
	HexCoordinate c211 = new HexCoordinate(2,1,1);
	HexCoordinate c202 = new HexCoordinate(2,0,2);
	HexCoordinate c022 = new HexCoordinate(0,2,-2);

	HexPath p;
	HexCoordinate[] a;
	
	public void test1() {
		p = new HexPath(c110);
		
		assertEquals(0,p.size());
		assertEquals(c110,p.last());
		assertEquals("<1,1,0>",p.toString());
		
		a = p.toArray();
		assertEquals(1,a.length);
		assertSame(c110,a[0]);
	}
	
	public void test2() {
		p = new HexPath(c110);
		p = new HexPath(p,c220);
		
		assertEquals(1,p.size());
		assertSame(c220,p.last());
		assertEquals("<1,1,0> -> <2,2,0>",p.toString());
		
		a = p.toArray();
		assertEquals(2,a.length);
		assertSame(c110,a[0]);
		assertSame(c220,a[1]);
	}
	
	public void test3() {
		p = new HexPath(c110);
		p = new HexPath(p,c220);
		p = new HexPath(p,c211);
		
		assertEquals(2,p.size());
		assertSame(c211,p.last());
		assertEquals("<1,1,0> -> <2,2,0> -> <2,1,1>",p.toString());
		
		a = p.toArray();
		assertEquals(3,a.length);
		assertSame(c110,a[0]);
		assertSame(c220,a[1]);
		assertSame(c211,a[2]);
	}
	
	public void test4() {
		p = new HexPath(p,c110);
		p = new HexPath(p,c220);
		p = new HexPath(p,c211);
		p = new HexPath(p,c110);
		
		assertEquals(3,p.size());
		assertSame(c110,p.last());
		assertEquals("<1,1,0> -> <2,2,0> -> <2,1,1> -> <1,1,0>",p.toString());
		
		a = p.toArray();
		assertEquals(4,a.length);
		assertSame(c110,a[0]);
		assertSame(c220,a[1]);
		assertSame(c211,a[2]);
		assertSame(c110,a[3]);
	}
	
	public void test5() {
		p = new HexPath(p,c000);
		p = new HexPath(p,c110);
		p = new HexPath(p,c220);
		p = new HexPath(p,c211);
		p = new HexPath(p,c110);
		
		assertEquals(4,p.size());
		assertSame(c110,p.last());
		assertEquals("<0,0,0> -> <1,1,0> -> <2,2,0> -> <2,1,1> -> <1,1,0>",p.toString());
		
		a = p.toArray();
		assertEquals(5,a.length);
		assertSame(c000,a[0]);
		assertSame(c110,a[1]);
		assertSame(c220,a[2]);
		assertSame(c211,a[3]);
		assertSame(c110,a[4]);
	}

	public void test6() {
		p = new HexPath(p,c110);
		p = new HexPath(p,c220);
		p = new HexPath(p,c211);
		p = new HexPath(p,c110);
		p = new HexPath(p,c000);
		p = new HexPath(p,c011);
		
		assertEquals(5,p.size());
		assertSame(c011,p.last());
		assertEquals("<1,1,0> -> <2,2,0> -> <2,1,1> -> <1,1,0> -> <0,0,0> -> <0,-1,1>",p.toString());
		
		a = p.toArray();
		assertEquals(6,a.length);
		assertSame(c110,a[0]);
		assertSame(c220,a[1]);
		assertSame(c211,a[2]);
		assertSame(c110,a[3]);
		assertSame(c000,a[4]);
		assertSame(c011,a[5]);
	}
	
	public void test7() {
		assertException(IllegalArgumentException.class,() -> new HexPath(null));
	}
	
	public void test8() {
		p = new HexPath(c110);
		assertException(IllegalArgumentException.class,() -> new HexPath(p,null));
	}
	
	public void test9() {
		p = new HexPath(c110);
		assertException(IllegalArgumentException.class,() -> new HexPath(p,c202));
		assertException(IllegalArgumentException.class,() -> new HexPath(p,c022));
	}
}
