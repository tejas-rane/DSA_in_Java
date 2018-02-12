package ctci.Ch01;

public class StringCompression {
	private static void compress(String s){
		StringBuilder compressed = new StringBuilder();
		int countrepeated = 0;
		for(int i =0;i<s.length();i++){
			countrepeated++;
			if(i+1>=s.length() || s.charAt(i) != s.charAt(i+1)  ){
				compressed.append(s.charAt(i));
				compressed.append(countrepeated);
				countrepeated = 0;
			}
		}
		
		if(compressed.length() == s.length()){
			System.out.println(s);
		}else{
			System.out.println(compressed);
		}
			
	}
	public static void main(String[] args) {
		//String in = "aabccccccaaaa";
		String in = "aa";
		compress(in);
	}
}
