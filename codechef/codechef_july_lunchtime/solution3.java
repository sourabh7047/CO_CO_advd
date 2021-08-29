package codechef_july_lunchtime;

import java.util.*;
import java.io.*;

public class solution3 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        public char nextChar() {
            return next().toCharArray()[0];
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int s = sc.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

        }
    }

    public static boolean bs(int[] arr, int rs, int re, int n) {

        int mid = rs + re / 2;
        if (rs < re) {
            bs2(arr, n, mid);
        }
        return false;

    }

    public static int bs2(int[] arr, int n, int mid) {
        int length = n - mid + 1;
        for (int i = 0; i < length; i++) {

        }
        return length;
    }

    public static boolean middian(int[] arr, int rs, int re, int mid, int k, int s) {
        return false;
        
    }

  
}
