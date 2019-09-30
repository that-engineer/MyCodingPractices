package com.myPractice.ProblemSolving;

public class RearrangePositiveNegative {
	int[] arr= new int[9];
	
	public static void rearrangeIntegers(int[] arr) {
		int s=0,l=arr.length-1;
		while(l>s) {
			if(arr[s]>0 && arr[l]<0) {
				swap(arr,s,l);
				l--;
				s++;
			}else if(arr[s]>0 && arr[l]>0) {
				l--;
			}else if(arr[s]<0 && arr[l]<0) {
				s++;
			}else {
				l--;
				s++;
			}
		}
	}
	public static void swap(int[] arr, int s, int l) {
		int temp = arr[s];
		arr[s]=arr[l];
		arr[l]=temp;
	}

	public static void main(String[] args) {
		int[] arr = {10,-9,4,-7,-14,1,3,-2,8};
		rearrangeIntegers(arr);
		for(int i:arr) {
			System.out.print(" ");
			System.out.print(i);
		}
	}

}
