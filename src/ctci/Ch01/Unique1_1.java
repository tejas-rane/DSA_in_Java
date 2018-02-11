package ctci.Ch01;
import java.util.HashMap;
import java.util.HashSet;

public class Unique1_1 {

	public static void checkUnique(String x){
		HashSet<Character> hm = new HashSet<>();
		String in = x.toLowerCase().replaceAll("\\s", "");
		//System.out.println(in);
		for(int i=0;i<in.length();i++){
			hm.add(in.charAt(i));
		}
//		System.out.println(hm);
		if(in.length() != hm.size()){
			System.out.println("Not unique chars");
		}else {
			System.out.println("Unique");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x= "H  I am Tejs Rn";
		checkUnique(x);
	}

}
