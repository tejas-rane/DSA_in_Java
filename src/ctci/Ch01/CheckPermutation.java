package ctci.Ch01;

import java.util.Arrays;

public class CheckPermutation {

	public static void main(String[] args) {
		String first = "apple";
		String second = "papel";
		
		checkPermutation(first, second);
	}

	private static void checkPermutation(String first, String second) {
		// TODO Auto-generated method stub
		if(first.length() != second.length()){
			System.out.println("NO");
			System.exit(0);
		}
		char f[] = first.toCharArray();
		char s[] = second.toCharArray();
		Arrays.sort(f);
		Arrays.sort(s);
		//boolean anagram = ;
		if(new String(f).equals(new String(s))){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		//
	}
}
