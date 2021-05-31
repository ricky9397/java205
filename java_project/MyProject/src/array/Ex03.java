package array;

public class Ex03 {
	
	public static void deployment(int[][] arr) {
		int tmp;
		for(int i = 0; i < arr.length; i++) {
			tmp = arr[0][i];
			arr[0][i] = arr[2][i];
			arr[2][i] = arr[1][i];
			arr[1][i] = tmp;
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		deployment(arr);
		
	}

}
