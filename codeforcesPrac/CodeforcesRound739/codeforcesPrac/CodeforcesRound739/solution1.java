package codeforcesPrac.CodeforcesRound739;

import java.util.*;
import java.io.*;

public class solution1{
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
            int k = sc.nextInt();
            boolean enter = true;
            int i=1;
            int count =0;
            int val = 0;

            while(true){
                if(i%10 != 3 && i%3 != 0){
                    count++;
                    if(count == k){
                        val = i;
                        break;
                    }
                }
                i++;
            }

            System.out.println(val);
        }
    }

}