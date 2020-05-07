package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA4366_정식이의은행업무_Solution_김우희 {
	static char[] arr1;
	static char[] arr2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			arr1 = br.readLine().toCharArray(); // 1010
			arr2 = br.readLine().toCharArray(); // 212
			
ex:			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = arr1[i] == '0'? '1':'0';
				
				
				String temp = "";
				for (int j = 0; j < arr1.length; j++) {
					temp += arr1[j];
				}

				// 10진수로 변환
				int num = Integer.parseInt(temp, 2);
				
				
				// 3진수로 변환
				String temp2 = "";
				int copy = num;
				while(true) {
					if(copy/3 == 0) {
						temp2 = copy%3 + temp2;
						break;
					} 
					temp2 = copy%3 + temp2;
					copy = copy/3;
				}
				
				int cnt = 0;
				// 길이가 같다면 비교!
				if(arr2.length == temp2.length()) {
					for (int j = 0; j < arr2.length; j++) {
						if(arr2[j] != temp2.charAt(j)) {
							cnt++;
						}
						
					}
				}
				
				
				if(cnt == 1) {
					System.out.println("#"+testCase+" "+num);
					break ex;
				}

				arr1[i] = arr1[i] == '0'? '1':'0';
			}

		} // end of testCase

	} // end of main

} // end of class
