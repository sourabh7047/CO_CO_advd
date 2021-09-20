package september_Cook_Off_2021;

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

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            String s = sc.next();
            solve(n, k, s);
        }

    }

    public static void solve(int n, int k, String s) {

        char res = s.charAt(0);
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (res != s.charAt(i)) {
                cnt++;
                res = s.charAt(i);
            }
        }
        if (cnt < k) {
            System.out.println(-1);
            return;
        }
        if (cnt < k) {
            System.out.println(-1);
            return;
        }
        if (s.charAt(0) == '0') {
            if (k % 2 != 0) {
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (s.charAt(i) == '1') {
                        System.out.println(i + 1);
                        return;
                    }
                }
            } else {
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (s.charAt(i) == '0') {
                        System.out.println(i + 1);
                        return;
                    }
                }
            }
        } else {
            if (k % 2 != 0) {
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (s.charAt(i) == '0') {
                        System.out.println(i + 1);
                        return;
                    }
                }
            } else {
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (s.charAt(i) == '1') {
                        System.out.println(i + 1);
                        return;
                    }
                }
            }
        }

    }
}
