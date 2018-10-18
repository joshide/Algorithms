package sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {329, 457, 657, 839, 436, 720, 355};
		radixSort(arr);

	}
	
	private static void radixSort(int[] arr) {
		int numberOfDigits = getNumberOfDigits(arr[0]);
		System.out.println(numberOfDigits);
		
		for(int i = 1; i <= numberOfDigits; i++) {
			arr = countSort(arr,i);
		}
		
		for(int number : arr) {
			System.out.print(number +",");
		}
	}
	
	private static int getNumberOfDigits(int number) {
		int count = 0;
		while(number/10 != 0) {
			number = number/10;
			count++;
		}
		return count+1;
	}
	
	private static int[] countSort(int[] arr, int index) {
		
		int[] sortingNumber = getArraysof(arr, index);
		
		
		
		
		
		Element[] elements = new Element[arr.length];
		for(int i = 0; i < arr.length; i++) {
			Element element = new Element(arr[i], sortingNumber[i]);
			elements[i] = element;
		}
		
		int max = getMax(elements);
		
		int[] c = new int[max+1];
		for(int i = 0; i < elements.length; i++) {
			c[elements[i].sortingNumber] = c[elements[i].sortingNumber] + 1;
		}
		
		for(int i = 1; i < c.length; i++) {
			c[i] = c[i] + c[i-1];
		}
		
		int[] b = new int[arr.length];
		
		for(int i = elements.length-1; i >= 0; i--) {
			b[c[elements[i].sortingNumber] -1 ] = elements[i].number;
			c[elements[i].sortingNumber] --;
		}
		
		
		return b;
	}
	
	private static int getMax(Element[] elements) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < elements.length; i++ ) {
			if(elements[i].sortingNumber > max) {
				max = elements[i].sortingNumber;
			}
		}
		return max;
	}
	
	private static int[] getArraysof(int[] arr, int index) {
		int[] outputArr = new int[arr.length];
		
		int tempIndex = index;
		int[] tempArr = Arrays.copyOf(arr, arr.length);
		
		
		for(int i = 0; i < tempArr.length; i++) {
			int digit = 0;
			while(index != 0) {
				 digit = tempArr[i]%10;
				 tempArr[i] = tempArr[i]/10;
				 index --;
			}
			outputArr[i] = digit;
			index = tempIndex;
		}
		
		return outputArr;
	}

}

class Element{
	
	int number;
	int sortingNumber;
	
	Element(int number, int sortingNumber) {
		this.number = number;
		this.sortingNumber = sortingNumber;
	}
	
	public String toString() {
		return number +"-" + sortingNumber;
	}
}
