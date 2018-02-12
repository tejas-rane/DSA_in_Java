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
		//for ASCII conditions, create an empty array and mark 1 to all positions of char in given first string
		// iterate to second string and decrement elements if value < 0 found throw false.
	}
}
