package august_starter9;

import java.util.*;

import java.io.*;

public class solution2 {
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

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = fab(n);
            System.out.println(solve(str)); 
        }
    }

    public static String fab(int n) {
        String[] arr = new String[n + 1];
        arr[0] = "0";
        arr[1] = "1";

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];

    }

    static int pow(int x, int y, int p) {
        int res = 1;
        x = x % p;

        if (x == 0) {
            return 0;
        }
        while (y > 0) {
            if ((y & 1) != 0) {
                res = (res * x) % p;
                y = y >> 1;
                x = (x * x) % p;
            }
        }
        return res;
    }

    static int mod = 1000000007;

    public static long solve(String s) {
        long ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            ans += (((Character.getNumericValue(s.charAt(i)) * pow(11, n - i - 1, mod)) % mod) * pow(2, i, mod)) % mod;
            ans %= mod;
        }
        return ans;
    }
}
