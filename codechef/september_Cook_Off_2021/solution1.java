package september_Cook_Off_2021;

import java.util.*;
import java.io.*;

public class solution1 {
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
        // OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            long a[] = new long[n];
            ArrayList<Long> odd = new ArrayList<Long>();// Creating arraylist
            ArrayList<Long> even = new ArrayList<Long>();// Creating arraylist

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                if (a[i] % 2 == 0) {
                    odd.add(a[i]);

                } else {
                    even.add(a[i]);
                }
            }

            if (odd.size() == 0 || even.size() == 0) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < odd.size(); i++) {
                    System.out.print(odd.get(i) + " ");
                }
                for (int i = 0; i < even.size(); i++) {
                    System.out.print(even.get(i) + " ");
                }
                System.out.println();
            }
        }
    }

}
