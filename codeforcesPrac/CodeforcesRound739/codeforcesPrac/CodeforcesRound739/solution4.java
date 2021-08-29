package codeforcesPrac.CodeforcesRound739;

import java.util.*;
import java.io.*;

public class solution4 {
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
            String mains = Integer.toString(n);

            int pow = (int) (Math.log(n) / Math.log(2));
            String stringval = Integer.toString((int) Math.pow(2, pow));

            String[] arrmain = mains.split("");
            String[] arrstringval = stringval.split("");

            // method 1-----------------
            int method1 = Integer.MAX_VALUE;
            for (int i = 0; i < mains.length(); i++) {
                char x = mains.charAt(i);
                if (arrmain[i].equals(Character.toString('1')) || arrmain[i].equals(Character.toString('2'))|| arrmain[i].equals(Character.toString('4')) || arrmain[i].equals(Character.toString('8'))) {
                    method1 = mains.length() - 1;
                    System.out.println(method1+"/");
                    break;
                }
            }

            // method2 --------------------
            int method2 = Integer.MAX_VALUE;
            int temp;
            for (String x : st) {
                int p = Integer.parseInt(x);
                double power = (Math.log(p) / Math.log(2));
                double diff = power - (int)power;
                if(diff ==0){
                    temp= mains.length()- x.length();
                    if(method2>temp){
                        method2= temp;
                    }
                }
            }

            // method3---------------------------
            int method3 = 0;
            int k = 0;
            int erase = 0;
            for (int i = 0; i < arrmain.length; i++) {
                if (arrstringval[k].equals(arrmain[i])) {
                    k++;
                } else {
                    erase++;
                }
            }

            method3 = arrstringval.length - k + erase;


            // final verdict ----------------
            int finval = Math.min(method1, method2);
            finval = Math.min(finval, method3);
            System.out.println(finval);
            
        }
    }

    static HashSet<String> st = new HashSet<>();

    // Function computes all the subsequence of an string
    static void subsequence(String str) {

        // Iterate over the entire string
        for (int i = 0; i < str.length(); i++) {

            // Iterate from the end of the string
            // to generate substrings
            for (int j = str.length(); j > i; j--) {
                String sub_str = str.substring(i, j);

                if (!st.contains(sub_str))
                    st.add(sub_str);

                // Drop kth character in the substring
                // and if its not in the set then recur
                for (int k = 1; k < sub_str.length() - 1; k++) {
                    StringBuffer sb = new StringBuffer(sub_str);

                    // Drop character from the string
                    sb.deleteCharAt(k);
                    if (!st.contains(sb))
                        ;
                    subsequence(sb.toString());
                }
            }
        }
    }
}
