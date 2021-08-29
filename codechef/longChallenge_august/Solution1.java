package longChallenge_august;

import java.util.*;
import java.io.*;

public class Solution1 {
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

    public static void print(ArrayList<Integer> arr, PrintWriter out) {
        for (int x : arr) {
            out.print(x + " ");
        }
        out.println();
    }

    static HashMap<Long, Long> kv = new HashMap<>();

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        long[] ans = new long[t];
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < t; i++) {
            ans[i] = sc.nextLong();
            if (max < ans[i]) {
                max = ans[i];
            }
        }

        arrfiller(max);

        // for(int i=0; i<t; i++){
        // System.out.println(kv.get(ans[i]));
        // }

        for(int i=0;i<t; i++){
            System.out.println(kv.get(ans[i]));
        }

    }

    static void arrfiller(long n) {

        kv.put((long)3, (long)3);
        // long cc = 2; // common counter 1X1
        // long ec = 1; // end counter x (x-1) 1
        long fc = 0; // factor counter
        long subc = 0; // subtract counter x-2 pr x-3
        long i = 3;

        while (++i <= n) {
            if (primes.contains(i)) {
                if (factor.containsKey(i - 1)) {
                    fc = factor.get(i - 1);
                } else {
                    fc = calculate(i - 1) - 1;
                }
            } else {
                fc = calculate(i);
                // System.out.println(fc);

                subc = subcCounter(i);
            }

            kv.put(i, kv.get(i - 1) + fc + subc+ 1);

        }
    }

    static Map<Long, Long> factor = new HashMap<>();

    static long subcCounter(long n) {
        long subc = 0;
        ArrayList<Long> alldivisors = printDivisors(n);
        // System.out.println(alldivisors.size());
        for (int j = 0; j < alldivisors.size(); j++) {
            // System.out.println(alldivisors.get(j) + "//");
            if (alldivisors.get(j) != n) {
                long temp = n - alldivisors.get(j);
                ArrayList<Long> tempArr = printDivisors(temp);
                for (int k = 0; k < tempArr.size(); k++) {
                    if (tempArr.get(k) % alldivisors.get(j) == 0 && tempArr.get(k) != alldivisors.get(j)) {
                        // System.out.println(tempArr.get(k)+"r "+alldivisors.get(j));
                        subc++;

                    }
                }
            }
        }
        // System.out.println(subc + "/");
        alldivisors.removeAll(alldivisors);
        return subc;
    }

    static ArrayList<Long> printDivisors(long n) {

        ArrayList<Long> divisors = new ArrayList<>();
        // Note that this loop runs till square root
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If divisors are equal, print only one
                if (n / i == i && i != n) {
                    divisors.add((long)i);

                }

                else {
                    // Otherwise print both
                    divisors.add((long)i);
                    divisors.add((long)(n / i));
                }

            }
        }

        return divisors;
    }

    static long calculate(long n) {
        long count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i)
                    count++;
                else
                    count += 2;
            }
        }

        factor.put(n, count - 2);
        return count - 2;
    }
    // for (int k = 1; k <= n; k++) {
    // for (int j = k; j <= n; j+=k) {
    // if ((j % k) == 0) {
    // for(int i =k; i<=n;i+=j){
    // if(i%j == k){
    // count++;
    // }

    static ArrayList<Long> primes = new ArrayList<>();

    class SieveOfEratosthenes {
        void sieveOfEratosthenes(long n) {
            // Create a boolean array
            // "prime[0..n]" and
            // initialize all entries
            // it as true. A value in
            // prime[i] will finally be
            // false if i is Not a
            // prime, else true.
            boolean prime[] = new boolean[ (int)n + 1];
            for (int i = 0; i <= n; i++)
                prime[i] = true;

            for (int p = 2; p * p <= n; p++) {
                // If prime[p] is not changed, then it is a
                // prime
                if (prime[p] == true) {
                    // Update all multiples of p
                    for (int i = p * p; i <= n; i += p)
                        prime[i] = false;
                }
            }

            // Print all prime numbers
            for (int i = 2; i <= n; i++) {
                if (prime[i] == true)
                    primes.add((long) i);
            }
        }

    }

    // This code has been contributed by Amit Khandelwal

}

// static long factors(long N) {
// long count = 0;
// long ans = 0;
// int p;
// for (int i = 0; i < primes.size(); i++) {
// p = primes.get(i);
// if (p * p * p > N) {
// break;
// }
// count = 1;
// while (N / p > 0) {
// N = N / p;
// count = count + 1;
// ans = ans * count;
// }
// }
// if (primes.contains(N)) {
// ans = ans * 2;
// } else if (primes.contains(Math.sqrt(N))) {
// ans = ans * 3;
// } else if (N != 1) {
// ans = ans * 4;
// }

// return ans;

// }