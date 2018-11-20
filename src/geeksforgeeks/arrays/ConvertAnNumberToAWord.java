package geeksforgeeks.arrays;

public class ConvertAnNumberToAWord {

	private static String[] primary = {"one","two","three","four","five","six","seven","eight","nine","ten"};
	
	private static String[] countArr = {"","", "hundred","thousand",};
	
	private static String[] tensArr = {"twnety","thirty","fourty","fifty","sixty","seventy","eighty",
			"ninety"};
	
	private static String[] others = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen",
			"seventeen","eighteen","nineteen"};
	
	
	public static void main(String[] args) {
		int number = 1010;
		printWord(number);
	}
	
	private static void printWord(int number) {
		
		if(number == 0)
			return;
		
		if (number <= 10) {
			System.out.println(primary[number-1]);
		}
		if(number > 10 && number < 20) {
			System.out.print(others[number%10 -1] +" ");
			
		}
		
		int temp = number;
		int count = 0;
		int modulo = 0;
		int tens = 1;
		while(temp != 0) {
			modulo = temp % 10;
			temp = temp/10;
			count++;
			tens = tens * 10;
		}
		
		if(count > 2) {
			System.out.print(primary[modulo-1] +" " +countArr[count-1] +" ");
			printWord(number%(tens/10));
		} else {
			if (number > 20) {
				modulo = number%10;
				number = number/10;
				
				System.out.print(tensArr[number-2] + " " + primary[modulo-1] + " ");
			}
		}	
		
	}

}



