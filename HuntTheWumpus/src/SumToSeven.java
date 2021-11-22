import java.io.*;
import java.util.*;

public class SumToSeven {
	//solve 8/10, runtime exceed for last 2 cases
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("div7.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // num of cow
		int[] sum = new int[N+1];
		for (int i=1;i<=N;i++) {
			sum[i] = sum[i-1];
			sum[i] += Integer.parseInt(br.readLine());
		}

		int max = 0; 
		for (int i=1;i<=N;i++) {
			for (int j=i;j<=N;j++) {

				if ((sum[j]-sum[i-1]) % 7 == 0) {
					max = Math.max(max, j-i+1);

				}
			}
		}
		pw.print(max);
		pw.close();
	}

}
