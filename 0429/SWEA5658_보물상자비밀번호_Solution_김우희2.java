package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA5658_보물상자비밀번호_Solution_김우희2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String s = sc.next();
			String t = s + s.substring(0, N/4-1);
			 
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				String hex = t.substring(i, i+N/4);
				int num = Integer.parseInt(hex, 16);
				if(!list.contains(num)) {
					list.add(num);
				}

			}
			Collections.sort(list,Collections.reverseOrder());
			System.out.println("#"+tc + " " +list.get(K-1));
		} // end of testCase
		
		sc.close();
		
		
		
	} // end of main

} // end of class
