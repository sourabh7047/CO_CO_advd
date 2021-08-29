package longChallenge_august;

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Pair[] set = new Pair[(int) m];

            for (int i = 0; i < m; i++) {
                set[i] = new Pair(sc.nextInt(), sc.nextInt());
            }

            Arrays.sort(set);

            // for (int i = 0; i < m; i++) {
            // System.out.println(set[i].x + " " + set[i].y);
            // }

            System.out.println(calc(n, set));

        }
    }

    // gcd calculator
    static int gcd(int a, int b)
    {
        // GCD(0, b) == b; GCD(a, 0) == a,
        // GCD(0, 0) == 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;
 
        // Finding K, where K is the greatest
        // power of 2 that divides both a and b
        int k;
        for (k = 0; ((a | b) & 1) == 0; ++k)
        {
            a >>= 1;
            b >>= 1;
        }
 
        // Dividing a by 2 until a becomes odd
        while ((a & 1) == 0)
            a >>= 1;
 
        // From here on, 'a' is always odd.
        do
        {
            // If b is even, remove
            // all factor of 2 in b
            while ((b & 1) == 0)
                b >>= 1;
 
            // Now a and b are both odd. Swap
            // if necessary so a <= b, then set
            // b = b - a (which is even)
            if (a > b)
            {
                // Swap u and v.
                int temp = a;
                a = b;
                b = temp;
            }
 
            b = (b - a);
        } while (b != 0);
 
        // restore common factors of 2
        return a << k;
    }

    // class pair implementation
    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            // TODO Auto-generated method stub

            if (this.x == other.x)
                return 0;
            else if (this.x < other.x)
                return 1;
            else
                return -1;
        }
    }

    

    // calc2 function
    public static long calc2(int n, Pair[] set, int curr, int multi) {
        int store = multi;

        // System.out.println(n+" n");
        long res = 0;
        if (set.length <= curr || n == 0) {
            return res;
        }
        // System.out.println(set[curr].y+" "+multi+"??");
        int dividor = gcd(set[curr].y, multi);

        // System.out.println(dividor+"//");

        multi = set[curr].y / dividor; // 8/4
        // System.out.println(multi + "///");
        int csize = n / multi; // 14/2
        // System.out.println(csize + " c");
        int lsize = n - csize; // 14-7
        // System.err.println(lsize+" s");
        res = lsize * set[curr].x;
        // System.out.println(set[curr].x + " " + lsize + "/");
        curr++;
        return res + calc2(csize, set, curr, store*multi);

    }

    // calc1 function
    public static long calc(int n, Pair[] set) {

        int csize = n / set[0].y; // 170/12 =14
        int lsize = n - csize; // 170-14 = 156
        long res = lsize * set[0].x; // 156*16
        // System.out.println(set[0].x + " " + lsize + "/");
        return res + calc2(csize, set, 1, set[0].y);

    }
}
