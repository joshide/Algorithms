package geeksforgeeks.dynamic_programming;

public class EditDistance {

	private static int[][] store = null;
	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		
		store = new int[str1.length()][str2.length()];
		int minimumOperations = convert(str1,str2,0,0);
		System.out.println(minimumOperations);

	}
	
	private static int convert(String str1, String str2, int index1, int index2) {
		if(str1 == null) {
			return str2.length();
		}
		
		if(str2 == null) {
			return str1.length();
		}
		
		if(index1 == str1.length()) {
			return str2.length() - index2;
		}
		
		if(index2 == str2.length()) {
			return str1.length() - index1;
		}
		if(store[index1][index2] != 0) {
			//System.out.println("result");
			return store[index1][index2];
		}
		String char1 = str1.substring(index1, index1+1);
		String char2 = str2.substring(index2, index2+1);
		
		int result = 0;
		if(char1.equals(char2)) {
			result = convert(str1, str2, index1+1, index2+1);
		} else {
			int insert = 1 + convert(str1, str2, index1, index2+1);
			int replace = 1 + convert(str1, str2, index1+1, index2+1);
			int remove = 1 + convert(str1, str2, index1+1, index2);
			
			if(insert <= replace && insert <= remove)
				result = insert;
			else if(replace <= insert && replace <= remove)
				result = replace;
			else
				result = remove;
		}
		
		store[index1][index2] = result;
		return result;
	}

}
