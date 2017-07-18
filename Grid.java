package percolation;

import java.util.Random;

public class Grid {
	
	public int[][] grids;
	private int dimension;
	
	
	public Grid(int n, double p) {
		this.dimension = n;
		grids = new int[n + 1][n];
		
		for (int i = 0; i < dimension; i++) {
			grids[0][i] = 2;
		}
		
		for (int i = 1; i < dimension + 1; i++) {
			for (int j = 0; j < dimension; j++) {
				if (new Random().nextFloat() < p) {
					grids[i][j] = 1;
				} else {
					grids[i][j] = 0;
				}
			}
		}
	}
	
	public void display() {
		for(int i = 0; i < dimension + 1; i++) {
			for(int j = 0; j < dimension; j++) {
				System.out.print(grids[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(grids);
	}
	
	void seep(int row) {
		if (row >= dimension) {
			return;
		} else {
			for (int i = 0; i < dimension; i++) {
				if (grids[row][i] == 2 && grids[row + 1][i] == 0) {
					grids[row + 1][i] = 2;
					flow(row+1, i);
				}
			}
		}
	}
	
	void seepthrough (int row) {
		for (int i = row; i < dimension; i++) {
			this.seep(i);
		}
	}
	
	private void flow(int row, int column) {
		if (grids[row][column] != 2) {
			return;
		}
		int current_col = column - 1;
		while (current_col >= 0 && grids[row][current_col] == 0) {
			grids[row][current_col] = 2;
			current_col--;
		}
		
		current_col = column + 1;
		while (current_col < dimension && grids[row][current_col] == 0) {
			grids[row][current_col] = 2;
			current_col++;
		}
	}
	
	boolean percolate() {
		for (int i : grids[dimension - 1]) {
			if (i == 2) {
				return true;
			}
		}
		return false;
	}

}
