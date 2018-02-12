
public class Sorting {
	static int arr[] = { 1, 5, 2, 6, 3, 5 , 7, 11, 3, 0};

	public static void printArray() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
	public static void printArray(int arrTemp[]) {
		for (int i = 0; i < arrTemp.length; i++) {
			System.out.print(arrTemp[i] + " ");
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
	public static void insertionSort(){
		int i= 0;
		int j,temp;
		int key= 0;
		
		for(i=1;i<arr.length;i++){
			key = arr[i];
			j = i-1;
			while(j>=0 && key < arr[j]){
				//swap
				temp = arr[j];
				arr[j] = arr[j+1] ;
				arr[j+1]=temp;
				j--;
			}
			//arr[j+1]=key;
		}
		printArray();
	}
	public static void merge(int input[], int l , int m , int r){
		int n1 = m-l+1;
		int n2 = r-m;
		
		int temp1[] = new int[n1];
		int temp2[] = new int[n2];
		for(int i = 0 ; i <n1; i++){
			temp1[i]=input[l+i];
		}
		for(int i = 0 ; i <n2; i++){
			temp2[i]=input[m+1+i];
		}
		
		//merge temp arrays into input[]
		//index of output array would be starting from l
		int indexT1 =0;
		int indexT2 = 0;
		int k = l;
		while(indexT1<n1 && indexT2<n2){
			if(temp1[indexT1]<=temp2[indexT2]){
				input[k]=temp1[indexT1];
				indexT1++;
			}
			else{
				input[k]=temp2[indexT2];
				indexT2++;
			}
			k++;
		}
		//need to copy remaining elements
		while(indexT1<n1){
			input[k]=temp1[indexT1];
			k++;
			indexT1++;
		}
		while(indexT2<n2){
			input[k]=temp2[indexT2];
			k++;
			indexT2++;
		}
		
	}
	public static void mergeSort(int input[],int l, int r){
		if(l<r){
			int m = (l+r)/2;
			mergeSort(input,l,m);
			mergeSort(input,m+1,r);
			
			merge(input , l , m  , r);
		}
	}
	public static void main(String[] args) {

		//bubbleSort();
		//insertionSort();
		mergeSort(arr,0,arr.length-1);
		System.out.println();
		printArray(arr);
	}

}
