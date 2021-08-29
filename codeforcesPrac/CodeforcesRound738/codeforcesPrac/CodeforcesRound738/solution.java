package codeforcesPrac.CodeforcesRound738;

import java.util.*;
import java.io.*;

public class solution {
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
        long t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long ans = sc.nextLong();

            for (int i = 1; i < n; i++) {
              long temp = sc.nextLong();
              ans = ans&temp;
            }

            System.out.println(ans);

        }
    }
}