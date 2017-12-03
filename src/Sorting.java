
public class Sorting {
	static int arr[] = { 1, 5, 2, 6, 3, 5 };

	public static void printArray() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
	public static void bubbleSort(){
		for(int i =0; i < arr.length; i++){
			for(int j = i+1 ; j< arr.length ; j++){
				if(arr[i] >= arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		printArray();
	}
	public static void main(String[] args) {

		bubbleSort();
		

	}

}
