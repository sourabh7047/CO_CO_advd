package codechef_july_lunchtime;

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
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            Map<Long, Long> connect = new HashMap<>();

            long count = 0;

            for (int i = 0; i < n; i++) {

                count += i * 2;

                long x = sc.nextLong();
                if (connect.containsKey(x)) {
                    connect.put(x, connect.get(x) + 1);
                } else {
                    connect.put(x, (long) 1);
                }
            }
            

            for (Map.Entry<Long, Long> entry : connect.entrySet()) {
                if (entry.getValue() > 1)
                    
                    count -= entry.getValue()*(entry.getValue()-1);
            }

            System.out.println(count);

        }
    }
}
