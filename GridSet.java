package percolation;

import java.util.*;

public class GridSet {
	ArrayList<Grid> allgrids = new ArrayList<Grid>();
	ArrayList<Boolean> percolated = new ArrayList<Boolean>();
	
	void addGrid(Grid g) {
		allgrids.add(g);
	}
	
	void addPercolate(Grid g) {
		percolated.add(g.percolate());
	}
	
	double percolRate() {
		double total = percolated.size();
		int percol = 0;
		for(Boolean b : percolated) {
			if (b) {
				percol++;
			}
		}
		return percol/total;
	}
	void clearAllgrid() {
		allgrids.clear();
	}
	void clearPercolated() {
		percolated.clear();
	}

}
