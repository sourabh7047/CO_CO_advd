package codeforcesPrac.CodeforcesRound738;

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
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String ques = sc.next();
            Boolean fi = false;
            String ans = "";

            for (int i = 0; i < n; i++) {
                if (ques.charAt(i) != '?') {
                    if (i % 2 == 0) {
                        if (ques.charAt(i) == 'R') {
                            ans += "R";
                        } else {
                            ans += "B";
                        }
                    } else {
                        if (ques.charAt(i) == 'R') {
                            ans += "B";
                        } else {
                            ans += "R";
                        }
                    }
                    fi = true;
                    break;
                }
            }

            if (fi) {
                if (ques.length() > 1) {
                    for (int i = 1; i < n; i++) {
                        if (ques.charAt(i) == '?') {
                            if (ans.charAt(i - 1) == 'R') {
                                ans += 'B';
                            } else {
                                ans += 'R';
                            }
                        } else {
                            ans += ques.charAt(i);
                        }
                    }
                }

            } else {
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        ans += 'B';
                    } else {
                        ans += 'R';
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
