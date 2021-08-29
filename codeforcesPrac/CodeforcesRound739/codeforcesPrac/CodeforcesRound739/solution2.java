package codeforcesPrac.CodeforcesRound739;

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
        int t= sc.nextInt();
        while(t-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c  = sc.nextLong();

            long maxval = Math.max(a, b);
            long diff = Math.abs(a-b);
            long circleOf = diff*2;
            long sum, subs;


            if(maxval> circleOf || circleOf<c || c==0){
                System.out.println(-1);
            } else{
                sum = c+diff;
                subs = c-diff;
                if(sum<=circleOf){
                    System.out.println(sum);
                }else if(subs>0){
                    System.out.println(subs);
                }
            }

        }
    }
}
