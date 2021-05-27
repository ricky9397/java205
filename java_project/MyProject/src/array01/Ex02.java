package array01;

public class Ex02 {

	public static void addOneDArr(int[][] arr, int add) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] += add;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {{20,30,40},{50,60,70}};
		
		
	}

}
