import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


/**
 * Things to be used by the driver / test suite.
 * Not to be used by application code in package edu.uwm.cs351.util
 */
public class TestUtil {

	public static <T> Comparator<T> nondiscrimination() {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return 0;
			}
		};
	}
	
	
	private static class DefaultComparator<T extends Comparable<T>> implements Comparator<T> {
		public int compare(T o1, T o2) {
			return o1.compareTo(o2);
		}	
	}
	
	public static <T extends Comparable<T>> Comparator<T> defaultComparator() {
		return new DefaultComparator<T>();
	}
	
	
	public static <T> Comparator<T> reverse(final Comparator<T> comp) {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return comp.compare(o2, o1);
			}
		};
	}
	
	public static <T> Comparator<T> obscure(final Comparator<T> comp) {
		return new Comparator<T>() {
			private Random r = new Random();
			public int compare(T o1, T o2) {
				int c = comp.compare(o1, o2);
				return c * (r.nextInt(100) + 1);
			}
		};
	}
	
	public static <T> boolean nextPermutation(List<T> l, Comparator<T> comp) {
		// http://stackoverflow.com/questions/352203/generating-permutations-lazily
		ListIterator<T> it = l.listIterator(l.size());
		if (!it.hasPrevious()) return false;
		T next = it.previous();
		for (;;) {
			if (!it.hasPrevious()) return false;
			T e = it.previous();
			if (comp.compare(e, next) < 0) {
				next = e;
				break;
			}
			next = e;
		}
		int i = it.nextIndex();
		it = l.listIterator(l.size());
		for (;;) {
			T e = it.previous();
			if (comp.compare(e,next) > 0) {
				it.set(next);
				l.set(i, e);
				break;
			}
		}
		++i;
		it = l.listIterator(l.size());
		while (it.previousIndex() > i) {
			T e = it.previous();
			it.set(l.get(i));
			l.set(i, e);
			++i;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Comparator<String> c = defaultComparator();
		List<String> l = Arrays.asList(args);
		System.out.println(Arrays.toString(args));
		while (nextPermutation(l,c)) {
			System.out.println(Arrays.toString(args));			
		}
	}
	
	public static class Point {
		public final int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Point)) return false;
			Point p = (Point) o;
			return p.x == x && p.y == y;
		}
		@Override
		public int hashCode() {
			return 17 * x + y;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	
	public static Point p(int x, int y) {
		return new Point(x,y);
	}
	
	public static Comparator<Point> pointLex = new Comparator<Point>() {
		public int compare(Point p1, Point p2) {
			if (p1.x != p2.x) return p1.x - p2.x;
			return p1.y - p2.y;
		}
	};
}