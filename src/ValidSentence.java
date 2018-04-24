
public class ValidSentence {
	private static boolean startswCaps(String s) {
		return s.isEmpty()? false: Character.isUpperCase(s.charAt(0)) ;
	}

	private static boolean checkQuotes(String s) {
		int doubleQuotes = 0;
		int singleQuotes = 0;
		//System.out.println("checkQuotes");
		for (int i = 0; i < s.length(); i++) {
			int pos = i+1;
		    if (s.charAt(i) == 34) {
		    	//System.out.println("found");
		    	doubleQuotes++;
		    }
		    else if (s.charAt(i) == 39 && pos<s.length() && s.charAt(pos) != 's') {
		    	singleQuotes++;
		    }
		}
		//System.out.println(doubleQuotes + " "+ singleQuotes);
		return doubleQuotes%2 == 0 && singleQuotes %2 == 0;
	}

	private static boolean endswPeriod(String s) {
		//System.out.println("endswPeriod");
		int numberOfPeriods=0;
		for (int i = 0; i < s.length(); i++) {
		    if (s.charAt(i) == '.') {
		    	numberOfPeriods++;
		    }
		}
		return numberOfPeriods == 1 && s.charAt(s.length()-1) == '.';
	}

	private static boolean checkNumbers(String s) {
		//System.out.println("checkNumbers");
		String[] words = s.split(" ");
		for(String word : words){
			try{
				int test = Integer.parseInt(word);
				if(test < 13) return false;
			}catch(Exception e){
				//e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean isValid(String s) {
		return startswCaps(s) && checkQuotes(s) && endswPeriod(s) && checkNumbers(s);
	}

	public static void main(String[] args) {
		String[] input = { 
				"The quick brown fox said \"hello Mr lazy dog\".",
				"The quick brown fox said hello Mr lazy dog.", 
				"One lazy dog is too few, 13 is too many.",
				"One lazy dog is too few, thirteen is too many.",
				"The quick brown fox said \"hello Mr. lazy dog\".",
				"the quick brown fox said \"hello Mr lazy dog\".",
				"The quick brown fox said \"hello Mr lazy dog.",
				"One lazy dog is too few, 12 is too many." ,
				"One's lazy dog.",
				"One's 'lazy' dog.",
				"One's 'lazy Dog.'",
				"One's 'lazy Dog' is okay.",
				"One's 'lazy Dog'.",
				""
				};
		for (String s : input) {
			if (isValid(s))
				System.out.println("\""+s +"\""+ " \n==>\tis a Valid sentence");
			else
				System.out.println("\""+s +"\""+ " \n==>\tis a inValid sentence");
		}
	}
}
