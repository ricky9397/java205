package array01;

public class Ex02 {

	public static void addOneDArr(int[] arr, int add) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] += add;
		}
	}
	
	public static void addOneDArr(int[][] arr, int add) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] += add;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		
		addOneDArr(arr, 5);
	}

}
