package lunchtime_aug;

import java.util.*;

import javax.management.MXBean;

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
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int max = Integer.MIN_VALUE;
            int moves =0;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] > max)
                    max = arr[i];
            }

            if (max != arr[0]) {
                System.out.println(-1);
            } else {
                int[] output = nextG(arr);
                for(int i=1;i<n; i++){
                    if(output[i] == -1) moves++;
                }
                System.out.println(moves);
            }

        }

    }

    public static int[] nextG(int arr[]) {
        int n = arr.length;
        int[] arrl = new int[n];
        Stack<Integer> stack = new Stack<>();
        arrl[n-1] = -1;
        stack.push(arr[n-1]);

        for(int i=n-2;i>=0; i--){
            while(stack.size()>0 && arr[i]>stack.peek()){
                stack.pop();
            }

            if(stack.size() == 0){
                arrl[i] = -1;
            } else {
                arrl[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return arrl;

    }
}