import edu.uwm.cs351.util.PriorityQueue;


public class TestPriorityQueue2 extends TestCollection<Integer> {

	@Override
	protected void initCollections() {
		c = new PriorityQueue<Integer>();
		e = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		permitNulls = false;
	}

}
