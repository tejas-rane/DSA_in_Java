import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SmallProgramsPractice {

	public static void checkArmstrong(int num){
		int result = 0;
		int no = num;
		
		while (no != 0){
			int rem = no%10;
			result += rem * rem * rem;// works only for 3 digit
			/*
			 * can be modified by adding a for loop to calculate the power by 
			 * finding the length of number
			 */
			no /= 10;
		}
		if(result == num){
			System.out.println("Armstrong number");
		}else{
			System.out.println("Not a Armstrong number");
		}
	}
	public static void sumOfAllDigits(int num){
		int sum = 0 ;
		int temp = num;
		while (temp!=0){
			int lastDigit = temp%10;
			sum += lastDigit;
			temp /= 10;
		}
		System.out.println("sum is "+ sum);
	}
	public static void isAnagram(String s1, String s2){
		String cps1 = s1.replaceAll("\\s", "");
		String cps2 = s2.replaceAll("\\s", "");
		if(cps1.length()!= cps2.length()){
			System.out.println("Not an Anagram");
			return;
		}
		char[] cs1 = cps1.toLowerCase().toCharArray();
		char[] cs2 = cps2.toLowerCase().toCharArray();
		Arrays.sort(cs1);
		Arrays.sort(cs2);
		if(Arrays.equals(cs1, cs2)){ //Arrays.equals(cs1, cs2) //cs1.equals(cs2)
			System.out.println("Anagram");
			return;
		}
	}
	public static void countOfUniqChars(String in){
		HashSet<Character> hs = new HashSet<>();
		for(int i = 0 ; i < in.length(); i++){
			hs.add(in.charAt(i));
		}
		System.out.println("Count of uniq chars in string is "+ hs.size());
	}
	public static void printOfUniqChars(String in){
		HashMap<Character, Integer > hashChar = new HashMap<>();
		char [] input = in.toCharArray();
		for(char s : input){
			if(hashChar.containsKey(s)){
				int count = hashChar.get(s);
				hashChar.put(s, ++count);
				// hashChar.put(s, hashChar.get(s)+1);
			}else{
				hashChar.put(s, 1);
			}
		}
		System.out.println("printing uniq chars with their values");
		System.out.println(hashChar);
		
	}
	public static void main(String[] args) {
		checkArmstrong(371);
		checkArmstrong(123);
		sumOfAllDigits(12321);
		isAnagram("Mother in law", "Hitler woman");
		isAnagram("Mother in lw", "Hitler woman");
		countOfUniqChars("auydgadagdbaykbjhydbakbddcdd");
		printOfUniqChars("auydgadagdbaykbjhydbakbddcdd");
	}

}
