package codechef_july_lunchtime;

import java.util.*;
import java.io.*;

public class solution5 {
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

    public static void bs(int[] arr, int sti, int ndi, long s, int k, int n){    // startindex = sti, endindex = edi
        
        int ans = 0;
        while(sti<ndi){
            int mid = (sti+ndi)/2;

            // memory to hold the position of min value
            ArrayList<Long> memory = new ArrayList<>(); 
            
            // to keep the count sum of element, minsum, segments completed
            long count =0;

            for(int i=0; i<mid; i++){
                
                // if the count is less than s then it will be not counted in segment
                if(count+arr[i]<=s){
                    count +=arr[i];
                } else {
                    memory.add(count);
                }
            }

            if(memory.size()<=k){
                ans = memory.size();
                sti = mid+1;
            } else {
                for(int i=mid; i<n; i++){

                    // reducing the initial value
                    Collections.sort(memory);
                    if(memory.get(0)+arr[i]<=s){
                        
                    }
                }
            }
        }
    }
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long s = sc.nextLong();

            long[] A = new long[n];

            for(int i=0;i <n; i++){
                A[i] = sc.nextLong();
            }


        }
    }
}
