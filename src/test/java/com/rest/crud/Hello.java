package com.rest.crud;

public class Hello {

	public static void main(String args[]) {
		String x = "xyz abc \"abcdsfd sdfs sddfd\" sdddsf \"sdfdsd sdfds dsfds\" onncccv";

//		char res[] = s.toCharArray();
//		int flag = 0;
//		for (char result : res) {
//			if (result == '\"' && flag <= 1) {
//				System.out.print(result);
//				// System.out.println("1 block");
//				flag++;
//			} else if (result == '\"' && flag == 2) {
//				System.out.print(result);
//				flag = 0;
//			} else if (result == ' ' && flag == 0) {
//				System.out.println();
//
//			} else if (result == ' ' && flag == 2) {
//				System.out.println();
//				flag = 0;
//			} else {
//				System.out.print(result);
//			}
//		}
		  System.out.println(x);
	        char[] xChar = x.toCharArray();
	        int xLen = x.length();
	        int count=0;
	        for (int i=0;i<xLen;i++)
	        {   
	            if (xChar[i]=='"'){count = count+1;}
	        
	            if (count>0 && count<2){
	                System.out.print(xChar[i]);
	                continue;
	            }
	            count=0;
	            System.out.print(xChar[i]);
	            
	            if (xChar[i] ==' ')
	            {  
	                System.out.println();
	            }
	        }

	}
}
