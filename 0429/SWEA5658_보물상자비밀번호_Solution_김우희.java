package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA5658_보물상자비밀번호_Solution_김우희 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String s = sc.next();
			 
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < N/4; i++) {
				int start = 0;
				int end = N/4;
				for (int j = 0; j < 4; j++) {
					String hex = s.substring(start, end);
					int num = Integer.parseInt(hex, 16);
					if(!list.contains(num)) {
						list.add(num);
					}
					start = end;
					end += N/4;
				}
				char c = s.charAt(N-1);
				s = c+s.substring(0,N-1);
			}
			Collections.sort(list);
			System.out.println("#"+tc + " " +list.get(list.size()-K));
		} // end of testCase
		
		sc.close();
		
		
		
	} // end of main

} // end of class
