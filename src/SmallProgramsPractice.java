import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SmallProgramsPractice {
	public static void checkArmstrong(int num) {
		int result = 0;
		int no = num;
		while (no != 0) {
			int rem = no % 10;
			result += rem * rem * rem;// works only for 3 digit
			/*
			 * can be modified by adding a for loop to calculate the power by
			 * finding the length of number
			 */
			no /= 10;
		}
		if (result == num) {
			System.out.println("Armstrong number");
		} else {
			System.out.println("Not a Armstrong number");
		}
	}
	public static void sumOfAllDigits(int num) {
		int sum = 0;
		int temp = num;
		while (temp != 0) {
			int lastDigit = temp % 10;
			sum += lastDigit;
			temp /= 10;
		}
		System.out.println("sum is " + sum);
	}
	public static void isAnagram(String s1, String s2) {
		String cps1 = s1.replaceAll("\\s", "");
		String cps2 = s2.replaceAll("\\s", "");
		if (cps1.length() != cps2.length()) {
			System.out.println("Not an Anagram");
			return;
		}
		char[] cs1 = cps1.toLowerCase().toCharArray();
		char[] cs2 = cps2.toLowerCase().toCharArray();
		Arrays.sort(cs1);
		Arrays.sort(cs2);
		if (Arrays.equals(cs1, cs2)) { // Arrays.equals(cs1, cs2)
										// //cs1.equals(cs2)
			System.out.println("Anagram");
			return;
		}
	}
	public static void countOfUniqChars(String in) {
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i < in.length(); i++) {
			hs.add(in.charAt(i));
		}
		System.out.println("Count of uniq chars in string is " + hs.size());
	}
	public static void printOfUniqChars(String in) {
		HashMap<Character, Integer> hashChar = new HashMap<>();
		char[] input = in.toCharArray();
		for (char s : input) {
			if (hashChar.containsKey(s)) {
				int count = hashChar.get(s);
				hashChar.put(s, ++count);
				// hashChar.put(s, hashChar.get(s)+1);
			} else {
				hashChar.put(s, 1);
			}
		}
		System.out.println("printing uniq chars with their values");
		System.out.println(hashChar);

	}
	public static void findDuplicate(String[] str) {
		HashSet<String> hs = new HashSet<>();
		for (String s : str) {
			if (hs.add(s) == false) {
				System.out.println("Duplicate : " + s);
			}
		}
	}
	public static void firstNonRepeatingChar(String str) {
		char[] s = str.toCharArray();
		HashMap<Character, Integer> hs = new HashMap<>();
		for (char c : s) {
			if (hs.containsKey(c)) {
				hs.put(c, hs.get(c)+1);
			} else {
				hs.put(c, 1);
			}
		}
		//find the key with count equal to 1: gives first non repeating char
		for(char c : s){
			if(hs.get(c) == 1){
				System.out.println("1st non repeating char is " + c);
				break;
			}
		}
		for(char c : s){
			if(hs.get(c) > 1){
				System.out.println("1st repeating char is " + c);
				break;
			}
		}
	}
	public static void isPalindrome(String str){
		char[] c = str.toCharArray();
		int start= 0;
		boolean palindrome = true;
		int end = c.length-1;
		while(start < end){
			if(c[start] != c[end]){
				palindrome = false;
				break;
			}
			start++; end--;
		}
		if(palindrome){System.out.println("Palindrome");}else{ System.out.println("Not Palindrome");}
	}
	public static void isPalindrome(int no){
		//length of number if even
		if(no <= 0 || no%10 == 0){
			return;
		}
		int rev=0;
		while(no > rev){
			rev = rev*10 + no%10;
			no = no/10;
		}
		// above loop breaks at halfway
		if(rev == no){
			System.out.println("Nubmer is palindrome");
		}else{
			System.out.println("Not a palindrome number");
		}
	}
	public static void reverseWordsInString(String s){
		String[] words = s.split(" ");
        String reverseString = "";
        
        
        for(int i =0 ; i< words.length; i++){
            char[] w = words[i].toCharArray();
            
            String revWord = "";
            
            for(int j =w.length-1 ; j>=0 ;j--){
                revWord = revWord+w[j];
            }
            reverseString = reverseString + revWord + " ";
        }
        reverseString = reverseString.substring(0,reverseString.length() - 1);
        System.out.print(reverseString);
        //return reverseString;
	}
	public static void main(String[] args) {
		checkArmstrong(371);
		checkArmstrong(123);
		sumOfAllDigits(12321);
		isAnagram("Mother in law", "Hitler woman");
		isAnagram("Mother in lw", "Hitler woman");
		countOfUniqChars("auydgadagdbaykbjhydbakbddcdd");
		printOfUniqChars("auydgadagdbaykbjhydbakbddcdd");
		String[] arr = { "abc", "def", "abc", "xyz", "xyz" };
		findDuplicate(arr);
		firstNonRepeatingChar("sazsdahdvajzdvjada");
		isPalindrome("madam");isPalindrome("madama");isPalindrome(123454321);isPalindrome(1234554321);
		reverseWordsInString("Let's take LeetCode contest");
	}

}
