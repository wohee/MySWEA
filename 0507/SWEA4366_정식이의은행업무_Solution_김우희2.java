package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SWEA4366_정식이의은행업무_Solution_김우희2 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			long answer = 0;
			
			String wrong2 = br.readLine();
			String wrong3 = br.readLine();
			
			char[] char2 = wrong2.toCharArray();
			char[] char3 = wrong3.toCharArray();
			
			// 2진수의 각 자리수를 하나씩 바꿔가며 10진수로 변경해서 관리
			List<Long> candidates = new ArrayList<>();
			for (int i = 0; i < char2.length; i++) {
				// 변경할 자리수를 저장해뒀다가 원복때 사용
				char2[i] = char2[i] == '0'? '1':'0';
				
				// 이진수를 10진수로 바꿔주자..
				candidates.add(toDigit10(char2, 2));
				
				// 원복
				char2[i] = char2[i] == '0'? '1':'0';
			}
			
			
			Collections.sort(candidates);

outer:		for (int i = 0; i < char3.length; i++) {
				// 변경할 자리수를 저장해뒀다가 원복때 사용
				for (char k = '0'; k < '3'; k++) {
					char old = char3[i];
					if(char3[i] != k) {
						char3[i] = k;
					}
					long digit10 = toDigit10(char3, 3);
					
					if(Collections.binarySearch(candidates, digit10) >= 0) {
						answer = digit10;
						break outer;
					}
//					if(candidates.contains(digit10)) {
//						answer = digit10;
//						break outer;
//					}
					// 변수 원복
					char3[i] = old;
				}
			}

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
			

		} // end of testCase
		System.out.println(sb);

	} // end of main
	
	static long toDigit10(char[] chars, int digits) {
		long num = 0;
		
		for (int i = 0, j=chars.length-1; i < chars.length; i++,j--) {
			num += (chars[i]-'0') * Math.pow(digits, j);
		}
		return num;
		
	}

} // end of class
