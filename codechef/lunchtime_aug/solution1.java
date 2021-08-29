package lunchtime_aug;

import java.util.*;

import javax.xml.stream.XMLOutputFactory;

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
            int k = sc.nextInt();

            int l = 0;
            int r = 0;
            int count =0;

            int[] arr = new int[n];
            int max = Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(arr[i]>max){
                    max = arr[i];
                }
            }

            while(r<n){
                if(r-l+1 == k){
                    if(arr[r] == max) count += n-r;
                    l++;
                } else {
                    r++;
                }
            }

            System.out.println(count);
        }
    }

}