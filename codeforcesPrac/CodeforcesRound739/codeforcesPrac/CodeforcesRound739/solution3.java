package codeforcesPrac.CodeforcesRound739;

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
        int t= sc.nextInt();
        while(t-->0){
            long k = sc.nextLong();

            double root = Math.sqrt(k);
           
            double remaining = root - (long)root;

            long rowCol = (long)root +1;
            long col, val;

            if(remaining == 0){
                System.out.println((long)root+" "+1);
            } else {
                val = k-(long)root*(long)root;
                if(val<=rowCol){
                    System.out.println(val+" "+rowCol);
                }else if(val>rowCol){
                    col = rowCol-(val)%rowCol;
                    System.out.println(rowCol+" "+ col);
                }
            }
           

        }
    }
}
