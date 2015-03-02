package dbms.kdtree.main;

public class KDTree {
	int[][] data;

	public static void main(String[] args) {
/*		int data[][] = { {3, 6, 1}, { 2, 4, 5}, { 8, 3, 2 }, { 2, 1, 8 },
				{6, 1, 4 }, { 9, 3, 7} , { 5, 7, 0} };
		*/
		
		
		int data[][] = { { 6, 1}, { 5, 5}, { 9, 6 }, { 3, 6 },
				{4, 9 }, { 4, 0} , { 7, 9}, {2,9} };

		System.out.println(data[0].length);
		System.out.println(data.length);

		//traversing 
		System.out.print("input: ");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]+",");
			}
			System.out.print("; ");
		}
		System.out.println();
		
		
		constructTree(data, 0, data.length, 0);

	}

	public static void constructTree(int data[][], int from, int to, int dimension) {
		//sorting
		for (int i = from; i < to; i++) {
			for (int j = i; j < to; j++) {
				if (data[j][dimension] < data[i][dimension]) {
					int[] temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
		}

		//traverse
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]+",");
			}
			System.out.print("; ");
		}
		System.out.println();
		
		
		if(to-from==1){
			return;
		}
		
		System.out.println("Median: " + data[(from+to)/2][dimension]);
		
		dimension++;
		if (dimension == data[0].length) {
			dimension = 0;
		}

//		int median = (from + to) / 2;

		if(to-from > 1){
			constructTree(data, from, ((from+to)/2), dimension);
			constructTree(data, ((from+to)/2), to, dimension);
		}
	}
}
