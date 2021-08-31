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
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k =sc.nextInt();
            int count =0;

            int[] arr  = new int[n];
            for(int i=0;i<n; i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            
            int x =0;
            while(x<k){
                if( arr[x] < 0){
                    arr[x] *=-1;
                    x++;
                }else {
                    break;
                }
            }

            Arrays.sort(arr);

            int y = n-1;
            while(y>=0){
                if(arr[y]>0){
                    count += arr[y];
                    y--;
                }else {
                    break;
                }
            }

            System.out.println(count);
        }
    }
}
