import java.util.Comparator;
import java.util.Iterator;

import edu.uwm.cs351.util.PriorityQueue;
import junit.framework.TestCase;

public class TestExhaustive extends TestCase {
  private static class IntPair {
    private int v1,v2;
    IntPair(int x1, int x2) { v1 = x1; v2 = x2; }
    @Override public String toString() { return "("+v1+","+v2+")"; }
  }
  private Comparator<IntPair> comp1 = (a,b) -> a.v1 - b.v1;
  private Comparator<IntPair> comp2 = (a,b) -> a.v2 - b.v2;
  private PriorityQueue<IntPair> ss;
  private Iterator<IntPair> it;
  private IntPair p1, p2, p3, p4, p5, p6;

  @Override
  protected void setUp() {
    p1 = new IntPair(1,1);
    p2 = new IntPair(2,2);
    p3 = new IntPair(3,3);
    p4 = new IntPair(4,4);
    p5 = new IntPair(5,5);
    p6 = new IntPair(6,6);
    ss = new PriorityQueue<>(comp1);
   }

  public void test1001() {
    p1.v1 = 1;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertFalse(it.hasNext());
  }

  public void test2001() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertFalse(it.hasNext());
  }

  public void test2002() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertFalse(it.hasNext());
  }

  public void test3001() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertFalse(it.hasNext());
  }

  public void test3002() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertFalse(it.hasNext());
  }

  public void test3003() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertFalse(it.hasNext());
  }

  public void test3004() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertFalse(it.hasNext());
  }

  public void test3005() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertFalse(it.hasNext());
  }

  public void test3006() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertFalse(it.hasNext());
  }

  public void test4001() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4002() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4003() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4004() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4005() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4006() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4007() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4008() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4009() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4010() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4011() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4012() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4013() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4014() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4015() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4016() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4017() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4018() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4019() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4020() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4021() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4022() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4023() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test4024() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertFalse(it.hasNext());
  }

  public void test5001() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5002() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5003() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5004() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5005() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5006() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5007() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5008() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5009() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5010() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5011() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5012() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5013() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5014() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5015() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5016() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5017() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5018() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5019() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5020() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5021() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5022() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5023() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5024() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5025() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5026() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5027() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5028() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5029() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5030() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5031() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5032() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5033() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5034() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5035() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5036() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5037() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5038() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5039() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5040() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5041() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5042() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5043() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5044() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5045() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5046() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5047() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5048() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5049() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5050() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5051() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5052() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5053() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5054() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5055() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5056() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5057() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5058() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5059() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5060() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5061() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5062() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5063() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5064() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5065() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5066() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5067() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5068() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5069() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5070() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5071() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5072() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5073() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5074() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5075() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5076() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5077() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5078() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5079() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5080() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5081() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5082() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5083() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5084() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5085() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5086() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5087() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5088() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5089() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5090() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5091() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5092() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5093() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5094() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5095() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5096() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5097() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5098() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5099() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5100() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5101() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5102() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5103() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5104() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5105() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5106() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5107() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5108() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5109() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5110() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5111() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5112() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5113() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5114() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5115() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5116() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5117() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5118() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5119() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test5120() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertFalse(it.hasNext());
  }

  public void test6001() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6002() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6003() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6004() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6005() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6006() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6007() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6008() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6009() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6010() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6011() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6012() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6013() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6014() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6015() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6016() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6017() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6018() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6019() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6020() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6021() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6022() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6023() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6024() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6025() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6026() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6027() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6028() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6029() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6030() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6031() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6032() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6033() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6034() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6035() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6036() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6037() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6038() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6039() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6040() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6041() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6042() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6043() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6044() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6045() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6046() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6047() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6048() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6049() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6050() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6051() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6052() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6053() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6054() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6055() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6056() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6057() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6058() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6059() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6060() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6061() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6062() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6063() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6064() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6065() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6066() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6067() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6068() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6069() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6070() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6071() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6072() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6073() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6074() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6075() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6076() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6077() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6078() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6079() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6080() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6081() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6082() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6083() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6084() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6085() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6086() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6087() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6088() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6089() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6090() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6091() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6092() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6093() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6094() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6095() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6096() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6097() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6098() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6099() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6100() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6101() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6102() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6103() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6104() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6105() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6106() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6107() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6108() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6109() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6110() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6111() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6112() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6113() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6114() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6115() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6116() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6117() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6118() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6119() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6120() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p6.v1 = 6;    ss.add(p6);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6121() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6122() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6123() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6124() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6125() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6126() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6127() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6128() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6129() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6130() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6131() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6132() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6133() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6134() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6135() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6136() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6137() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6138() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6139() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6140() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6141() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6142() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6143() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6144() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6145() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6146() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6147() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6148() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6149() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6150() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6151() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6152() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6153() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6154() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6155() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6156() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6157() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6158() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6159() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6160() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6161() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6162() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6163() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6164() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6165() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6166() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6167() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6168() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6169() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6170() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6171() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6172() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6173() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6174() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6175() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6176() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6177() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6178() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6179() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6180() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6181() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6182() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6183() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6184() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6185() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6186() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6187() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6188() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6189() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6190() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6191() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6192() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6193() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6194() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6195() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6196() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6197() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6198() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6199() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6200() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6201() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6202() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6203() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6204() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6205() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6206() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6207() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6208() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6209() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6210() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6211() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6212() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6213() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6214() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6215() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6216() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6217() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6218() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6219() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6220() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6221() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6222() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6223() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6224() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6225() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6226() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6227() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6228() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6229() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6230() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6231() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6232() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6233() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6234() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6235() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6236() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6237() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6238() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6239() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6240() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p5.v1 = 6;    ss.add(p5);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6241() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6242() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6243() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6244() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6245() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6246() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6247() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6248() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6249() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6250() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6251() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6252() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6253() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6254() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6255() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6256() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6257() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6258() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6259() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6260() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6261() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6262() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6263() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6264() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6265() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6266() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6267() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6268() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6269() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6270() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6271() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6272() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6273() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6274() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6275() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6276() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6277() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6278() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6279() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6280() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6281() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6282() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6283() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6284() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6285() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6286() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6287() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6288() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6289() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6290() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6291() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6292() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6293() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6294() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6295() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6296() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6297() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6298() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6299() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6300() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6301() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6302() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6303() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6304() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6305() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6306() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6307() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6308() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6309() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6310() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6311() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6312() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6313() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6314() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6315() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6316() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6317() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6318() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6319() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6320() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6321() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6322() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6323() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6324() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6325() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6326() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6327() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6328() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6329() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6330() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6331() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6332() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6333() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6334() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6335() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6336() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6337() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6338() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6339() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6340() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6341() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6342() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6343() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6344() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6345() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6346() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6347() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6348() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6349() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6350() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6351() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6352() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6353() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6354() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6355() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6356() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6357() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6358() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6359() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6360() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p2.v1 = 6;    ss.add(p2);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6361() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6362() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6363() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6364() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6365() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6366() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6367() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6368() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6369() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6370() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6371() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6372() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6373() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6374() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6375() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6376() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6377() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6378() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6379() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6380() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6381() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6382() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6383() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6384() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6385() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6386() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6387() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6388() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6389() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6390() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6391() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6392() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6393() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6394() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6395() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6396() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6397() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6398() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6399() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6400() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6401() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6402() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6403() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6404() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6405() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6406() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6407() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6408() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6409() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6410() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6411() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6412() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6413() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6414() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6415() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6416() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6417() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6418() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6419() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6420() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6421() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6422() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6423() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6424() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6425() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6426() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6427() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6428() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6429() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6430() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6431() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6432() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6433() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6434() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6435() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6436() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6437() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6438() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6439() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6440() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6441() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6442() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6443() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6444() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6445() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6446() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6447() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6448() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6449() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6450() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6451() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6452() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6453() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6454() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6455() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6456() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6457() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6458() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6459() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6460() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6461() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6462() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6463() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6464() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6465() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6466() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6467() {
    p1.v1 = 1;    ss.add(p1);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6468() {
    p4.v1 = 1;    ss.add(p4);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6469() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6470() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6471() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6472() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6473() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6474() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6475() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6476() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6477() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6478() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6479() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6480() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p3.v1 = 6;    ss.add(p3);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6481() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6482() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6483() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6484() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6485() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6486() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6487() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6488() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6489() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6490() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6491() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6492() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6493() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6494() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6495() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6496() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6497() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6498() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6499() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6500() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6501() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6502() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6503() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6504() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p6.v1 = 5;    ss.add(p6);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6505() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6506() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6507() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6508() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6509() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6510() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6511() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6512() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6513() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6514() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6515() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6516() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6517() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6518() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6519() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6520() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6521() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6522() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6523() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6524() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6525() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6526() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6527() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6528() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6529() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6530() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6531() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6532() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6533() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6534() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6535() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6536() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6537() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6538() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6539() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6540() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6541() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6542() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6543() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6544() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6545() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6546() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6547() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6548() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6549() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6550() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6551() {
    p1.v1 = 1;    ss.add(p1);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6552() {
    p3.v1 = 1;    ss.add(p3);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6553() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6554() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6555() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6556() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6557() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6558() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6559() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6560() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6561() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6562() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p1.v1 = 3;    ss.add(p1);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6563() {
    p1.v1 = 1;    ss.add(p1);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6564() {
    p2.v1 = 1;    ss.add(p2);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6565() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6566() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6567() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6568() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6569() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6570() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p1.v1 = 4;    ss.add(p1);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6571() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6572() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p1.v1 = 3;    ss.add(p1);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6573() {
    p1.v1 = 1;    ss.add(p1);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6574() {
    p5.v1 = 1;    ss.add(p5);
    p1.v1 = 2;    ss.add(p1);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6575() {
    p6.v1 = 1;    ss.add(p6);
    p1.v1 = 2;    ss.add(p1);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6576() {
    p1.v1 = 1;    ss.add(p1);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6577() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6578() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6579() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6580() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6581() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6582() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6583() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6584() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6585() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6586() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6587() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6588() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6589() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6590() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6591() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6592() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6593() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6594() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6595() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6596() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6597() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6598() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6599() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6600() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p1.v1 = 5;    ss.add(p1);
    p4.v1 = 6;    ss.add(p4);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6601() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6602() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6603() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6604() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6605() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6606() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6607() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6608() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6609() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6610() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6611() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6612() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6613() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6614() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6615() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6616() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6617() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6618() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6619() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6620() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6621() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6622() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6623() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6624() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p4.v1 = 5;    ss.add(p4);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6625() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6626() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6627() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6628() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6629() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6630() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6631() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6632() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6633() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6634() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6635() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6636() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6637() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6638() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6639() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6640() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6641() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6642() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6643() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6644() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6645() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6646() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6647() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6648() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p5.v1 = 5;    ss.add(p5);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6649() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6650() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6651() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6652() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6653() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6654() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6655() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6656() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6657() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6658() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6659() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6660() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6661() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6662() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6663() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6664() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6665() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6666() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6667() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6668() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6669() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6670() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6671() {
    p6.v1 = 1;    ss.add(p6);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6672() {
    p3.v1 = 1;    ss.add(p3);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p2.v1 = 5;    ss.add(p2);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6673() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6674() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6675() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6676() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6677() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6678() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6679() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6680() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6681() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6682() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p6.v1 = 3;    ss.add(p6);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6683() {
    p6.v1 = 1;    ss.add(p6);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6684() {
    p2.v1 = 1;    ss.add(p2);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6685() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6686() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6687() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6688() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6689() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6690() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p6.v1 = 4;    ss.add(p6);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6691() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6692() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p6.v1 = 3;    ss.add(p6);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6693() {
    p6.v1 = 1;    ss.add(p6);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6694() {
    p5.v1 = 1;    ss.add(p5);
    p6.v1 = 2;    ss.add(p6);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6695() {
    p4.v1 = 1;    ss.add(p4);
    p6.v1 = 2;    ss.add(p6);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6696() {
    p6.v1 = 1;    ss.add(p6);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p3.v1 = 5;    ss.add(p3);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6697() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6698() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6699() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6700() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6701() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6702() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p2.v1 = 4;    ss.add(p2);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6703() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6704() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6705() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6706() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p4.v1 = 3;    ss.add(p4);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6707() {
    p4.v1 = 1;    ss.add(p4);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6708() {
    p3.v1 = 1;    ss.add(p3);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p5.v1 = 4;    ss.add(p5);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6709() {
    p3.v1 = 1;    ss.add(p3);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6710() {
    p5.v1 = 1;    ss.add(p5);
    p3.v1 = 2;    ss.add(p3);
    p2.v1 = 3;    ss.add(p2);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6711() {
    p2.v1 = 1;    ss.add(p2);
    p3.v1 = 2;    ss.add(p3);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6712() {
    p3.v1 = 1;    ss.add(p3);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6713() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6714() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p3.v1 = 3;    ss.add(p3);
    p4.v1 = 4;    ss.add(p4);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6715() {
    p2.v1 = 1;    ss.add(p2);
    p5.v1 = 2;    ss.add(p5);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6716() {
    p5.v1 = 1;    ss.add(p5);
    p2.v1 = 2;    ss.add(p2);
    p4.v1 = 3;    ss.add(p4);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6717() {
    p4.v1 = 1;    ss.add(p4);
    p2.v1 = 2;    ss.add(p2);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6718() {
    p2.v1 = 1;    ss.add(p2);
    p4.v1 = 2;    ss.add(p4);
    p5.v1 = 3;    ss.add(p5);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6719() {
    p5.v1 = 1;    ss.add(p5);
    p4.v1 = 2;    ss.add(p4);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

  public void test6720() {
    p4.v1 = 1;    ss.add(p4);
    p5.v1 = 2;    ss.add(p5);
    p2.v1 = 3;    ss.add(p2);
    p3.v1 = 4;    ss.add(p3);
    p6.v1 = 5;    ss.add(p6);
    p1.v1 = 6;    ss.add(p1);
    ss.setComparator(comp2);
    it = ss.iterator();
    assertSame(p1,it.next());
    assertSame(p2,it.next());
    assertSame(p3,it.next());
    assertSame(p4,it.next());
    assertSame(p5,it.next());
    assertSame(p6,it.next());
    assertFalse(it.hasNext());
  }

}
