package codechef_july_lunchtime;

import java.util.*;
import java.io.*;
import java.text.*;

class comp {
    static long mod=(long)(1e9+7);
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()  {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static long GCD(long a,long b) 
	{
		if(b==0)
		{
			return a;
		}
		else return GCD(b,a%b );
	}

    static  long pow(long a,long b)
	{
		long pow=1;
		long x=a;
		while(b!=0)
		{
			if((b&1)!=0)pow=(pow*x)%mod;
			x=(x*x)%mod;
			b/=2;
		}
		return pow;
	}

    static long lower_Bound(long A[],int low,int high, long x) 
	{ 
		if (low > high) 
			if (x >= A[high]) 
				return A[high]; 

		int mid = (low + high) / 2; 

		if (A[mid] == x) 
			return A[mid]; 

		if (mid > 0 && A[mid - 1] <= x && x < A[mid]) 
			return A[mid - 1]; 

		if (x < A[mid]) 
			return lower_Bound( A, low, mid - 1, x); 

		return lower_Bound(A, mid + 1, high, x); 
	} 

    public static void print(ArrayList<Integer> arr, PrintWriter out) {
        for (int x : arr) {
            out.print(x + " ");
        }
        out.println();
    }

    public static void print(int[] arr, PrintWriter out) {
        for (int x : arr) {
            out.print(x + " ");
        }
        out.println();
    }
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
       
        int t = sc.nextInt();
        int hh = 0;

        while (hh++ < t) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            int i, j;
            for (i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                a[i] = a[i] % n;
            }

            for (i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                b[i] = b[i] % n;
            }

            int f[] = new int[n];
            int min = Integer.MAX_VALUE;
            for (i = 0; i < n; i++) {
                f[i] = (a[0] + b[i]) % n;
                min = Math.min(min, f[i]);
            }

            ArrayList<Integer> minimum = new ArrayList<>();
            for (i = 0; i < n; i++) {
                if (f[i] == min) {
                    minimum.add(i);
                }
            }

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            for (int x : minimum) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (j = 0; j < n; j++) {
                    arr.add((a[j] + b[(j + x) % n]) % n);
                }
                result.add(arr);
            }

            Collections.sort(result, (x, y) -> {
                int g;
                for (g = 0; g < x.size(); g++) {
                    if (x.get(g) < y.get(g))
                        return -1;
                    if (x.get(g) > y.get(g))
                        return 1;
                }
                return 0;
            });

            print(result.get(0), out);
        }

        out.flush();

    }
}
