package Starter11_sept;

import java.util.*;
import java.io.*;

public class solution3 {
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader() {
            in = System.in;
        }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        String nextLine() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c != 10 && c != 13; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        char nextChar() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            return (char) c;
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        long mod = 1000000007;
        long val = 100000;
        while (t-- > 0) {
            long n = sc.nextLong();
            long ans = 0;
            long maxval = Integer.MIN_VALUE;

            long[] arr = new long[(int) (n - 1)];

            for(int i=0;i<n-1; i++){
                arr[i] = sc.nextLong();
                if(maxval<arr[i]){
                    maxval = arr[i];
                }
            }
            System.out.println(maxval);
            long maxi = val - maxval;
            ans = (maxi + (maxi + 1)%mod)%mod;
            

            System.out.println(ans);
        }
    }
}
