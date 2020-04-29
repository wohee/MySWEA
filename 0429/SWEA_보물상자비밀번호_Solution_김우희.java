package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SWEA_보물상자비밀번호_Solution_김우희 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
			int K = Integer.parseInt(st.nextToken()); // 크기 순서
			
			
			char[] str = new char[N];
			String line = br.readLine();
			for (int i = 0; i < N; i++) {
				str[i] = line.charAt(i);
			}
			
			HashSet<String> hash = new HashSet<>();

			// 중복된것이 나왓을 때 stop & 시계방향으로 방향바꾸기
			for (int i = 0; i < N/4; i++) { // 회전 횟수
				int cnt = 0;
				String name = null;
				for (int j = 0; j < 4; j++) {
					char[] temp2 = new char[N/4]; 
					for (int l = 0; l < N/4; l++) {
						temp2[l] = str[cnt++];
					}
					
					name = String.valueOf(temp2); // string으로 변환
					
					if(!hash.contains(name)) { // 중복하지 않으면 추가
						hash.add(name);
					}

				}
				
				// 옮기기
				char temp = str[N-1];
				for (int m = N-1; m > 0; m--) {
					str[m] = str[m-1];
				}
				str[0] = temp;
			}
			
			int[] num = new int[hash.size()];
			int cnt = 0;
			Iterator<String> i = hash.iterator();
			while(i.hasNext()) {
				int last = Integer.parseInt(i.next(), 16); // 16진수 10진수로 바꿔주기
				num[cnt++] = last;
			}
			
			Arrays.sort(num); // 정렬
			int[] total = new int[num.length];
			cnt = 0;
			for (int j = num.length-1; j >= 0; j--) { // 다시 뒤집어주기
				total[cnt++] = num[j];
			}
			
			System.out.println("#"+testCase+" " +total[K-1]);
			
			
		} // end of testCase
	} // end of main
} // end of class
