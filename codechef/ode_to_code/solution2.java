package ode_to_code;

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
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextInt();
            long k = sc.nextLong();
            String str = sc.next();

            if (k == 1) {
                System.out.println(sortString(str));

            } else {
                System.out.println(str.charAt(0));
            }
        }
    }
    public static String sortString(String inputString)
    {
        // Converting input string to Character array
        Character tempArray[]
            = new Character[inputString.length()];
 
        for (int i = 0; i < inputString.length(); i++) {
            tempArray[i] = inputString.charAt(i);
        }
 
        // Sort, ignoring case during sorting
        Arrays.sort(tempArray, new Comparator<Character>() {
             
          // Method 2
            // To compare characters
            @Override
            public int compare(Character c1, Character c2)
            {
                // Ignoring case
                return Character.compare(
                    Character.toLowerCase(c1),
                    Character.toLowerCase(c2));
            }
        });
 
        // Using StringBuilder to convert Character array to
        // String
        StringBuilder sb
            = new StringBuilder(tempArray.length);
 
        for (Character c : tempArray)
            sb.append(c.charValue());
 
        return sb.toString();
    }
}
