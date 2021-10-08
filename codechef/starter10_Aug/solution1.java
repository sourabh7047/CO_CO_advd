package starter10_Aug;

import java.util.*;
import java.io.*;

public class solution1 {
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

        static int gcd(int a, int b) {
            if (a == 0)
                return b;
            return gcd(b % a, a);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int even = 0;
            int odd = 0;
            int count = 0;

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                if (arr[i] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            if (even == 0) {
                System.out.println(0);
            } else if (odd == 0) {
                Arrays.sort(arr);
                for (int i = 0; i < n; i++) {
                    if (arr[i] % 3 == 0) {
                       long x = arr[i];
                       while(x%2 ==0){
                            x=(long)Math.floor(x/2);
                           count++;
                       }
                        break;
                    }
                }
                System.out.println(count);
            } else {
                System.out.println(0);
            }
        }
    }
}
