package ctci.Ch01;

public class URLify {

	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, trueLength);	
		System.out.println("\"" + new String(arr) + "\"");
	}

	private static void replaceSpaces(char[] arr, int trueLength) {
		int spacecount = 0, index, i  = 0;
		for(i =0 ; i < trueLength;i++){
			if(arr[i] == ' ') spacecount++;
		}
		index = trueLength + spacecount*2;
		//add \0 at the end of string
		if(trueLength < arr.length) arr[trueLength]='\0';
		for(i = trueLength-1; i>= 0 ; i--){
			if(arr[i]== ' '){
				arr[index-1]='0';arr[index-2]='2'; arr[index-3]='%';
				index =index -3;
			}else{
				arr[index-1]=arr[i];
				index--;
			}
		}
	}

	private static int findLastCharacter(char[] arr) {
		for(int i= arr.length-1; i >=0; i--){
			if(arr[i] != ' '){
				return i;
			}
		}
		return -1;
	}
}
