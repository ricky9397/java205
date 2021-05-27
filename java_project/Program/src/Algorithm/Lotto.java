package Algorithm;

public class Lotto {

	public static void main(String[] args) {
		
		int[] arr = new int[45];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		int tmp = 0;
		int j = 0;
		
		for(int i = 0; i < 100; i++) {
			j = (int)(Math.random() * 45);
			
			tmp = arr[0];
			arr[0] = arr[j];
			arr[j] = tmp;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
