package cci.arraystring;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		// pt.display(pt.generate(5));

		pt.display2(pt.generate2(5));

	}

	public int[][] generate(int numRows) {
		int[][] result = new int[numRows][numRows];
		for (int line = 0; line < numRows; line++) {
			for (int i = 0; i <= line; i++) {
				if (line == i || i == 0) {
					result[line][i] = 1;
				} else {
					result[line][i] = result[line - 1][i - 1] + result[line - 1][i];
					// System.out.print(result[line][i]);
				}
				// System.out.println("");
			}
		}
		// List<List<Integer>>
		// output=Arrays.stream(result).map(Arrays::asList).collect(Collectors.toList());
		return result;
	}

	public void display(int num[][]) {
		int row = num.length;
		int column = num[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(num[i][j] + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		// First base case; if user requests zero rows, they get zero rows.
		if (numRows == 0) {
			return triangle;
		}

		// Second base case; first row is always [1].
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);

		for (int rowNum = 1; rowNum < numRows; rowNum++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(rowNum - 1);

			// The first row element is always 1.
			row.add(1);

			// Each triangle element (other than the first and last of each row)
			// is equal to the sum of the elements above-and-to-the-left and
			// above-and-to-the-right.
			for (int j = 1; j < rowNum; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			// The last row element is always 1.
			row.add(1);

			triangle.add(row);
		}

		return triangle;
	}

	public void display2(List<List<Integer>> triangle) {
		for (int i = 0; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				System.out.print(triangle.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
