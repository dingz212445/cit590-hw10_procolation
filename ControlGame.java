package percolation;

public class ControlGame {

	public static void main(String[] args) {
		ControlGame game = new ControlGame();
		double result = game.findProbability(200);
		System.out.println("result is " + result);

	}
	
	double findProbability(int n) {
		GridSet alltest = new GridSet();
		double p = 0.5;
		int numGrid = 200;
		double delta = 0.02;
		boolean fromNeg = true;
		
		do {
			alltest.clearAllgrid();
			alltest.clearPercolated();
			for (int i = 0; i < numGrid; i++) {
				Grid curGrid = new Grid(n, p);
				alltest.addGrid(curGrid);
				curGrid.seepthrough(0);
				alltest.addPercolate(curGrid);
			}
			
			if (alltest.percolRate() - 0.5 > 0.02) {
				if (fromNeg) {
					delta = delta / 2;
					fromNeg = false;
				}
				p = p + delta;
				
			} else if (alltest.percolRate() - 0.5 < -0.02) {
				if (!fromNeg) {
					delta = delta / 2;
					fromNeg = true;
				}
				p = p - delta;
				
			}
			System.out.println("p is " + p);
			System.out.println("percolRate is " + alltest.percolRate());

			
		} while (Math.abs(alltest.percolRate() - 0.5) > 0.01);
		
		
		return p;
		
	}

}
