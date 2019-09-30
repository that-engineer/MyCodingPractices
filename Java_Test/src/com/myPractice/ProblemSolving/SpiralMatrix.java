package com.myPractice.ProblemSolving;

import java.util.ArrayList;

public class SpiralMatrix {
	public static ArrayList<Integer> printSpiralMat(int[][] mat) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int rowBegin=0;
		int rowEnd=mat.length-1;
		int colBegin=0;
		int colEnd=mat[0].length-1;
		
		while(rowBegin<=rowEnd && colBegin<=colEnd) {
			for(int i=colBegin;i<=colEnd;i++) {
				res.add(mat[rowBegin][i]);
			}
			rowBegin++;
			for(int i=rowBegin;i<=rowEnd;i++) {
				res.add(mat[i][colEnd]);
			}
			colEnd--;
			if(rowBegin<=rowEnd) {
				for(int i=colEnd;i>=colBegin;i--) {
					res.add(mat[rowEnd][i]);
				}
				rowEnd--;
			}
			if(colBegin<=colEnd) {
				for(int i=rowEnd;i>=rowBegin;i--) {
					res.add(mat[i][colBegin]);
				}
				colBegin++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
	
		int m=4; int n = 5;
		int mat[][] = new int[m][n];
		int c=1;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				mat[i][j]= c;
				c++;
			}
		}
		ArrayList<Integer> res = printSpiralMat(mat);
		for(Integer i: res) {
			System.out.print(i+" ");
		}

	}

}
