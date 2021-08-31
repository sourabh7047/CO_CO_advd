package starter10_Aug;

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
            int input;

            ArrayList<Integer> arrA = new ArrayList<>();
            ArrayList<Integer> arrB = new ArrayList<>();
            Set<Integer> hash = new HashSet<>();

            for (int i = 0; i < n; i++) {
                input = sc.nextInt();
                arrA.add(input);
                hash.add(input);
            }

            for (int i = 0; i < n - 1; i++) {
                input = sc.nextInt();
                arrB.add(input);
                
            }

            Collections.sort(arrA, Collections.reverseOrder());
            Collections.sort(arrB, Collections.reverseOrder());

            

            int j = 0;
            int k = 0;
            int ans = Integer.MAX_VALUE;

            if (arrB.size() == 1) {
                int diff1 = arrB.get(j) - arrA.get(k);
                int diff2 = arrB.get(j) - arrA.get(k + 1);

                if (ans > diff1 && diff1 > 0) {
                    ans = diff1;
                }

                if (diff2 < ans && diff2 > 0) {
                    ans = diff2;
                }

            } else {

                int temp = arrB.get(0) - arrA.get(0);
                for (int i = 1; i < n - 1; i++) {
                    if (hash.contains(arrB.get(i) - temp)) {
                        if (i == n - 2 && ans > temp) {
                            ans = temp;
                        }
                    } else {
                        break;
                    }
                }

                temp = arrB.get(0) - arrA.get(1);
                for (int i = 1; i < n - 1; i++) {
                    if (hash.contains(arrB.get(i) - temp)) {
                        if (i == n - 2 && ans > temp) {
                            ans = temp;
                        }
                    } else {
                        break;
                    }
                }
            }

            System.out.println(ans);

        }
    }

}
