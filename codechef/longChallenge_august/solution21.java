package longChallenge_august;

import java.util.*;
import java.io.*;

public class solution21 {
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

         
            ArrayList<ArrayList<Integer>> set = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add( sc.nextInt());
                temp.add(sc.nextInt());
                set.add(temp);
                
            }

            Collections.sort(set, (x,y)->{
                if(x.get(0) >y.get(0)) return  -1;
                else if (x.get(0)<y.get(0)) return 1;
                else return 0;
            });
            

            // for (int i = 0; i < m; i++) {
            // System.out.println(set[i].x + " " + set[i].y);
            // }

            System.out.println(calc(n, set));

        }
    }

    // gcd calculator
    static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
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
    public static long calc2(int n, ArrayList<ArrayList<Integer>> set, int curr, int multi) {
        int store = multi;

        // System.out.println(n+" n");
        long res = 0;
        if (set.size() <= curr || n == 0) {
            return res;
        }
        // System.out.println(set[curr].y+" "+multi+"??");
        int dividor = gcd(set.get(curr).get(1), multi);

        // System.out.println(dividor+"//");

        multi = set.get(curr).get(1) / dividor; // 8/4
        // System.out.println(multi + "///");
        int csize = n / multi; // 14/2
        // System.out.println(csize + " c");
        int lsize = n - csize; // 14-7
        // System.err.println(lsize+" s");
        res = lsize *set.get(curr).get(0);
        // System.out.println(set[curr].x + " " + lsize + "/");
        curr++;
        return res + calc2(csize, set, curr, store*multi);

    }

    // calc1 function
    public static long calc(int n, ArrayList<ArrayList<Integer>> set) {

        int csize = n / set.get(0).get(1); // 170/12 =14
        int lsize = n - csize; // 170-14 = 156
        long res = lsize *set.get(0).get(0); // 156*16
        // System.out.println(set[0].x + " " + lsize + "/");
        return res + calc2(csize, set, 1,  set.get(0).get(1));

    }
}

