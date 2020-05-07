package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA6109_추억의2048게임_Solution_김우희 {
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
	
			arr = new int[n][n];
			visited = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			if(dir.equals("up")) {
				for (int j = 0; j < n; j++) {
					for (int i = 1; i < n; i++) {
						if(arr[i][j] != 0) {
							for (int k = i; k > 0; k--) {
								if(visited[k-1][j] || (arr[k-1][j] != 0 && arr[k-1][j] != arr[k][j])) {
									break;
								} else if(arr[k-1][j] == 0) {
									if(!visited[k][j]) {
										arr[k-1][j] = arr[k][j];
										arr[k][j] = 0;
									}else {
										arr[k-1][j] = arr[k][j];
										arr[k][j] = 0;
										visited[k][j] = false;
										visited[k-1][j] = true;
									}
										
								} else if(!visited[k-1][j] && !visited[k][j] && arr[k-1][j] == arr[k][j]) {
										arr[k-1][j] = arr[k][j]*2;
										arr[k][j] = 0;
										visited[k-1][j] = true;
									
								}
							}
	
						}	
					}
				}
				
			} else if(dir.equals("down")) {
				for (int j = 0; j < n; j++) {
					for (int i = n-1; i >= 0; i--) {
						if(arr[i][j] != 0) {
							for (int k = i; k < n-1; k++) {
								if(visited[k+1][j] || (arr[k+1][j] != 0 && arr[k+1][j] != arr[k][j])) {
									break;
								} else if(arr[k+1][j] == 0) {
									if(!visited[k][j]) {
										arr[k+1][j] = arr[k][j];
										arr[k][j] = 0;
									}else {
										arr[k+1][j] = arr[k][j];
										arr[k][j] = 0;
										visited[k][j] = false;
										visited[k+1][j] = true;
									}
										
								} else if(!visited[k+1][j] && !visited[k][j] && arr[k+1][j] == arr[k][j]) {
										arr[k+1][j] = arr[k][j]*2;
										arr[k][j] = 0;
										visited[k+1][j] = true;
									
								}
							}
	
						}	
					}
				}
				
				
			} else if(dir.equals("left")) {
				for (int i = 0; i < n; i++) {
					for (int j = 1; j < n; j++) {
						if(arr[i][j] != 0) {
							for (int k = j; k > 0; k--) {
								if(visited[i][k-1] || (arr[i][k-1] != 0 && arr[i][k-1] != arr[i][k])) {
									break;
								} else if(arr[i][k-1] == 0) {
									if(!visited[i][k]) {
										arr[i][k-1] = arr[i][k];
										arr[i][k] = 0;
									}else {
										arr[i][k-1] = arr[i][k];
										arr[i][k] = 0;
										visited[i][k] = false;
										visited[i][k-1] = true;
									}
										
								} else if(!visited[i][k-1] && !visited[i][k] && arr[i][k-1] == arr[i][k]) {
										arr[i][k-1] = arr[i][k]*2;
										arr[i][k] = 0;
										visited[i][k-1] = true;
									
								}
							}
	
						}	
					}
					
				}
	
			} else if(dir.equals("right")) {
				for (int i = 0; i < n; i++) {
					for (int j = n-1; j >= 0; j--) {
						if(arr[i][j] != 0) {
							for (int k = j; k < n-1; k++) {
								if(visited[i][k+1] || (arr[i][k+1] != 0 && arr[i][k+1] != arr[i][k])) {
									break;
								} else if(arr[i][k+1] == 0) {
									if(!visited[i][k]) {
										arr[i][k+1] = arr[i][k];
										arr[i][k] = 0;
									}else {
										arr[i][k+1] = arr[i][k];
										arr[i][k] = 0;
										visited[i][k] = false;
										visited[i][k+1] = true;
									}
										
								} else if(!visited[i][k+1] && !visited[i][k] && arr[i][k+1] == arr[i][k]) {
										arr[i][k+1] = arr[i][k]*2;
										arr[i][k] = 0;
										visited[i][k+1] = true;
									
								}
					
							}
			
						}	
					}
					
				}
			}
			
			System.out.println("#"+testCase);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
		} // end of testCase

	} // end of main
} // end of class


