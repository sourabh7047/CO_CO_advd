package Starters10august;

import java.util.*;
import java.io.*;

public class solution2 {
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

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();

            Integer[] arrA = new Integer[(int) n];
            for (int i = 0; i < n; i++) {
                arrA[i] = sc.nextInt();
            }

            Integer[] arrB = new Integer[(int) (n - 1)];
            for (int i = 0; i < n - 1; i++) {
                arrB[i] = sc.nextInt();
            }

            Arrays.sort(arrA, Collections.reverseOrder());
            Arrays.sort(arrB, Collections.reverseOrder());

            if (n == 2) {
                if (arrA[0] < arrB[0]) {
                    System.out.println(arrB[0] - arrA[0]);
                } else {
                    System.out.println(arrB[0] - arrA[1]);
                }

            } else if (arrB[0] - arrA[1] == arrB[1] - arrA[2] && arrB[0] > arrA[0]) {
                System.out.println(arrB[0] - arrA[1]);
            } else {
                System.out.println(arrB[0] - arrA[0]);
            }
        }
    }
}
