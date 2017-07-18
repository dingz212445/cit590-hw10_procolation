package percolation;

import static org.junit.Assert.*;

import org.junit.*;

public class GridTest {

	Grid ground;
	
	@Before
	public void setUp() {
		ground = new Grid(9, 0.38);
		//ground.grids = {{0, 1, 2}, {1, 0, 0}, {0, 1, 0}};
	}
	
	
	
	@Test
	/*
	public void testGround() {
		int[][] testedGround = ground.getGrid();
		int sum = 0;
		for(int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				sum += testedGround[i][j];
			}
		}
		assertTrue(sum/400.0 < 0.55 && sum/400.0 > 0.45);
	}
	
	public void testSeep() {
		ground.display();
		ground.seep(0);
		ground.display();
	}
	*/
	
	public void testSeepthrough() {
		ground.display();
		ground.seepthrough(0);
		ground.display();
		System.out.println(ground.percolate());
	}

}
