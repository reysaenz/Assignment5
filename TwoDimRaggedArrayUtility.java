import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	public TwoDimRaggedArrayUtility() {

	}

	public static double getAverage(double[][] data) {
		int div = 0;
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			div += data[i].length;
			for (int j = 0; j < data[i].length; j++) {
				sum += data[i][j];
			}
		}

		return sum / div;
	}

	public static double getColumnTotal(double[][] data, int col) {
		double columnT = 0;// number that will be returned
		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) {// of the coloumn param is greater than the length of the array, it skips to
										// prevent the loop to go the the next column
				continue;
			}
			columnT += data[i][col];// stockpiles all the columns
		}
		return columnT;// returns the column total
	}

	public static double getHighestInArray(double[][] data) {
		double champ = 0;// the value that will change in accordance to which element is higher
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {// for loop goes through each element in the array
				if (data[i][j] > 0) {
					champ = data[i][j];// if the element is higher than the previous champion , it replaces the value
										// of champ
				}
			}
		}
		return champ;// returns the final value of champ
	}

	public static double getHighestInColumn(double[][] data, int col) {
		double champ = 0;
		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) {// for loop ensures that the loop does not go to the next column
				continue;
			}
			if (data[i][col] > 0) {
				champ = data[i][col];// if the element is greater than the previous champ, replace the champ
			}

		}
		return champ;// returns highest element in the column
	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
		double champ = 0;
		int index = -1;
		for (int i = 0; i < data.length; i++) {

			if (col >= data[i].length) {// for loop ensures that the loop does not go to the next column
				continue;
			}
			if (data[i][col] > 0) {
				champ = data[i][col];
				index = i;// if the element is greater than the previous champ, replace the champ
			}

		}
		return index;
	}

	public static double getHighestInRow(double[][] data, int row) {
		double champ = 0;
		for (int i = 0; i < data.length; i++) {// for loop goes through each number in a row and changes "champ"
												// depending on number value
			if (data[row][i] > champ) {
				champ = data[row][i];
			}
		}
		return champ;
	}

	public static int getHighestInRowIndex(double[][] data, int row) {
		double champ = 0;
		int index = -1;
		for (int i = 0; i < data.length; i++) {// the same as get highest in row but has a seprate variable to keep
												// track of what row index is the highest
			if (data[row][i] > champ) {
				champ = data[row][i];
				index = 1;

			}
		}
		return index;
	}

	public static double getLowestInArray(double[][] data) {
		double low = data[0][0];// starts off at zero to compare
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {// compares all number to the first element to see if it is
														// smaller
				if (data[i][j] < low) {
					low = data[i][j];
				}
			}
		}
		return low;

	}

	public static double getLowestInColumn(double[][] data, int col) {
		double low = data[0][0];
		for (int i = 0; i < data.length; i++) {// searches each element in a column but this time compares each element
												// to the first one to see if it is smaller
			if (col >= data[i].length) {
				continue;
			}
			if (data[i][col] < low) {
				low = data[i][col];
			}
		}
		return low;
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {
		double low = data[0][col];
		int index = -1;
		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) {
				continue;
			}
			if (data[i][col] < low) {
				low = data[i][col];
				index = i;
			}
		}
		return index;
	}

	public static double getLowestInRow(double[][] data, int row) {
		double low = data[row][0];
		for (int i = 0; i < data.length; i++) {
			if (data[row][i] < low) {
				low = data[row][i];
			}
		}
		return low;
	}

	public static int getLowestInRowIndex(double[][] data, int row) {
		double low = data[row][0];
		int index = -1;
		for (int i = 0; i < data.length; i++) {
			if (data[row][i] < low) {
				low = data[row][i];
				index = i;
			}
		}
		return index;
	}

	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		return total;
	}

	public static double getTotal(double[][] data) {
		double total = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		return total;
	}

	public static double[][] readFile(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int indexRow = 0;
		String[][] temp = new String[10][];
		// read file and pass numbers to temp array as Strings
		while (sc.hasNextLine()) {
			String[] row = sc.nextLine().split(" ");
			temp[indexRow] = new String[row.length];
			for (int i = 0; i < row.length; i++) {
				temp[indexRow][i] = row[i];
			}
			indexRow++;
		}
		// Create double data array and parse numbers as doubles
		double[][] data = new double[indexRow][];
		for (int i = 0; i < indexRow; i++) {
			data[i] = new double[temp[i].length];
			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j] + " ");
				data[i][j] = Double.parseDouble(temp[i][j]);
			}
			System.out.println();
		}

		sc.close();
		return data;

	}

	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter output = new PrintWriter(outputFile);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sb.append(data[i][j] + " ");
			}
			sb.append("\n");
		}
		output.print(sb.toString());
		output.close();
	}

}