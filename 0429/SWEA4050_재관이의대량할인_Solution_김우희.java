package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4050_재관이의대량할인_Solution_김우희 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int sum = 0;
			int num = 1;
			for (int i = N-1; i >= 0; i--) {
				if(num != 3) {
					sum += arr[i];
					num++;
				} else {
					num = 1;
				}
			}
			
			System.out.println("#"+testCase+" "+sum);
		}
	}

}
